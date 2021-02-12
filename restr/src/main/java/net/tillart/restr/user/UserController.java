package net.tillart.restr.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class UserController {

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
	public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
		User newUser = dao.add(user);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newUser.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@DeleteMapping(path = "/users/{id}")
	public void deleteUser(@PathVariable int id) {
		if (!dao.delete(id)) {
			throw new UserNotFoundException("id-" + id);
		}
	}

}
