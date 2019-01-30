package com.shop.application.DTO;

import com.google.gson.annotations.Expose;
import java.util.Calendar;
import com.shop.domain.Picture;
import com.shop.utilities.InvalidParamException;

public class PictureDTO {
	@Expose /* Expose: lo que va a ver el cliente */
	private Integer id;
	@Expose
	private String author;
	@Expose
	private String name;
	@Expose
	private double price;
	@Expose
	private Calendar dateIn;

	public PictureDTO() {
	}

	public PictureDTO(Picture picture) throws InvalidParamException {
		
		if(picture == null) throw new InvalidParamException();

		this.id = picture.getId();
		this.name = picture.getName();
		this.author = picture.getAuthor();
		this.price = picture.getPrice();
		this.dateIn = picture.getDateIn();

	}

	public Integer getId() {
		return id;
	}

	public String getAuthor() {
		return author;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	public Calendar getDateIn() {
		return dateIn;
	}

}