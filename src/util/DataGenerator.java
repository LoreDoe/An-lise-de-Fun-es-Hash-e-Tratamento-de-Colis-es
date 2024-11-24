package util;

import entity.Cliente;
import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe utilitária para gerar dados fictícios de clientes.
 */
public class DataGenerator {

    /**
     * Gera uma lista de clientes com dados fictícios.
     * 
     * @param quantidade O número de clientes a serem gerados.
     * @return Uma lista de objetos Cliente.
     */
    public static List<Cliente> gerarClientes(int quantidade) {
        Faker faker = new Faker(); // Biblioteca para gerar dados fictícios.
        List<Cliente> clientes = new ArrayList<>();

        for (int i = 0; i < quantidade; i++) {
            String nome = faker.name().firstName();
            String sobrenome = faker.name().lastName();
            String telefone = faker.phoneNumber().cellPhone();

            clientes.add(new Cliente(nome, sobrenome, telefone)); // Cria e adiciona um cliente à lista.
        }

        return clientes;
    }
}
