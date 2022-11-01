package App.Repository;

import App.Model.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface GradeRepository extends JpaRepository <Grade, Integer> {

 /**
  * Database query to get grades by user
  * @param userId id of user
  * @return list of grade
  */
    @Query("FROM Grade WHERE userId= :userId")
    List<Grade> getGradesByUserId(@Param("userId") int userId);

  /**
  * Database query to get grades by user and subject
  * @param userId id of user
  * @param subjectId id of subject
  *  @return list of grade
  */
    @Query("FROM Grade WHERE userId= :userId AND subjectId= :subjectId")
    Grade getGradesByUserIdAndSubjectId(@Param("userId") int userId, @Param("subjectId")int subjectId);
}
