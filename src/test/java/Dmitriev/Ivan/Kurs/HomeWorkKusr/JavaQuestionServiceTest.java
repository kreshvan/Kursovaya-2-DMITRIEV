package Dmitriev.Ivan.Kurs.HomeWorkKusr;

import Dmitriev.Ivan.Kurs.HomeWorkKusr.Exception.NoSuchQuestionException;
import Dmitriev.Ivan.Kurs.HomeWorkKusr.Exception.addingSimilarQuestionException;
import Dmitriev.Ivan.Kurs.HomeWorkKusr.SERVICES.JavaQuestionService;
import org.junit.jupiter.api.Test;

import java.util.Collection;

import static Dmitriev.Ivan.Kurs.HomeWorkKusr.TestData.*;
import static org.assertj.core.api.Assertions.assertThat;    //сравнение двух обЪектов
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class JavaQuestionServiceTest  {
    JavaQuestionService javaQuestionService = new JavaQuestionService();

    @Test
    void check_ForAddingQuestion_thenAdd() {

        Question question = javaQuestionService.add(RANDOM_QUESTION_1);
        assertThat(question).isEqualTo(RANDOM_QUESTION_1);

    }

    @Test
    void check_ForAddingQuestion_thenAdd_thenThrowException() {
        javaQuestionService.add(RANDOM_QUESTION_1);
        assertThatExceptionOfType(addingSimilarQuestionException.class)
                .isThrownBy(() -> javaQuestionService.add(RANDOM_QUESTION_1));

    }

    @Test
    void check_ForAddingQuestionAndAnswer_thenAdd() {
        Question Addquestion = javaQuestionService.add(RANDOM_QUESTION_1.getQuestion(), RANDOM_QUESTION_1.getAnswer());
        assertThat(Addquestion).isEqualTo(RANDOM_QUESTION_1);

    }

    @Test
    void check_ForAddingQuestionAndAnswer_thenAdd_thenThrowException() {
        javaQuestionService.add(RANDOM_QUESTION_1.getQuestion(), RANDOM_QUESTION_1.getAnswer());
        assertThatExceptionOfType(addingSimilarQuestionException.class)
                .isThrownBy(() -> javaQuestionService.add(RANDOM_QUESTION_1));

    }

    @Test
    void checkingForObjectDeletion_thenRemove() {
        javaQuestionService.add(RANDOM_QUESTION_1);
//Test
        Question removeQuestion = javaQuestionService.remove(RANDOM_QUESTION_1);
//Check
        Collection<Question> result = javaQuestionService.getFullList();
        assertThat(result).isEmpty();
        assertThat(removeQuestion).isEqualTo(RANDOM_QUESTION_1);

    }

    @Test
    void checkingForQuestionDeletion_thenRemove_thenThrowException() {
        assertThatExceptionOfType(NoSuchQuestionException.class)
                .isThrownBy(() -> javaQuestionService.remove(RANDOM_QUESTION_1));
    }


    @Test
    void getFullList() {

        javaQuestionService.add(RANDOM_QUESTION_1);
        javaQuestionService.add(RANDOM_QUESTION_2);
        javaQuestionService.add(RANDOM_QUESTION_3);

        //test
        Collection<Question> actual = javaQuestionService.getFullList();


    }

    @Test
    void getRandomQuestion() {
        javaQuestionService.add(RANDOM_QUESTION_1);
        javaQuestionService.add(RANDOM_QUESTION_2);
        javaQuestionService.add(RANDOM_QUESTION_3);

        Question randomQuestion = javaQuestionService.getRandomQuestion();

        assertThat(Dmitriev.Ivan.Kurs.HomeWorkKusr.TestData.getFullList()).contains(randomQuestion);

    }
}
