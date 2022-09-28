package App.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Subjects {
    @Id
    @Column
    public int subjectId;
    @Column
    public String subjectName;
    @Column
    public String tips;
}
