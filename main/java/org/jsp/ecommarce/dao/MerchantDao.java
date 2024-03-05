package org.jsp.ecommarce.dao;

import java.util.Optional;

import org.jsp.ecommarce.model.Merchant;
import org.jsp.ecommarce.repository.MerchantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MerchantDao {
	@Autowired
	private MerchantRepository merchantRepository;

	public Merchant saveMerchant(Merchant merchant) {
		return merchantRepository.save(merchant);
	}

	public Optional<Merchant> findById(int id) {
		return merchantRepository.findById(id);
	}

	public Optional<Merchant> verifyByEmail(String email, String password) {
		return merchantRepository.verifyByEmail(email, password);
	}

	public Optional<Merchant> verifyByPhone(long phone, String password) {
		return merchantRepository.verifyByPhone(phone, password);
	}


}
