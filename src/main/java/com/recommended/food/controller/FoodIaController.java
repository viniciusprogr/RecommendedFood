package com.recommended.food.controller;

import com.recommended.food.service.FoodAiService;
import dev.langchain4j.service.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/food")
public class FoodIaController {

    private final FoodAiService foodAiService;


    public FoodIaController(FoodAiService foodAiService) {
        this.foodAiService = foodAiService;
    }

    @PostMapping
    public String askAssistant(@RequestBody String userMessage){
        Result<String> result = foodAiService.handleRequest(userMessage);
        return result.content();
    }
}
