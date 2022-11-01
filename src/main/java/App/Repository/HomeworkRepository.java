package App.Repository;

import App.Model.Homework;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface HomeworkRepository extends JpaRepository<Homework, Integer> {

    /**
     * Database query to get all homework by id
     * @param hwId id of homework
     * @return homework
     */
    @Query("FROM Homework WHERE hwId= :hwId")
    public Homework findByHwId(@Param("hwId") int hwId);

    /**
     * Database query to get all homework by user
     * @param userId id of user
     * @return list of homework
     */
    @Query("FROM Homework WHERE userId = :userId")
    public List<Homework> getHomeworkByUserId(@Param("userId") int userId);

    /**
     * Database query to get homework by user and subject
     * @param userId id of user
     * @param subjectId id of subject
     * @return list of homework
     */
    List<Homework> findByUserIdAndSubjectId(int userId, int subjectId);
}
