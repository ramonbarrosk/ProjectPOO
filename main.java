import java.util.*;
import java.time.LocalDateTime;

public class main{
  
    public static User find_user(String name, ArrayList<User> users){
      for (User user : users) {
        if (user.name == name)
          return user;
      }
      
      return null;
    }

    public static Activity find_activity(String description, ArrayList<Activity> activities){
      for (Activity activity : activities) {
        if (activity.description == description)
          return activity;
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
              System.out.print("Informe a identificação do projeto: ");
              int ID = scan.nextInt();
              scan.nextLine();
              System.out.print("Informe a descrição do projeto: ");
              String description = scan.nextLine();
              System.out.print("Informe a data de início do projeto: ");
              String datetime_begin_input = scan.nextLine();
              LocalDateTime datetime_begin = LocalDateTime.parse(datetime_begin_input);
              System.out.print("Informe a data de término do projeto: ");
              String datetime_end_input = scan.nextLine();
              LocalDateTime datetime_end = LocalDateTime.parse(datetime_end_input);
              System.out.print("Informe o nome do coordenador do projeto: ");
              String name = scan.nextLine();
              User cordinator = find_user(name, users);
              System.out.println("Informe o período da bolsa:");
              String scholarship_period = scan.nextLine();
              Project project = new Project(ID, description, datetime_begin, datetime_end, cordinator, scholarship_period);

              System.out.print("Quantos usuários vão participar desse projeto? ");
              int size = scan.nextInt();
              scan.nextLine();
              for (int i = 0; i < size; i++){
                System.out.print("Informe o nome do usuário: ");
                String user_activity = scan.nextLine();
                User user = find_user(user_activity, users);
                project.addUser(user);
              }

              System.out.print("Quantos atividades vão participar desse projeto? ");
              int size_activity = scan.nextInt();
              scan.nextLine();
              for (int i = 0; i < size_activity; i++){
                System.out.print("Informe a descrição da atividade: ");
                String description_activity = scan.nextLine();
                Activity activity = find_activity(description_activity, activities);
                project.addActivity(activity);
              }

              for (User user : project.users) {
                System.out.print("Qual valor da bolsa do usuário" + user.name + "? ");
                Double value = scan.nextDouble();
                scan.nextLine();
                project.addScholarship(value, user);
              }

              projects.add(project);
              System.out.println("Projeto criado com sucesso!");
            }

            break;
          case 2:
            System.out.println("Escolha uma opção:\n 1- Criar Atividade\n 2- Editar Atividade\n 3- Remover Atividade");
            option = scan.nextInt();
            scan.nextLine();
            if (option==1){
              System.out.print("Informe a identificação da atividade: ");
              int ID = scan.nextInt();
              scan.nextLine();
              System.out.print("Informe a descrição da atividade: ");
              String description = scan.nextLine();
              System.out.print("Informe a data de início da atividade: ");
              String datetime_begin_input = scan.nextLine();
              LocalDateTime datetime_begin = LocalDateTime.parse(datetime_begin_input);
              System.out.print("Informe a data de término da atividade: ");
              String datetime_end_input = scan.nextLine();
              LocalDateTime datetime_end = LocalDateTime.parse(datetime_end_input);
              System.out.print("Informe o nome do usuário responsável pela atividade: ");
              String name = scan.nextLine();
              User manager = find_user(name, users);
              Activity activity = new Activity(
                ID,
                description,
                datetime_begin,
                datetime_end,
                manager);

              System.out.print("Quantos usuários vão participar dessa atividade? ");
              int size = scan.nextInt();
              scan.nextLine();
              for (int i = 0; i < size; i++){
                System.out.print("Informe o nome do usuário: ");
                String user_activity = scan.nextLine();
                User user = find_user(user_activity, users);
                activity.addUser(user);
              }

              ArrayList<User> users_activity = activity.users;

              for (User user : users_activity) {
                System.out.print("Qual tarefa " + user.name + " vai realizar?");
                String task = scan.nextLine();
                activity.addTask(task, user);
              }

              activities.add(activity);
              System.out.println("Atividade criada com sucesso!");
            }
            break;
          case 3:
            System.out.println("Escolha uma opção:\n 1- Criar Usuário\n 2- Editar Usuário\n 3- Remover Usuário");
            option = scan.nextInt();
            scan.nextLine();

            if (option==1){
              System.out.print("Informe a identificação do usuário: ");
              int ID = scan.nextInt();
              scan.nextLine();
              System.out.print("Informe o nome do usuário: ");
              String name = scan.nextLine();
              System.out.print("Informe o tipo do usuário: ");
              String type = scan.nextLine();
              User user = new User(ID, name, type);
              users.add(user);
              System.out.println("Usuário criado com sucesso!");
            
            }
            else if(option==2){
              
            }

            break;
          case 4:
            System.out.println("Você saiu do menu!");
            status = false;
        }
      }
    }
}

