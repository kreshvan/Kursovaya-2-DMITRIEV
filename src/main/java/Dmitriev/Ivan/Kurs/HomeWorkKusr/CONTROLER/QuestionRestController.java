package Dmitriev.Ivan.Kurs.HomeWorkKusr.CONTROLER;

import Dmitriev.Ivan.Kurs.HomeWorkKusr.Question;
import Dmitriev.Ivan.Kurs.HomeWorkKusr.SERVICES.QuestionService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/exam/java")
public class QuestionRestController {

    private final QuestionService questionService;

    public QuestionRestController(QuestionService questionService) {
        this.questionService = questionService;
    }


    @PostMapping("/add")
    public Question add(String question, String answer) {
        return questionService.add(question, answer);
    }

    @DeleteMapping("/remove")
    public Question remove(String question, String answer) {
        return questionService.remove(question, answer);
    }

    @GetMapping()
    public Collection<Question> getFullList() {

        return questionService.getFullList();
    }

















}
