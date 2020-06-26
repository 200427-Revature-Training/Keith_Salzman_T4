package com.revature.repositories;

import java.util.Optional;
import java.util.Set;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.revature.entities.User;

@Repository
public class UserRepository {
	
	@Autowired
	EntityManager em;
	
	@Transactional(propagation = Propagation.REQUIRED)
	public User save(User user) {
		Session session = em.unwrap(Session.class);
		session.save(user);
		return user;
	}
	
	public User update(User user) {
		Session session = em.unwrap(Session.class);
		session.update(user);
		return user;
	}
	
	public User delete(User user) {
		Session session = em.unwrap(Session.class);
		session.delete(user);
		return user;
	}
	
//	public Set<User> findAllUsers(int id) {
//		Session session = em.unwrap(Session.class);
//		Set<User> users = session.get(User.class);
//		return users;
//	}
	
	public Optional<User> findUserById(int id) {
		Session session = em.unwrap(Session.class);
		User user = session.get(User.class, id);
		return Optional.ofNullable(user);
	}
	
	public Optional<User> findUserByUsername(String username) {
		Session session = em.unwrap(Session.class);
		User user = session.get(User.class, username);
		return Optional.ofNullable(user);
	}
	
	public Optional<User> findUserByCredentials(String credentials) {
		Session session = em.unwrap(Session.class);
		User user = session.get(User.class, credentials);
		return Optional.ofNullable(user);
	}

}
