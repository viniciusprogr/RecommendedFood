package com.recommended.food.controller;


import com.recommended.food.controller.dtos.RequestFood;
import com.recommended.food.controller.dtos.ResponseFood;
import com.recommended.food.entities.FoodEntity;
import com.recommended.food.mapper.FoodMapper;
import com.recommended.food.service.FoodService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/food")
@AllArgsConstructor
public class FoodControler {

    private final FoodMapper foodMapper;

    private final FoodService foodService;

    @PostMapping
    public ResponseEntity<ResponseFood> create(@RequestBody RequestFood requestFood){
        FoodEntity entity = foodMapper.requstToEntity(requestFood);
        FoodEntity savedEntity = foodService.create(entity);
        return ResponseEntity.ok(foodMapper.entityToResponse(savedEntity));
    }
}
