/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package convertisseur;
import org.bson.types.ObjectId;

import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBObject;
import modeles.Objectif;

/**
 *
 * @author user
 */
public class ObjectifConverter {
     // convert Person Object to MongoDB DBObject
    // take special note of converting id String to ObjectId
    public static DBObject toDBObject(Objectif o) {
 
        BasicDBObjectBuilder builder = BasicDBObjectBuilder.start()
                .append("titre", o.getTitre()).append("description", o.getDescription())
                                            .append("nombrePas", o.getNombrePas())
                                            .append("minutes", o.getMinutes())
                                            .append("metres", o.getMetres())
                                            .append("veloMetres", o.getVeloMetres())
                                            .append("veloTemps", o.getVeloTemps())
                                            .append("courseTemps", o.getCourseTemps())
                                            .append("courseMetres", o.getCourseMetres())
                                            .append("marcheMetres", o.getMarcheMetres())
                                            .append("marcheTemps", o.getMarcheTemps());
        if (o.getId() != null)
            builder = builder.append("_id", new ObjectId(o.getId()));
        return builder.get();
    }
 
    // convert DBObject Object to Person
    // take special note of converting ObjectId to String
    public static Objectif toObjectif(DBObject doc) {
        Objectif o = new Objectif();
        o.setTitre((String) doc.get("titre"));
        o.setDescription((String) doc.get("description"));
        o.setNombrePas((Integer) doc.get("nombrePas"));
        o.setMinutes((Integer) doc.get("minutes"));
        o.setMetres((Integer) doc.get("metres"));
        o.setVeloMetres((Integer) doc.get("veloMetres"));
        o.setVeloTemps((Integer) doc.get("veloTemps"));
        o.setCourseTemps((Integer) doc.get("courseTemps"));
        o.setCourseMetres((Integer) doc.get("courseMetres"));
        o.setMarcheMetres((Integer) doc.get("marcheMetres"));
        o.setMarcheTemps((Integer) doc.get("marcheTemps"));
        ObjectId id = (ObjectId) doc.get("_id");
        o.setId(id.toString());
        return o;
 
    }
}