package servlet.mongodb;

import com.google.gson.Gson;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.*;

public class mongo {
            private  String     host="12.0.0.1" ;
            private  int        port=27017 ;
            private   String     user ;
            private   String       db;
            private   String   password;

            public mongo(String user, String db, String password) {
                this.user = user;
                this.db = db;
                this.password = password;

            }





            public mongo(String host, int port, String user, String db, String password) {
                this.host = host;
                this.port = port;
                this.user = user;
                this.db = db;
                this.password = password;


            }


//            获取mongodb数据库连接
            private  MongoClient  mongo_Client(){
                List  <ServerAddress> Address=new ArrayList();
                ServerAddress  mongo_server=new ServerAddress(host,port);
                Address.add(mongo_server);
                MongoCredential scramSha1Credential = MongoCredential.createScramSha1Credential(user, db, password.toCharArray());
                List<MongoCredential>   credential =new ArrayList<>();
                credential.add(scramSha1Credential);
                MongoClient mongoClient = new MongoClient(Address, credential);

                return  mongoClient;
            }


//            获取mongodb 集合连接
            private       MongoDatabase  data(){

                MongoDatabase database = this.mongo_Client().getDatabase(db);

                return  database ;

            }


//            插入数据一条数据
            public    int   insert_gather(Document data, String gather ){
                int a=0;
                try {
                    MongoCollection<Document> collection = this.data().getCollection(gather);
                    collection.insertOne(data);
                     a=1;
                }catch (Exception e){
                    e.printStackTrace();
                }
                return a;
            }

//          插入多条数据
            public  int    insert_many(List  list, String gather){
                int a=0;
                try {
                    MongoCollection<Document> collection = this.data().getCollection(gather);
                    collection.insertMany(list);
                     a=1;
                }catch (Exception e){
                    e.printStackTrace();
                }
                return  a;
            }

            public    String   count ( List gather ){
                MongoCollection<Document> collection = this.data().getCollection((String)gather.get(0));
                String a="";
                if  (gather.size()==1){
                        long count = collection.count();
                        if (count==0){
                            a=gather.get(0)+"没有数据";
                        }else {
                            a="查询到"+"{"+gather+"}"+count+"条数据";
                        }

                }else  if (gather.size()==2){
                        long count = collection.count((Document)gather.get(1));
                        if (count==0){
                        a=gather.get(0)+"没有数据";
                        }else {
                        a="查询到"+"{"+gather.get(0)+"}有+"+((Document) gather.get(1)).toJson() +"+"+count+"条数据";
                        }
                    }
                return  a ;

            }


            public   List<Map>  find(String gather, Object...agae){
                MongoCollection<Document> collection = this.data().getCollection(gather);
//                将字符串转换为map使用地方法
                Gson  gson =new Gson();

                Map map =new HashMap();
//              保存
                List <Map>  list=new ArrayList<>();
                FindIterable<Document>  dcu = null;
                if(agae.length==0){
                    FindIterable<Document> documents = collection.find();
                    for ( Document data : documents) {
                        String s = data.toJson();
                        map=gson.fromJson(s,map.getClass());
                        map.remove("_id");
                        list.add(map);
                    }
                }else if (agae.length==1){
                    FindIterable<Document> documents = collection.find((Document)agae[0]);
                    for ( Document data : documents) {
                        String s = data.toJson();
                        map=gson.fromJson(s,map.getClass());
                        map.remove("_id");
                        list.add(map);
                    }
                }

                return  list ;
            }





}
