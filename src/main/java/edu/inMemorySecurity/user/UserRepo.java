package edu.inMemorySecurity.user;

import edu.inMemorySecurity.user.User;
import edu.inMemorySecurity.user.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepo {

    private final PasswordEncoder passwordEncoder;
    private final List<User> userData;

    @Autowired
    public UserRepo(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
        this.userData = new ArrayList<>();
    }

    public void saveUser(User user) {
        this.userData.add(user);
    }

    public List<User> getAllUsers() {
        return List.copyOf(userData);
    }

    public void clearUsers() {
        this.userData.clear();
    }

    public long getStatistics() {
        return userData.size();
    }
}