/*
 *
 *  * Copyright (c) Crio.Do 2019. All rights reserved
 *
 */

package com.crio.qeats.models;

import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

// Java class that maps to Mongo collection.
// @Data@Getter@Setter
@Document(collection = "restaurants")
// @NoArgsConstructor
// @AllArgsConstructor
public class RestaurantEntity {
  
  @Id
  private String id;
  
  @NotNull
  private String restaurantId;
  
  @NotNull
  private String name;
  
  @NotNull
  private String city;
  
  @NotNull
  private String imageUrl;
  
  @NotNull
  private Double latitude;
  
  @NotNull
  private Double longitude;
  
  @NotNull
  private String opensAt;
  
  @NotNull
  private String closesAt;
  
  @NotNull
  private List<String> attributes = new ArrayList<>();
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getRestaurantId() {
    return restaurantId;
  }

  public void setRestaurantId(String restaurantId) {
    this.restaurantId = restaurantId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getImageUrl() {
    return imageUrl;
  }

  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }

  public Double getLatitude() {
    return latitude;
  }

  public void setLatitude(Double latitude) {
    this.latitude = latitude;
  }

  public Double getLongitude() {
    return longitude;
  }

  public void setLongitude(Double longitude) {
    this.longitude = longitude;
  }

  public String getOpensAt() {
    return opensAt;
  }

  public void setOpensAt(String opensAt) {
    this.opensAt = opensAt;
  }

  public String getClosesAt() {
    return closesAt;
  }

  public void setClosesAt(String closesAt) {
    this.closesAt = closesAt;
  }

  public List<String> getAttributes() {
    return attributes;
  }

  public void setAttributes(List<String> attributes) {
    this.attributes = attributes;
  }

  public RestaurantEntity(String id, @NotNull String restaurantId, @NotNull String name,
      @NotNull String city, @NotNull String imageUrl, @NotNull Double latitude,
      @NotNull Double longitude, @NotNull String opensAt, @NotNull String closesAt,
      @NotNull List<String> attributes) {
    this.id = id;
    this.restaurantId = restaurantId;
    this.name = name;
    this.city = city;
    this.imageUrl = imageUrl;
    this.latitude = latitude;
    this.longitude = longitude;
    this.opensAt = opensAt;
    this.closesAt = closesAt;
    this.attributes = attributes;
  }

  @Override
  public String toString() {
    return "RestaurantEntity [attributes=" + attributes + ", city=" + city + ", closesAt="
        + closesAt + ", id=" + id + ", imageUrl=" + imageUrl + ", latitude=" + latitude
        + ", longitude=" + longitude + ", name=" + name + ", opensAt=" + opensAt + ", restaurantId="
        + restaurantId + "]";
  }
  

  


}

