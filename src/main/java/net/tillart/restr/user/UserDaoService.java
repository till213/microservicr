package net.tillart.restr.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {

	static private List<User> users = new ArrayList<User>();
	static private int id = 0;
	
	static {
		users.add(new User(++id, "Eve", new Date()));
		users.add(new User(++id, "Adam", new Date()));
		users.add(new User(++id, "Bob", new Date()));
	}
	
	public List<User> findAll() {
		return users;
	}
	
	public User add(User user) {
		if (user.getId() == null) {
			user.setId(++id);
		}
		
		users.add(user);
		return user;
	}
	
	public User findById(int id) {
		for (User user : users) {
			if (user.getId() == id) {
				return user;
			}
		}
		return null;
	}	
	
}
