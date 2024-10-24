package Dmitriev.Ivan.Kurs.HomeWorkKusr;

import java.util.Collection;
import java.util.List;

public class TestData  {

    public final static Question RANDOM_QUESTION_1 = new Question("AAA", "111");

    public final static Question RANDOM_QUESTION_2 = new Question("BBB", "222");

    public final static Question RANDOM_QUESTION_3 = new Question("CCC", "333");


    public static Collection<Question> getFullList() {
        return List.of(RANDOM_QUESTION_1, RANDOM_QUESTION_2, RANDOM_QUESTION_3);
    }
}