package com.recommended.food.service;

import com.recommended.food.entities.FoodEntity;
import com.recommended.food.repositories.FoodRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FoodService {

    private final FoodRepository foodRepository;

    public FoodEntity create(FoodEntity entity) {
        if (foodRepository.existsByNome(entity.getNome())) {
            throw new RuntimeException("Já existe um produto cadastrado com o nome: " + entity.getNome());
        }
        return foodRepository.save(entity);
    }
}
