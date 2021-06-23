package thanhdat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import thanhdat.model.CreditCard;
import thanhdat.model.Person;
import thanhdat.service.CreditCardService;
import thanhdat.service.PersonService;

@Controller
@RequestMapping("/credit-cards")
public class CreditCardController {
	@Autowired
	private PersonService personService;
	@Autowired
	private CreditCardService creditCardService;
	
	@GetMapping("/")
	public String getCreditCardsByPersonId(@RequestParam("id")int id, Model model) {
		List<CreditCard> creditCards = creditCardService.getCreditCards(id);
		model.addAttribute("creditCards", creditCards);
		model.addAttribute("personId", id);
		return "list-credit-cards";
	}
	
	@GetMapping("/credit-card-form")
	public String formCreditCard(@RequestParam("personId")int id, Model model) {
		CreditCard c = new CreditCard();
		Person p = personService.getPersonById(id);
		c.setPerson(p);
		model.addAttribute("creditCard",c);
		return "credit-card-form";
	}
	
	@PostMapping("/save/{personId}")
	public String saveCreditCard(@ModelAttribute("creditCard") CreditCard c,@PathVariable("personId") int personId) {
		creditCardService.saveCreditCard(c, personId);
		return "redirect:/credit-cards/?id=" + personId;
	}
	
	@GetMapping("/update")
	public String updateCreditCard(@ModelAttribute("creditCard") CreditCard c, Model model, @RequestParam("personId")int personId) {	
		Person p = personService.getPersonById(personId);
		c.setPerson(p);
		model.addAttribute("creditCard", c);
		return "credit-card-form";
	}
	@GetMapping("/delete")
	public String deleteCreditCard(@RequestParam("id") int id) {
		creditCardService.deleteCreditCardById(id);
		return "index";
	}
	
}
