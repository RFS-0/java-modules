package ch.resrc.consumers.user;

import ch.resrc.domain.user.User;
import ch.resrc.providers.user.UserServiceImpl;
import ch.resrc.services.user.UserService;

public class UserServiceConsumer {

    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();
        System.out.println();
        System.out.println("--- User service returns the following users:");
        userService.getAllUsers().forEach(user -> System.out.println(user.getEmail()));
        printModulePath();
    }

    private static void printModulePath() {
        System.out.println();
        System.out.println(" --- Modularization infos ---");
        System.out.format("%-50s %-40s %s%n", "Class", "Module", "Packages in this module");
        Module moduleOfUser = User.class.getModule();
        Module moduleOfUserServiceImpl = UserServiceImpl.class.getModule();
        Module moduleOfUserService = UserService.class.getModule();
        Module moduleOfUserServiceConsumer = UserServiceConsumer.class.getModule();
        System.out.format("%-50s %-40s %s%n", User.class.getName(), moduleOfUser.getName(), moduleOfUser.getPackages());
        System.out.format("%-50s %-40s %s%n", UserServiceImpl.class.getName(), moduleOfUserServiceImpl.getName(), moduleOfUserServiceImpl.getPackages());
        System.out.format("%-50s %-40s %s%n", UserService.class.getName(), moduleOfUserService.getName(), moduleOfUserService.getPackages());
        System.out.format("%-50s %-40s %s%n", UserServiceConsumer.class.getName(), moduleOfUserServiceConsumer.getName(), moduleOfUserServiceConsumer.getPackages());
    }
}
