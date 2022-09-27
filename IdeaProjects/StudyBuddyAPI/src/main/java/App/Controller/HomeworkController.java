package App.Controller;

import App.Model.Homework;
import App.Repository.HomeworkRepository;
import App.Service.HomeworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HomeworkController {
    HomeworkService hs;

    @Autowired
    public HomeworkController(HomeworkService hs){
        this.hs =hs;
    }

    @GetMapping("homework")
    public List<Homework> getAllHomework(){
       return hs.getAllHomeworks();
    }
    @GetMapping("home")
    public String sayHi(){
        return "Hi all!";
    }
    @PostMapping("homework")
    public void addMovie(@RequestBody Homework item){
        hs.addHomeworkItem(item);
    }
}
