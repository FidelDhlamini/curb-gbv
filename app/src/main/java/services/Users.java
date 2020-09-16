package raiders;
import org.jdbi.v3.core.mapper.reflect.ColumnName;
public class Users {
   public String firstName;
    public String lastName;
    public String email;
    public Users(String firstName, String lastName, String email){
        this.firstName = firstName;
        this.lastName =lastName;
        this.email = email;
    }
  public void setFirstName(String firstName){
        this.firstName = firstName;

  }
  public void setLastName(String lastName){
        this.lastName = lastName;
  }
  public void setEmail(String email){
        this.email = email;
  }
  public String getFirstName(){
        return firstName;
  }
  public  String getLastName(){
        return lastName;
  }
  public String getEmail(){
        return email;
  }
}
