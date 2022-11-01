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

    /**
     * Get request to get all grades for all users and subjects
     * @return list of grades
     */
    @GetMapping()
    public List<Grade> getAllGrades() {
        return gradeService.getAllGrades();
    }

    /**
     * Get request to get all grades for a user
     * @param userId id of user
     * @return list of grades
     */
    @GetMapping("/{userId}")
    public List<Grade> getGradesByUserId(@PathVariable("userId") int userId) {
        return gradeService.getGradesByUserId(userId);
    }

    /**
     * Get request to get a grade for a subject and user
     * @param userId id of user
     * @param subjectId id of subject
     * @return grade
     */
    @GetMapping("/{userId}/{subjectId}")
    public Grade getGradesByUserIdAndSubjectId(@PathVariable("userId") int userId,
                                                        @PathVariable ("subjectId") int subjectId) {
        return gradeService.getGradesByUserIdAndSubjectId(userId, subjectId);
    }


    /**
     * Post request to add a grade
     * @param grade grade to add
     * @return added grade or error
     */
    @PostMapping()
    public Grade addGrade(@RequestBody Grade grade) {
        return gradeService.addGrade(grade);
    }

    /**
     * Put request to update a grade
     * @param grade grade to update
     * @return updated grade or error
     */
    @PutMapping()
    public Grade updateGrade(@RequestBody Grade grade) {
        return gradeService.updateGrade(grade);
    }

    /**
     * Delete request to delete a grade
     * @param gradeId id of grade
     */
    @DeleteMapping("/{gradeId}")
    public void deleteGradeByGradeId(@PathVariable("gradeId") int gradeId) {
        gradeService.deleteGradeByGradeId(gradeId);
    }

}
