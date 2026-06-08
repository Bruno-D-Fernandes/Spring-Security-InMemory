package edu.inMemorySecurity.Service;

import edu.inMemorySecurity.user.UserRepo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public record AuthService(UserRepo userRepo) implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails userDetails = (UserDetails) userRepo.getAllUsers().stream()
                .filter(user -> user.username().equals(username));

        return userDetails;
    }
}
