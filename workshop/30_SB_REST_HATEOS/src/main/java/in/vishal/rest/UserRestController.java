package in.vishal.rest;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.vishal.binding.User;

@RestController
public class UserRestController {

	@GetMapping("/user")
	public ResponseEntity<User> getUser() {

		User user = new User(100, "vishal", "vishal@gmail.com");

		user.add(linkTo(methodOn(UserRestController.class).getUser()).withSelfRel());
//what ever is avaialbe in this USerRestController get that method for that method
		//create a self Relation link and add that link to user object
		// link is coming from RepresentationModel which is the base class to
		// create link for our binding classes

		return new ResponseEntity<>(user, HttpStatus.OK);
	}

	@PostMapping("/user")
	public ResponseEntity<User> createUser(@RequestBody User user) {
		// logic to insert user data
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

	@PatchMapping("/user")
	public ResponseEntity<User> updateUser(@RequestBody User user) {
		// logic to update user data
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

	@DeleteMapping("/user/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable Integer id) {
		// logic to delete user data
		return new ResponseEntity<>("Deleted", HttpStatus.OK);
	}
}
