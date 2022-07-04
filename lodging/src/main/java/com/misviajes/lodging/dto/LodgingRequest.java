package com.misviajes.lodging.dto;

import lombok.Data;

@Data
public class LodgingRequest {
    private Long workerId;

    private Long requestId;

    private String name;

    private Double price;
}
