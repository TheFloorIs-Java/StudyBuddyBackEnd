package App.Repository;

import App.Model.Homework;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface HomeworkRepository extends JpaRepository<Homework, Integer> {
    @Query("FROM Homework WHERE userId= :userId AND subjectId= :subjectId")
    public List<Homework> getHomeworkByUserandSubjectId(@Param("userId") int userId, @Param("subjectId") int subjectId);

    public List findByUserIdAndSubjectId(int userId, int subjectId);

    @Query("FROM Homework WHERE hwId= :hwId")
    public Homework findByHwId(@Param("hwId") int hwId);

    @Query("FROM Homework WHERE userId = :userId")
    public List<Homework> getHomeworkByUserId(@Param("userId") int userId);

}
