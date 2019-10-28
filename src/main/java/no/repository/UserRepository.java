package no.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import no.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	List<User> findByUserNameOrPassword(String username, String password);
	
	
//	@Query ("SELECT u FROM User u WHERE"
//			+"(:userName IS NULL OR u.userName LIKE :userName) AND"
//			+"(:userFirstName IS NULL OR u.userFirstName LIKE :userFirstName) AND"
//			+"(:userLasttName IS NULL OR u.userLasttName LIKE :userLasttName)"
//			)
//	List<User> search(
//			@Param("userName") String userName,
//			@Param("userFirstName") String userFirsName,
//			)
//	
	

}
