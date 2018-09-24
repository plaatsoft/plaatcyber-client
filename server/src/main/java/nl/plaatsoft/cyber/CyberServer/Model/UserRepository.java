package nl.plaatsoft.cyber.CyberServer.Model;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

	 public User findById(long id);
}
