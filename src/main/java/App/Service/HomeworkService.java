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
    public List<Homework> getAllHomeworks(){
        return hr.findAll();
    }
    public void addHomeworkItem(Homework item){
        hr.save(item);
    }

    public List<Homework> getHomeworkByUserAndSubjectId(int userId,int subjectId){
        return hr.findByUserIdAndSubjectId(userId,subjectId);
    }
    public void deleteHomeworkItem(int hwId){
       Homework hw = hr.findByHwId(hwId);
       Complete c = new Complete();
       c.completeItem=hw.getHwItem();
       c.userId=hw.getUserId();
       c.subjectId = hw.getSubjectId();
       cr.save(c);
       hr.deleteById(hwId);
    }
    public List<Homework> getByUserId(int userId){
        return hr.getHomeworkByUserId(userId);
    }

    public Homework getHwById(int id){
        return hr.findByHwId(id);
    }

}
