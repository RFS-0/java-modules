package ch.resrc.consumers.user;

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
        userMap.put("Hugh@Davis", new User("Hugh@Davis", "Hugh", "Davis", "pw5"));
        userMap.put("Carolyn@Rudzik", new User("Carolyn@Rudzik", "Carolyn", "Rudzik", "pw6"));
        userMap.put("Alyce@Adams", new User("Alyce@Adams", "Alyce", "Adams", "pw7"));
        userMap.put("Derrick@Hill", new User("Derrick@Hill", "Derrick", "Hill", "pw8"));
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
