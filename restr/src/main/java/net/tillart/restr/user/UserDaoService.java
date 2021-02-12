package net.tillart.restr.user;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Component
public class UserDaoService {

	static private final List<User> users = new ArrayList<>();
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

	public boolean delete(int id) {
		Iterator<User> it = users.iterator();
		while (it.hasNext()) {
			if (it.next().getId() == id) {
				it.remove();
				return true;
			}
		}
		return false;
	}

}
