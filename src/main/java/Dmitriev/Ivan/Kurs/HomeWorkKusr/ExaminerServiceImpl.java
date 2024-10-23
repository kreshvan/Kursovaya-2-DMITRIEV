package Dmitriev.Ivan.Kurs.HomeWorkKusr;

import java.util.*;

public class ExaminerServiceImpl implements ExaminerService {
    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }


    @Override
    public Collection<Question> getQuestions(int amount) {//5 рандомных вопросов
        if (amount <= 0 || amount > questionService.getFullList().size()) {
            throw new QuestionAmountMismatchException("Ошибка!");
        }
        Set<Question> newQuestionsList = new HashSet<>();
        while (newQuestionsList.size() < amount) {   // while - делаем до тех пор пока не выполним условие.
            newQuestionsList.add(questionService.getRandomQuestion());


        }

        return newQuestionsList;


    }
}
