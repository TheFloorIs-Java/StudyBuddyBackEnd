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

    /**
     * Gets all completes for all users and subjects
     * @return list of complete
     */
    public List<Complete> getAllHwCompleted(){return cr.findAll();}

    /**
     * Gets all completed by user and subject while deleting extra
     * @param userId id of user
     * @param subjectId id of subject
     * @return list of complete
     */
    public List<Complete> getHwCompletedByUserAndSubjectId(int userId, int subjectId) {
         List<Complete> cList = cr.getHwCompletedByUserAndSubjectId(userId, subjectId);
        if(cList.size()>5){
            cr.deleteById(getOldestId(userId, subjectId));
        }
        return cr.getHwCompletedByUserAndSubjectId(userId, subjectId);
    }

    /**
     * Adds new complete and checks size <=5
     * @param item complete
     */
    public void addCompleteHw(Complete item){
        cr.save(item);
        getHwCompletedByUserAndSubjectId(item.getUserId(), item.getSubjectId());
    }

    /**
     * Gets oldest id of complete to delete
     * @param userId id of user
     * @param subjectId id of subject
     * @return complete id
     */
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