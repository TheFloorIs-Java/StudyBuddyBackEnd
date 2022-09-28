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
public class Users {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int userId;
    @Column
    public String name;
    @Column
    public String username;
    @Column
    public String password;


}