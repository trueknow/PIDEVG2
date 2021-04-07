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

import tn.esprit.spring.entity.Like;
import tn.esprit.spring.service.LikeService;

@RestController
public class LikeRestControlImpl {
	@Autowired
	LikeService likeService;

	// http://localhost:8081/SpringMVC/servlet/retrieve-all-likes
	@GetMapping("/retrieve-all-likes")
	@ResponseBody
	public List<Like> getLikes() {
	List<Like> list = likeService.retrieveAllLikes();
	return list;
	}
	//http://localhost:8081/SpringMVC/servlet/retrieve-like/{like-id}
	@GetMapping("/retrieve-like/{like-id}")
	@ResponseBody
	 public Like retrieveLike(@PathVariable("like-id") String likeId) {
	 return likeService.retrieveLike(likeId);
	 }

	 // Ajouter Like : http://localhost:8081/SpringMVC/servlet/add-like
	@PostMapping("/add-like")
	@ResponseBody
	public Like addLike(@RequestBody Like l) {
		Like like = likeService.addLikes(l);
	 return like;
	 }
	//http://localhost:8081/SpringMVC/servlet/remove-like/{like-id}
	@DeleteMapping("/remove-like/{like-id}")
	@ResponseBody
	public void removeLike(@PathVariable("like-id") String likeId) {
		likeService.deleteLikes(likeId);
	 }

	// http://localhost:8081/SpringMVC/servlet/modify-like
	@PutMapping("/modify-like")
	@ResponseBody
	 public Like modifyComment(@RequestBody Like like) {
	 return likeService.updateLikes(like);
	 }

}
