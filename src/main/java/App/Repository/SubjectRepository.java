package App.Repository;

import App.Model.Subjects;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SubjectRepository extends JpaRepository<Subjects, Integer> {

    /**
     * Database query to find subject by name
     * @param name subject name
     * @return subject
     */
    Subjects findBySubjectName(String name);

    /**
     * Database query to find subject by id
     * @param id subject id
     * @return subject
     */
    Subjects findBySubjectId(int id);
}
