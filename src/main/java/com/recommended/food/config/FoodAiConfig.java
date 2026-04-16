package com.recommended.food.config;

import com.recommended.food.service.FoodAiService;
import com.recommended.food.tools.FoodTools;
import dev.langchain4j.memory.chat.ChatMemoryProvider;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.memory.chat.TokenWindowChatMemory;
import dev.langchain4j.model.googleai.GoogleAiGeminiChatModel;
import dev.langchain4j.model.googleai.GoogleAiGeminiTokenCountEstimator;
import dev.langchain4j.service.AiServices;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FoodAiConfig {

    @Value("${gemini.api-key}")
    private String geminiApiKey;

    @Value("${gemini.model}")
    private String geminiModel;

    @Bean
    public GoogleAiGeminiChatModel getGeminiChatModel() {
        return GoogleAiGeminiChatModel.builder()
                .apiKey(geminiApiKey)
                .modelName(geminiModel)
                // Removido o systemMessage/systemInstruction que causava erro
                .build();
    }

    @Bean
    public ChatMemoryProvider chatMemoryProvider() {
        return chatId -> MessageWindowChatMemory.withMaxMessages(50);
    }

    @Bean
    public FoodAiService foodAiService(GoogleAiGeminiChatModel model, FoodTools foodTools, ChatMemoryProvider chatMemoryProvider) {
        return AiServices.builder(FoodAiService.class)
                .chatModel(model)
                .tools(foodTools)
                .chatMemoryProvider(chatMemoryProvider)
                .build();
    }
}