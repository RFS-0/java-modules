package ch.resrc.providers.user;

import ch.resrc.domain.user.User;
import ch.resrc.services.user.UserService;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UserServiceImpl implements UserService {

    private static final Map<String, User> USER_MAP = initializeUsers();

    private static Map<String, User> initializeUsers() {
        HashMap<String, User> userMap = new HashMap<>();
        userMap.put("Craig@Mooneyham", new User("Craig@Mooneyham", "Craig", "Mooneyham", "pw1"));
        userMap.put("Regina@Adams", new User("Regina@Adams", "Regina", "Adams", "pw2"));
        userMap.put("Jeff@Stephens", new User("Jeff@Stephens", "Jeff", "Stephens", "pw3"));
        userMap.put("Mary@Stone", new User("Mary@Stone", "Mary", "Stone", "pw4"));
        return userMap;
    }

    @Override
    public Set<User> getAllUsers() {
        return new HashSet<>(USER_MAP.values());
    }

    @Override
    public User getUser(String email) {
        return USER_MAP.get(email);
    }

    @Override
    public boolean authenticate(String email, String password) {
        return USER_MAP.get(email).getPassword().equals(password);
    }
}
