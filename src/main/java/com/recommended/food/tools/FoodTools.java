package com.recommended.food.tools;

import dev.langchain4j.agent.tool.Tool;
import org.springframework.stereotype.Component;

@Component
public class FoodTools {

    @Tool("Calcula o valor total do pedido somando os itens selecionados")
    public String calcularTotal(double precoLanche, boolean comBatata) {
        double total = precoLanche + (comBatata ? 15.0 : 0.0);
        return String.format("O valor total com os adicionais é R$ %.2f", total);
    }

    @Tool("Verifica se o CEP ou endereço do cliente está dentro do raio de entrega de 3km")
    public String verificarEntrega(String enderecoCliente) {
        if (enderecoCliente.contains("Itapecerica")) {
            return "Endereço atendido! O delivery está disponível.";
        }
        return "Infelizmente este endereço está fora do nosso raio de 3km. Apenas retirada no balcão.";
    }
}
