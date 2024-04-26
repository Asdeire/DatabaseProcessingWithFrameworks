package data_access.dao;

import model.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TagDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Tag findById(Long id) {
        return jdbcTemplate.queryForObject(
                "SELECT * FROM tags WHERE id = ?",
                new Object[]{id},
                (rs, rowNum) -> {
                    Tag tag = new Tag();
                    tag.setId(rs.getLong("id"));
                    tag.setName(rs.getString("name"));
                    return tag;
                });
    }

    public List<Tag> findAll() {
        return jdbcTemplate.query(
                "SELECT * FROM tags",
                (rs, rowNum) -> {
                    Tag tag = new Tag();
                    tag.setId(rs.getLong("id"));
                    tag.setName(rs.getString("name"));
                    return tag;
                });
    }

    public void save(Tag tag) {
        jdbcTemplate.update(
                "INSERT INTO tags (name) VALUES (?)",
                tag.getName());
    }

    public void update(Tag tag) {
        jdbcTemplate.update(
                "UPDATE tags SET name = ? WHERE id = ?",
                tag.getName(), tag.getId());
    }

    public void delete(Long id) {
        jdbcTemplate.update("DELETE FROM tags WHERE id = ?", id);
    }
}

