package edu.iba.lilya.bean;

public class UserBean {

    private String user;
    private String password;
    private String role;

    public String getUser() {
        return user;
    }

    public void setUser(String users) {
        user = users;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return user + " " + password + " " + role;
    }
}
