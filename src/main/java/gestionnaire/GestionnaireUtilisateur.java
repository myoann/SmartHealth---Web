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
import convertisseur.ObjectifConverter;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import listener.MongoClientProvider;
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
        DBObject newUser = new BasicDBObject().append("country", u.getCountry())
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
        return UtilisateurConverter.toUtilisateur(data);
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
