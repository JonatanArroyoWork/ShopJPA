package com.shop.domain;

import java.util.Calendar;
import com.shop.utilities.InvalidParamException;


import com.shop.domain.Picture;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity(name = "Picture")
public class Picture {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="idPicture")
	private Integer id;
	@Column(name="Author")
	private String author;
	@Column(name="Name")
	private String name;
	@Column(name="Price")
	private double price;
	@Column(name="dateIn")
	private Calendar dateIn;
	/*Meto Shop como parametro para poder mostrar el join*/

	private static int counter = 1;

	
	public Picture() {
		/* constructor vacio */

		this.id = counter;
		counter++;
	}

	public Picture(String name, String author, double price) throws InvalidParamException {

		if (author == null || author.equals(""))
			author = "Anonymous";
		if (name == null || name.equals(""))
			throw new InvalidParamException();
		if (price < 0)
			throw new InvalidParamException();

		this.id = counter;
		counter++;

		
		this.name = name;
		this.author = author;
		this.price = price;
		this.dateIn = Calendar.getInstance();

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
