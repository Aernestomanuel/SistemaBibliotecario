package com.mycompany.sistemabibliotecario;
import java.util.ArrayList;
import java.util.Scanner;

class Livro {
    String titulo;
    String autor;
    boolean disponivel;

    Livro(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
        this.disponivel = true;
    }
}

class Biblioteca {
    ArrayList<Livro> livros = new ArrayList<>();

    void adicionarLivro(String titulo, String autor) {
        livros.add(new Livro(titulo, autor));
        System.out.println("Livro adicionado: " + titulo);
    }

    void listarLivros() {
        for (Livro livro : livros) {
            System.out.println("Título: " + livro.titulo + ", Autor: " 
                    + livro.autor + ", Disponível: " 
                    + (livro.disponivel ? "Sim" : "Não"));
        }
    }

    void emprestarLivro(String titulo) {
        for (Livro livro : livros) {
            if (livro.titulo.equals(titulo) && livro.disponivel) {
                livro.disponivel = false;
                System.out.println("Livro emprestado: " + titulo);
                return;
            }
        }
        System.out.println("Livro não disponível.");
    }

    void devolverLivro(String titulo) {
        for (Livro livro : livros) {
            if (livro.titulo.equals(titulo) && !livro.disponivel) {
                livro.disponivel = true;
                System.out.println("Livro devolvido: " + titulo);
                return;
            }
        }
        System.out.println("Livro não encontrado.");
    }
}

public class SistemaBiblioteca {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n1. Adicionar Livro\n2. Listar Livros\n"
                    + "3. Emprestar Livro\n4. Devolver Livro\n5. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1:
                    System.out.print("Título do Livro: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Autor do Livro: ");
                    String autor = scanner.nextLine();
                    biblioteca.adicionarLivro(titulo, autor);
                    break;
                case 2:
                    biblioteca.listarLivros();
                    break;
                case 3:
                    System.out.print("Título do Livro para emprestar: ");
                    titulo = scanner.nextLine();
                    biblioteca.emprestarLivro(titulo);
                    break;
                case 4:
                    System.out.print("Título do Livro para devolver: ");
                    titulo = scanner.nextLine();
                    biblioteca.devolverLivro(titulo);
                    break;
                case 5:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 5);
        scanner.close();
    }
}

/*Sonarqube*/
/*JUnit*/
