/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.hibernate.annotations.Table;


/**
 *
 * @author Fanjava
 */
@Entity

public class Region {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    
    int idprovince;
    String nom;
}
