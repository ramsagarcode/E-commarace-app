package org.jsp.ecommarce.controller;

import org.jsp.ecommarce.dto.ResponseStructure;
import org.jsp.ecommarce.model.Merchant;
import org.jsp.ecommarce.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/merchants")
public class MerchantController {
	@Autowired
	public MerchantService merchantService;

	@PostMapping
	public ResponseEntity<ResponseStructure<Merchant>> saveMerchant(@RequestBody Merchant merchant) {
		return merchantService.saveMerchant(merchant);
	}

	@PutMapping
	public ResponseEntity<ResponseStructure<Merchant>> updateMerchant(@RequestBody Merchant merchant) {
		return merchantService.updateMerchant(merchant);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ResponseStructure<Merchant>> findById(@PathVariable int id) {
		return merchantService.findById(id);
	}

	@GetMapping("/verify-by-email")
	public ResponseEntity<ResponseStructure<Merchant>> verifyByEmail(@RequestParam String email,
			@RequestParam String password) {
		return merchantService.verifyByEmail(email, password);
	}

	@GetMapping("/verfiy-by-phone")
	public ResponseEntity<ResponseStructure<Merchant>> verifyByPhone(@RequestParam long phone,
			@RequestParam String password) {
		return merchantService.verifyByPhone(phone, password);
	}
}

