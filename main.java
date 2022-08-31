import java.util.Scanner;
import java.util.ArrayList;

public class main{
  
    public static User find_user(int ID, ArrayList<User> users){
      for (User user : users) {
        if (user.ID == ID)
          return user;
      }
  
      return null;
    }
  
  public static void main(String args[]){
      ArrayList<User> users = new ArrayList<User>();
      ArrayList<Project> projects = new ArrayList<Project>();
      ArrayList<Activity> activities = new ArrayList<Activity>();

      int option;
      Scanner scan = new Scanner(System.in);
      Boolean status = true;
      while (status){
        System.out.println("Qual entidade deseja modificar: \n 1 - Projeto\n 2 - Atividade \n 3 - Usuário \n 4 - Sair do menu");
        option = scan.nextInt();
        scan.nextLine();

        switch(option){
          case 1:
            System.out.println("Escolha uma opção:\n 1- Criar Projeto\n 2- Editar Projeto\n 3- Remover Projeto");
            option = scan.nextInt();
            scan.nextLine();
            if (option==1){
              System.out.println("Informe a identificação do projeto: ");
              int ID = scan.nextInt();
              scan.nextLine();
              System.out.println("Informe a descrição do projeto:");
              String description = scan.nextLine();
              System.out.println("Informe a data de início do projeto:");
              String datetime_begin = scan.nextLine();
              System.out.println("Informe a data de término do projeto:");
              String datetime_end = scan.nextLine();
              System.out.println("Informe o ID do coordenador:");
              int user_id = scan.nextInt();
              User cordinator = find_user(user_id, users);
              scan.nextLine();
              System.out.println("Informe o valor da bolsa:");
              Double scholarship_value = scan.nextDouble();
              System.out.println("Informe o período da bolsa:");
              String scholarship_period = scan.nextLine();

              Project project = new Project(ID, description, datetime_begin, datetime_end, cordinator, users, activities, scholarship_value, scholarship_period);
              projects.add(project);
            }

            break;
          case 2:
            System.out.println("Você escolheu a opção 2");
            System.out.println("Escolha uma opção:\n 1- Criar Atividade\n 2- Editar Atividade\n 3- Remover Atividade");
            option = scan.nextInt();
            scan.nextLine();
            if (option==1){
              System.out.println("Informe a identificação da atividade: ");
              int ID = scan.nextInt();
              scan.nextLine();
              System.out.println("Informe a descrição da atividade:");
              String description = scan.nextLine();
              System.out.println("Informe a data de início da atividade:");
              String datetime_begin = scan.nextLine();
              System.out.println("Informe a data de término da atividade:");
              String datetime_end = scan.nextLine();
              System.out.println("Informe o ID do usuário responsável:");
              int user_id = scan.nextInt();
              scan.nextLine();
              User manager = find_user(user_id, users);
              System.out.println("Informe as tarefas a serem realizadas:");
              String tarefas = scan.nextLine();
              String[] tasks = tarefas.split("-");
              Activity activity = new Activity(
                ID,
                description,
                datetime_begin,
                datetime_end,
                manager,
                users,
                tasks);

              activities.add(activity);
              System.out.println(activities);
            }
            break;
          case 3:
            System.out.println("Escolha uma opção:\n 1- Criar Usuário\n 2- Editar Usuário\n 3- Remover Usuário");
            option = scan.nextInt();
            scan.nextLine();
            if (option==1){
              System.out.println("Informe a identificação do usuário: ");
              int ID = scan.nextInt();
              scan.nextLine();
              System.out.println("Informe o nome do usuário: ");
              String name = scan.nextLine();
              System.out.println("Informe o tipo do usuário:");
              String type = scan.nextLine();
              User user = new User(ID, name, type);
              users.add(user);
            }
            else if(option==2){
              

            }
            break;
          case 4:
            System.out.println("Você saiu do menu!");
            System.out.println("Projetos criados:");
            for (Project project : projects) {
              System.out.println("ID:" + project.ID + "\n Descrição: " + project.description + "\n Status: " + project.status);
              
            }
            System.out.println("Usuários criados:");
            for (User user : users) {
              System.out.println("ID:" + user.ID + "\n Nome: " + user.name + "\n Tipo: " + user.type);
              
            }

            System.out.println("Atividades criadas:");
            for (Activity activity: activities) {
              System.out.println("ID:" + activity.ID + "\n Descrição: " + activity.description + "\n Usuário manager: " + activity.manager.name);
              
            }
            status = false;
        }
      }
    }
}

