package edu.inMemorySecurity.Exception.User;

public class UserDatabaseAlreadyClearException extends RuntimeException{
    public UserDatabaseAlreadyClearException() {
        super("Banco de dados de usuário já está vazio");
    }

    public UserDatabaseAlreadyClearException(String message) {
        super(message);
    }
}
