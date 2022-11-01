package App.Controller;


import App.Model.Users;
import App.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class UserController {
    UserService us;
    @Autowired
    public UserController(UserService us){
        this.us = us;
    }

    /**
     * Get request to get all users
     * @return list of users
     */
    @GetMapping("users")
    public List<Users> getAllUsers(){
        return us.allUsers();
    }

    /**
     * Post request to add a user
     * @param u user
     */
    @PostMapping("users")
    public void addUser(@RequestBody Users u){
        System.out.println(u.toString());
         us.addUser(u);
    }

}
