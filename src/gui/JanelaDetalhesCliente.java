package gui;

import models.Cliente;
import utils.ArquivoCliente;

import javax.swing.*;
import java.util.List;

public class JanelaDetalhesCliente extends JFrame {
    public JanelaDetalhesCliente(JFrame parent) {
        setTitle("Inserir Cliente");
        setSize(400, 300);
        setLayout(null);

        JLabel lblNome = new JLabel("Nome:");
        lblNome.setBounds(20, 20, 100, 25);
        add(lblNome);

        JTextField txtNome = new JTextField();
        txtNome.setBounds(120, 20, 200, 25);
        add(txtNome);

        JLabel lblEndereco = new JLabel("Endereço:");
        lblEndereco.setBounds(20, 60, 100, 25);
        add(lblEndereco);

        JTextField txtEndereco = new JTextField();
        txtEndereco.setBounds(120, 60, 200, 25);
        add(txtEndereco);

        JLabel lblTelefone = new JLabel("Telefone:");
        lblTelefone.setBounds(20, 100, 100, 25);
        add(lblTelefone);

        JTextField txtTelefone = new JTextField();
        txtTelefone.setBounds(120, 100, 200, 25);
        add(txtTelefone);

        JButton btnSalvar = new JButton("Salvar");
        btnSalvar.setBounds(120, 150, 100, 30);
        add(btnSalvar);

        btnSalvar.addActionListener(e -> {
            String id = String.valueOf(System.currentTimeMillis());
            String nome = txtNome.getText();
            String endereco = txtEndereco.getText();
            String telefone = txtTelefone.getText();

            Cliente cliente = new Cliente(id, nome, endereco, telefone);
            List<Cliente> clientes = ArquivoCliente.lerClientes();
            clientes.add(cliente);
            ArquivoCliente.salvarClientes(clientes);

            JOptionPane.showMessageDialog(this, "Cliente salvo!");
            parent.repaint();
            dispose();
        });

        setVisible(true);
    }
}