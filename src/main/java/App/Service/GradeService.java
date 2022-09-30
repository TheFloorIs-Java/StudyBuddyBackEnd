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

    //LIST ALL GRADES
    public List<Grade> getAllGrades() {
        return gradeRepository.findAll();
    }

    //LIST ALL GRADES BY userId
    public List<Grade> getGradesByUserId(int userId) {
        return gradeRepository.getGradesByUserId(userId);
    }

    //LIST ALL GRADES BY userId + subjectId
    public Grade getGradesByUserIdAndSubjectId(int userId, int subjectId) {
        return gradeRepository.getGradesByUserIdAndSubjectId(userId, subjectId);
    }

    //POST - ADD NEW GRADE
    public Grade addGrade(Grade grade) {
        //CHECKING TO SEE IF THE subjectId ALREADY EXISTS FOR THIS userId, IF IT DOES THE GRADE WILL NOT BE ADDED
        Grade existingGrade = gradeRepository.getGradesByUserIdAndSubjectId(grade.userId, grade.subjectId);
        if (existingGrade == null) {
            return gradeRepository.save(grade);
        }
        //IT WILL RETURN THE EXISTING GRADE
        return existingGrade;
    }

    //UPDATE GRADE FOR PUT
    public Grade updateGrade(Grade grade){
        return gradeRepository.save(grade);
    }

    //DELETE GRADE BY gradeId - NOT USED
    public void deleteGradeByGradeId(int gradeId) {
        gradeRepository.deleteById(gradeId);
    }


}
