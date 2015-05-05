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

import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import convertisseur.ObjectifConverter;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import listener.MongoClientProvider;
import modeles.Objectif;
/**
 *
 * @author user
 */
@Stateless
public class GestionnaireObjectif {
 
    @EJB
    MongoClientProvider mongoClientProvider;
    
    public Objectif createObjectif(Objectif o) {
        MongoClient mongoClient = mongoClientProvider.getMongoClient();
        DBCollection col = mongoClient.getDB("miage").getCollection("Objectifs");
 
        DBObject doc = ObjectifConverter.toDBObject(o);
        col.insert(doc);
        ObjectId id = (ObjectId) doc.get("_id");
        o.setId(id.toString());
        return o;
    }
 
    public void updateObjectif(Objectif o) {
        MongoClient mongoClient = mongoClientProvider.getMongoClient();
        DBCollection col = mongoClient.getDB("miage").getCollection("Objectifs");
        DBObject query = BasicDBObjectBuilder.start()
                .append("_id", new ObjectId(o.getId())).get();
        BasicDBObject updateUser = new BasicDBObject();
        DBObject newObjectif = new BasicDBObject().append("titre", o.getTitre())
                                            .append("description", o.getDescription())
                                            .append("nombrePas", o.getNombrePas())
                                            .append("minutes", o.getMinutes())
                                            .append("metres", o.getMetres())
                                            .append("veloMetres", o.getVeloMetres())
                                            .append("veloTemps", o.getVeloTemps())
                                            .append("courseTemps", o.getCourseTemps())
                                            .append("courseMetres", o.getCourseMetres())
                                            .append("marcheMetres", o.getMarcheMetres())
                                            .append("marcheTemps", o.getMarcheTemps());
	updateUser.append("$set", newObjectif);
        col.update(query, updateUser);
    }
 
    public List<Objectif> readAllObjectifs() {
        MongoClient mongoClient = mongoClientProvider.getMongoClient();
        DBCollection col = mongoClient.getDB("miage").getCollection("Objectifs");
        List<Objectif> data = new ArrayList<Objectif>();
        DBCursor cursor = col.find();
        while (cursor.hasNext()) {
            DBObject doc = cursor.next();
            Objectif o = ObjectifConverter.toObjectif(doc);
            data.add(o); 
        }
        return data;
    }
 
    public void deleteObjectif(Objectif o) {
        MongoClient mongoClient = mongoClientProvider.getMongoClient();
        DBCollection col = mongoClient.getDB("miage").getCollection("Objectifs");
        DBObject query = BasicDBObjectBuilder.start()
                .append("_id", new ObjectId(o.getId())).get();
        col.remove(query);
    }
 
    public Objectif readObjectif(Objectif o) {
        MongoClient mongoClient = mongoClientProvider.getMongoClient();
        DBCollection col = mongoClient.getDB("miage").getCollection("Objectifs");
        DBObject query = BasicDBObjectBuilder.start()
                .append("_id", new ObjectId(o.getId())).get();
        DBObject data = col.findOne(query);
        return ObjectifConverter.toObjectif(data);
    }
 
}
