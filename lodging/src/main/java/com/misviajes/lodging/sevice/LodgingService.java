package com.misviajes.lodging.sevice;

import com.misviajes.lodging.dto.LodgingRequest;
import com.misviajes.lodging.dto.LodgingResponse;

import java.util.List;



public interface LodgingService {
    List<LodgingResponse> getAll();

    LodgingResponse getById(Long id);

    LodgingResponse create(LodgingRequest request);

    LodgingResponse update(LodgingRequest request, Long id);

    void delete(Long id);
}
