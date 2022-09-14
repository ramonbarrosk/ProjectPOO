public class User {
  int ID;
  String type;
  String name;
  String username;
  int password;

  public User(String name, String type){
    this.type = type;
    this.name = name;
  }

  public void setID(int id){
    this.ID = id;
  }

  public void setUsername(String username){
    this.username = username;
  }
  
  public void setPassword(int password){
    this.password = password;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setType(String type) {
    this.type = type;
  }
}
