package ngothanh.com.responsitory;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ngothanh.com.entity.Users;

@Repository
public interface UserResponsitory extends CrudRepository<Users,Integer>{
	
	Users findByUsername(String username);
	 
	@Query("SELECT u.role FROM Users u WHERE u.username = ?1")
	public String findRole (String username);
}
