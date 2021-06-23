package thanhdat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import thanhdat.model.CreditCard;

@Service
public class CreditCardServiceImpl implements CreditCardService{

private final String url = "http://localhost:7070/api/credit-cards/";
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public CreditCard saveCreditCard(CreditCard c, int id) {
		if(c.getId() == 0)
			//personId
			restTemplate.postForEntity(url+id, c, String.class);
		//creditCardId
		else restTemplate.put(url + id, c);
		return c;
	}

	@Override
	public CreditCard getCreditCardById(int id) {
		ResponseEntity<CreditCard> resp = restTemplate.exchange(url+id, HttpMethod.GET, null, new ParameterizedTypeReference<CreditCard>() {
		});
		return resp.getBody();
	}

	@Override
	public List<CreditCard> getCreditCards(int personId) {
		ResponseEntity<List<CreditCard>> resp = restTemplate.exchange(url+personId, HttpMethod.GET,null, new ParameterizedTypeReference<List<CreditCard>>() {
		});
		return resp.getBody();
	}

	@Override
	public String deleteCreditCardById(int id) {
		restTemplate.delete(url+id);
		return "delete: " + id;
	}

}
