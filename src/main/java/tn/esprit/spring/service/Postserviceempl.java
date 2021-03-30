package tn.esprit.spring.service;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import tn.esprit.spring.entity.Posts;
import org.springframework.stereotype.Service;
import tn.esprit.spring.repository.PostRepository;

@Service
public  class Postserviceempl implements Postservice {

	@Autowired
	PostRepository PostRepository;
	private static final Logger L = LogManager.getLogger(Pictureserviceempl.class);
	
	@Override
	public List<Posts> getPosts() {
		List<Posts> Posts = (List<Posts>) PostRepository.findAll();
		for (Posts Post : Posts) {
			L.info("Posts +++ : " + Post );
		}
		return Posts;
	}

	@Override
	public Posts addPosts(Posts Posts) {
		Posts PostSaved = null;
		PostSaved = PostRepository.save(Posts);
		return PostSaved;
	}

	@Override
	public void deletePosts(Long idpost) {
		PostRepository.deleteById(idpost);
		
	}

	@Override
	public Posts updatePosts(Posts Posts) {
		Posts PostsAdded = (Posts) PostRepository.save(Posts);
		return PostsAdded;
	}

}

