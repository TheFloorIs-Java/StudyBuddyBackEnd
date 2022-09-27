package App.Repository;

import App.Model.Homework;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface HomeworkRepository extends JpaRepository<Homework, Integer> {
//    @Query(value = "SELECT * FROM Homework where userId=:userId AND subjectId=:subjectId")
//    public List<Homework> getHomeworkByUserandSubjectId(@Param("userId") int userId, @Param("subjectId") int subjectId);
}
