package com.recommended.food.mapper;

import com.recommended.food.controller.dtos.RequestFood;
import com.recommended.food.controller.dtos.ResponseFood;
import com.recommended.food.entities.FoodEntity;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class FoodMapper {

    private final ModelMapper modelMapper;


    public FoodEntity requstToEntity(RequestFood requestFood) {
        return  this.modelMapper.map(requestFood, FoodEntity.class);
    }

    public ResponseFood entityToResponse(FoodEntity savedEntity) {
        return this.modelMapper.map(savedEntity, ResponseFood.class);
    }
}
