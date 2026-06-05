package edu.inMemorySecurity.Controller;


import edu.inMemorySecurity.Exception.User.UserDatabaseAlreadyClearException;
import edu.inMemorySecurity.Exception.User.UsernameAlreadyInUseException;
import edu.inMemorySecurity.user.User;
import edu.inMemorySecurity.user.UserRepo;
import org.apache.juli.logging.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController             // Poderia fazer uma camada de service tbm
@RequestMapping(value = "users")
public record UserController(UserRepo userRepo) {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @GetMapping
    public List<User> getAllUsers(){
        log.info("Retornando todos os usuários");
        return userRepo.getAllUsers();
    }

    @PostMapping
    public ResponseEntity createUser(@RequestBody User user){
        if(userRepo.getAllUsers().contains(user)) throw new UsernameAlreadyInUseException();

        log.info("Criando usuário");
        userRepo.saveUser(user);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity deleteAllUsers(){
        if(userRepo.getAllUsers().size() == 0) throw new UserDatabaseAlreadyClearException();

        log.info("Limpando banco de dados de usuário");
        userRepo.clearUsers();

        return ResponseEntity.ok().build();
    }
}
