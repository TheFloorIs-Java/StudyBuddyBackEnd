package App.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
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
