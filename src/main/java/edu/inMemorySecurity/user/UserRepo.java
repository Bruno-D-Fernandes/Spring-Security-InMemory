package edu.inMemorySecurity.user;


import org.springframework.stereotype.Repository;

import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.Stream;

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

    // fazer algo com strem aqui.
    public long getStatistics(){

        long quantidade = userData.size();
        return quantidade;
    }
}
