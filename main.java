import java.util.*;
import java.time.LocalDateTime;

public class main{
    public static User find_user(int ID, ArrayList<User> users){
      for (User user : users) {
        if (user.ID ==  ID)
          return user;
      }
      
      return null;
    }

    public static User find_user_by_username(String username, ArrayList<User> users){
      for (User user : users) {
        if (user.username ==  username)
          return user;
      }
      
      return null;
    }

    public static void remove_user(int ID, ArrayList<User> users){
      for (User user : users) {
        if (user.ID == ID)
          users.set(ID, null);
      }
    }

    public static Activity find_activity(int ID, ArrayList<Activity> activities){
      for (Activity activity : activities) {
        if (activity.ID == ID)
          return activity;
      }
      
      return null;
    }

    public static void remove_activity(int ID, ArrayList<Activity> activities){
      for (Activity activity : activities) {
        if (activity.ID == ID)
          activities.set(ID, null);
      }
    }

    public static Project find_project(int ID, ArrayList<Project> projects){
      for (Project project : projects) {
        if (project.ID == ID)
          return project;
      }
      
      return null;
    }

    public static void remove_project(int ID, ArrayList<Project> projects){
      for (Project project : projects) {
        if (project.ID == ID)
          projects.set(ID, null);
      }
    }

    public static void view_project(Project project){
      System.out.println("----------------------");
      System.out.println("ID: " + project.ID + "\nDescrição: " + project.description + "\nData de início: " + project.datetime_begin );
      System.out.println("Data de término: " + project.datetime_end + "\nStatus: " + project.status + "\nCoordenador: " + project.cordinator.name );
      System.out.println("Duração da bolsa: " + project.scholarship_period);
      System.out.println("Usuários associados ao projeto:\n");
      for (User user : project.users) {
        view_user(user);
      }

      for (Activity activity : project.activities) {
        System.out.println("Atividades do projeto:\n");
        view_activity(activity);
      }
    }

    public static void list_projects(ArrayList<Project> projects){
      for (Project project : projects){
        if(project != null){
          view_project(project);
        }
      }
    }

    public static void list_users(ArrayList<User> users, String type){
      for (User user : users){
        if (user != null){
          if(user.type.equals(type) || type.equals("ALL")){
            view_user(user);
          }
        }
      }
    }

    public static void list_activities(ArrayList<Activity> activities){
      for (Activity activity : activities){
        if(activity != null){
          view_activity(activity);
        }
      }
    }

    public static void view_activity(Activity activity){
      System.out.println("----------------------");
      System.out.println("ID: " + activity.ID + "\nDescrição: " + activity.description + "\nData de início: " 
                          + activity.datetime_begin + "\nData de término: " + activity.datetime_end + "\nResponsável: " + activity.manager.name );
      System.out.println("Tarefas da atividade:");
      for (var entry : activity.tasks.entrySet()) {
        System.out.println(entry.getKey() + " - Responsável pela tarefa: " + entry.getValue().name);
      }
    }

    public static void view_user(User user){
      System.out.println("----------------------");
      System.out.println("ID: " + user.ID + "\nNome: " + user.name + "\nTipo: "+ user.type);
    }

    public static Boolean login(String username, int password, ArrayList<User> users){
      for (User user : users) {
        if(user.username.equals(username) && user.password == password){
          return true;
        }
        
      }
      return false;
    }
  
  public static void main(String args[]){
      ArrayList<User> users = new ArrayList<User>();
      ArrayList<Project> projects = new ArrayList<Project>();
      ArrayList<Activity> activities = new ArrayList<Activity>();

      int option;
      Scanner scan = new Scanner(System.in);

      int option_menu = 0;
      Boolean status = false;
      String current_user = "";
      String current_type = "";

      while(option_menu!=4){
        System.out.println("Bem vindo ao sistema de gerenciamento de projetos!");
        System.out.println("\n1 - Login\n2 - Cadastrar\n3 - Esqueci minha senha\n4 - Sair do sistema");
        System.out.print("Escolha uma opção: ");
        int op_menu = scan.nextInt();
        scan.nextLine();
        switch(op_menu){
          case 1:
            System.out.print("Digite seu usuário: ");
            String username = scan.nextLine();
            System.out.print("Digite sua senha: ");
            int password = scan.nextInt();
            scan.nextLine();
            Boolean result = login(username, password, users);
            if (result == false){
              System.out.print("Usuário ou senha incorreto!\n");
            }
            else{
              current_user = username;
              option_menu = 4;
              status = true;
            }
            break;
          case 2:
            System.out.print("Digite o nome: ");
            String new_name = scan.nextLine();
            System.out.print("Digite o tipo de usuário: ");
            String new_type = scan.nextLine();
            System.out.print("Digite o usuário: ");
            String new_username = scan.nextLine();
            System.out.print("Digite a senha: ");
            int new_password = scan.nextInt();
            scan.nextLine();
            User user = new User(new_name, new_type.toUpperCase());
            user.setUsername(new_username);
            user.setPassword(new_password);
            users.add(user);
            int ID = users.indexOf(user);
            user.setID(ID);
            System.out.println("Usuário criado com sucesso!");
            current_user = new_username;
            status = true;
            break;
          case 3:
            System.out.print("Digite seu usuario: ");
            String username_find = scan.nextLine();
            for (User find_user : users) {
              if(find_user.username.equals(username_find)){
                System.out.print("Digite sua nova senha: ");
                int password_recovery = scan.nextInt();
                User user_recovery = find_user(find_user.ID, users);
                user_recovery.setPassword(password_recovery);
                System.out.print("Senha recuperada com sucesso!\n");
                break;
              }
              System.out.print("Usuário não encontrado!\n");
            }
        }
      }
      

      while (status){ 
        User obj_user = find_user_by_username(current_user, users);
        System.out.println("Bem vindo " + current_user);
        System.out.println("Qual entidade deseja modificar: \n 1- Projeto\n 2- Atividade \n 3- Usuário \n 4- Relatório\n 5- Pagamento de Bolsa\n 6- Sair do menu");
        option = scan.nextInt();
        scan.nextLine();

        switch(option){
          case 1:
            System.out.println("Escolha uma opção:\n 1- Criar Projeto\n 2- Editar Projeto\n 3- Remover Projeto\n 4- Listar Projetos");
            option = scan.nextInt();
            scan.nextLine();
            if (option==1){
              System.out.print("Informe a descrição do projeto: ");
              String description = scan.nextLine();
              System.out.print("Informe a data de início do projeto (YYYY-MM-DD): ");
              String date_begin_input = scan.nextLine();
              System.out.print("Informe a hora de início do projeto (HH:MM): ");
              String time_begin_input = scan.nextLine();
              String datetime_begin_input = date_begin_input + "T" + time_begin_input + ":00";
              LocalDateTime datetime_begin = LocalDateTime.parse(datetime_begin_input);
              System.out.print("Informe a data de término do projeto (YYYY-MM-DD): ");
              String date_end_input = scan.nextLine();
              System.out.print("Informe a hora de término do projeto (HH:MM): ");
              String time_end_input = scan.nextLine();
              String datetime_end_input = date_begin_input + "T" + time_begin_input + ":00";
              LocalDateTime datetime_end = LocalDateTime.parse(datetime_end_input);
              list_users(users, "COORDENADOR");
              System.out.print("Informe o ID do coordenador do projeto: ");
              int id_cordinator = scan.nextInt();
              scan.nextLine();
              User cordinator = find_user(id_cordinator, users);
              System.out.print("Informe o período da bolsa (quantidade de meses): ");
              int scholarship_period = scan.nextInt();
              scan.nextLine();
              Project project = new Project(description, datetime_begin, datetime_end, cordinator, scholarship_period);

              list_users(users, "ALUNO");
              System.out.print("Quantos usuários vão participar desse projeto? ");
              int size = scan.nextInt();
              scan.nextLine();
              for (int i = 0; i < size; i++){
                System.out.print("Informe o ID do usuário: ");
                int user_id = scan.nextInt();
                scan.nextLine();
                User user = find_user(user_id, users);
                project.addUser(user);
              }

              list_activities(activities);
              System.out.print("Quantas atividades vão participar desse projeto? ");
              int size_activity = scan.nextInt();
              scan.nextLine();
              for (int i = 0; i < size_activity; i++){
                System.out.print("Informe o ID da atividade: ");
                int activity_id = scan.nextInt();
                scan.nextLine();
                Activity activity = find_activity(activity_id, activities);
                project.addActivity(activity);
              }

              for (User user : project.users) {
                System.out.print("Qual valor da bolsa do usuário " + user.name + "? ");
                Double value = scan.nextDouble();
                scan.nextLine();
                project.addScholarship(value, user);
              }
              project.setStatus("Em processo de criação");
              projects.add(project);
              int ID = projects.indexOf(project);
              project.setID(ID);
              System.out.println("Projeto criado com sucesso!");
            }
            else if(option==2){
              list_projects(projects);
              System.out.print("Informe o ID do projeto que deseja editar: ");
              int ID = scan.nextInt();
              scan.nextLine();
              Project project = find_project(ID, projects);
              System.out.println("Escolha uma opção:\n 1- Editar descrição\n 2- Editar data de início\n 3 - Editar data de término\n 4 - Editar coordenador\n 5 - Editar status\n 6 - Editar período da bolsa\n 7 - Editar usuários associados a atividade\n 8 - Editar valor da bolsa\n 9 - Editar atividades");
              int option_edit = scan.nextInt();
              scan.nextLine();
              if (option_edit==1){
                System.out.print("Digite a nova descrição: ");
                String new_description = scan.nextLine();
                project.setDescription(new_description);
                System.out.println("Descrição atualizado com sucesso!");
              }
              else if (option_edit==2){
                System.out.print("Informe a nova data de início do projeto (YYYY-MM-DD): ");
                String date_begin_input = scan.nextLine();
                System.out.print("Informe a nova hora de início do projeto (HH:MM): ");
                String time_begin_input = scan.nextLine();
                String datetime_begin_input = date_begin_input + "T" + time_begin_input + ":00";
                LocalDateTime datetime_begin = LocalDateTime.parse(datetime_begin_input);
                project.setDatetimeBegin(datetime_begin);
                System.out.println("Data de início atualizada com sucesso!");
              }  
              else if (option_edit==3){
                System.out.print("Informe a nova data de término do projeto (YYYY-MM-DD): ");
                String date_end_input = scan.nextLine();
                System.out.print("Informe a nova hora de término do projeto (HH:MM): ");
                String time_end_input = scan.nextLine();
                String datetime_end_input = date_end_input + "T" + time_end_input + ":00";
                LocalDateTime datetime_end = LocalDateTime.parse(datetime_end_input);
                project.setDatetimeEnd(datetime_end);
                System.out.println("Data de término atualizada com sucesso!");
              }  
              else if (option_edit==4){
                list_users(users, "COORDENADOR");
                System.out.print("Digite o ID do novo coordenador: ");
                int user_id = scan.nextInt();
                User user = find_user(user_id, users);
                project.setCordinator(user);
                System.out.println("Coordenador atualizado com sucesso!");
              }
              else if (option_edit==5){
                
                String new_status = scan.nextLine();
                if (obj_user.type=="COORDENADOR"){
                  System.out.print("Digite o novo status do projeto: ");
                  project.setStatus(new_status);
                  System.out.println("Status do projeto atualizado com sucesso!");
                }
                else{
                  System.out.println("Apenas coordenador pode atualizar o status do projeto!");
                }
              }
              else if (option_edit==6){
                System.out.print("Digite o novo período da bolsa (quantidade em meses): ");
                int new_period = scan.nextInt();
                scan.nextLine();
                project.setScholarshipPeriod(new_period);
                System.out.println("Período da bolsa atualizado com sucesso!");
              }
              else if (option_edit==7){
                project.edit_users(users);
              }
              else if (option_edit==8){
                list_users(users, "ALUNO");
                System.out.print("Digite o ID do usuário: ");
                int user_id = scan.nextInt();
                User user = find_user(user_id, users);
                System.out.println("Digite o novo valor da bolsa: ");
                Double new_value = scan.nextDouble();
                project.setScholarshipValue(new_value, user);
                
              }
              else if (option_edit==9){
                project.edit_activities(activities);
              }
            }
            else if(option==3){
              System.out.print("Informe o ID do projeto que deseja remover: ");
              int id = scan.nextInt();
              scan.nextLine();
              remove_project(id, projects);
              System.out.println("Projeto removido com sucesso!");
            }
            else if(option==4){
              list_projects(projects);
            }

            break;
          case 2:
            System.out.println("Escolha uma opção:\n 1- Criar Atividade\n 2- Editar Atividade\n 3- Remover Atividade\n 4- Listar Atividades");
            option = scan.nextInt();
            scan.nextLine();
            if (option==1){
              System.out.print("Informe a descrição da atividade: ");
              String description = scan.nextLine();
              System.out.print("Informe a data de início do projeto (YYYY-MM-DD): ");
              String date_begin_input = scan.nextLine();
              System.out.print("Informe a hora de início do projeto (HH:MM): ");
              String time_begin_input = scan.nextLine();
              String datetime_begin_input = date_begin_input + "T" + time_begin_input + ":00";
              LocalDateTime datetime_begin = LocalDateTime.parse(datetime_begin_input);
              System.out.print("Informe a data de término do projeto (YYYY-MM-DD): ");
              String date_end_input = scan.nextLine();
              System.out.print("Informe a hora de término do projeto (HH:MM): ");
              String time_end_input = scan.nextLine();
              String datetime_end_input = date_begin_input + "T" + time_begin_input + ":00";
              LocalDateTime datetime_end = LocalDateTime.parse(datetime_end_input);
              list_users(users, "PROFESSOR");
              System.out.print("Informe o ID do usuário responsável pela atividade: ");
              int user_id = scan.nextInt();
              scan.nextLine();
              User manager = find_user(user_id, users);
              Activity activity = new Activity(
                description,
                datetime_begin,
                datetime_end,
                manager);

              list_users(users, "ALUNO");
              System.out.print("Quantos usuários vão participar dessa atividade? ");
              int size = scan.nextInt();
              scan.nextLine();
              for (int i = 0; i < size; i++){
                System.out.print("Informe o ID do usuário: ");
                int id = scan.nextInt();
                scan.nextLine();
                User user = find_user(id, users);
                activity.addUser(user);
              }

              ArrayList<User> users_activity = activity.users;

              for (User user : users_activity) {
                System.out.print("Qual tarefa " + user.name + " vai realizar? ");
                String task = scan.nextLine();
                activity.addTask(task, user);
              }

              activities.add(activity);
              int ID = activities.indexOf(activity);
              activity.setID(ID);
              System.out.println("Atividade criada com sucesso!");
            }
            else if(option==2){
              list_activities(activities);
              System.out.print("Informe o ID da atividade na qual deseja editar as informações: ");
              int id = scan.nextInt();
              scan.nextLine();
              Activity activity = find_activity(id, activities);
              System.out.println("Escolha uma opção:\n 1- Editar descrição\n 2- Editar data de início\n 3 - Editar data de término\n 4 - Editar responsável\n 5 - Editar usuários");
              int option_edit = scan.nextInt();
              scan.nextLine();
              if (option_edit==1){
                System.out.print("Digite a nova descrição: ");
                String new_description = scan.nextLine();
                activity.setDescription(new_description);
                System.out.println("Descrição atualizado com sucesso!");
              }
              else if (option_edit==2){
                System.out.print("Informe a nova data de início do projeto (YYYY-MM-DD): ");
                String date_begin_input = scan.nextLine();
                System.out.print("Informe a nova hora de início do projeto (HH:MM): ");
                String time_begin_input = scan.nextLine();
                String datetime_begin_input = date_begin_input + "T" + time_begin_input + ":00";
                LocalDateTime datetime_begin = LocalDateTime.parse(datetime_begin_input);
                activity.setDatetimeBegin(datetime_begin);
                System.out.println("Data de início atualizada com sucesso!");
              }  
              else if (option_edit==3){
                System.out.print("Informe a nova data de término do projeto (YYYY-MM-DD): ");
                String date_end_input = scan.nextLine();
                System.out.print("Informe a nova hora de término do projeto (HH:MM): ");
                String time_end_input = scan.nextLine();
                String datetime_end_input = date_end_input + "T" + time_end_input + ":00";
                LocalDateTime datetime_end = LocalDateTime.parse(datetime_end_input);
                activity.setDatetimeEnd(datetime_end);
                System.out.println("Data de término atualizada com sucesso!");
              }  
              else if (option_edit==4){
                list_users(users, "PROFESSOR");
                System.out.print("Digite o ID do novo responsável: ");
                int user_id = scan.nextInt();
                scan.nextLine();
                User user = find_user(user_id, users);
                activity.setManager(user);
                System.out.println("Responsável atualizado com sucesso!");
              }
              else if(option_edit==5){
                activity.edit_users(users);
              }
            }
            else if(option==3){
              System.out.print("Informe o ID da ativitidade que deseja remover: ");
              int id = scan.nextInt();
              remove_activity(id, activities);
              System.out.println("Atividade removida com sucesso!");
            }
            else if (option==4){
              list_activities(activities);
            }
            break;
          case 3:
            System.out.println("Escolha uma opção:\n 1- Criar Usuário\n 2- Editar Usuário\n 3- Remover Usuário\n 4- Listar Usuários");
            option = scan.nextInt();
            scan.nextLine();

            if (option==1){
              System.out.print("Informe o nome do usuário: ");
              String name = scan.nextLine();
              System.out.print("Informe o tipo do usuário: ");
              String type = scan.nextLine();
              User user = new User(name, type.toUpperCase());
              users.add(user);
              int ID = users.indexOf(user);
              user.setID(ID);
              System.out.println("Usuário criado com sucesso!");
            
            }
            else if(option==2){
              list_users(users, "ALL");
              System.out.print("Informe o ID do usuário o qual deseja editar as informações: ");
              int id = scan.nextInt();
              scan.nextLine();
              User user = find_user(id, users);
              System.out.println("Escolha uma opção:\n 1- Editar nome\n 2- Editar tipo");
              int option_edit = scan.nextInt();
              scan.nextLine();
              if (option_edit==1){
                System.out.print("Digite o novo nome: ");
                String new_name = scan.nextLine();
                user.setName(new_name);
                System.out.println("Nome atualizado com sucesso!");
              }
              else if (option_edit==2){
                System.out.print("Digite o novo tipo: ");
                String new_type = scan.nextLine();
                user.setType(new_type);
                System.out.println("Tipo atualizado com sucesso!");
              }  
            }
            else if(option==3){
              list_users(users, "ALL");
              System.out.print("Informe o ID do usuário que deseja remover: ");
              int user_id = scan.nextInt();
              scan.nextLine();
              remove_user(user_id, users);
              System.out.println("Usuário removido com sucesso!");
            }
            else if(option==4){
              list_users(users, "ALL");
            }
            break;
          case 4:
            System.out.println("Todos os projetos cadastrados da unidade Acadêmica:");
            for (Project project : projects) {
              view_project(project);
            }
            break;
          case 5:
            System.out.println("Controle de pagamento de bolsa:");

            for (Project project : projects) {
              System.out.println("------------------------");
              System.out.println("Projeto sobre " + project.description);
              for (var entry : project.scholarship_values.entrySet()) {
                System.out.println("Aluno: " + entry.getValue().name + " - Bolsa: " + entry.getKey());
              }
            }
            break;
          case 6:
            System.out.println("Você saiu do menu!");
            status = false;
          }
      }
    }
}
