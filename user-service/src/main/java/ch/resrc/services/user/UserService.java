package ch.resrc.services.user;

import ch.resrc.domain.user.User;

import java.util.Set;

public interface UserService {

    Set<User> getAllUsers();

    User getUser(String email);

    boolean authenticate(String email, String password);
}
