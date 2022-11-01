package App.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@CrossOrigin
/**
 * Grade table with columns id, userid, subjectid, and grade
 */
public class Grade {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int gradeId;

    @Column
    public int userId;

    @Column
    public int subjectId;

    @Column
    public int grade;

}
