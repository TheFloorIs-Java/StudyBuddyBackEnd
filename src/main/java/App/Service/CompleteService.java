package App.Service;

import App.Model.Complete;
import App.Repository.CompleteRepository;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;

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
         List<Complete> cList = cr.getHwCompletedByUserAndSubjectId(userId, subjectId);
        if(cList.size()>5){
            cr.deleteById(getOldestId(userId, subjectId));
        }
        return cr.getHwCompletedByUserAndSubjectId(userId, subjectId);
    }
    public void addCompleteHw(Complete item){
        cr.save(item);
        cr.getHwCompletedByUserAndSubjectId(item.getUserId(), item.getSubjectId());
    }

    public int getOldestId(int userId, int subjectId){
        List<Complete> cList = cr.getHwCompletedByUserAndSubjectId(userId, subjectId);
        int currentMin=cList.get(0).completeId;
        for(int i = 0; i< cList.size(); i++){
           if(cList.get(i).completeId < currentMin){
               currentMin=cList.get(i).completeId;
           }
        }
        return currentMin;
    }
}