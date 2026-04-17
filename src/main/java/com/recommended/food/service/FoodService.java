package com.recommended.food.service;

import com.recommended.food.entities.FoodEntity;
import com.recommended.food.repositories.FoodRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    public FoodEntity getFoodById(Long id) {
        return foodRepository.findById(id).orElseThrow(() -> new RuntimeException("Não existe um produto cadastrado com o id: " + id));
    }

    @Transactional
    public void delete(FoodEntity findedFood) {
        foodRepository.delete(findedFood);
    }

    public List<FoodEntity> findAllFoods() {
        return foodRepository.findAll();
    }

}
