package data_access.dao;

import model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PostDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Post findById(Long id) {
        return jdbcTemplate.queryForObject(
                "SELECT * FROM posts WHERE id = ?",
                new Object[]{id},
                (rs, rowNum) -> {
                    Post post = new Post();
                    post.setId(rs.getLong("id"));
                    post.setTitle(rs.getString("title"));
                    post.setContent(rs.getString("content"));
                    // Set user if needed
                    return post;
                });
    }

    public List<Post> findAll() {
        return jdbcTemplate.query(
                "SELECT * FROM posts",
                (rs, rowNum) -> {
                    Post post = new Post();
                    post.setId(rs.getLong("id"));
                    post.setTitle(rs.getString("title"));
                    post.setContent(rs.getString("content"));
                    // Set user if needed
                    return post;
                });
    }

    public void save(Post post) {
        jdbcTemplate.update(
                "INSERT INTO posts (title, content) VALUES (?, ?)",
                post.getTitle(), post.getContent());
    }

    public void update(Post post) {
        jdbcTemplate.update(
                "UPDATE posts SET title = ?, content = ? WHERE id = ?",
                post.getTitle(), post.getContent(), post.getId());
    }

    public void delete(Long id) {
        jdbcTemplate.update("DELETE FROM posts WHERE id = ?", id);
    }
}

