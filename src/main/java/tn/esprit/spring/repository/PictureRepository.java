package tn.esprit.spring.repository;


import tn.esprit.spring.entity.Pictures;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PictureRepository  extends CrudRepository<Pictures, Long> {

}
