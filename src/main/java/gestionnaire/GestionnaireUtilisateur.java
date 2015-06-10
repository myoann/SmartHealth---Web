/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionnaire;
import com.mongodb.BasicDBObject;
import java.util.ArrayList;
import java.util.List;
 
import org.bson.types.ObjectId;
 
import convertisseur.UtilisateurConverter;
import modeles.Utilisateur;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import convertisseur.ActiviteConverter;
import convertisseur.ObjectifConverter;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import modeles.Activite;
import mongo.MongoClientProvider;
/**
 *
 * @author user
 */
@Stateless
public class GestionnaireUtilisateur {
    @EJB
    MongoClientProvider mongoClientProvider;
    
    public Utilisateur createUser(Utilisateur u) {
        MongoClient mongoClient = mongoClientProvider.getMongoClient();
        DBCollection col = mongoClient.getDB("miage").getCollection("Utilisateurs");
        DBObject doc = UtilisateurConverter.toDBObject(u);
        col.insert(doc);
        ObjectId id = (ObjectId) doc.get("_id");
        u.setId(id.toString());
        return u;
    }
 
    public void updateUser(Utilisateur u) {
        MongoClient mongoClient = mongoClientProvider.getMongoClient();
        DBCollection col = mongoClient.getDB("miage").getCollection("Utilisateurs");
        DBObject query = BasicDBObjectBuilder.start()
                .append("_id", new ObjectId(u.getId())).get();
        BasicDBObject updateUser = new BasicDBObject();
        DBObject objectif = ObjectifConverter.toDBObject(u.getObjectif());
        DBObject newUser = new BasicDBObject()//.append("photo", u.getPhoto())
                                              .append("email", u.getEmail())
                                              .append("naissance", u.getNaissance())
                                              .append("motdepasse", u.getMotdepasse())
                                              .append("poids", u.getPoids())
                                              .append("taille", u.getTaille())
                                              .append("objectif", objectif)
                                              .append("name", u.getName());
	updateUser.append("$set", newUser);
        col.update(query, updateUser);
    }
 
    public void updateProfil(Utilisateur u) {
        MongoClient mongoClient = mongoClientProvider.getMongoClient();
        DBCollection col = mongoClient.getDB("miage").getCollection("Utilisateurs");
        DBObject query = BasicDBObjectBuilder.start()
                .append("_id", new ObjectId(u.getId())).get();
        BasicDBObject updateUser = new BasicDBObject();
        DBObject newUser = new BasicDBObject().append("motdepasse", u.getMotdepasse())
                                              .append("email", u.getEmail());
	updateUser.append("$set", newUser);
        col.update(query, updateUser);
    }
    
    public void updateDonnees(Utilisateur u) {
        
        System.out.println(u.getPoids());
        MongoClient mongoClient = mongoClientProvider.getMongoClient();
        DBCollection col = mongoClient.getDB("miage").getCollection("Utilisateurs");
        DBObject query = BasicDBObjectBuilder.start()
                .append("_id", new ObjectId(u.getId())).get();
        BasicDBObject updateUser = new BasicDBObject();
        DBObject newUser = new BasicDBObject().append("naissance", u.getNaissance())
                                              .append("poids", u.getPoids())
                                              .append("taille", u.getTaille());
	updateUser.append("$set", newUser);
        col.update(query, updateUser);
    }
    
    public void updateObjectif(Utilisateur u) {
        MongoClient mongoClient = mongoClientProvider.getMongoClient();
        DBCollection col = mongoClient.getDB("miage").getCollection("Utilisateurs");
        DBObject query = BasicDBObjectBuilder.start()
                .append("_id", new ObjectId(u.getId())).get();
        BasicDBObject updateUser = new BasicDBObject();
        DBObject objectif = ObjectifConverter.toDBObject(u.getObjectif());
        DBObject newUser = new BasicDBObject().append("objectif", objectif);
	updateUser.append("$set", newUser);
        col.update(query, updateUser);
    }
    
    public void addActivite(Utilisateur u) {
        MongoClient mongoClient = mongoClientProvider.getMongoClient();
        DBCollection col = mongoClient.getDB("miage").getCollection("Utilisateurs");
        BasicDBObject updateUser = new BasicDBObject();
        ArrayList<DBObject> activites = new ArrayList<>();
        for(int i = 0; i < u.getActivites().size(); i++) {
            activites.add(ActiviteConverter.toDBObject(u.getActivites().get(i)));
        }
        DBObject query = BasicDBObjectBuilder.start()
                .append("_id", new ObjectId(u.getId())).get();
        DBObject newUser = new BasicDBObject().append("activites", activites);
	updateUser.append("$set", newUser);
        col.update(query, updateUser);
    }
    
    public List<Utilisateur> readAllUsers() {
        MongoClient mongoClient = mongoClientProvider.getMongoClient();
        DBCollection col = mongoClient.getDB("miage").getCollection("Utilisateurs");
        List<Utilisateur> data = new ArrayList<Utilisateur>();
        DBCursor cursor = col.find();
        while (cursor.hasNext()) {
            DBObject doc = cursor.next();
            Utilisateur u = UtilisateurConverter.toUtilisateur(doc);
            data.add(u); 
        }
        return data;
    }
 
    public void deleteUser(Utilisateur u) {
        
        MongoClient mongoClient = mongoClientProvider.getMongoClient();
        DBCollection col = mongoClient.getDB("miage").getCollection("Utilisateurs");
        DBObject query = BasicDBObjectBuilder.start()
                .append("_id", new ObjectId(u.getId())).get();
        col.remove(query);
    }
 
    public Utilisateur readUser(Utilisateur u) {
        
        MongoClient mongoClient = mongoClientProvider.getMongoClient();
        DBCollection col = mongoClient.getDB("miage").getCollection("Utilisateurs");
        DBObject query = BasicDBObjectBuilder.start()
                .append("_id", new ObjectId(u.getId())).get();
        DBObject data = col.findOne(query);
        if(data == null) {
            return null;
        }
        else {
            return UtilisateurConverter.toUtilisateur(data);
        }
    }
 
    public Utilisateur checkUser(Utilisateur u) {
        
        MongoClient mongoClient = mongoClientProvider.getMongoClient();
        DBCollection col = mongoClient.getDB("miage").getCollection("Utilisateurs");
        DBObject query = BasicDBObjectBuilder.start()
                .append("email",u.getEmail()).get();
        DBObject data = col.findOne(query);
        if(data == null) {
            return null;
        }
        else {
            return UtilisateurConverter.toUtilisateur(data);
        }
    }
 
}
