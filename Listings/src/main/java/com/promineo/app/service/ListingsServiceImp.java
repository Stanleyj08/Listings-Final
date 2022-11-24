package com.promineo.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.promineo.app.entity.Listings;
import com.promineo.app.exception.ResourceNotFoundException;
import com.promineo.app.repository.ListingsRepository;
@Service
public class ListingsServiceImp implements ListingsService{

	private ListingsRepository listingsrepository;
	@Autowired
	public ListingsServiceImp(ListingsRepository listingsrepository) {
		this.listingsrepository = listingsrepository;
	}
	


	@Override
	public List<Listings> getAllListings() {
		
		return listingsrepository.findAll();
	}

	@Override
	public Listings getListingById(int Id) {
		// TODO Auto-generated method stub
		return listingsrepository.findById(Id).orElseThrow(()-> new ResourceNotFoundException("Listings", "Id", Id));
	}
//update

//delete
	@Override
	public void deleteListing(int Id) {
	Listings existingListing = listingsrepository.findById(Id).orElseThrow(()-> new ResourceNotFoundException("Listings", "Id", Id));
		listingsrepository.deleteById(Id);
	}


//create a listing
@Override
public Listings saveListings(Listings listing) {
	System.out.println(listing.getTitle());
	return listingsrepository.save(listing);
}


//update
@Override
public Listings updateListings(Listings listings, int Id) {
		Listings exisitngListings = listingsrepository.findById(Id).orElseThrow(()-> new ResourceNotFoundException("Listings", "Id", Id));
		exisitngListings.setListing_id(listings.getListing_id());
		exisitngListings.setUsers_id(listings.getUsers_id());
		exisitngListings.setTitle(listings.getTitle());

	   listingsrepository.save(exisitngListings);
	   return exisitngListings; 
	}
}


