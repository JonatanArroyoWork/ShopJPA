package com.shop.application.DTO;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.shop.domain.Picture;
import com.shop.domain.Shop;
import com.shop.utilities.InvalidParamException;

public class ShopDTO {

	@Expose
	private Integer id;
	@Expose
	private String name;
	@Expose
	private int capacity;
	@Expose
	private List<PictureDTO> allPicture = new ArrayList<PictureDTO>();
		
	public ShopDTO (Shop shop) throws InvalidParamException {
		
		this.name= shop.getName();
		this.capacity= shop.getCapacity();
		this.allPicture = convertToDTO(shop.getAllPicture());
		this.id = shop.getId();
	}
	
	private List<PictureDTO> convertToDTO(List<Picture> allPicture) throws InvalidParamException{
		List<PictureDTO> result = new ArrayList<>();
		for (Picture p : allPicture) {
			result.add(new PictureDTO(p));
		}
		
		return result;
	}
	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getCapacity() {
		return capacity;
	}

	public List<PictureDTO> getAllPicture() {
		return allPicture;
	}

	
	public void addPicture(PictureDTO picture)  throws Exception{
		if(picture == null) 
			throw new Exception();
			allPicture.add(picture);
		
	}
}
