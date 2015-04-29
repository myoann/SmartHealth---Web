/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilisateurs.convertisseur;
import org.bson.types.ObjectId;
 
import utilisateurs.modeles.Utilisateur;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBObject;
import java.util.HashMap;

/**
 *
 * @author user
 */
public class UtilisateurConverter {
     // convert Person Object to MongoDB DBObject
    // take special note of converting id String to ObjectId
    public static DBObject toDBObject(Utilisateur u) {
 
        BasicDBObjectBuilder builder = BasicDBObjectBuilder.start()
                .append("name", u.getName()).append("country", u.getCountry()).append("motdepasse", u.getMotdepasse()).append("email", u.getEmail()).append("nombrePas", u.getNombrePas()).append("localisation", u.getLocalisation());
        if (u.getId() != null)
            builder = builder.append("_id", new ObjectId(u.getId()));
        return builder.get();
    }
 
    // convert DBObject Object to Person
    // take special note of converting ObjectId to String
    public static Utilisateur toUtilisateur(DBObject doc) {
        Utilisateur u = new Utilisateur();
        u.setName((String) doc.get("name"));
        u.setCountry((String) doc.get("country"));
        u.setEmail((String) doc.get("email"));
        u.setMotdepasse((String) doc.get("motdepasse"));
        u.setNombrePas((HashMap) doc.get("nombrePas"));
        u.setLocalisation((String) doc.get("localisation"));
        ObjectId id = (ObjectId) doc.get("_id");
        u.setId(id.toString());
        return u;
 
    }
}
