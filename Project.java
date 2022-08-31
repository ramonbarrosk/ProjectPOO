import java.util.ArrayList;

public class Project {
  int ID;
  String description;
  String status;
  String datetime_begin;
  String datetime_end;
  User cordinator;
  ArrayList<User> users;
  ArrayList<Activity> activities;
  Double scholarship_value;
  String scholarship_period;

  public Project(
    int ID,
    String description,
    String datetime_begin,
    String datetime_end,
    User cordinator,
    ArrayList<User> users,
    ArrayList<Activity> activities,
    Double scholarship_value,
    String scholarshio_period){

    this.ID = ID;
    this.description = description;
    this.datetime_begin = datetime_begin;
    this.datetime_end = datetime_end;
    this.cordinator = cordinator;
    this.users = users;
    this.activities = activities;
    this.scholarship_value = scholarship_value;
    this.scholarship_period = scholarshio_period;
  }

  private void addUser(User user){
    users.add(user);
  }

  private void addActivity(Activity activity){
    activities.add(activity);
  }

  private void setStatus(String status){
    this.status = status;
  }

}
