package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context =
              new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      userService.add(new User("User1", "Lastname1", "user1@mail.ru"));
      userService.add(new User("User2", "Lastname2", "user2@mail.ru"));
      userService.add(new User("User3", "Lastname3", "user3@mail.ru"));
      userService.add(new User("User4", "Lastname4", "user4@mail.ru"));

      Car car1 = new Car("audi", 11);
      Car car2 = new Car("audi", 12);
      Car car3 = new Car("bmv", 1);
      Car car4 = new Car("bmv", 5);
      Car car5 = new Car("bmv", 7);

      userService.addCar(car1);
      userService.addCar(car2);
      userService.addCar(car3);
      userService.addCar(car4);
      userService.addCar(car5);

      userService.add(new User("User5", "Lastname5", "user5@mail.ru", car1));
      userService.add(new User("User6", "Lastname6", "user6@mail.ru", car2));
      userService.add(new User("User7", "Lastname7", "user7@mail.ru", car3));
      userService.add(new User("User8", "Lastname8", "user8@mail.ru", car4));
      userService.add(new User("User9", "Lastname9", "user9@mail.ru", car5));

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = " + user.getId());
         System.out.println("First Name = " + user.getFirstName());
         System.out.println("Last Name = " + user.getLastName());
         System.out.println("Email = " + user.getEmail());
         System.out.println("Car = " + user.getCar());
         System.out.println();
      }

      User user = userService.getUserByCar("audi", 12);
      if (user == null) {
         System.out.println("Пользователей с таким автомобилем нет");
      } else {
         System.out.println(user);
      }

      context.close();
   }
}
