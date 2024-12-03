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
- **Manipulação de Arquivos**: Leitura e escrita de dados diretamente em arquivos de texto.

---

## 📂 Estrutura do Projeto
```
src/
├── models/
│   └── Cliente.java # Classe que representa o cliente 
├── utils/
│   └── OrdenadorExterno.java # Algoritmo para ordenação externa
│   └── ArquivoCliente.java # Gerenciamento de leitura/escrita de arquivos
├── gui/
│   └── JanelaPrincipal.java # Interface gráfica principal
│   └── JanelaDetalhesCliente.java # Tela de inserção de clientes
└── App.java # Classe principal para iniciar o sistema
```


📝 Como Usar
```
    Listar Clientes: Clique no botão Listar Clientes para exibir os clientes em ordem alfabética.
    Pesquisar Cliente: (Em desenvolvimento).
    Inserir Cliente: Clique em Inserir Cliente, preencha os campos e salve o cliente.
    Remover Cliente: Clique em Remover Cliente e insira o ID do cliente para removê-lo.
```
