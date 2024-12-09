# Gerenciador de Clientes

Este projeto é um sistema para gerenciar o cadastro de clientes de uma empresa global, projetado para manipular grandes volumes de dados de forma eficiente. O sistema utiliza uma interface gráfica (GUI) baseada em **JFrames**, seguindo o estilo gráfico do Windows.

---

## ⚙️ Funcionalidades

1. **Listar Clientes:** Exibe todos os clientes cadastrados em ordem alfabética.
2. **Pesquisar Cliente:** Permite buscar informações de um cliente específico.
3. **Inserir Cliente:** Adiciona um novo cliente ao sistema.
4. **Remover Cliente:** Remove um cliente pelo ID.

---

## 🛠️ Tecnologias Utilizadas

- **Java**: Linguagem de programação principal.
- **Swing**: Para a criação da interface gráfica.
- **Algoritmos de Ordenação Externa**: Para lidar com grandes volumes de dados armazenados em arquivos.

---

## 📂 Estrutura do Projeto
```
ClienteGUI/
│
├── src/
│   └── ClienteGUI.java               # Código da interface gráfica e lógica de manipulação de clientes
│
├── clientes.txt                      # Arquivo de texto para armazenar os clientes
│
└── README.md  
```


📝 Como Usar
```
    Listar Clientes: Clique no botão Listar Clientes para exibir os clientes em ordem alfabética.
    Pesquisar Cliente: Clique no botão Pesquisar Clientes para pesquisar o cliente especificado pelo seu nome.
    Adicionar Cliente: Clique em Inserir Cliente, preencha os campos e salve o cliente.
    Remover Cliente: Clique em Remover Cliente e insira o ID do cliente para removê-lo.
```
