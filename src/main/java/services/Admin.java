package services;

public class Admin {
public String firstName;
public String lastName;
public String password;
public String email;

public Admin(String firstName, String lastName, String password, String email){
    this.firstName = firstName;
    this.lastName = lastName;
    this.password = password;
    this.email = email;
}

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
}
