package thanhdat.service;

import java.util.List;

import org.springframework.stereotype.Service;

import thanhdat.model.Person;

@Service
public interface PersonService {
	public Person savePerson(Person p);
	public Person getPersonById(int id);
	public List<Person> getAllPerson();
	public String deletePersonById(int id);
}
