package tn.esprit.spring.service;
import tn.esprit.spring.entity.Posts;
import java.util.List;




public interface Postservice {
	List<Posts> getPosts();

	Posts  addPosts(Posts Posts);
    void deletePosts(Long idpost) ;
    Posts updatePosts(Posts Posts);
}
	