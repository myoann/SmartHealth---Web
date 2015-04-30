/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilisateurs.gestionnaire;
import com.mongodb.BasicDBObject;
import java.util.ArrayList;
import java.util.List;
 
import org.bson.types.ObjectId;
 
import utilisateurs.convertisseur.UtilisateurConverter;
import utilisateurs.modeles.Utilisateur;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
/**
 *
 * @author user
 */
public class GestionnaireUtilisateur {
 
    private DBCollection col;
 
    public GestionnaireUtilisateur(MongoClient mongo) {
        this.col = mongo.getDB("miage").getCollection("Utilisateurs");
    }
 
    public Utilisateur createUser(Utilisateur u) {
        DBObject doc = UtilisateurConverter.toDBObject(u);
        this.col.insert(doc);
        ObjectId id = (ObjectId) doc.get("_id");
        u.setId(id.toString());
        return u;
    }
 
    public void updateUser(Utilisateur u) {
        DBObject query = BasicDBObjectBuilder.start()
                .append("_id", new ObjectId(u.getId())).get();
        BasicDBObject updateUser = new BasicDBObject();
        DBObject newUser = new BasicDBObject().append("country", u.getCountry())
                                              .append("email", u.getEmail())
                                              .append("naissance", u.getNaissance())
                                              .append("motdepasse", u.getMotdepasse())
                                              .append("poids", u.getPoids())
                                              .append("taille", u.getTaille())
                                              .append("name", u.getName());
	updateUser.append("$set", newUser);
        this.col.update(query, updateUser);
    }
 
    public List<Utilisateur> readAllUsers() {
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
        DBObject query = BasicDBObjectBuilder.start()
                .append("_id", new ObjectId(u.getId())).get();
        this.col.remove(query);
    }
 
    public Utilisateur readUser(Utilisateur u) {
        DBObject query = BasicDBObjectBuilder.start()
                .append("_id", new ObjectId(u.getId())).get();
        DBObject data = this.col.findOne(query);
        return UtilisateurConverter.toUtilisateur(data);
    }
 
    public Utilisateur checkUser(Utilisateur u) {
        DBObject query = BasicDBObjectBuilder.start()
                .append("email",u.getEmail()).get();
        DBObject data = this.col.findOne(query);
        if(data == null) {
            return null;
        }
        else {
            return UtilisateurConverter.toUtilisateur(data);
        }
    }
 
}
