package App.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@CrossOrigin
/**
 * Subject table with columns subjectId, subjectName, and tips
 */
public class Subjects {
    @Id
    @Column
    public int subjectId;
    @Column
    public String subjectName;
    @Column
    public String tips;
}
