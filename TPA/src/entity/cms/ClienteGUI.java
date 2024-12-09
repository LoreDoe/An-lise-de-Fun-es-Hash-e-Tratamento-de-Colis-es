package entity.cms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ClienteGUI extends JFrame {
    private JTextField searchField;
    private JTextArea displayArea;
    private JButton listButton, searchButton, addButton, removeButton;
    private File dataFile = new File("clientes.txt");

    public ClienteGUI() {
        // Configuração da janela principal
        setTitle("Gerenciamento de Clientes");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Painel superior com campo de busca
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout());
        searchField = new JTextField(20);
        searchButton = new JButton("Pesquisar");
        topPanel.add(new JLabel("Buscar:"));
        topPanel.add(searchField);
        topPanel.add(searchButton);
        add(topPanel, BorderLayout.NORTH);

        // Área de exibição de resultados
        displayArea = new JTextArea();
        displayArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(displayArea);
        add(scrollPane, BorderLayout.CENTER);

        // Painel inferior com botões
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout());
        listButton = new JButton("Listar Clientes");
        addButton = new JButton("Adicionar Cliente");
        removeButton = new JButton("Remover Cliente");
        bottomPanel.add(listButton);
        bottomPanel.add(addButton);
        bottomPanel.add(removeButton);
        add(bottomPanel, BorderLayout.SOUTH);

        // Configurar eventos dos botões
        configureEvents();
    }

    private void configureEvents() {
        listButton.addActionListener(e -> listClients());
        searchButton.addActionListener(e -> searchClient());
        addButton.addActionListener(e -> addClient());
        removeButton.addActionListener(e -> removeClient());
    }

    private void listClients() {
        try {
            List<String> clients = loadClients();
            clients.sort(String::compareToIgnoreCase); // Ordenar alfabeticamente
            displayArea.setText(String.join("\n", clients));
        } catch (IOException ex) {
            showError("Erro ao listar clientes: " + ex.getMessage());
        }
    }

    private void searchClient() {
        String searchTerm = searchField.getText().trim();
        if (searchTerm.isEmpty()) {
            showError("Por favor, insira um nome para buscar.");
            return;
        }
        try {
            List<String> clients = loadClients();
            String result = clients.stream()
                    .filter(client -> client.toLowerCase().contains(searchTerm.toLowerCase()))
                    .findFirst()
                    .orElse("Cliente não encontrado.");
            displayArea.setText(result);
        } catch (IOException ex) {
            showError("Erro ao buscar cliente: " + ex.getMessage());
        }
    }

    private void addClient() {
        String newClient = JOptionPane.showInputDialog(this, "Digite o nome do novo cliente:");
        if (newClient == null || newClient.trim().isEmpty()) {
            showError("Nome do cliente não pode estar vazio.");
            return;
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(dataFile, true))) {
            writer.write(newClient.trim());
            writer.newLine();
            displayArea.setText("Cliente adicionado com sucesso.");
        } catch (IOException ex) {
            showError("Erro ao adicionar cliente: " + ex.getMessage());
        }
    }

    private void removeClient() {
        String clientToRemove = JOptionPane.showInputDialog(this, "Digite o nome do cliente a ser removido:");
        if (clientToRemove == null || clientToRemove.trim().isEmpty()) {
            showError("Nome do cliente não pode estar vazio.");
            return;
        }
        try {
            List<String> clients = loadClients();
            if (clients.removeIf(client -> client.equalsIgnoreCase(clientToRemove.trim()))) {
                saveClients(clients);
                displayArea.setText("Cliente removido com sucesso.");
            } else {
                displayArea.setText("Cliente não encontrado.");
            }
        } catch (IOException ex) {
            showError("Erro ao remover cliente: " + ex.getMessage());
        }
    }

    private List<String> loadClients() throws IOException {
        if (!dataFile.exists()) return new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(dataFile))) {
            List<String> clients = new ArrayList<>();
            String line;
            while ((line = reader.readLine()) != null) {
                clients.add(line.trim());
            }
            return clients;
        }
    }

    private void saveClients(List<String> clients) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(dataFile))) {
            for (String client : clients) {
                writer.write(client);
                writer.newLine();
            }
        }
    }

    private void showError(String message) {
        JOptionPane.showMessageDialog(this, message, "Erro", JOptionPane.ERROR_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ClienteGUI app = new ClienteGUI();
            app.setVisible(true);
        });
    }
}