package App.Repository;

import App.Model.Complete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CompleteRepository extends JpaRepository<Complete, Integer> {
    /**
     * Datbase query to get all completed items by user and subject
     * @param userId id of user
     * @param subjectId is of subject
     * @return list of complete
     */
    @Query("FROM Complete WHERE userId= :userId AND subjectId= :subjectId")
    public List<Complete> getHwCompletedByUserAndSubjectId(@Param("userId") int userId, @Param("subjectId") int subjectId);


}
