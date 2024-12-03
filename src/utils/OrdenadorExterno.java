package utils;

import models.Cliente;

import java.util.Comparator;
import java.util.List;

public class OrdenadorExterno {
    public static void ordenarClientesPorNome(List<Cliente> clientes) {
        clientes.sort(Comparator.comparing(Cliente::getNome));
    }
}