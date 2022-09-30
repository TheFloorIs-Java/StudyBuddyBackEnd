package App.Service;

import App.Model.Subjects;
import App.Repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@Component
@CrossOrigin
public class SubjectService {
    SubjectRepository sr;
    @Autowired
    public SubjectService(SubjectRepository sr){
        this.sr=sr;
    }

    public void addSubject(Subjects s) {
        sr.save(s);
    }
    public List<Subjects> allSubjects(){
        return sr.findAll();
    }

    public Subjects getSubjectByName(String name){
        return sr.findBySubjectName(name);
    }

    public Subjects getSubjectById(int id){
        return sr.findBySubjectId(id);
    }




}
