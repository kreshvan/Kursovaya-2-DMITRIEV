package Dmitriev.Ivan.Kurs.HomeWorkKusr.SERVICES;

import Dmitriev.Ivan.Kurs.HomeWorkKusr.Question;

import java.util.Collection;

public interface ExaminerService  {

    Collection<Question> getQuestions(int amount);
}
