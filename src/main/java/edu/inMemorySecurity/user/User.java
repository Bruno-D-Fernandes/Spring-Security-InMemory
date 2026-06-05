package edu.inMemorySecurity.user;


//Entity
public record User(
        String username,
        String password,
        UserRole role
){
    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }
}
