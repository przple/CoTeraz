package controllers;



import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.util.JSONPObject;

import model.Response;
import model.User;
import model.Whatsnow;
import model.Whatsnow_en;

@RestController
public class UserController {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("CoTerazJPA");
	EntityManager entityManager = entityManagerFactory.createEntityManager();


	@RequestMapping(path="/user", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<User> getUser() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("CoTerazJPA");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		List<User> result = new ArrayList<>();
		
		List<User> wynik = entityManager.createNamedQuery("User.findAll").getResultList();
		
		
		for(User wn: wynik) {
			result.add(new User(wn.getID(), wn.getLogin(), wn.getPassword(), wn.getType()));
		}
		
		
		entityManager.close();
		entityManagerFactory.close();
		
		return result;		
	}
	
	
	@RequestMapping(path="/user/{login}/{password}", produces=MediaType.APPLICATION_JSON_UTF8_VALUE, method=RequestMethod.GET)
	public List<User> getUserParam(@PathVariable String login, @PathVariable String password) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("CoTerazJPA");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		List<User> result = new ArrayList<>();
		
		List<User> wynik = entityManager.createNamedQuery("User.singIn").setParameter("login", login).setParameter("password", password).getResultList();
		
		
		for(User wn: wynik) {
			result.add(new User(wn.getID(), wn.getLogin(), wn.getPassword(), wn.getType()));
		}
		
		
		entityManager.close();
		entityManagerFactory.close();
		
		return result;		
	}
	
	
	@RequestMapping(path="/user/add/{login}/{password}", method=RequestMethod.POST)
	public Response setUserAdd(@PathVariable String login, @PathVariable String password) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Response response = new Response();
		boolean isExist = false;
		
		List<User> userList = entityManager.createNamedQuery("User.findAll").getResultList();
		
		
		for(User u: userList) {
			if(login.toLowerCase().equals(u.getLogin())) {
				isExist = true;
			}
		}
		
		if(!isExist) {
			entityManager.getTransaction().begin();
			
			User user=new User();
			user.setLogin(login.toLowerCase());
			user.setPassword(password);
			user.setType("basic");
			
			entityManager.persist(user);
			entityManager.getTransaction().commit();
			
			response.setResponse("Succes");
			isExist = false;
		}
		else {
			response.setResponse("Failed: This login is occupied");
		}
		
		entityManager.close();
		return response;	
	}	
	
	@RequestMapping(path="/user/changeType/{id}/{newType}", produces=MediaType.APPLICATION_JSON_UTF8_VALUE, method=RequestMethod.POST)
	public Response changeParameter(@PathVariable int id, @PathVariable String newType) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Response response = new Response();
				
		List<User> wynik = entityManager.createNamedQuery("User.changeType").setParameter("id", id).getResultList();
		
		
		for(User d : wynik) {
			if (id == d.getID()) {
				
				User user = entityManager.find(User.class, 1);
				entityManager.getTransaction().begin();
				d.setType(newType);
				
				entityManager.getTransaction().commit();
				response.setResponse("Succes");
				
			}
			else {
				response.setResponse("Failed");
			}
		}
		entityManager.close();
		
		
		return response;
	}	
}
