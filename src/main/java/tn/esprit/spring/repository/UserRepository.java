package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.spring.entity.DAOUser;
import tn.esprit.spring.entity.ProfileEnum;

@Repository
public interface UserRepository extends CrudRepository<DAOUser, Long>{
	@Modifying@Transactional
	@Query("update DAOUser u set u.profile = :prof where u.id = :imiu")
	void setProfileForDAOUser(@Param("prof")ProfileEnum profile, @Param("imiu")Long id);
	
	List<DAOUser> findByName(String name);
	DAOUser findByemail(String email);

}
