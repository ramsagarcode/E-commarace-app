package org.jsp.ecommarce.service;


import java.util.Optional;

import org.jsp.ecommarce.dao.MerchantDao;
import org.jsp.ecommarce.dto.ResponseStructure;
import org.jsp.ecommarce.model.Merchant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class MerchantService {
	@Autowired
	private MerchantDao merchantDao;

	public ResponseEntity<ResponseStructure<Merchant>> saveMerchant(Merchant merchant) {
		ResponseStructure<Merchant> structure = new ResponseStructure<>();
		structure.setData(merchantDao.saveMerchant(merchant));
		structure.setMessage("Merchant saved");
		structure.setStatuscode(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<Merchant>>(structure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Merchant>> updateMerchant(Merchant merchant) {
		Optional<Merchant> recMerchant = merchantDao.findById(merchant.getId());
		ResponseStructure<Merchant> structure = new ResponseStructure<>();
		if (recMerchant.isPresent()) {
			Merchant dbmerchant = new Merchant();

			dbmerchant.setName(merchant.getName());
			dbmerchant.setPhone(merchant.getPhone());
			dbmerchant.setGst_number(merchant.getGst_number());
			dbmerchant.setEmail(merchant.getEmail());
			dbmerchant.setPassword(merchant.getPassword());
			merchant = merchantDao.saveMerchant(merchant);

		}

		structure.setData(merchantDao.saveMerchant(merchant));
		structure.setMessage("Merchant Updated");
		structure.setStatuscode(HttpStatus.ACCEPTED.value());
		return new ResponseEntity<ResponseStructure<Merchant>>(structure, HttpStatus.ACCEPTED);
	}

	public ResponseEntity<ResponseStructure<Merchant>> findById(int id) {
		Optional<Merchant> recMerchant = merchantDao.findById(id);
		ResponseStructure<Merchant> structure = new ResponseStructure<>();
		if (recMerchant.isPresent()) {
			structure.setData(recMerchant.get());
			structure.setMessage("Merchant Found");
			structure.setStatuscode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Merchant>>(structure, HttpStatus.OK);
		}
		return null;
	}

	public ResponseEntity<ResponseStructure<Merchant>> verifyByEmail(String email, String password) {
		Optional<Merchant> recMerchant = merchantDao.verifyByEmail(email, password);
		ResponseStructure<Merchant> structure = new ResponseStructure<>();
		if (recMerchant.isPresent()) {
			structure.setData(recMerchant.get());
			structure.setMessage("Merchant email verified");
			structure.setStatuscode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Merchant>>(structure, HttpStatus.OK);
		}
		return null;
	}

	public ResponseEntity<ResponseStructure<Merchant>> verifyByPhone(long phone, String password) {
		Optional<Merchant> recMerchant = merchantDao.verifyByPhone(phone, password);
		ResponseStructure<Merchant> structure = new ResponseStructure<>();
		if (recMerchant.isPresent()) {
			structure.setData(recMerchant.get());
			structure.setMessage("Merchant phone number verified");
			structure.setStatuscode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Merchant>>(structure, HttpStatus.OK);
		}
		return null;

}
}
