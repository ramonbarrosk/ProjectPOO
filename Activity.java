import java.util.*;
import java.time.LocalDateTime;

public class Activity {
  int ID;
  String description;
  LocalDateTime datetime_begin;
  LocalDateTime datetime_end;
  User manager;
  ArrayList<User> users;
  Map<String, User> tasks;

  public Activity(String description, LocalDateTime datetime_begin, LocalDateTime datetime_end, User manager){
    this.description = description;
    this.datetime_begin = datetime_begin;
    this.datetime_end = datetime_end;
    this.manager = manager;
    this.users = new ArrayList<User>();
    this.tasks = new HashMap<String, User>();
    }
  
  public void setID(int ID){
    this.ID = ID;
  }

  public void addUser(User user){
    this.users.add(user);
  }

  public void addTask(String task, User user){
    this.tasks.put(task, user);
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public void setDatetimeBegin(LocalDateTime date_time_begin) {
    this.datetime_begin = date_time_begin;
  }

  public void setDatetimeEnd(LocalDateTime date_time_end) {
    this.datetime_end = date_time_end;
  }

  public void setManager(User manager) {
    this.manager = manager;
  }

  public void edit_tasks(ArrayList<User> users){
    
  }

  public void edit_users(ArrayList<User> users) {
    Scanner scan = new Scanner(System.in);
    for (User user : this.users){
      System.out.println("----------------------");
      System.out.println("ID: " + user.ID + "\nNome: " + user.name + "\nTipo: "+ user.type);
    }
    System.out.println("Digite 1 para remover ou 2 para substituir: ");
    int op = scan.nextInt();
    scan.nextLine();
    System.out.println("Digite o ID do usuário: ");
    int user_id = scan.nextInt();
    scan.nextLine();
    if (op==1){
      this.users.remove(user_id);
      System.out.println("Usuário removido do projeto com sucesso!");
    }
    else if(op==2){
      for (User user : users){
        System.out.println("----------------------");
        System.out.println("ID: " + user.ID + "\nNome: " + user.name + "\nTipo: "+ user.type);
      }
      System.out.println("Digite o ID do aluno que deseja inserir no projeto: ");
      int user_sub = scan.nextInt();
      scan.nextLine();
      User user = users.get(user_sub);
      this.users.add(user);
      System.out.println("Usuário substituido com sucesso!");
    }
  }
}
