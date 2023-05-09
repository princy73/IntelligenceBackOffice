package models;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;

@Entity
public class Article_Contenu extends BaseModel {    
    
    @Column
    private String titre;
    
    @Column
    private String description;
    
    @Column
    private Date date;

    public Article_Contenu() {
    }

    public Article_Contenu(String titre, String description, Date date) {
        this.titre = titre;
        this.description = description;
        this.date = date;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }
    
    
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
