package tn.esprit.spring.service;
import tn.esprit.spring.entity.Post;
import java.util.List;




public interface Postservice {
	List<Post> getPosts();

	Post  addPosts(Post Posts);
    void deletePosts(Long idpost) ;
    Post updatePosts(Post Posts);
}
	