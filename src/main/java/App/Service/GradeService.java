package App.Service;

import App.Model.Grade;
import App.Repository.GradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GradeService {
    GradeRepository gradeRepository;

    @Autowired
    public GradeService(GradeRepository gradeRepository) {
        this.gradeRepository = gradeRepository;
    }

    /**
     * Gets all the grades for all users and grades
     * @return list of grade
     */
    public List<Grade> getAllGrades() {
        return gradeRepository.findAll();
    }

    /**
     * Gets all grades by user
     * @param userId id of user
     * @return list of grade
     */
    public List<Grade> getGradesByUserId(int userId) {
        return gradeRepository.getGradesByUserId(userId);
    }

    /**
     * Gets grade by user and subject
     * @param userId id of user
     * @param subjectId id of subject
     * @return grade
     */
    public Grade getGradesByUserIdAndSubjectId(int userId, int subjectId) {
        return gradeRepository.getGradesByUserIdAndSubjectId(userId, subjectId);
    }

    /**
     * Adds a new grade
     * @param grade grade to be added
     * @return added grade or error
     */
    public Grade addGrade(Grade grade) {
        //CHECKING TO SEE IF THE subjectId ALREADY EXISTS FOR THIS userId, IF IT DOES THE GRADE WILL NOT BE ADDED
        Grade existingGrade = gradeRepository.getGradesByUserIdAndSubjectId(grade.userId, grade.subjectId);
        if (existingGrade == null) {
            return gradeRepository.save(grade);
        }
        //IT WILL RETURN THE EXISTING GRADE
        return existingGrade;
    }

    /**
     * Updates grade in database
     * @param grade grade to update
     * @return updated grade or error
     */
    public Grade updateGrade(Grade grade){
        return gradeRepository.save(grade);
    }

    /**
     * Deletes grade by id
     * @param gradeId id of grade
     */
    public void deleteGradeByGradeId(int gradeId) {
        gradeRepository.deleteById(gradeId);
    }


}
