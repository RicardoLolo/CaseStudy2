package LoginPermission;

import java.io.Serializable;

public class LoginManagement implements Serializable {
    private String username;
    private String account;
    private String passWord;

    public LoginManagement(String username, String account, String passWord) {
        this.username = username;
        this.account = account;
        this.passWord = passWord;
    }

    public LoginManagement(String account, String password) {
        this.account = account;
        this.passWord = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    @Override
    public String toString() {
        return "LoginManagement{" +
                "username='" + username + '\'' +
                ", account='" + account + '\'' +
                ", passWord='" + passWord + '\'' +
                '}';
    }
}
