import java.util.*;
import java.time.LocalDateTime;

public class Project {
  int ID;
  String description;
  String status;
  LocalDateTime datetime_begin;
  LocalDateTime datetime_end;
  User cordinator;
  ArrayList<User> users = new ArrayList<User>();
  ArrayList<Activity> activities = new ArrayList<Activity>();
  Map<Double, User> scholarship_values = new HashMap<>();
  int scholarship_period;

  public Project(
    String description,
    LocalDateTime datetime_begin,
    LocalDateTime datetime_end,
    User cordinator,
    int scholarshio_period){

    this.description = description;
    this.datetime_begin = datetime_begin;
    this.datetime_end = datetime_end;
    this.cordinator = cordinator;
    this.scholarship_period = scholarshio_period;
    this.scholarship_values = new HashMap<Double, User>();
  }

  public void setID(int ID){
    this.ID = ID;
  }
  
  public void addUser(User user){
    users.add(user);
  }

  public void addScholarship(Double value, User user){
    scholarship_values.put(value, user);
  }

  public void addActivity(Activity activity){
    activities.add(activity);
  }

  public void setStatus(String status){
    this.status = status;
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

  public void setCordinator(User cordinator) {
    this.cordinator = cordinator;
  }

  public void setScholarshipPeriod(int period) {
    this.scholarship_period = period;
  }

  public void setScholarshipValue(Double value, User user) {
    for (var entry : this.scholarship_values.entrySet()) {
      if (entry.getValue().name == user.name){
        this.scholarship_values.put(value, user);
      }
    }
  }
  
  public void edit_activities(ArrayList<Activity> activities){
    Scanner scan = new Scanner(System.in);
    for (Activity activity: this.activities){
      System.out.println("----------------------");
      System.out.println("ID: " + activity.ID + "\nDescrição: " + activity.description);
    }
    System.out.println("Digite 1 para remover ou 2 para substituir: ");
    int op = scan.nextInt();
    scan.nextLine();
    System.out.println("Digite o ID da atividade: ");
    int activity_id = scan.nextInt();
    scan.nextLine();
    if (op==1){
      this.activities.remove(activity_id);
      System.out.println("Atividade removida do projeto com sucesso!");
    }
    else if(op==2){
      for (Activity activity: activities){
        System.out.println("----------------------");
        System.out.println("ID: " + activity.ID + "\nDescrição: " + activity.description);
      }
      System.out.println("Digite o ID da atividade que deseja inserir no projeto: ");
      int activity_sub = scan.nextInt();
      scan.nextLine();
      User user = users.get(activity_sub);
      this.users.add(user);
      System.out.println("Atividade substituida com sucesso!");
    }
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
