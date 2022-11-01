package App.Service;

import App.Model.Users;
import App.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@Component
@CrossOrigin
public class UserService {
    UserRepository ur;
    @Autowired
    public UserService( UserRepository ur){
        this.ur=ur;
    }

    /**
     * Get all users from database
     * @return list of users
     */
    public List<Users> allUsers(){
        return ur.findAll();
    }

    /**
     * Add a user to database
     * @param u user
     */
    public void addUser(Users u){
        ur.save(u);
    }
}
