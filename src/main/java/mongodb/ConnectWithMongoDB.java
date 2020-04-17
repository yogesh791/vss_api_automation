package mongodb;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

public class ConnectWithMongoDB {

	public static void main(String[] args) {

		@SuppressWarnings("resource")
		MongoClient mongoClient = new MongoClient("localhost", 27017);
		System.out.println("Connection established successfully");
		MongoDatabase db = mongoClient.getDatabase("customer");
		MongoCollection<Document> coll = db.getCollection("VehicleDetails");
		FindIterable<Document> it = coll.find();
		MongoCursor<Document> cursor = it.cursor(); 
		while (cursor.hasNext()) {
			{
				System.out.println(cursor.next());
			}
			
		}
	}

}
