package com.promineo.app.service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.promineo.app.entity.Listings;
import com.promineo.app.entity.Users;
import com.promineo.app.exception.ResourceNotFoundException;
import com.promineo.app.repository.ListingsRepository;
import com.promineo.app.repository.UsersRepository;
@Service
public class UsersImplementation implements UsersService{
	@Autowired
	private ListingsRepository listingsrep;
	public UsersImplementation(ListingsRepository listingsrep) {
	this.listingsrep = listingsrep;	
	
	}
	private UsersRepository usersrepository;
	@Autowired
	public UsersImplementation(UsersRepository usersrepository) {
		this.usersrepository = usersrepository;
	}
	
	@Override
	public Users saveUser(Users user) {
		// TODO Auto-generated method stub
		return usersrepository.save(user);
	}

	@Override
	public List<Users> getAllUsers() {
		// TODO Auto-generated method stub
		return usersrepository.findAll();
	}

	@Override
	public Users updateUsers(Users user, int id) throws ResourceNotFoundException {
		Users users = usersrepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Users", "Id", id));
		users.setUsers_id(user.getUsers_id());
		users.setFirst_name(user.getFirst_name());
		users.setLast_name(user.getLast_name());

		usersrepository.save(users);
	   return users;
		//Users Users = usersrepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Users", "Id", id));
		//Users users = new Users();
		//users.setUsers_id(Users.getUsers_id());
		//users.setFirst_name(Users.getFirst_name());
		//users.setLast_name(Users.getLast_name());
		// usersrepository.save(users);
		  // return users; 
	}

	@Override
	public void deleteUser(int usersId) {
		usersrepository.deleteById(usersId);;
		// TODO Auto-generated method stub
		
	}
/*
 * 
 
	@Override
	public Users assignListingtoUsers(int users_id, int listing_id) {
		Set<Listings> listingSet = new HashSet();
		Users user = usersrepository.findById(users_id).get();
		Listings listing = listingsrep.findById(listing_id).get();
		listingSet = user.getListingnew();
		listingSet.add(listing);
		user.setListingnew(listingSet);
		return usersrepository.save(user);
		
	}
*/
	/*@Override
	public Users mapUsersToListings(int users_id, int listing_id) {
		Users user = usersrepository.findById(users_id).get();
		Listings listing =  listingsrep.findById(listing_id).get();
		Users users = new Users();
		users.mapListing(listing);
		return usersrepository.save(user);
	}

	*/

	

}
