package App.Service;

import App.Model.Complete;
import App.Model.Homework;
import App.Repository.CompleteRepository;
import App.Repository.HomeworkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@Component
@CrossOrigin
public class HomeworkService {
    HomeworkRepository hr;
    CompleteRepository cr;
    @Autowired
    public HomeworkService(HomeworkRepository hr, CompleteRepository cr){
        this.cr =cr;
        this.hr = hr;
    }

    /**
     * Get all homework for all users and subjects
     * @return list of homework
     */
    public List<Homework> getAllHomeworks(){
        return hr.findAll();
    }

    /**
     * Add homework to database
     * @param item homework
     */
    public void addHomeworkItem(Homework item){
        hr.save(item);
    }

    /**
     * Get homework by user and subject
     * @param userId id of user
     * @param subjectId id of subject
     * @return list of homework
     */
    public List<Homework> getHomeworkByUserAndSubjectId(int userId,int subjectId){
        return hr.findByUserIdAndSubjectId(userId, subjectId);
    }

    /**
     * Deletes a homework and add to complete
     * @param hwId id of homework
     */
    public void deleteHomeworkItem(int hwId){
       Homework hw = hr.findByHwId(hwId);
       Complete c = new Complete();
       c.completeItem=hw.getHwItem();
       c.userId=hw.getUserId();
       c.subjectId = hw.getSubjectId();
       cr.save(c);
       hr.deleteById(hwId);
    }

    /**
     * Gets all homeworks by user
     * @param userId id of user
     * @return list of homework
     */
    public List<Homework> getByUserId(int userId){
        return hr.getHomeworkByUserId(userId);
    }

    /**
     * Get homework by id
     * @param id homework id
     * @return homework
     */
    public Homework getHwById(int id){
        return hr.findByHwId(id);
    }

}
