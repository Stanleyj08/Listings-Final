package com.promineo.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.promineo.app.entity.Purchase;
import com.promineo.app.entity.Users;
import com.promineo.app.repository.PurchaseRepository;
import com.promineo.app.repository.UsersRepository;
import com.promineo.app.service.PurchaseService;
import com.promineo.app.service.UsersService;


@RestController
@RequestMapping("/listings/purchase")
public class PurchaseController {
	@Autowired
	private PurchaseRepository purchaserepo;
	@Autowired
	private UsersRepository usersrepo;
	private PurchaseService purchaseservice;
	@Autowired
	public PurchaseController(PurchaseService purchaseservice) {
		super();
		this.purchaseservice = purchaseservice;
	}

	@PostMapping()
	public ResponseEntity<Purchase> savePurchase(@RequestBody Purchase pur){
		System.out.println(pur);
		return new ResponseEntity<Purchase>(purchaseservice.savePurchase(pur), HttpStatus.CREATED);
		
	}
	@GetMapping()
	public List<Purchase> getAllPurchase(){
		return purchaseservice.getAllPurchase();
	}
	@PutMapping("{purchase_id}")
	public ResponseEntity<Purchase> updatePurchase(@PathVariable("purchase_id") Integer id, @RequestBody Purchase pur) {
		return new ResponseEntity<Purchase>(purchaseservice.updatePurchase(pur, id), HttpStatus.OK);
}
	@DeleteMapping("{purchase_id}")
	public ResponseEntity<String> deletePur(@PathVariable("purchase_id") int purId){
		purchaseservice.deletePur(purId);
		return new ResponseEntity<String>("Listing was deleted.", HttpStatus.OK);
	}
	/*
		@PutMapping("/{purchase_id}/users/{users_id}")
		Purchase assignUserToPurchase(
				@PathVariable int purchase_id,
				@PathVariable int users_id
			
				) {
			Purchase purchase = purchaserepo.findById(purchase_id).get();
			Users user = usersrepo.findById(users_id).get();
		
			purchase.assignUser(user);
			
			return purchaserepo.save(purchase);
		} 
		*/
}
