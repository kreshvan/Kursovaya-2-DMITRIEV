package Dmitriev.Ivan.Kurs.HomeWorkKusr;

import Dmitriev.Ivan.Kurs.HomeWorkKusr.Exception.QuestionAmountMismatchException;
import Dmitriev.Ivan.Kurs.HomeWorkKusr.SERVICES.ExaminerServiceImpl;
import Dmitriev.Ivan.Kurs.HomeWorkKusr.SERVICES.JavaQuestionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collection;

import static Dmitriev.Ivan.Kurs.HomeWorkKusr.TestData.*;
import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {
    @Mock
    private JavaQuestionService javaQuestionService;
    @InjectMocks
    private ExaminerServiceImpl examinerService;

    @BeforeEach
    public void setUp() {
        when(javaQuestionService.getFullList()).thenReturn(getFullList());
    }

    @Test
    @DisplayName("Возращает весь список ранодомных вопроов!")
    void getQuestions() {
        int amount = 2;
        when(javaQuestionService.getFullList()).thenReturn(getFullList());
        when((javaQuestionService.getRandomQuestion())).thenReturn(
                RANDOM_QUESTION_1,
                RANDOM_QUESTION_2,
                RANDOM_QUESTION_3);
        //Test
        Collection<Question> questionsActual = examinerService.getQuestions(2);

        assertThat(getFullList()).containsAll(questionsActual);

        verify(javaQuestionService, times(1)).getFullList();
        verify(javaQuestionService, times(amount)).getRandomQuestion();
    }

    @Test
    @DisplayName("Возращает все вопросы , не вызывает сервис повторно.")
    void getQuestions_1() {
        int amount = 3;
        //Test
        Collection<Question> questionsActual = examinerService.getQuestions(2);

        assertThat(getFullList()).containsAll(questionsActual);

        verify(javaQuestionService, times(1)).getFullList();
        verify(javaQuestionService, never()).getRandomQuestion();
    }

    @Test
    @DisplayName("Возращает все вопросы , не вызывает сервис повторно.")
    void getQuestions_2() {
        int amount = 4;
        //Test
        assertThatExceptionOfType(QuestionAmountMismatchException.class).isThrownBy(() -> examinerService.getQuestions(amount));


    }
}