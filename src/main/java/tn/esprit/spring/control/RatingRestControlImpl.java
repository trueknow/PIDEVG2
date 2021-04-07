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

import tn.esprit.spring.entity.Rating;
import tn.esprit.spring.service.RatingService;

@RestController
public class RatingRestControlImpl {
	@Autowired
	RatingService ratingService;

	// http://localhost:8081/SpringMVC/servlet/retrieve-all-ratings
	@GetMapping("/retrieve-all-ratings")
	@ResponseBody
	public List<Rating> getRatings() {
	List<Rating> list = ratingService.retrieveAllRatings();
	return list;
	}
	//http://localhost:8081/SpringMVC/servlet/retrieve-rating/{rating-id}
	@GetMapping("/retrieve-rating/{rating-id}")
	@ResponseBody
	 public Rating retrieveRating(@PathVariable("rating-id") String ratingId) {
	 return ratingService.retrieveRating(ratingId);
	 }

	 // Ajouter Comment : http://localhost:8081/SpringMVC/servlet/add-rating
	@PostMapping("/add-rating")
	@ResponseBody
	public Rating addRating(@RequestBody Rating r) {
		Rating rating = ratingService.addRatings(r);
	 return rating ;
	 }
	//http://localhost:8081/SpringMVC/servlet/remove-rating/{rating-id}
	@DeleteMapping("/remove-rating/{rating-id}")
	@ResponseBody
	public void removeRating(@PathVariable("rating-id") String ratingId) {
		ratingService.deleteRatings(ratingId);
	 }

	// http://localhost:8081/SpringMVC/servlet/modify-rating
	@PutMapping("/modify-rating")
	@ResponseBody
	 public Rating modifyRating(@RequestBody Rating rating) {
	 return ratingService.updateRatings(rating);
	 }

}
