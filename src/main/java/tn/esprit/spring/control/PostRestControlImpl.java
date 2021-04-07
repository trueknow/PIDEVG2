package tn.esprit.spring.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Post;
import tn.esprit.spring.service.PostService;

@RestController
public class PostRestControlImpl {
	@Autowired
	PostService postService;

	// http://localhost:8081/SpringMVC/servlet/retrieve-all-posts
	@GetMapping("/retrieve-all-posts")
	@ResponseBody
	public List<Post> getPosts() {
	List<Post> list = postService.retrieveAllPosts();
	return list;
	}
	//http://localhost:8081/SpringMVC/servlet/retrieve-post/{post-id}
	@GetMapping("/retrieve-post/{post-id}")
	@ResponseBody
	 public Post retrievePost(@PathVariable("post-id") String postId) {
	 return postService.retrievePost(postId);
	 }

	 // Ajouter Like : http://localhost:8081/SpringMVC/servlet/add-post
	@PostMapping("/add-post")
	@ResponseBody
	public Post addPost(@RequestBody Post p) {
		Post post = postService.addPosts(p);
	 return post ;
	 }
	//http://localhost:8081/SpringMVC/servlet/remove-post/{post-id}
	@DeleteMapping("/remove-post/{post-id}")
	@ResponseBody
	public void removePost(@PathVariable("post-id") String postId) {
		postService.deletePosts(postId);
	 }

	// http://localhost:8081/SpringMVC/servlet/modify-post
	@PutMapping("/modify-post")
	@ResponseBody
	 public Post modifyPost(@RequestBody Post post) {
	 return postService.updatePosts(post);
	 }

}

