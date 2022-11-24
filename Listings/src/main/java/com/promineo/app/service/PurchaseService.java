package com.promineo.app.service;

import java.util.List;

import com.promineo.app.entity.Purchase;

public interface PurchaseService {
/*
 * @param pur
 * @param id
 * @param purId
 * @return
 */
	

	public Purchase savePurchase(Purchase pur);


	public List<Purchase> getAllPurchase();


	public Purchase updatePurchase(Purchase pur, Integer id);


	public void deletePur(int purId);

}
