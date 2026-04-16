package com.recommended.food.tools;

import dev.langchain4j.agent.tool.Tool;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FoodTools {

    @Tool("Calcula o valor total do pedido somando todos os itens e adicionais informados")
    public String calcularTotal(List<Double> precosItens) {
        double total = precosItens.stream().mapToDouble(Double::doubleValue).sum();
        return String.format("O valor total do seu pedido é R$ %.2f", total);
    }

    @Tool("Verifica se o CEP ou endereço do cliente está dentro do raio de entrega de 3km")
    public String verificarEntrega(String enderecoCliente) {
        if (enderecoCliente.contains("Itapecerica")) {
            return "Endereço atendido! O delivery está disponível.";
        }
        return "Infelizmente este endereço está fora do nosso raio de 3km. Apenas retirada no balcão.";
    }
}
