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
  String scholarship_period;

  public Project(
    int ID,
    String description,
    LocalDateTime datetime_begin,
    LocalDateTime datetime_end,
    User cordinator,
    String scholarshio_period){

    this.ID = ID;
    this.description = description;
    this.datetime_begin = datetime_begin;
    this.datetime_end = datetime_end;
    this.cordinator = cordinator;
    this.scholarship_period = scholarshio_period;
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

}
