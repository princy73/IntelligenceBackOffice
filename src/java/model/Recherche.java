/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import connex.Connexi;
import java.sql.Connection;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import object.ObjetBDD;
import utilitaire.Connect;

/**
 *
 * @author itu
 */
public class Recherche extends ObjetBDD {
//     id |  titre  |  prix  | idtypes |   date1    |   date2    |     image      |    lieu    | description
    private int id;
    private String nom;
    private String titre;
    private double prix;
    private Date date1;
    private Date date2;
    private String image;
    private String lieu;
    private String description;
    private String etat;
    private int idtypes;
    private Timestamp datepublication;
    private Timestamp datecreation;

    public Timestamp getDatecreation() {
        return datecreation;
    }

    public void setDatecreation(Timestamp datecreation) {
        this.datecreation = datecreation;
    }
    
    

    public Timestamp getDatepublication() {
        return datepublication;
    }

    public void setDatepublication(Timestamp datepublication) {
        this.datepublication = datepublication;
    }

    
    
    public int getIdtypes() {
        return idtypes;
    }

    public void setIdtypes(int idtypes) {
        this.idtypes = idtypes;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    
    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }
    
    

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public Date getDate1() {
        return date1;
    }

    public void setDate1(Date date1) {
        this.date1 = date1;
    }

    public Date getDate2() {
        return date2;
    }

    public void setDate2(Date date2) {
        this.date2 = date2;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Recherche> recherche(String param) throws Exception {
        List<Recherche> val = new ArrayList<>();
        Connection con = new Connect().connectto();
        String sql = "recherche where datepublication<=now() and datepublication::date<=CURRENT_DATE and lower(titre) like '%" + param.toLowerCase() + "%' or " + " lower(description) like '%" + param.toLowerCase() + "%' or " + "lower(lieu) like '%" + param.toLowerCase() + "%'";
        Vector vct = this.findView(con, sql);
        for (int i = 0; i < vct.size(); i++) {
            val.add((Recherche) vct.get(i));
        }
        return val;
    }

    public List<Recherche> suivant(String param) throws Exception {
        List<Recherche> val = new ArrayList<Recherche>();
        Connection con = new Connexi().getConnexion();
        String sql = "recherche where datepublication<=now() and datepublication::date<=CURRENT_DATE offset " + param + " limit 4";
        Vector vct = this.findView(con, sql);
        for (int i = 0; i < vct.size(); i++) {
            val.add((Recherche) vct.get(i));
        }
        return val;
    }
}
