package UseCase;

public class UserUpdateInfo {
    String username;
    String password;
    String email;

    public UserUpdateInfo(String username, String password, String email){
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public String getUsername(){
        return this.username;
    }
    public String getPassword(){
        return this.password;
    }
    public String getEmail(){
        return this.email;
    }

    public void changeUsername(String newUsername){
        this.username = newUsername;
    }
    public void changePassowrd(String newPassword){
        this.password = newPassword;
    }
    public void changeEmail(String newEmail){
        this.email = newEmail;
    }

}
