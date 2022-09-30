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

    @GetMapping("complete")
    public List<Complete> getAllHwCompleted() {
        return cs.getAllHwCompleted();
    }

    @GetMapping("complete/{userId}/{subjectId}")
    public List<Complete> getHwCompletedByUserAndSubjectId(
            @PathVariable int userId, @PathVariable Integer subjectId) {
        return cs.getHwCompletedByUserAndSubjectId(userId, subjectId);
    }

    @PostMapping("complete")
    public void addCompleteHw(@RequestBody Complete item) {
        cs.addCompleteHw(item);
    }


}