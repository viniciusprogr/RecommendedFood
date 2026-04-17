package com.recommended.food.controller;


import com.recommended.food.controller.dtos.RequestFood;
import com.recommended.food.controller.dtos.ResponseFood;
import com.recommended.food.entities.FoodEntity;
import com.recommended.food.mapper.FoodMapper;
import com.recommended.food.repositories.FoodRepository;
import com.recommended.food.service.FoodService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/food")
@AllArgsConstructor
public class FoodController {

    private final FoodMapper foodMapper;

    private final FoodService foodService;

    @PostMapping
    public ResponseEntity<ResponseFood> create(@RequestBody RequestFood requestFood){
        FoodEntity entity = foodMapper.requstToEntity(requestFood);
        FoodEntity savedEntity = foodService.create(entity);
        return ResponseEntity.ok(foodMapper.entityToResponse(savedEntity));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseFood> findById(@PathVariable Long id) {
        FoodEntity entity = foodService.getFoodById(id);
        return ResponseEntity.ok(foodMapper.entityToResponse(entity));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        FoodEntity findedFood = foodService.getFoodById(id);
        foodService.delete(findedFood);
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<ResponseFood>> findAll() {
        List<FoodEntity> listFood = foodService.findAllFoods();
        return ResponseEntity.ok(foodMapper.listEntityToListResponse(listFood));
    }
}
