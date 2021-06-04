package servlet.mongodb;

import com.mongodb.client.FindIterable;
import org.bson.Document;

import java.util.*;
import java.util.logging.Handler;

public class testmongo {
    public static void main(String[] args) {
        mongo mongo = new mongo("1.15.17.194", 27017, "1822", "you", "zhr");

        Document document =new Document();

        document.append("name","张恒瑞");

        List<Map> inform = mongo.find("inform");

        for (Map data: inform) {
            System.out.println(data);
        }




    }

}
