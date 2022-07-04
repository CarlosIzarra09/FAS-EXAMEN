package com.misviajes.lodging.sevice.impl;

import com.misviajes.lodging.dto.LodgingRequest;
import com.misviajes.lodging.dto.LodgingResponse;
import com.misviajes.lodging.entity.Lodging;
import com.misviajes.lodging.exception.ResourceNotFoundExceptionRequest;
import com.misviajes.lodging.repository.LodgingRepository;
import com.misviajes.lodging.sevice.LodgingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class LodgingServiceImpl implements LodgingService {
    @Autowired
    private LodgingRepository lodgingRepository;

    private LodgingResponse convertToResponse(Lodging entity) {
        LodgingResponse response = new LodgingResponse();
        response.setId(entity.getId());
        response.setName(entity.getName());
        response.setWorkerId(entity.getWorkerId());
        response.setPrice(entity.getPrice());
        return response;
    }

    private Lodging convertToEntity(LodgingRequest request) {
        Lodging entity = new Lodging();
        entity.setName(request.getName());
        entity.setWorkerId(request.getWorkerId());
        entity.setPrice(request.getPrice());
        return entity;
    }

    private Lodging convertToEntity(LodgingRequest request, Long id) {
        Lodging entity = new Lodging();
        entity.setId(id);
        entity.setName(request.getName());
        entity.setWorkerId(request.getWorkerId());
        entity.setPrice(request.getPrice());
        return entity;
    }

    @Override
    public List<LodgingResponse> getAll() {
        var entities = lodgingRepository.findAll();
        var response = entities.stream().map(entity -> convertToResponse(entity)).collect(Collectors.toList());
        return response;
    }

    @Override
    public LodgingResponse getById(Long id) {
        var entity = lodgingRepository.getLodgingById(id)
                .orElseThrow(() -> new ResourceNotFoundExceptionRequest("lodging not found"));
        var response = convertToResponse(entity);
        return response;
    }

    @Override
    public LodgingResponse create(LodgingRequest request) {

        var entity = convertToEntity(request);

        try {
            lodgingRepository.save(entity);
            var response = convertToResponse(entity);
            return response;
        } catch (Exception e) {
            throw new ResourceNotFoundExceptionRequest("Error ocurred while creating lodging");
        }
    }

    @Override
    public LodgingResponse update(LodgingRequest request, Long id) {
        var entity = lodgingRepository.getLodgingById(id)
                .orElseThrow(() -> new ResourceNotFoundExceptionRequest("lodging not found"));

        entity = convertToEntity(request, id);

        try {
            lodgingRepository.save(entity);
            var response = convertToResponse(entity);
            return response;
        } catch (Exception e) {
            throw new ResourceNotFoundExceptionRequest("Error ocurred while updating lodging");
        }
    }

    @Override
    public void delete(Long id) {
        try {
            lodgingRepository.deleteById(id);
        } catch (Exception e) {
            throw new ResourceNotFoundExceptionRequest("Error ocurred while deleting lodging");
        }
    }
}
