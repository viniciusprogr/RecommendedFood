package com.recommended.food.config;

import com.recommended.food.service.FoodAiService;
import com.recommended.food.tools.FoodTools;
import dev.langchain4j.model.googleai.GoogleAiGeminiChatModel;
import dev.langchain4j.service.AiServices;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FoodAiConfig {

    @Value("${gemini.api-key}") // Removido o espaço extra
    private String geminiApiKey;

    @Value("${gemini.model}")
    private String geminiModel;

    @Bean
    public GoogleAiGeminiChatModel getGeminiChatModel() {
        return GoogleAiGeminiChatModel.builder()
                .apiKey(geminiApiKey)
                .modelName(geminiModel)
                .build();
    }

    @Bean // Adicionado o @Bean obrigatório
    public FoodAiService foodAiService(GoogleAiGeminiChatModel model, FoodTools foodTools) {
        return AiServices.builder(FoodAiService.class)
                .chatModel(model)
                .tools(foodTools)
                .build();
    }
}