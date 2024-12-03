package gui;

import models.Cliente;
import utils.ArquivoCliente;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.stream.Collectors;

public class JanelaPesquisaCliente extends JFrame {
    public JanelaPesquisaCliente(JFrame parent) {
        setTitle("Pesquisar Cliente");
        setSize(400, 300);  // Tamanho da janela
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(parent);  // Centraliza a janela em relação à janela principal
        setLayout(new BorderLayout());  // Usando BorderLayout para um layout mais simples

        // Painel para os componentes
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1));  // Configuração para alinhar os componentes

        // Campo de texto para pesquisa
        JTextField txtPesquisar = new JTextField();
        panel.add(txtPesquisar);

        // Botão de pesquisa
        JButton btnPesquisar = new JButton("Pesquisar");
        panel.add(btnPesquisar);

        // Área de texto para exibir resultados
        JTextArea textAreaResultado = new JTextArea();
        textAreaResultado.setEditable(false);  // Não permite edição no resultado da pesquisa
        JScrollPane scrollPane = new JScrollPane(textAreaResultado);
        panel.add(scrollPane);

        // Adiciona o painel à janela
        add(panel, BorderLayout.CENTER);

        // Ação do botão de pesquisa
        btnPesquisar.addActionListener(e -> {
            String nomePesquisa = txtPesquisar.getText().toLowerCase().trim();  // Converte o texto da pesquisa para minúsculas

            if (nomePesquisa.isEmpty()) {
                textAreaResultado.setText("Por favor, insira um nome para pesquisa.");
                return;
            }

            // Ler todos os clientes
            List<Cliente> clientes = ArquivoCliente.lerClientes();

            // Filtrar clientes que correspondem ao nome pesquisado
            List<Cliente> resultado = clientes.stream()
                    .filter(cliente -> cliente.getNome().toLowerCase().contains(nomePesquisa))
                    .collect(Collectors.toList());

            // Exibir o resultado na área de texto
            if (resultado.isEmpty()) {
                textAreaResultado.setText("Nenhum cliente encontrado.");
            } else {
                StringBuilder sb = new StringBuilder();
                for (Cliente cliente : resultado) {
                    sb.append(cliente.toString()).append("\n");
                }
                textAreaResultado.setText(sb.toString());
            }
        });

        setVisible(true);
    }
}