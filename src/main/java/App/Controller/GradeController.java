package App.Controller;


import App.Model.Grade;
import App.Service.GradeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("grades")
@Slf4j

public class GradeController {
    GradeService gradeService;

    @Autowired
    public GradeController(GradeService gradeService) {
        this.gradeService = gradeService;
    }

    //GET ALL GRADES
    @GetMapping()
    public List<Grade> getAllGrades() {
        return gradeService.getAllGrades();
    }

    //GET ALL GRADES BY userId
    @GetMapping("/{userId}")
    public List<Grade> getGradesByUserId(@PathVariable("userId") int userId) {
        return gradeService.getGradesByUserId(userId);
    }

    //GET GRADE BY userId + subjectId - Isolating one grade from db to be able to access the gradeId for UPDATE
    @GetMapping("/{userId}/{subjectId}")
    public Grade getGradesByUserIdAndSubjectId(@PathVariable("userId") int userId,
                                                        @PathVariable ("subjectId") int subjectId) {
        return gradeService.getGradesByUserIdAndSubjectId(userId, subjectId);
    }

    //POST - ADD NEW GRADE
    @PostMapping()
    public Grade addGrade(@RequestBody Grade grade) {
        return gradeService.addGrade(grade);
    }

    //PUT - UPDATE
    @PutMapping()
    public Grade updateGrade(@RequestBody Grade grade) {
        return gradeService.updateGrade(grade);
    }

    //DELETE WITH gradeId - NOT USED
    @DeleteMapping("/{gradeId}")
    public void deleteGradeByGradeId(@PathVariable("gradeId") int gradeId) {
        gradeService.deleteGradeByGradeId(gradeId);
    }

}
