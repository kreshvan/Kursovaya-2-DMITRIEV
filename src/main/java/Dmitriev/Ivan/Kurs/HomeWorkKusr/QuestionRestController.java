package Dmitriev.Ivan.Kurs.HomeWorkKusr;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
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
