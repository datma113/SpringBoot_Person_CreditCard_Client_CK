package thanhdat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import thanhdat.model.Person;
import thanhdat.service.PersonService;

@Controller
@RequestMapping("/persons")
public class PersonController {
	
	@Autowired
	private PersonService personService;
	
	@GetMapping("/")
	public String home() {
		return "index";
	}
	
	@GetMapping("/person-form")
	public String personForm(Model model) {
		Person p = new Person();
		model.addAttribute("person", p);
		return "person-form";
	}
	
	@PostMapping("/save")
	public String savePerson(Person p) {
		personService.savePerson(p);
		return "redirect:/persons/list";
	}
	
	@GetMapping("/list")
	public String personList(Model model) {
		List<Person> list = personService.getAllPerson();
		model.addAttribute("persons", list);
		return "list-person";
	}
	
	@GetMapping("/update")
	public String updatePerson(@RequestParam("id")int id, Model model) {
		Person p = personService.getPersonById(id);
		model.addAttribute("person", p);
		return "person-form";
	}
	@GetMapping("/delete")
	public String deletePerson(@RequestParam("id")int id) {
		personService.deletePersonById(id);
		return "redirect:/persons/list";
	}
}
