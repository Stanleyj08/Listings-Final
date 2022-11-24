package com.promineo.app.service;

import java.util.List;

import com.promineo.app.entity.Listings;
/*
 * @param listing
 * @param listings
 * @param Id
 * @return
 */
public interface ListingsService {
//Post a listings, CREATE
	public Listings saveListings(Listings listing);
//READ all listings
	public List<Listings> getAllListings();
	//get a player by attribute
	public Listings getListingById(int Id);
	//the UPDATE
	public Listings updateListings(Listings listings, int Id);
	//THE DELETE
	public void deleteListing(int Id);
}
