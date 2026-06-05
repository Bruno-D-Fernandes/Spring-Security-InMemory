package edu.inMemorySecurity.user;


import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

//DAO
@Repository
public class UserRepo {

    List<User> userData = new ArrayList<User>();

    public void saveUser(User user){
        this.userData.add(user);
    }

    public List<User> getAllUsers(){
        return List.copyOf(userData);
    }

    public void clearUsers(){
        this.userData.clear();
    }


}
