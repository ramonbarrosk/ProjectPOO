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

  public Activity(int ID, String description, LocalDateTime datetime_begin, LocalDateTime datetime_end, User manager){
    this.ID = ID;
    this.description = description;
    this.datetime_begin = datetime_begin;
    this.datetime_end = datetime_end;
    this.manager = manager;
    users = new ArrayList<User>();
    tasks = new HashMap<String, User>();
    }

  public void addUser(User user){
    users.add(user);
  }

  public void addTask(String task, User user){
    tasks.put(task, user);
  }
}
