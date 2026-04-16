package com.recommended.food.controller.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseFood {
    private Long id;

    private String nome;

    private String descricao;

    private Double preco;
}
