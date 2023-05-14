import builders.StudentsBuilder;
import entities.Student;

import java.util.*;

public class Main {

  public static void main(String[] args) {
    var allStudents = StudentsBuilder.getAllStudents();
    var option = 0;
    var med = 0.0;
    var note = 0.0;
    var count = 0;
    var input = new Scanner(System.in);

    // Agora vamos às atividades
        /*

        1. Recupere da lista os alunos que passaram de ano (nota minima 7.0).
            - Exiba os dados nesse formato: <código> - <nome> : Média = <nota>
        2. Recupere da lista os alunos que não passaram de ano.
            - Exiba os dados nesse formato: <código> - <nome> : Média = <media> (Faltou = <nota_faltante>)
        3. Traga os alunos que tiraram a nota máxima (nota 10).
            - Exiba os dados nesse formato: <código> - <nome>
        4. Traga o aluno que tirou a menor nota, em caso de notas iguais, traga ambos os alunos.
            - Exiba os dados nesse formato: <código> - <nome> : Nota = <nota>
        5. Faça uma lista com top 3 notas de alunos.
            - Exiba os dados nesse formato: <posição> - <nome> : Nota = <nota>
        6. Faça uma lista com as 3 menores notas de alunos.
            - Exiba os dados nesse formato: <posição> - <nome> : Nota = <nota>
        7. Monte a média de todos os alunos e exiba em tela ordenando da maior para a menor nota.
            - Exiba os dados nesse formato: <posição> - <código> - <nome> : Média = <nota>

         */
    do {
      System.out.print("""
           ------------------------------------
           |     Sistema de Notas Escolares   |
           ------------------------------------
           | Escolha um opção abaixo          |
           |                                  |
           | 1 - Alunos que passaram de ano   |
           | 2 - Alunos que reprovaram de ano |
           | 3 - Alunos com nota máxima       |
           | 4 - Alunos com nota mínima       |
           | 5 - Top 3 melhores alunos        |
           | 6 - Top 3 piores alunos          |
           | 7 - Listar todos os alunos       |
           | 0 - Sair                         |
           |                                  |
           ------------------------------------           \s
          """);
      count = 0;
      System.out.print("Selecione uma opção: ");
      option = input.nextInt();

      switch (option) {
        case 1 -> {
          System.out.println();
          System.out.println("""
              ------------------------------------
              | 1 - Alunos que passaram de ano   |
              ------------------------------------
              """);
          for (Student allStudent : allStudents) {
            med = (
                allStudent.getTestOne() +
                    allStudent.getTestTwo() +
                    allStudent.getTestThree()
            ) / 3;
            if (med >= 7.0) {
              count++;
              System.out.printf("%dº %s - %s : Média = %.2f\n", count, allStudent.getCode(), allStudent.getName(), med);
            }
          }
          System.out.println();
          input.nextLine();
          System.out.print("Pressione enter para continuar");
          input.nextLine();
        }
        case 2 -> {
          System.out.println("""
              ------------------------------------
              | 2 - Alunos que reprovaram de ano |
              ------------------------------------
              """);
          for (Student allStudent : allStudents) {
            med = (
                allStudent.getTestOne() +
                    allStudent.getTestTwo() +
                    allStudent.getTestThree()
            ) / 3;
            if (med < 7.0) {
              note = 7.0 - med;
              count++;
              System.out.printf("%dº %s - %s : Média = %.2f (Faltou = %.2f)\n", count, allStudent.getCode(),
                  allStudent.getName(), med, note);
            }
          }
          System.out.println();
          input.nextLine();
          System.out.print("Pressione enter para continuar");
          input.nextLine();
        }
        case 3 -> {
          System.out.println("""
              ------------------------------------
              | 3 - Alunos com nota máxima       |
              ------------------------------------
              """);
          for (Student allStudent : allStudents) {
            if (allStudent.getTestOne() == 10 ||
                allStudent.getTestTwo() == 10 ||
                allStudent.getTestThree() == 10) {
              count++;
              System.out.printf("%dº %s - %s \n", count, allStudent.getCode(), allStudent.getName());
            }
          }
          System.out.println();
          input.nextLine();
          System.out.print("Pressione enter para continuar");
          input.nextLine();
        }
        case 4 -> {
          System.out.println("""
              ------------------------------------
              | 4 - Alunos com nota mínima       |
              ------------------------------------
              """);
          note = 10.0;
          for (Student student : allStudents) {
            double note1 = student.getTestOne();
            double note2 = student.getTestTwo();
            double note3 = student.getTestThree();
            double min = Math.min(Math.min(note1, note2), note3);
            if (min < note) {
              note = min;
            }
          }
          for (Student student : allStudents) {
            double note1 = student.getTestOne();
            double note2 = student.getTestTwo();
            double note3 = student.getTestThree();
            double min = Math.min(Math.min(note1, note2), note3);
            if (min == note) {
              count++;
              System.out.printf("%dº %s - %s\n", count, student.getCode(), student.getName());
            }
          }
          System.out.println();
          input.nextLine();
          System.out.print("Pressione enter para continuar");
          input.nextLine();
        }
        case 5 -> {
          System.out.println("""
              ------------------------------------
              | 5 - Top 3 melhores alunos        |
              ------------------------------------
              """);
          List<Double> medListTop3 = new ArrayList<>();

          for (Student allStudent : allStudents) {
            double media = (allStudent.getTestOne() +
                allStudent.getTestTwo() +
                allStudent.getTestThree()) / 3.0;
            medListTop3.add(media);
          }

          medListTop3.sort(Collections.reverseOrder());

          System.out.println("Os três melhores alunos são:");

          for (int i = 0; i < 3 && i < medListTop3.size(); i++) {
            med = medListTop3.get(i);

            for (Student allStudent : allStudents) {
              if ((allStudent.getTestOne() +
                  allStudent.getTestTwo() +
                  allStudent.getTestThree()) / 3.0 == med) {

                count++;
                System.out.printf("%dº - %s : Média = %.2f)\n", count, allStudent.getName(), med);
                break;
              }
            }
          }
          System.out.println();
          input.nextLine();
          System.out.print("Pressione enter para continuar");
          input.nextLine();
        }
        case 6 -> {
          System.out.println("""
              ------------------------------------
              | 6 - Top 3 piores alunos          |
              ------------------------------------
              """);
          List<Double> medListDown3 = new ArrayList<>();

          for (Student allStudent : allStudents) {
            med = (allStudent.getTestOne() +
                allStudent.getTestTwo() +
                allStudent.getTestThree()) / 3.0;
            medListDown3.add(med);
          }

          Collections.sort(medListDown3);

          System.out.println("Os três piores alunos são:");

          for (int i = 0; i < 3 && i < medListDown3.size(); i++) {
             med = medListDown3.get(i);

            for (Student allStudent : allStudents) {
              if ((allStudent.getTestOne() +
                  allStudent.getTestTwo() +
                  allStudent.getTestThree()) / 3.0 == med) {

                count++;
                System.out.printf("%dº - %s : Média = %.2f)\n", count, allStudent.getName(), med);
                break;
              }
            }
          }
          System.out.println();
          input.nextLine();
          System.out.print("Pressione enter para continuar");
          input.nextLine();
        }
        case 7 -> {
          System.out.println("""
              ------------------------------------
              | 7 - Lista de todos os alunos     |
              ------------------------------------
              """);
          List<Double> medList = new ArrayList<>();

          for (Student allStudent : allStudents) {
            double media = (allStudent.getTestOne() +
                allStudent.getTestTwo() +
                allStudent.getTestThree()) / 3.0;
            medList.add(media);
          }

          medList.sort(Collections.reverseOrder());

          System.out.println("Os três melhores alunos são:");

          for (Double aDouble : medList) {
            med = aDouble;

            for (Student allStudent : allStudents) {
              if ((allStudent.getTestOne() +
                  allStudent.getTestTwo() +
                  allStudent.getTestThree()) / 3.0 == med) {

                count++;
                System.out.printf("%dº %s - %s : Média = %.2f \n", count,
                    allStudent.getName(),
                    allStudent.getName(),
                    med);
                break;
              }
            }
          }
          System.out.println();
          input.nextLine();
          System.out.print("Pressione enter para continuar");
          input.nextLine();
        }
        default -> {
          System.out.println();
          System.out.println("Opção inválida");
          input.nextLine();
          System.out.print("Pressione enter para continuar");
          input.nextLine();
        }
      }

    } while (option != 0);

    System.out.println("Sistema de notas finalizado.");
  }
}