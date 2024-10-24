package Dmitriev.Ivan.Kurs.HomeWorkKusr;

import java.util.Objects;

public class Question {
    private final String question;
    private final String answer;
    public Question(String question,String answer) {
        this.question = question;
        this.answer = answer;
    }
    public String getQuestion() {
        return question;
    }

public String getAnswer() {
        return answer;
}

public String toString() {
        return super.toString();
}



public boolean equals(Object q) {
        if (this==q) return true;
if (!(q instanceof Question question1)) return false;
return Objects.equals(question, question1.question) && Objects.equals(answer, question1.answer);
}

    @Override
    public int hashCode() {
        return Objects.hash(question, answer);
    }
}
