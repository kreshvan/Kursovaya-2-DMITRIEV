package Dmitriev.Ivan.Kurs.HomeWorkKusr;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Stream;

@Service
@Component
public class JavaQuestionService implements QuestionService {

    Set<Question> questionsSet = new HashSet<Question>();
    static final int MaxQuestions = 1000;
    Random random = new Random();


    @Override
    public Question add(String question, String answer) {
        Question questionNew = new Question(question, answer);
        if (questionsSet.size() > MaxQuestions) {
            throw new OversizeException("Превышет лимит количества вопросов!");
        }
        if (questionsSet.contains(questionNew)) {
            throw new addingSimilarQuestionException("Такой вопрос уже есть!");
        }
        questionsSet.add(questionNew);
        return questionNew;
    }


    @Override
    public Question add(Question question) {

        if (questionsSet.size() > MaxQuestions) {
            throw new OversizeException("Превышет лимит количества вопросов!");
        }
        if (questionsSet.contains(question)) {
            throw new addingSimilarQuestionException("Такой вопрос уже есть!");
        }
        questionsSet.add(question);
        return question;
    }


    @Override
    public Question remove(String question, String answer) {
        Question questionNew = new Question(question, answer);
        if (!questionsSet.contains(questionNew)) {
            throw new NoSuchQuestionException("Нет такого вопроса!");
        }
        questionsSet.remove(questionNew);
        return questionNew;
    }


    @Override
    public Question remove(Question question) {
        if (!questionsSet.contains(question)) {
            throw new NoSuchQuestionException("Нет такого вопроса!");
        }
        questionsSet.remove(question);
        return question;


    }

    @Override
    public Collection<Question> getFullList() {

        return Collections.unmodifiableSet(questionsSet);
    }


    @Override
    public Question getRandomQuestion() {

        return questionsSet.toArray(new Question[0])[random.nextInt(questionsSet.size())];
    }

}
