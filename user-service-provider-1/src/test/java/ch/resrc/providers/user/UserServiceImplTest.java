package ch.resrc.providers.user;

import ch.resrc.domain.user.User;
import ch.resrc.services.user.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

class UserServiceImplTest {
    private UserService userService;

    @BeforeEach
    void setUp() {
        userService = new UserServiceImpl();
    }

    @Test
    void getUsers_four_users() {
        Set<User> allUsers = userService.getAllUsers();

        assertNotNull(allUsers);
        assertEquals(4, allUsers.size());
    }

    @Test
    void loaded_from_named_module() {
        Module module = UserServiceImplTest.class.getModule();

        assumeTrue(module::isNamed, "Needs to be a named module.");
        assertEquals("providers.user", module.getName());
    }
}