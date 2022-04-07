package ntnu.sindrgl.oving5.repository;

import ntnu.sindrgl.oving5.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User, String> {

}
