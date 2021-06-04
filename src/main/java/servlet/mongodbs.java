package servlet;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class mongodbs {
    public static void main(String[] args) {
        MongoCollection<Document> user = mongdbe().getCollection("userse");
        Document document = new Document();
        document.append("name","张三");
        document.append("age",19);
        document.append("sex","男");
        System.out.println(document);

//        HashMap<String, Object> hashMap = new HashMap<>();
//            hashMap.put("name","张三");
//            hashMap.put("age",19);
//            hashMap.put("sex","男");
//            System.out.println(hashMap);
        user.insertOne(document);


    }


    public  static  MongoDatabase mongdbe(){
        List<ServerAddress> list = new ArrayList<>();
        ServerAddress mongos = new ServerAddress("1.15.17.194", 27017);
        list.add(mongos);
        List<MongoCredential> arrayList = new ArrayList();
        MongoCredential you = MongoCredential.createScramSha1Credential("1822", "you", "zhr".toCharArray());
        arrayList.add(you);
        MongoClient mongo = new MongoClient(list,arrayList);
        MongoDatabase you1 = mongo.getDatabase("you");
        return  you1;
    }






}
