package controllers;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import model.Dane;
import model.Whatsnow;

@RestController
public class DaneController {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("CoTerazJPA");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	
	@RequestMapping(path="/", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public String getDefault() {
		return "Nie poprawna siezka";
	}

	@RequestMapping(path="/nuda", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Dane> getNuda() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("CoTerazJPA");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		List<Dane> result = new ArrayList<>();
		
		List<Whatsnow> wynik = entityManager.createNamedQuery("Whatsnow.findByType").setParameter("type", "nuda").getResultList();
		
		
		for(Whatsnow wn: wynik) {
			result.add(new Dane(wn.getId(), wn.getName(), wn.getInfo(), wn.getMarkerIcon(), wn.getLat(), wn.getLng(), wn.getRating(), wn.getWww(), 
					wn.getAdress(), wn.getPhone(), wn.getType(), wn.getPlaceImage()));
		}
		
		
		entityManager.close();
		entityManagerFactory.close();
		
		return result;		
	}

	@RequestMapping(path="/zmeczenie", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Dane> getZmeczenie() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("CoTerazJPA");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		List<Dane> result = new ArrayList<>();
		
		List<Whatsnow> wynik = entityManager.createNamedQuery("Whatsnow.findByType").setParameter("type", "zmeczenie").getResultList();
		
		
		for(Whatsnow wn: wynik) {
			result.add(new Dane(wn.getId(), wn.getName(), wn.getInfo(), wn.getMarkerIcon(), wn.getLat(), wn.getLng(), wn.getRating(), wn.getWww(), 
					wn.getAdress(), wn.getPhone(), wn.getType(), wn.getPlaceImage()));
		}
		
		
		entityManager.close();
		entityManagerFactory.close();
		
		return result;
	}

	@RequestMapping(path="/glod", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Dane> getGlod() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("CoTerazJPA");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		List<Dane> result = new ArrayList<>();
		
		List<Whatsnow> wynik = entityManager.createNamedQuery("Whatsnow.findByType").setParameter("type", "glod").getResultList();
		
		
		for(Whatsnow wn: wynik) {
			result.add(new Dane(wn.getId(), wn.getName(), wn.getInfo(), wn.getMarkerIcon(), wn.getLat(), wn.getLng(), wn.getRating(), wn.getWww(), 
					wn.getAdress(), wn.getPhone(), wn.getType(), wn.getPlaceImage()));
		}
		
		
		entityManager.close();
		entityManagerFactory.close();
		
		return result;
	}

	@RequestMapping(path="/zakupy", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Dane> getZakupy() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("CoTerazJPA");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		List<Dane> result = new ArrayList<>();
		
		List<Whatsnow> wynik = entityManager.createNamedQuery("Whatsnow.findByType").setParameter("type", "zakupy").getResultList();
		
		
		for(Whatsnow wn: wynik) {
			result.add(new Dane(wn.getId(), wn.getName(), wn.getInfo(), wn.getMarkerIcon(), wn.getLat(), wn.getLng(), wn.getRating(), wn.getWww(), 
					wn.getAdress(), wn.getPhone(), wn.getType(), wn.getPlaceImage()));
		}
		
		
		entityManager.close();
		entityManagerFactory.close();
		
		return result;
	}
	
	// =======================================
	
	@RequestMapping(path="/all", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Dane> getAll() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("CoTerazJPA");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		
		List<Dane> result = new ArrayList<>();
		
		List<Whatsnow> wynik = entityManager.createNamedQuery("Whatsnow.findAll").getResultList();
		
		
		for(Whatsnow wn: wynik) {
			result.add(new Dane(wn.getId(), wn.getName(), wn.getInfo(), wn.getMarkerIcon(), wn.getLat(), wn.getLng(), wn.getRating(), wn.getWww(), 
					wn.getAdress(), wn.getPhone(), wn.getType(), wn.getPlaceImage()));
		}
		
		entityManager.close();
		entityManagerFactory.close();
		
		
		return result;
	}
	
	@RequestMapping(path="/hard", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Dane> getTestHard() {
		List<Dane> result = new ArrayList<>();
		
		
		result.add(new Dane(1, "Cinema City", "Najnowoczesniejsze kino w £odzi", "nuda.jpg", 51.780833, 19.448461, 5, "https://www.cinema-city.pl/",
				"ul. Drewnowska 58, £ódŸ", "42 664 64 64", "nuda","cinema.jpg"));
		
		result.add(new Dane(2,"Sky Bowling", "Ogromna 24-torowa krêgielnia zapewni moc zabawy z dzieæmi, przyjació³mi, znajomymi z pracy", "nuda.jpg", 51.749990, 19.448772, 4, "http://sukcesja.eu/sklepy/sky-bowling",
				"al. Politechniki 1, £ódŸ", "42 295 02 54", "nuda","skyBowling.jpg"));
		
		result.add(new Dane(3, "Fit Fabric", "Nowoczesna sieæ klubów fitness, gdzie ka¿dy znajdzie coœ dla siebie", "nuda.jpg", 51.781523, 19.484153, 5, "https://www.fitfabric.pl/kluby/fitfabric-matejki",
				"ul. Jana Matejki 3/5, £ódŸ", "505 450 068", "nuda","fit.jpg"));
		
		return result;
	}
	
	
}
