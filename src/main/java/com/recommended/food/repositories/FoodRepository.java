package com.recommended.food.repositories;

import com.recommended.food.FoodApplication;
import com.recommended.food.entities.FoodEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodRepository extends JpaRepository<FoodEntity, Long> {
    boolean existsByNome(String nome);
}
