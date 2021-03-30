package tn.esprit.spring.service;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import tn.esprit.spring.entity.Pictures;
import org.springframework.stereotype.Service;
import tn.esprit.spring.repository.PictureRepository;

@Service
public  class Pictureserviceempl implements Pictureservice {

	@Autowired
	PictureRepository PictureRepository;
	private static final Logger L = LogManager.getLogger(Pictureserviceempl.class);
	
	@Override
	public List<Pictures> getPictures() {
		List<Pictures> Pictures = (List<Pictures>) PictureRepository.findAll();
		for (Pictures Picture : Pictures) {
			L.info("Pictures +++ : " + Picture );
		}
		return Pictures;
	}

	@Override
	public Pictures addPictures(Pictures Pictures) {
		Pictures PictureSaved = null;
		PictureSaved = PictureRepository.save(Pictures);
		return PictureSaved;
	}

	@Override
	public void deletePictures(Long idpic) {
		PictureRepository.deleteById(idpic);
		
	}

	@Override
	public Pictures updatePictures(Pictures Pictures) {
		Pictures PicturesAdded = (Pictures) PictureRepository.save(Pictures);
		return PicturesAdded;
	}

}

