package ru.netology.spring_boot_rest.repository;

import org.springframework.stereotype.Repository;
import ru.netology.spring_boot_rest.enums.Authorities;
import ru.netology.spring_boot_rest.pojo.User;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Возвращает разрешения для пользователя
 */
@Repository
public class UserRepository {
    private final List<User> users = Arrays.asList(
            new User("Ivan", "q12345", Arrays.asList(Authorities.READ)),
            new User("Oleg", "Qq12345", Arrays.asList(Authorities.READ, Authorities.WRITE)),
            new User("Denis", "Ww12345", Arrays.asList(Authorities.READ, Authorities.WRITE, Authorities.DELETE))
    );

    public List<Authorities> getUserAuthorities(String user, String password) {
        Optional<User> obj = users.stream()
                .filter((o) -> o.getUser().equals(user) && o.getPassword().equals(password))
                .findFirst();
        return obj.map(User::getPermission).orElse(null);
    }
}