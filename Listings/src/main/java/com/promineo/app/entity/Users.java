package com.promineo.app.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;


@Data
@Entity
@Table(name="users")
public class Users {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int users_id;

	@Column(value="first_name")
	private String first_name;

	@Column(value="last_name")
	private String last_name; 

@ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
@JoinTable(name = "user_listings",joinColumns =  @JoinColumn( name = "users_id",referencedColumnName = "users_id"),
inverseJoinColumns = @JoinColumn( name = "listing_id", referencedColumnName = "listing_id")
)
@JsonIgnore
private  Set<Listings> listing = new HashSet<>();

@JsonIgnore
@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
private Set<Purchase> pur = new HashSet<>();

//public void mapListing(Listings listings) {
	//listing.add(listings);
	
//}

public void addListing(Listings listing2) {
listing.add(listing2);	
}
}

