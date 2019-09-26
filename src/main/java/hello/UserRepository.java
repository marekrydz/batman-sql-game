package hello;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    String sqlQuery = "SELECT * FROM users u WHERE u.id = 1";

    @Query(
    value = sqlQuery,
    nativeQuery = true)
    User findOne();

    List<User> findByName(String name);
}
