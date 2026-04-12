package ru.netology.spring_boot_rest.pojo;

import lombok.Getter;
import lombok.Setter;
import ru.netology.spring_boot_rest.enums.Authorities;

import java.util.List;

@Setter
@Getter
public class User {
    private String login;
    private String password;
    private List<Authorities> permission;

    public User() {}

    public User(String login, String password, List<Authorities> permission) {
        this.login = login;
        this.password = password;
        this.permission = permission;
    }
}
