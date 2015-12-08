/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mongodb;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 5105870
 */
public class MongoConnection 
{
    private MongoClient client;
    private DB banco;
    private DBCollection colecao;
    private BasicDBObject obj;
    
    public MongoConnection(String dataBaseName, String collectionName)
    {
        try {
            client = new MongoClient();
        } catch (UnknownHostException ex) {
            Logger.getLogger(MongoConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        banco = client.getDB(dataBaseName);//cria ou acessa uma instância DB mongo
        colecao = banco.getCollection(collectionName); //nome da coleção
    }
    
    // Criação
    public void Insert(BasicDBObject obj)
    {
        this.obj = obj;
    }
    
    // Criação de objetos dentro do objeto
    public void InsertExtension(BasicDBObject objExt, String name)
    {
        BasicDBObject ext = objExt;
        obj.append(name, ext);
    }
    
    public void Save()
    {
        colecao.save(obj);
    }

    public DBCursor Select()
    {
        DBCursor cursor = colecao.find();
        return cursor;
    }
    
    public DBCursor SelectWhere(String key, String value)
    {
        BasicDBObject where = new BasicDBObject(key,value);
        DBCursor cursor = colecao.find(where);
        return cursor;
    }
    
    public void SetUpdate(String key, String value, String newValue)
    {
        BasicDBObject where = new BasicDBObject(key,value); 
        BasicDBObject set = new BasicDBObject("$set", new BasicDBObject(key,newValue));
        colecao.update(where, set);
    }
    
    public void Delete(String key, String value)
    {
        BasicDBObject where = new BasicDBObject(key,value); //where key = value
        colecao.remove(where);
    }
    
}
