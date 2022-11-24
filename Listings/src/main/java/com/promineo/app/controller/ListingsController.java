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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.promineo.app.entity.Listings;
import com.promineo.app.service.ListingsService;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/listings/listings")
public class ListingsController {
private ListingsService listingsservice;
@Autowired
public ListingsController(ListingsService listingsservice) {
	super();
	this.listingsservice = listingsservice;
	
	
	}
	//build the create Listings api
	@PostMapping()
	public ResponseEntity<Listings> saveListings(@RequestBody Listings listing){
		System.out.println(listing);
		return new ResponseEntity<Listings>(listingsservice.saveListings(listing), HttpStatus.CREATED);
		
	}
	//Read all mapping
	@GetMapping()
	public List<Listings> getAllListings(){
		return listingsservice.getAllListings();
	}
	//read by id
@GetMapping("{listing_id}")
public ResponseEntity<Listings> getListingsById(@PathVariable("listing_id") int listingId) {
	return new ResponseEntity<Listings>(listingsservice.getListingById(listingId), HttpStatus.OK);
	
}
@PutMapping("{listing_id}")
public ResponseEntity<Listings> updateListings(@PathVariable("listing_id") int Id, @RequestBody Listings listings) {
	return new ResponseEntity<Listings>(listingsservice.updateListings(listings, Id), HttpStatus.OK);
	
}
@DeleteMapping("{listing_id}")
public ResponseEntity<String> deleteListing(@PathVariable("listing_id") int listingId){
	listingsservice.deleteListing(listingId);
	return new ResponseEntity<String>("Listing was deleted.", HttpStatus.OK);
}

}


