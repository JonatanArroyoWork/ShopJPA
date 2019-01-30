package com.shop.api;

import com.shop.application.DTO.ShopDTO;
import com.shop.application.ShopController;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class ShopRestController {
	
	@Autowired
	private ShopController controller;

	@PostMapping(value = "/shop", produces = "application/json;charset=UTF-8")
	public String createShop(@RequestBody String jShop) throws Exception {

		ShopDTO newShop = new Gson().fromJson(jShop, ShopDTO.class);

		ShopDTO shop = controller.createShop(newShop);

		return toJson(shop);
	}

	@GetMapping(value = "/shop", produces = "application/json;charset=UTF-8")
	public String listShop() throws Exception {

		List<ShopDTO> shops = controller.listShops();

		return toJson(shops);
	}

	private String toJson(Object object) {

		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		return gson.toJson(object);
	}
}