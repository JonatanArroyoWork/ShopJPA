package com.shop.persistence;

import java.util.ArrayList;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;


import com.shop.domain.Shop;
import com.shop.utilities.InvalidParamException;
import com.shop.utilities.NotFoundException;

@Repository
public class ShopRepository {

	@Autowired	HelperShopRepository repository;
	/*private static Datastore datastore = DatastoreManager.getInstance().getDatastore();*/

	/*private static List<Shop> shops = new ArrayList<>();*/

	public ShopRepository() {
	}


	public void addShop(Shop shop) throws InvalidParamException {
		if (shop == null)
			throw new InvalidParamException();
		try {
			repository.save(shop);
		} catch (Exception e) {
			throw new InvalidParamException();
		}
	}
	
	

//	public List<Shop> getAllShops() {
//		return new ArrayList<>(shops);
//	}

	public List<Shop> getAllShops() {
		List<Shop> result = new ArrayList<>();
		for (Shop shop : repository.findAll()) {
			result.add(shop);
		}
		return result;
	}

	public Shop getShopById(int shopID) throws NotFoundException {
		try{
			return repository.findById(shopID).get();
		}catch (Exception exception) {
			
		throw new NotFoundException();
		}
	}

//	public boolean shopExistById(Shop shop) {
//		for (Shop s : shops) {
//			if (s.getId().equals(shop.getId()))
//				return true;
//		}
//		return false;
//	}

}
