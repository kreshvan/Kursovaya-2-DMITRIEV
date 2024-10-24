package Dmitriev.Ivan.Kurs.HomeWorkKusr.CONTROLER;

import Dmitriev.Ivan.Kurs.HomeWorkKusr.Question;
import Dmitriev.Ivan.Kurs.HomeWorkKusr.SERVICES.ExaminerService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/exam/java/")
public class ExamController {
    private final ExaminerService examinerService;

    public ExamController(ExaminerService examinerService)  {
        this.examinerService = examinerService;
    }


    @GetMapping("/get/{amount}")
    public Collection<Question> getQuestions(@PathVariable("amount") int amount) {
        return examinerService.getQuestions(amount);
    }
}
