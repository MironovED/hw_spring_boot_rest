package ru.netology.spring_boot_rest.pojo;

import lombok.Getter;
import lombok.Setter;
import ru.netology.spring_boot_rest.enums.Authorities;

import java.util.List;

@Setter
@Getter
public class User {
    private String user;
    private String password;
    private List<Authorities> permission;

    public User() {}

    public User(String user, String password, List<Authorities> permission) {
        this.user = user;
        this.password = password;
        this.permission = permission;
    }

    public User(String user, String password) {
        this.user = user;
        this.password = password;
    }
}
