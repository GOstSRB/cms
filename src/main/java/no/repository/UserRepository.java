package no.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import no.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	List<User> findByUserNameAndPassword(String username, String password);
	
	
	@Query ("SELECT u FROM User u WHERE "
			+"(:username IS NULL OR u.userName LIKE :username) AND"
			+"(:firstname IS NULL OR u.firstName LIKE :firstname) AND"
			+"(:lastname IS NULL OR u.lastName LIKE :lastname)"
			)
	Page<User> search(
			@Param("username") String userName,
			@Param("firstname") String firstName,
			@Param("lastname") String lastName,
 			Pageable pageRequest
			);
	
	

}
