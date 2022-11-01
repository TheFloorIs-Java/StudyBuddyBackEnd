package App.Controller;

import App.Model.Complete;
import App.Service.CompleteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import App.Model.Complete;
import App.Repository.CompleteRepository;
import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@CrossOrigin
public class CompleteController {
    CompleteService cs;

    //@autowired
    // automatically finds the most appropriate bean and injects into this class.
    @Autowired
    public CompleteController(CompleteService cs) {
        this.cs = cs;
    }

    /**
     * Get request with endpoint complete to get all homeworks that have been completed
     * @return list of all complete homeworks
     */
    @GetMapping("complete")
    public List<Complete> getAllHwCompleted() {
        return cs.getAllHwCompleted();
    }

    /**
     * Get request to get all completed homeworks for a user in a subject
     * @param userId id of a user
     * @param subjectId is of a subject
     * @return list of all homeworks completed in a subject by a user
     */
    @GetMapping("complete/{userId}/{subjectId}")
    public List<Complete> getHwCompletedByUserAndSubjectId(
            @PathVariable int userId, @PathVariable Integer subjectId) {
        return cs.getHwCompletedByUserAndSubjectId(userId, subjectId);
    }

    /**
     * Post request to add a homework item to completed
     * @param item completed homework item
     */
    @PostMapping("complete")
    public void addCompleteHw(@RequestBody Complete item) {
        cs.addCompleteHw(item);
    }


}