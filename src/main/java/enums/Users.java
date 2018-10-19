package enums;

public enum Users {

    PITER_CHAILOVSKII("epam", "1234");

    public String login;
    public String password;


    Users(String login, String password) {
        this.login = login;
        this.password = password;
    }
}
