import java.util.ArrayList;

public class Activity {
  int ID;
  String description;
  String datetime_begin;
  String datetime_end;
  User manager;
  ArrayList<User> users;
  String[] tasks;

  public Activity(int ID, String description, String datetime_begin, String datetime_end, User manager, ArrayList<User> users, String[] tasks){
    this.ID = ID;
    this.description = description;
    this.datetime_begin = datetime_begin;
    this.datetime_end = datetime_end;
    this.manager = manager;
    this.users = users;
    this.tasks = tasks;
  }
}
