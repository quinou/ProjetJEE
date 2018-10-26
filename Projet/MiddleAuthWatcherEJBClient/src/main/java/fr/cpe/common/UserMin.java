package fr.cpe.common;

public class UserMin {
    private String login;
    private boolean validAuth;
    private Role role;

    public UserMin(String login, boolean valid, Role role) {
        this.validAuth = valid;
        this.login = login;
        this.role = role;
    }

    public String getLogin() {
        return login;
    }

    public boolean getValidAuth() {
        return validAuth;
    }

    public Role getRole() {
        return role;
    }
}
