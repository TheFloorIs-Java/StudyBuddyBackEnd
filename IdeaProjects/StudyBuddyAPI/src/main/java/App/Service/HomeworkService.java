package App.Service;

import App.Model.Homework;
import App.Repository.HomeworkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HomeworkService {
    HomeworkRepository hr;
    @Autowired
    public HomeworkService(HomeworkRepository hr){
        this.hr = hr;
    }
    public List<Homework> getAllHomeworks(){
        return hr.findAll();
    }
    public void addHomeworkItem(Homework item){
        hr.save(item);
    }

//    public List<Homework> getHomeworkByUserAndSubjectId(int userId,int subjectId){
//        return hr.getHomeworkByUserandSubjectId(userId,subjectId);
//    }

}