
package team5.repo;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

import team5.model.RoleType;
import team5.model.User;


public interface UserRepo extends JpaRepository<User, Long> {
	public User findByUserName(String userName);
	public ArrayList<User> findByRole(RoleType roleType);
}

