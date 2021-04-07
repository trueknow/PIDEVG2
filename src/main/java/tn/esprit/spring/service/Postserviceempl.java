package tn.esprit.spring.service;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import tn.esprit.spring.entity.Post;
import org.springframework.stereotype.Service;
import tn.esprit.spring.repository.PostRepository;

@Service
public  class Postserviceempl implements PostService {

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
	public Post addPosts(Post p) {
		Post PostSaved = null;
		PostSaved = PostRepository.save(p);
		return PostSaved;
	}

	@Override
	public void deletePosts(String idpost){
		
		PostRepository.deleteById(Long.parseLong(idpost));
	}

	@Override
	public Post updatePosts(Post p) {
		Post PostsAdded = (Post) PostRepository.save(p);
		return PostsAdded;
	}
	@Override
	public Post retrievePost(String idpost) {
		L.info("in retrievePost idpost= " + idpost);
		Post p = PostRepository.findById(Long.parseLong(idpost)).orElse(null);
		L.info("post returned : " + p);
		return p;
	}
	@Override
	public List<Post> retrieveAllPosts() {
		List<Post> posts = (List<Post>) PostRepository.findAll();
		for (Post post : posts) {
			L.info("post +++ : " + post);
		}
		return posts;
	}


}

