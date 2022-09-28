package App.Service;

import App.Model.Users;
import App.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserService {
    UserRepository ur;
    @Autowired
    public UserService( UserRepository ur){
        this.ur=ur;
    }

    public List<Users> allUsers(){
        return ur.findAll();
    }
    public void addUser(Users u){
        System.out.println(u.toString());
        ur.save(u);
    }
}
