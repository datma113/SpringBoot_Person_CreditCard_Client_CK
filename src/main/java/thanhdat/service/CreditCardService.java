package thanhdat.service;

import java.util.List;

import thanhdat.model.CreditCard;

public interface CreditCardService {
	public CreditCard saveCreditCard(CreditCard c, int personId);
	public CreditCard getCreditCardById(int id);
	public List<CreditCard> getCreditCards(int personId);
	public String deleteCreditCardById(int id);

}
