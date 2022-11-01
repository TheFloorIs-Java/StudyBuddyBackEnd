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

    /**
     * Adds subject to database
     * @param s subject
     */
    public void addSubject(Subjects s) {
        sr.save(s);
    }

    /**
     * Gets all subjects
     * @return list of subject
     */
    public List<Subjects> allSubjects(){
        return sr.findAll();
    }

    /**
     * Gets subjects by name
     * @param name subject name
     * @return subject
     */
    public Subjects getSubjectByName(String name){
        return sr.findBySubjectName(name);
    }

    /**
     * Gets subject by id
     * @param id subject id
     * @return subject
     */
    public Subjects getSubjectById(int id){
        return sr.findBySubjectId(id);
    }




}
