package models;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Admin extends BaseModel{
    
    @Column
    private String email;

    @Column
    private String password;

    public Admin() {
    }

    public Admin(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}