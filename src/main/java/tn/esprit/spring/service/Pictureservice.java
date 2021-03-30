package tn.esprit.spring.service;
import tn.esprit.spring.entity.Pictures;
import java.util.List;




public interface Pictureservice {
	List<Pictures> getPictures();

	Pictures  addPictures(Pictures Pictures);
    void deletePictures(Long idpic) ;
    Pictures updatePictures(Pictures Pictures);
}
	