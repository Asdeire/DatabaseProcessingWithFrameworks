package data_access.dao;

import model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CommentDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;



    public Comment findById(Long id) {
        return jdbcTemplate.queryForObject(
                "SELECT * FROM comments WHERE id = ?",
                new Object[]{id},
                (rs, rowNum) -> {
                    Comment comment = new Comment();
                    comment.setId(rs.getLong("id"));
                    comment.setContent(rs.getString("content"));
                    // Set user and post if needed
                    return comment;
                });
    }

    public List<Comment> findAll() {
        return jdbcTemplate.query(
                "SELECT * FROM comments",
                (rs, rowNum) -> {
                    Comment comment = new Comment();
                    comment.setId(rs.getLong("id"));
                    comment.setContent(rs.getString("content"));
                    // Set user and post if needed
                    return comment;
                });
    }

    public void save(Comment comment) {
        jdbcTemplate.update(
                "INSERT INTO comments (content) VALUES (?)",
                comment.getContent());
    }

    public void update(Comment comment) {
        jdbcTemplate.update(
                "UPDATE comments SET content = ? WHERE id = ?",
                comment.getContent(), comment.getId());
    }

    public void delete(Long id) {
        jdbcTemplate.update("DELETE FROM comments WHERE id = ?", id);
    }
}
