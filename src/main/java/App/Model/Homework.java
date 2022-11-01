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
 * Homework table with columns hwid, userid, subjectid, and hwItem
 */
public class Homework {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int hwId;
    @Column
    public int userId;
    @Column
    public int subjectId;
    @Column
    public String hwItem;

}
