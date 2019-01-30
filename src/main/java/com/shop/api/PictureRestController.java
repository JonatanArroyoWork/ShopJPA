package com.shop.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.shop.application.PictureController;
import com.shop.application.ShopController;
import com.shop.application.DTO.PictureDTO;

@CrossOrigin
@RestController
public class PictureRestController {

	@Autowired
    private PictureController controller;
	@Autowired
	private ShopController shopController;
	
    @PostMapping(value = "/shop/{shopId}/pictures", produces = "application/json;charset=UTF-8")
    public String addPicture(@PathVariable int shopId, @RequestBody String jPicture) throws Exception{

        PictureDTO newPicture = new Gson().fromJson(jPicture, PictureDTO.class);

        PictureDTO picture = controller.createPICTURE(shopId, newPicture);

        return toJson(picture);
    }

    @GetMapping(value = "/shop/{shopId}/pictures", produces = "application/json;charset=UTF-8")
    public String listPicture(@PathVariable int shopId) throws Exception {

        List<PictureDTO> pictureList = controller.getAllPicturesByShop(shopId);

        return toJson(pictureList);
    }

    @DeleteMapping (value="/shop/{shopId}/pictures",produces="application/json;charset=UTF-8")
    public void removeAllPictures(@PathVariable int shopId) throws Exception {
        shopController.burnPicturesByShopID(shopId);

    }
    
    private String toJson(Object object){

        Gson gson=new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        return gson.toJson(object);
    }
}




