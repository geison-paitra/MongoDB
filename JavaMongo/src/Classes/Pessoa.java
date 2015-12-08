/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import com.mongodb.BasicDBObject;

/**
 *
 * @author 5105870
 */
public class Pessoa 
{
   private int Id;
   private String Nome;
   private int Idade;
   
   public Pessoa(String nome, int idade)
   {
       this.Nome = nome;
       this.Idade = idade;
   }


    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public int getIdade() {
        return Idade;
    }

    public void setIdade(int Idade) {
        this.Idade = Idade;
    }
   
}
