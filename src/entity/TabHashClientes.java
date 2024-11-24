package entity;

import java.util.Arrays;

/**
 * Classe que implementa uma tabela hash para armazenar clientes.
 */
public class TabHashClientes {
    private Cliente[] tabela; // Array para armazenar os dados da tabela hash.
    private int tamanho; // Tamanho da tabela hash.
    private int numElementos; // Contador de elementos inseridos.

    // Construtor
    public TabHashClientes(int tamanho) {
        this.tamanho = tamanho;
        this.tabela = new Cliente[tamanho];
        this.numElementos = 0;
    }

    /**
     * Função hash base: calcula a posição na tabela usando o nome do cliente.
     */
    private int hash(String chave) {
        int hashCode = chave.hashCode();
        return Math.abs(hashCode) % tamanho;
    }

    /**
     * Insere um cliente na tabela hash utilizando sondagem linear em caso de colisões.
     */
    public void inserir(Cliente cliente) {
        int posicao = hash(cliente.getNome());
        int tentativas = 0;

        // Resolve colisões utilizando sondagem linear
        while (tabela[posicao] != null) {
            tentativas++;
            posicao = (posicao + 1) % tamanho; // Calcula a próxima posição.
        }

        tabela[posicao] = cliente; // Insere o cliente na posição encontrada.
        numElementos++;
    }

    /**
     * Pesquisa um cliente pelo nome. Retorna o cliente encontrado ou null.
     */
    public Cliente pesquisar(String nome) {
        int posicao = hash(nome);
        int tentativas = 0;

        // Procura o cliente resolvendo colisões com sondagem linear
        while (tabela[posicao] != null) {
            if (tabela[posicao].getNome().equals(nome)) {
                return tabela[posicao]; // Cliente encontrado.
            }
            tentativas++;
            posicao = (posicao + 1) % tamanho; // Calcula a próxima posição.
        }

        return null; // Cliente não encontrado.
    }

    /**
     * Remove um cliente da tabela hash pelo nome.
     */
    public void remover(String nome) {
        int posicao = hash(nome);

        // Resolve colisões com sondagem linear
        while (tabela[posicao] != null) {
            if (tabela[posicao].getNome().equals(nome)) {
                tabela[posicao] = null; // Remove o cliente.
                numElementos--;
                return;
            }
            posicao = (posicao + 1) % tamanho;
        }
    }

    /**
     * Retorna o número total de elementos na tabela hash.
     */
    public int getNumElementos() {
        return numElementos;
    }

    /**
     * Exibe o conteúdo da tabela hash no console.
     */
    public void exibirTabela() {
        System.out.println(Arrays.toString(tabela));
    }
}
