package enums;

import java.util.stream.Stream;

public enum Users {

    PITER_CHAILOVSKII("PITER CHAILOVSKII", "epam", "1234");

    public String name;
    public String login;
    public String password;

    Users(String name, String login, String password) {
        this.name = name;
        this.login = login;
        this.password = password;
    }

    public static Users getByName(String name) {
        return Stream.of(Users.values()).filter(u -> u.name.equals(name.toUpperCase())).findFirst().orElseThrow(RuntimeException::new);
    }
}
