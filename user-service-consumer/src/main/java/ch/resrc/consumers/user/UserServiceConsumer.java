package ch.resrc.consumers.user;

import java.util.Arrays;

public class UserServiceConsumer {

    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();
        userService.getAllUsers().forEach(user -> System.out.println(user.getEmail()));
        printModulepath();
    }

    private static void printModulepath() {
        // Java SE platfrom
        System.out.println(" --- Plattform packages ---");
        Arrays.stream(ClassLoader.getPlatformClassLoader().getDefinedPackages()).forEach(System.out::println);
        // Application specific packages
        System.out.println(" --- Application packages ---");
        Arrays.stream(ClassLoader.getSystemClassLoader().getDefinedPackages()).forEach(System.out::println);
    }
}
