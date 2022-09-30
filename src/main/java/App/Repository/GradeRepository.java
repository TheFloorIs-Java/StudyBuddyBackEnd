package App.Repository;

import App.Model.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface GradeRepository extends JpaRepository <Grade, Integer> {

   //FILTER BY USERID - This is used to grab data from the grade db by the userId to be displayed in the
   // "Report-Card" component of the user profile.
    @Query("FROM Grade WHERE userId= :userId")
    List<Grade> getGradesByUserId(@Param("userId") int userId);

    //FILTER BY USERID + SUBJECTID - This is used to grab the gradeId from the grade db by the userId and subjectId,
    // this is necessary for the update function.
    @Query("FROM Grade WHERE userId= :userId AND subjectId= :subjectId")
    Grade getGradesByUserIdAndSubjectId(@Param("userId") int userId, @Param("subjectId")int subjectId);
}
