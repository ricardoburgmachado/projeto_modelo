/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.model;

import java.io.Serializable;
import javax.validation.constraints.*;
/**
 *
 * @author Ricardo
 */
//@Entity
public class Pessoa implements Serializable{

    @NotNull @Size(min=5, message = "O nome deve conter pelo menos cinco caracteres")
    private String nome;
    
    @NotNull
    @Pattern(regexp = "^[\\w\\-]+(\\.[\\w\\-]+)*@([A-Za-z0-9-]+\\.)+[A-Za-z]{2,4}$",message = "O email não é válido") 
    private String email;
   // @Id
    private int id;
    
    public Pessoa() {}
    
    public Pessoa(String nome, String email) {
        
        setNome(nome);
        setEmail(email);
    }
    
    public Pessoa(int id, String nome, String email) {
        setId(id);
        setNome(nome);
        setEmail(email);
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }
}
