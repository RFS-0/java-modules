package ch.resrc.consumers.user;

import java.net.URL;
import java.net.URLClassLoader;
import java.util.Arrays;

public class UserServiceConsumer {

    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();
        userService.getAllUsers().forEach(user -> System.out.println(user.getEmail()));
        printClasspath();
    }

    private static void printClasspath() {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        URL[] urls = ((URLClassLoader) classLoader).getURLs();
        System.out.println(" --- CLASSPATH ---");
        Arrays.stream(urls).forEach(url -> System.out.println(url.getFile()));
    }
}
