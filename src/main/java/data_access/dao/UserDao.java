package data_access.dao;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    public User findById(Long id) {
        return jdbcTemplate.queryForObject(
                "SELECT * FROM users WHERE id = ?",
                new Object[]{id},
                (rs, rowNum) -> {
                    User user = new User();
                    user.setId(rs.getLong("id"));
                    user.setUsername(rs.getString("username"));
                    user.setEmail(rs.getString("email"));
                    user.setRole(rs.getString("role"));
                    return user;
                });
    }

    public List<User> findAll() {
        return jdbcTemplate.query(
                "SELECT * FROM users",
                (rs, rowNum) -> {
                    User user = new User();
                    user.setId(rs.getLong("id"));
                    user.setUsername(rs.getString("username"));
                    user.setEmail(rs.getString("email"));
                    user.setRole(rs.getString("role"));
                    return user;
                });
    }

    public void save(User user) {
        jdbcTemplate.update(
                "INSERT INTO users (username, email, role) VALUES (?, ?, ?)",
                user.getUsername(), user.getEmail(), user.getRole());
    }

    public void update(User user) {
        jdbcTemplate.update(
                "UPDATE users SET username = ?, email = ?, role = ? WHERE id = ?",
                user.getUsername(), user.getEmail(), user.getRole(), user.getId());
    }

    public void delete(Long id) {
        jdbcTemplate.update("DELETE FROM users WHERE id = ?", id);
    }
}
