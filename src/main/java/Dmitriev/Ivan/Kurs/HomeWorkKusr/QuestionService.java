package Dmitriev.Ivan.Kurs.HomeWorkKusr;

import java.util.Collection;

public interface QuestionService {
    Question add(String question, String answer);

    Question add(Question question);

    Question remove(String question, String answer);

    Question remove(Question question);


    //Question find(String question, String answer);

    Collection<Question> getFullList();


    Question getRandomQuestion();
}
