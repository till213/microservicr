package net.tillart.restr.user;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserResource {

	@Autowired
	private UserDaoService dao;

	@GetMapping(path = "/users")
	public List<User> retrieveAllUsers() {
		return dao.findAll();
	}

	@GetMapping(path = "/users/{id}")
	public User getUser(@PathVariable int id) {
		User user = dao.findById(id);
		if (user == null) {
			throw new UserNotFoundException("id-" + id);
		}
		return user;
	}

	@PostMapping(path = "/users")
	public ResponseEntity<User> createUser(@RequestBody User user) {
		User newUser =  dao.add(user);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newUser.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
}
