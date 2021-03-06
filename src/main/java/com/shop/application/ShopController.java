package com.shop.application;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import com.shop.application.DTO.ShopDTO;
import com.shop.domain.Shop;
import com.shop.persistence.ShopRepository;
import com.shop.utilities.InvalidParamException;
import com.shop.utilities.NotFoundException;

@Controller
public class ShopController {
	
	@Autowired
	private ShopRepository shopRepository;
	
	/*
	 * POST /shops/
	 * -	Crear botiga: li direm el nom i la capacitat
	 */
	public ShopDTO createShop(ShopDTO shopDTO ) throws Exception {
		Shop shop = new Shop(shopDTO.getName(), shopDTO.getCapacity());
			shopRepository.addShop(shop);
			return new ShopDTO(shop);
		}
	
	/*
	 * GET /shops/  
	 * Llistar botigues: retorna la llista de botigues amb el seu nom i la capacitat
 	 */
	public List<ShopDTO> listShops() throws NotFoundException, InvalidParamException {		
		List<ShopDTO> userDTOList = new ArrayList<>();
		List<Shop> shopList = shopRepository.getAllShops();
		//verifico si la lista esta vacia y lanzo una excepcion
		if (shopList.isEmpty())
			throw new NotFoundException();
		for (Shop u : shopList) {
			userDTOList.add(new ShopDTO(u));
		}
		return userDTOList;
	}
	
	/* DELETE /SHOPS/{ID} pictures:
	 * Incendiar quadres: per si ve la policia,
	 *  es poden eliminar tots els quadres de la botiga sense deixar
	 *   rastre
	 */
	public void burnPicturesByShopID(int shopID) throws Exception {
		Shop shop = shopRepository.getShopById(shopID);
		shop.burnPictures();				
	}
	
	

}
