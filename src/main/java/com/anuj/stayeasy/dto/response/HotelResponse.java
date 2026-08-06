package com.anuj.stayeasy.dto.response;

import lombok.Data;

@Data
public class HotelResponse {

    private Long id;
    private String name;
    private String description;
    private String city;
    private String address;
    private Integer totalRooms;
    private Integer availableRooms;
    private Long managerId;

}
