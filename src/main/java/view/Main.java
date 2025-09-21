package view;

import controller.SecretariaController;
import factory.Persistencia;
import model.Secretaria;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        SecretariaController controller = new SecretariaController();
        Scanner sc = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n--- Sistema de Secretarias ---");
            System.out.println("1. Cadastrar secretaria");
            System.out.println("2. Listar secretarias");
            System.out.println("3. Atualizar secretaria");
            System.out.println("4. Deletar secretaria");
            System.out.println("5. Buscar secretaria por ID");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Nome: ");
                    String nome = sc.nextLine();
                    System.out.print("Email: ");
                    String email = sc.nextLine();
                    System.out.print("Setor: ");
                    String setor = sc.nextLine();
                    controller.save(nome, email, setor);
                    System.out.println("Secretaria cadastrada com sucesso!");
                    break;
                case 2:
                    List<Object> lista = controller.findAll();
                    for (Object obj : lista) {
                        Secretaria s = (Secretaria) obj;
                        System.out.println(s.getId() + " | " + s.getNome() + " | " + s.getEmail() + " | " + s.getSetor());
                    }
                    break;
                case 3:
                    System.out.print("ID da secretaria para atualizar: ");
                    int idUpdate = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Novo nome: ");
                    String novoNome = sc.nextLine();
                    System.out.print("Novo email: ");
                    String novoEmail = sc.nextLine();
                    System.out.print("Novo setor: ");
                    String novoSetor = sc.nextLine();
                    controller.update(idUpdate, novoNome, novoEmail, novoSetor);
                    System.out.println("Secretaria atualizada com sucesso!");
                    break;
                case 4:
                    System.out.print("ID da secretaria para deletar: ");
                    int idDel = sc.nextInt();
                    sc.nextLine();
                    if(controller.delete(idDel)) {
                        System.out.println("Secretaria deletada com sucesso!");
                    } else {
                        System.out.println("Não foi possível deletar. ID não encontrado.");
                    }
                    break;
                case 5:
                    System.out.print("ID da secretaria para buscar: ");
                    int idBusca = sc.nextInt();
                    sc.nextLine();
                    Secretaria s = controller.find(idBusca);
                    if (s != null) {
                        System.out.println(s.getId() + " | " + s.getNome() + " | " + s.getEmail() + " | " + s.getSetor());
                    } else {
                        System.out.println("Secretaria não encontrada.");
                    }
                    break;
                case 0:
                    System.out.println("Saindo...");
                    Persistencia.closeConnection();
                    break;
                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 0);

        sc.close();
    }


}
