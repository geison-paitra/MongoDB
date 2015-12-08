/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javamongo;
import com.mongodb.*;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.logging.Logger;

public class JavaMongo 
{

    public static void main(String[] args) 
    {
       try
       {
        MongoClient client = new MongoClient();
        
        DB banco = client.getDB("javadb");//cria ou acessa uma instância DB mongo
        DBCollection colecao = banco.getCollection("pessoas");
        
        //Salvar
        /*
            BasicDBObject p1 = new BasicDBObject();
            p1.append("Nome", "Joao");
            p1.append("Idade", 20);
            colecao.save(p1);
        
            p1.append("Nome", "Maria");
            p1.append("Idade", 20);
        
            BasicDBObject endereco = new BasicDBObject();
            endereco.append("Logradouro", "Avemida Brasil");
            endereco.append("Numero", 1090);
            endereco.append("Complemento", "Ap 200");
            p1.append("Endereco", endereco);
        
            ArrayList<String> telefones = new ArrayList<>();
            telefones.add("047 33216598");
            telefones.add("047 99699999");
        
            p1.append("Telefones", telefones);
            colecao.save(p1);
         */
        
        //consulta
        /*
        //where
            BasicDBObject where = new BasicDBObject("Nome","Aninha"); //where nome = aninha
            BasicDBObject where = new BasicDBObject("Idade", new BasicDBObject("$gte",5)); //where idade >= 5
        
        //select
            DBCursor cursor = colecao.find(); //select tudo
            DBCursor cursor = colecao.find(where);
        
           while (cursor.hasNext()) 
           {
               BasicDBObject documento = (BasicDBObject)cursor.next();
               
               System.out.println("Nome: "+documento.getString("Nome"));
               System.out.println("Endereco: "+documento.getString("Endereco"));
               System.out.println("Complemento: "+documento.getString("Complemento"));
           } 
        */
        
        
        //delete
        /*
            BasicDBObject where = new BasicDBObject("Nome","Aninha"); //where nome = aninha
            colecao.remove(where);
        */
        
        //update
        /*
            BasicDBObject where = new BasicDBObject("Nome","Pedrinho"); 
            BasicDBObject set = new BasicDBObject("$set", new BasicDBObject("Nome","Pedrinho2"));
            colecao.update(where, set);
        */
       }
       catch(UnknownHostException ex)
       {
           System.out.println(ex.getMessage());
       }
          
    }
    
}
