package thanhdat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import thanhdat.model.Person;

@Service
public class PersonServiceImpl implements PersonService{
	private final String url = "http://localhost:7070/api/persons/";
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public Person savePerson(Person p) {
		if(p.getId() == 0)
			restTemplate.postForEntity(url, p, String.class);
		else restTemplate.put(url, p);
		return p;
	}

	@Override
	public Person getPersonById(int id) {
		ResponseEntity<Person> resp = restTemplate.exchange(url+id, HttpMethod.GET, null, new ParameterizedTypeReference<Person>() {
		});
		return resp.getBody();
	}

	
	@Override
	public List<Person> getAllPerson() {
		ResponseEntity<List<Person>> resp = restTemplate.exchange(url, HttpMethod.GET,null, new ParameterizedTypeReference<List<Person>>() {
		});
		return resp.getBody();
	}

	@Override
	public String deletePersonById(int id) {
		restTemplate.delete(url+id);
		return "delete: " + id;
	}

	
}
