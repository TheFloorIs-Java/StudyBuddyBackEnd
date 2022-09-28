package App.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
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
