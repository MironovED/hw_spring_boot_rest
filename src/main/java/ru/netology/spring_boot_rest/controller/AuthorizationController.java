package ru.netology.spring_boot_rest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.netology.spring_boot_rest.enums.Authorities;
import ru.netology.spring_boot_rest.exceptions.InvalidCredentials;
import ru.netology.spring_boot_rest.exceptions.UnauthorizedUser;
import ru.netology.spring_boot_rest.service.AuthorizationService;

import java.util.List;

@RestController
public class AuthorizationController {
    AuthorizationService service;

    AuthorizationController(AuthorizationService authorizationService) {
        this.service = authorizationService;
    }

    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(@RequestParam("user") String user,
                                            @RequestParam("password") String password
    ) {
        return service.getAuthorities(user, password);
    }

    @ExceptionHandler
    public ResponseEntity<String> invalidCredentialsHandler(InvalidCredentials e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<String> unauthorizedUserHandler(UnauthorizedUser e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.UNAUTHORIZED);
    }
}
