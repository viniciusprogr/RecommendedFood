package com.recommended.food.controller;


import com.recommended.food.controller.dtos.RequestFood;
import com.recommended.food.controller.dtos.ResponseFood;
import com.recommended.food.entities.FoodEntity;
import com.recommended.food.mapper.FoodMapper;
import com.recommended.food.repositories.FoodRepository;
import com.recommended.food.service.FoodService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/food")
@AllArgsConstructor
public class FoodControler {

    private final FoodMapper foodMapper;

    private final FoodService foodService;
    private final FoodRepository foodRepository;

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

}
