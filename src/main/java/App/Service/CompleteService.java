package App.Service;

import App.Model.Complete;
import App.Repository.CompleteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import App.Controller.CompleteController;

import java.util.ArrayList;
import java.util.List;
@Component
@CrossOrigin
public class CompleteService {
    CompleteRepository cr;

    public CompleteService(CompleteRepository cr){
        this.cr = cr;
    }
    List<Complete>completedhomework= new ArrayList<>();
    public List<Complete> getAllHwCompleted(){return cr.findAll();}
    public List<Complete> getHwCompletedByUserAndSubjectId(int userId, int subjectId) {
        return cr.getHwCompletedByUserAndSubjectId(userId, subjectId);
    }
    public void addCompleteHw(Complete item){
        cr.save(item);
    }
    }
