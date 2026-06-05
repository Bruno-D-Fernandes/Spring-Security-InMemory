package edu.inMemorySecurity.Exception.User;

public class UsernameAlreadyInUseException extends RuntimeException{

    public UsernameAlreadyInUseException() {
        super("Nome de usuário indisponível.");
    }

    public UsernameAlreadyInUseException(String message) {
        super(message);
    }
}
