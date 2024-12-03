package gui;

import models.Cliente;
import utils.ArquivoCliente;
import utils.OrdenadorExterno;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class JanelaPrincipal extends JFrame {
    public JanelaPrincipal() {
        setTitle("Gerenciador de Clientes");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JButton btnListar = new JButton("Listar Clientes");
        JButton btnPesquisar = new JButton("Pesquisar Cliente");
        JButton btnInserir = new JButton("Inserir Cliente");
        JButton btnRemover = new JButton("Remover Cliente");

        JPanel panel = new JPanel();
        panel.add(btnListar);
        panel.add(btnPesquisar);
        panel.add(btnInserir);
        panel.add(btnRemover);

        add(panel, BorderLayout.NORTH);

        JTextArea textArea = new JTextArea();
        add(new JScrollPane(textArea), BorderLayout.CENTER);

        btnListar.addActionListener(e -> {
            List<Cliente> clientes = ArquivoCliente.lerClientes();
            OrdenadorExterno.ordenarClientesPorNome(clientes);
            textArea.setText("");
            for (Cliente cliente : clientes) {
                textArea.append(cliente.toString() + "\n");
            }
        });

        btnInserir.addActionListener(e -> new JanelaDetalhesCliente(this));

        btnRemover.addActionListener(e -> {
            String id = JOptionPane.showInputDialog(this, "Digite o ID do cliente para remover:");
            if (id != null) {
                List<Cliente> clientes = ArquivoCliente.lerClientes();
                clientes.removeIf(cliente -> cliente.getId().equals(id));
                ArquivoCliente.salvarClientes(clientes);
                JOptionPane.showMessageDialog(this, "Cliente removido!");
            }
        });

        setVisible(true);
    }
}