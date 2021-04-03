package tn.esprit.spring.service;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import tn.esprit.spring.entity.Post;
import org.springframework.stereotype.Service;
import tn.esprit.spring.repository.PostRepository;

@Service
public  class Postserviceempl implements Postservice {

	@Autowired
	PostRepository PostRepository;
	private static final Logger L = LogManager.getLogger(Postserviceempl.class);
	
	@Override
	public List<Post> getPosts() {
		List<Post> Posts = (List<Post>) PostRepository.findAll();
		for (Post Post : Posts) {
			L.info("Posts +++ : " + Post );
		}
		return Posts;
	}

	@Override
	public Post addPosts(Post Posts) {
		Post PostSaved = null;
		PostSaved = PostRepository.save(Posts);
		return PostSaved;
	}

	@Override
	public void deletePosts(Long idpost) {
		PostRepository.deleteById(idpost);
		
	}

	@Override
	public Post updatePosts(Post Posts) {
		Post PostsAdded = (Post) PostRepository.save(Posts);
		return PostsAdded;
	}

}

