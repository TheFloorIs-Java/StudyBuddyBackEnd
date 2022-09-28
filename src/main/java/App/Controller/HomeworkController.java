package App.Controller;

import App.Model.Homework;
import App.Repository.HomeworkRepository;
import App.Service.HomeworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping("homework")
    public void addMovie(@RequestBody Homework item){
        hs.addHomeworkItem(item);
    }
    @GetMapping("homework/{userId}/{subjectId}")
    public List<Homework> getHwByUserandSubjectIds(
        @PathVariable int userId,@PathVariable Integer subjectId){
        return hs.getHomeworkByUserAndSubjectId(userId, subjectId);
    }
    @GetMapping("homework/{itemId}")
    public void removeHwByItemId(@PathVariable int itemId){
        hs.deleteHomeworkItem(itemId);
    }

}
