package App.Repository;

import App.Model.Complete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CompleteRepository extends JpaRepository<Complete, Integer> {
    @Query("FROM Complete WHERE userId= :userId AND subjectId= :subjectId")
    public List<Complete> getHwCompletedByUserAndSubjectId(@Param("userId") int userId, @Param("subjectId") int subjectId);
}
