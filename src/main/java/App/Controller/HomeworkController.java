package App.Controller;

import App.Model.Homework;
import App.Repository.HomeworkRepository;
import App.Service.HomeworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class HomeworkController {
    HomeworkService hs;

    @Autowired
    public HomeworkController(HomeworkService hs){
        this.hs =hs;
    }

    /**
     * Get request to get all homeworks for all users and subjects
     * @return
     */
    @GetMapping("homework")
    public List<Homework> getAllHomework(){
       return hs.getAllHomeworks();
    }

    /**
     * Post request to add a homework item
     * @param item homework item to add
     */
    @PostMapping("homework")
    public void addMovie(@RequestBody Homework item){
        hs.addHomeworkItem(item);
    }

    /**
     * Get request to get all homework of a user in a subject
     * @param userId id of user
     * @param subjectId id of subject
     * @return list of homeworks
     */
    @GetMapping("homework/{userId}/{subjectId}")
    public List<Homework> getHwByUserandSubjectIds(
        @PathVariable int userId,@PathVariable Integer subjectId){
        return hs.getHomeworkByUserAndSubjectId(userId, subjectId);
    }

    /**
     * Delete request to delete homework by id
     * @param itemId homework id
     */
    @GetMapping("homework/{itemId}")
    public void removeHwByItemId(@PathVariable int itemId){
        hs.deleteHomeworkItem(itemId);
    }

    /**
     * Get request to get homework by id
     * @param itemId homework id
     * @return homework or error
     */
    @GetMapping("homework/id/{itemId}")
    public Homework HwByItemId(@PathVariable int itemId){
        return hs.getHwById(itemId);
    }

    /**
     * Get request to get all homework of a user
     * @param userId id of user
     * @return list of homework
     */
    @GetMapping("homework/user/{userId}")
    public List<Homework> HwByItemUserId(@PathVariable int userId){
        return hs.getByUserId(userId);
    }


}
