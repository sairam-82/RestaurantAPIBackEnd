/*
 *
 *  * Copyright (c) Crio.Do 2019. All rights reserved
 *
 */

package com.crio.qeats.exchanges;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

// TODO: CRIO_TASK_MODULE_RESTAURANTSAPI
//  Implement GetRestaurantsRequest.
//  Complete the class such that it is able to deserialize the incoming query params from
//  REST API clients.
//  For instance, if a REST client calls API
// 
//  this class should be able to deserialize lat/long and optional searchFor from that.
// @Data
// @Getter
// @Setter
// @AllArgsConstructor
// @NoArgsConstructor
// @RequiredArgsConstructor
public class GetRestaurantsRequest {
    @Max(90)
    @Min(-90)
    @NotNull
    private Double latitude;
    @Max(180)
    @Min(-180)
    @NotNull
    private Double longitude;

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
    // @JsonIgnore
    private String searchFor;
    public String getSearchFor() {
        return searchFor;
    }

    public void setSearchFor(String searchFor) {
        this.searchFor = searchFor;
    }

     public GetRestaurantsRequest(){}

    public GetRestaurantsRequest(Double latitude,Double longitude){
        this.latitude=latitude;
        this.longitude=longitude;
    }
 

    public GetRestaurantsRequest(@Max(90) @Min(-90) @NotNull Double latitude,
            @Max(180) @Min(-180) @NotNull Double longitude, String searchFor) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.searchFor = searchFor;
    }

    @Override
    public String toString() {
        return "GetRestaurantsRequest [latitude=" + latitude + ", longitude=" + longitude + "]";
    }
   





}

