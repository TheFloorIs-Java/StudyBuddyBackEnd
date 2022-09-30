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
public class Complete {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int completeId;
    @Column
    public int userId;
    @Column
    public int subjectId;
    @Column
    public String completeItem;

}
