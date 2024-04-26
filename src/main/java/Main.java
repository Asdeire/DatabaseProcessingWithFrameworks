

import config.SpringConfig;
import data_access.dao.UserDao;
import model.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);


        UserDao userDao = context.getBean(UserDao.class);

        List<User> users = userDao.findAll();

        for (User user : users) {
            System.out.println(user);
        }

        context.close();
    }
}

