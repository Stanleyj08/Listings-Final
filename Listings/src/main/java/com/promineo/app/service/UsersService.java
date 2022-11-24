package com.promineo.app.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.promineo.app.entity.Users;
import com.promineo.app.exception.ResourceNotFoundException;

public interface UsersService {
/*
 * @param user
 * @param id
 * @param usersId
 * @param users_id
 * @param listing_id
 * @return
 */
	public Users saveUser(Users user);

	public List<Users> getAllUsers();

	public Users updateUsers(Users user, int id) throws ResourceNotFoundException;

	public void deleteUser(int usersId);

	//public Users assignListingtoUsers(int users_id, int listing_id);

	//public Users mapUsersToListings(int users_id, int listing_id);

	

	

	

}
