package App.Repository;

import App.Model.Subjects;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SubjectRepository extends JpaRepository<Subjects, Integer> {

//    @Query("FROM Subjects WHERE subjectName= :subjectName")
//    public Subjects findBySubjectNameIs(@Param("subjectName")String subjectName);
    public Subjects findBySubjectName(String subjectName);
//    @Query("FROM Subjects WHERE subjectId= :subjectId")
//    public Subjects findById(@Param("subjectId")int subjectId);

    public Subjects findBySubjectId(int subjectId);
}
