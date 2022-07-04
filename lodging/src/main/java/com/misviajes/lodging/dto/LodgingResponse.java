package com.misviajes.lodging.dto;

import lombok.Data;

@Data
public class LodgingResponse {
    private Long id;

    private Long workerId;

    private Long requestId;

    private String name;

    private Double price;
}
