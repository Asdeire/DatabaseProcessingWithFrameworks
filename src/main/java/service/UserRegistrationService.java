package service;

import data_access.dao.UserDao;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRegistrationService {

    private final UserDao userDao;

    @Autowired
    public UserRegistrationService(UserDao userDao) {
        this.userDao = userDao;
    }

    public void registerUser(String username, String email, String password, String role) {
        User newUser = new User();
        newUser.setUsername(username);
        newUser.setEmail(email);
        newUser.setPassword(password);
        newUser.setRole(role);
        userDao.save(newUser);
    }
}
