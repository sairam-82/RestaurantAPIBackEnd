/*
 *
 * * Copyright (c) Crio.Do 2019. All rights reserved
 *
 */

package com.crio.qeats.controller;

import com.crio.qeats.dto.Restaurant;
import com.crio.qeats.exchanges.GetRestaurantsRequest;
import com.crio.qeats.exchanges.GetRestaurantsResponse;
import com.crio.qeats.services.RestaurantService;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;

import lombok.Data;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// TODO: CRIO_TASK_MODULE_RESTAURANTSAPI
// Implement Controller using Spring annotations.
// Remember, annotations have various "targets". They can be class level, method level or others.
@Data
@Log4j2
@RestController
@RequestMapping(RestaurantController.RESTAURANT_API_ENDPOINT)
public class RestaurantController {

    public static final String RESTAURANT_API_ENDPOINT = "/qeats/v1";
    public static final String RESTAURANTS_API = "/restaurants";
    public static final String MENU_API = "/menu";
    public static final String CART_API = "/cart";
    public static final String CART_ITEM_API = "/cart/item";
    public static final String CART_CLEAR_API = "/cart/clear";
    public static final String POST_ORDER_API = "/order";
    public static final String GET_ORDERS_API = "/orders";

    @Autowired
    private RestaurantService restaurantService;

   @GetMapping(RESTAURANTS_API)
   public ResponseEntity<GetRestaurantsResponse> getRestaurants(
      @Valid GetRestaurantsRequest getRestaurantsRequest) {

    log.info("getRestaurants called with {}", getRestaurantsRequest);
    GetRestaurantsResponse getRestaurantsResponse;

    if ((getRestaurantsRequest.getLatitude() != null && getRestaurantsRequest.getLongitude() != null
        && getRestaurantsRequest.getLatitude() >= -90 && getRestaurantsRequest.getLatitude() <= 90
        && getRestaurantsRequest.getLongitude() >= -180
        && getRestaurantsRequest.getLongitude() <= 180)) {

      List<Restaurant> restaurants;

      // if (!StringUtils.isEmpty(getRestaurantsRequest.getSearchFor())) {
        if (getRestaurantsRequest.getSearchFor() !=null &&  !getRestaurantsRequest.getSearchFor().isEmpty()) {
        getRestaurantsResponse =
            restaurantService.findRestaurantsBySearchQuery(getRestaurantsRequest, LocalTime.now());
        log.info("getRestaurants returned {}", getRestaurantsResponse);
        // restaurants = getRestaurantsResponse.getRestaurants();
      } else {
        getRestaurantsResponse =
            restaurantService.findAllRestaurantsCloseBy(getRestaurantsRequest, LocalTime.now());
        // restaurants = getRestaurantsResponse.getRestaurants();
      }
      if(getRestaurantsResponse!=null && !getRestaurantsResponse.getRestaurants().isEmpty()){
        restaurants = getRestaurantsResponse.getRestaurants();
        for (int i = 0; i < restaurants.size(); i++) {
          restaurants.get(i).setName(restaurants.get(i).getName().replace("é", "e"));
        }
        log.info("getRestaurants returned {}", getRestaurantsResponse);
  
        return ResponseEntity.ok().body(getRestaurantsResponse);
  
      }else{
        return new ResponseEntity<>(HttpStatus.OK) ;
      }
      

    } else {
      return ResponseEntity.badRequest().body(null);
    }



    /*
     * -- code before Search Implementation..
     * 
     * // CHECKSTYLE:OFF getRestaurantsResponse =
     * restaurantService.findAllRestaurantsCloseBy(getRestaurantsRequest, LocalTime.now());
     * 
     * // CHECKSTYLE:ON
     * 
     * List <Restaurant> restaurants= getRestaurantsResponse.getRestaurants();
     * 
     * for(Restaurant r : restaurants){ if (r.getName().contains("é")) { String name =
     * r.getName().replace('é', 'e'); r.setName(name); } }
     * 
     * getRestaurantsResponse.setRestaurants(restaurants);
     * 
     * return ResponseEntity.ok().body(getRestaurantsResponse);
     */
  }
    // @GetMapping(RESTAURANTS_API)
    // public ResponseEntity<GetRestaurantsResponse> getRestaurants(
    // @Valid GetRestaurantsRequest getRestaurantsRequest) {

    // // System.out.println(getRestaurantsRequest);
    // // log.info("getRestaurants called with {}", getRestaurantsRequest);
    // // GetRestaurantsResponse getRestaurantsResponse;

    // // //CHECKSTYLE:OFF
    // // getRestaurantsResponse = restaurantService
    // // .findAllRestaurantsCloseBy(getRestaurantsRequest, LocalTime.now());
    // // // log.info("getRestaurants returned {}", getRestaurantsResponse);
    // // if(getRestaurantsResponse!=null && !getRestaurantsResponse.getRestaurants().isEmpty()){
    // // List<Restaurant> restaurants= getRestaurantsResponse.getRestaurants();
    // // List<Restaurant> changedRes= new ArrayList<>();
    // // for(Restaurant res:restaurants){
    // // String name = res.getName().replace("é", "e");
    // // res.setName(name);
    // // changedRes.add(res);
    // // }
    // // return ResponseEntity.ok().body(new GetRestaurantsResponse(changedRes));
    // // }
    // List<Restaurant> restaurants;
    // GetRestaurantsResponse getRestaurantsResponse;
    // if (!StringUtils.isEmpty(getRestaurantsRequest.getSearchFor())) {

    // getRestaurantsResponse =

    // restaurantService.findRestaurantsBySearchQuery(getRestaurantsRequest,
    // LocalTime.now());
    // log.info("getRestaurants returned {}", getRestaurantsResponse);
    // restaurants = getRestaurantsResponse.getRestaurants();
    // } else {
    // getRestaurantsResponse =
    // restaurantService.findAllRestaurantsCloseBy(getRestaurantsRequest,
    // LocalTime.now());
    // restaurants = getRestaurantsResponse.getRestaurants();
    // }
    // for (int i = 0; i < restaurants.size(); i++) {
    // restaurants.get(i).setName(restaurants.get(i).getName().replace("é",
    // "?"));
    // }
    // log.info("getRestaurants returned {}", getRestaurantsResponse);
    // return ResponseEntity.ok().body(getRestaurantsResponse);

    // // return ResponseEntity.badRequest().body(null);

    // //CHECKSTYLE:ON
    // // return ResponseEntity.ok().body(getRestaurantsResponse);
    // }

    // @GetMapping(RESTAURANT_API_ENDPOINT + RESTAURANTS_API)
    // public ResponseEntity<GetRestaurantsResponse> get

    // TIP(MODULE_MENUAPI): Model Implementation for getting menu given a restaurantId.
    // Get the Menu for the given restaurantId
    // API URI: /qeats/v1/menu?restaurantId=11
    // Method: GET
    // Query Params: restaurantId
    // Success Output:
    // 1). If restaurantId is present return Menu
    // 2). Otherwise respond with BadHttpRequest.
    //
    // HTTP Code: 200
    // {
    // "menu": {
    // "items": [
    // {
    // "attributes": [
    // "South Indian"
    // ],
    // "id": "1",
    // "imageUrl": "www.google.com",
    // "itemId": "10",
    // "name": "Idly",
    // "price": 45
    // }
    // ],
    // "restaurantId": "11"
    // }
    // }
    // Error Response:
    // HTTP Code: 4xx, if client side error.
    // : 5xx, if server side error.
    // Eg:
    // curl -X GET "http://localhost:8081/qeats/v1/menu?restaurantId=11"



}

