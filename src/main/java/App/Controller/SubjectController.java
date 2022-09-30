package App.Controller;

import App.Model.Subjects;
import App.Model.Users;
import App.Service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class SubjectController {
    SubjectService ss;
    @Autowired
    public SubjectController(SubjectService ss){
        this.ss=ss;
    }
    @GetMapping("subjects")
    public List<Subjects> getAllSubjects(){
        //System.out.println(us.allUsers());
        return ss.allSubjects();
    }
    @PostMapping("subjects")
    public void addSubject(@RequestBody Subjects s){
        ss.addSubject(s);
    }
    @GetMapping("subjects/name/{name}")
    public Subjects getSubjectByName(@PathVariable String  name){
        //System.out.println(us.allUsers());
       return ss.getSubjectByName(name);
    }
    @GetMapping("subjects/id/{id}")
    public Subjects getSubjectByName(@PathVariable int  id){
        //System.out.println(us.allUsers());
        return ss.getSubjectById(id);
    }
}
