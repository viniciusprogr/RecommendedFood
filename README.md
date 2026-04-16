# 🍔 FoodAI - Assistente Virtual para Restaurantes

O **FoodAI** é um assistente virtual inteligente desenvolvido para o restaurante **Burguer & Batata**. O projeto utiliza **Generative AI** para automatizar o atendimento ao cliente, sendo capaz de processar pedidos, consultar o cardápio detalhado, calcular valores totais e validar a viabilidade de entrega através de ferramentas integradas ao modelo de linguagem.

---

## 🚀 Tecnologias e Versões

* **Java 26 (Early Access):** Versão de ponta da linguagem para máxima performance.
* **Spring Boot 4.0.5:** Framework para gestão de dependências e exposição da API.
* **LangChain4j (1.12.2-beta22):** Orquestração entre a aplicação Java e o modelo de IA.
* **Google Gemini 1.5 Flash:** Modelo de linguagem otimizado para respostas rápidas.
* **MySQL 8.0:** Banco de dados para persistência e gestão de informações.
* **Docker & Docker Compose:** Padronização do ambiente de desenvolvimento e infraestrutura.

---

## 🛠️ Arquitetura do Sistema

O projeto foi construído focando na separação de responsabilidades e extensibilidade:

* **Camada de Configuração (`FoodAiConfig`):** Define os Beans do modelo Gemini, provedores de memória (`MessageWindowChatMemory`) e integra as ferramentas de sistema.
* **Serviço de IA (`FoodAiService`):** Contrato que contém as diretrizes de comportamento do assistente (System Message), incluindo o cardápio completo de burgueres, opções veggies e bebidas.
* **Ferramentas (`FoodTools`):** Implementa a lógica de *Function Calling*, permitindo que a IA execute código Java para cálculos matemáticos e verificações geográficas.
* **Controlador (`FoodAiController`):** Endpoint REST (`/api/food`) que recebe as mensagens dos clientes.

---

## 🍱 Funcionalidades Principais

1.  **Atendimento Automatizado:** Responde dúvidas sobre ingredientes, pontos da carne e disponibilidade de itens.
2.  **Cálculo Preciso de Pedidos:** Utiliza a ferramenta `calcularTotal` para somar itens e adicionais, evitando erros de cálculo comuns em modelos de texto.
3.  **Verificação de Entrega:** Valida se o endereço ou CEP do cliente está dentro do raio de entrega de 3km.
4.  **Gestão de Memória:** O assistente mantém o contexto das últimas 50 mensagens, permitindo um diálogo contínuo e natural.

---

## 📦 Como Executar

### 1. Configuração do Banco de Dados
Certifique-se de ter o Docker instalado e suba o container do MySQL:
```bash
docker-compose up -d
