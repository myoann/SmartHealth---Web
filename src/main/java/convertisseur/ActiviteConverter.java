/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package convertisseur;

import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBObject;
import java.util.Date;
import modeles.Activite;
import modeles.Objectif;
import org.bson.types.ObjectId;

/**
 *
 * @author user
 */
public class ActiviteConverter {
     // convert Person Object to MongoDB DBObject
    // take special note of converting id String to ObjectId
    public static DBObject toDBObject(Activite a) {
 
        BasicDBObjectBuilder builder = BasicDBObjectBuilder.start()
                .append("date", a.getDate()).append("nombrePas", a.getNombrePas())
                                            .append("minutes", a.getMinutes())
                                            .append("metres", a.getMetres())
                                            .append("frequenceCardiaque", a.getFrequenceCardiaque())
                                            .append("itineraire", a.getItineraire())
                                            .append("vitesse", a.getVitesse())
                                            .append("type", a.getType());
        if (a.getId() != null)
            builder = builder.append("_id", new ObjectId(a.getId()));
        return builder.get();
    }
 
    // convert DBObject Object to Person
    // take special note of converting ObjectId to String
    public static Activite toActivite(DBObject doc) {
        Activite a = new Activite();
        a.setDate((Date) doc.get("date"));
        a.setNombrePas((Integer) doc.get("nombrePas"));
        a.setMinutes((Integer) doc.get("minutes"));
        a.setMetres((Integer) doc.get("metres"));
        a.setFrequenceCardiaque((Integer) doc.get("frequenceCardiaque"));
        a.setVitesse((Integer) doc.get("vitesse"));
        a.setItineraire((String[][]) doc.get("itineraire"));
        a.setType((String) doc.get("type"));
        ObjectId id = (ObjectId) doc.get("_id");
        a.setId(id.toString());
        return a;
 
    }
}
