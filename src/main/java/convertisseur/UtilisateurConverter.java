/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package convertisseur;
import org.bson.types.ObjectId;
 
import modeles.Utilisateur;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBObject;
import java.util.HashMap;
import modeles.Objectif;

/**
 *
 * @author user
 */
public class UtilisateurConverter {
     // convert Person Object to MongoDB DBObject
    // take special note of converting id String to ObjectId
    public static DBObject toDBObject(Utilisateur u) {
 
        DBObject objectif = ObjectifConverter.toDBObject(u.getObjectif());
        BasicDBObjectBuilder builder = BasicDBObjectBuilder.start()
                .append("name", u.getName())//.append("photo", u.getPhoto())
                                            .append("motdepasse", u.getMotdepasse())
                                            .append("email", u.getEmail())
                                            .append("nombrePas", u.getNombrePas())
                                            .append("minutes", u.getMinutes())
                                            .append("metres", u.getMetres())
                                            .append("taille", u.getTaille())
                                            .append("naissance", u.getNaissance())
                                            .append("poids", u.getPoids())
                                            .append("admin", u.isAdmin())
                                            .append("objectif", objectif)
                                            .append("localisation", u.getLocalisation());
        if (u.getId() != null)
            builder = builder.append("_id", new ObjectId(u.getId()));
        return builder.get();
    }
 
    // convert DBObject Object to Person
    // take special note of converting ObjectId to String
    public static Utilisateur toUtilisateur(DBObject doc) {
        Utilisateur u = new Utilisateur();
        u.setName((String) doc.get("name"));
        //u.setPhoto((String) doc.get("photo"));
        u.setEmail((String) doc.get("email"));
        u.setMotdepasse((String) doc.get("motdepasse"));
        u.setNombrePas((HashMap) doc.get("nombrePas"));
        u.setMinutes((HashMap) doc.get("minutes"));
        u.setMetres((HashMap) doc.get("metres"));
        u.setTaille((String) doc.get("taille"));
        u.setNaissance((String) doc.get("naissance"));
        u.setPoids((String) doc.get("poids"));
        u.setAdmin((boolean) doc.get("admin"));
        DBObject objectif = (DBObject) doc.get("objectif");
        if(objectif != null) {
            u.setObjectif(ObjectifConverter.toObjectif(objectif));
        }
        u.setLocalisation((String) doc.get("localisation"));
        ObjectId id = (ObjectId) doc.get("_id");
        u.setId(id.toString());
        return u;
 
    }
}
