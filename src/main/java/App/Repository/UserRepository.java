package App.Repository;

import App.Model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<Users, Integer> {
//    @Query("FROM User WHERE username= :usernema AND subjectId= :subjectId")
//    public List<Homework> getHomeworkByUserandSubjectId(@Param("userId") int userId, @Param("subjectId") int subjectId);
}
