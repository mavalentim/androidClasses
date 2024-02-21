package dk.itu.shoppingv1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ItemsDB {
    private HashMap<String, String> ItemsDB= new HashMap<>();

    public ItemsDB() {
        fillItemsDB();
    }
    public void fillItemsDB() {
        ItemsDB.put("Milk Carton", "Plastic");
        ItemsDB.put("Wine Bottle", "Glass");
        ItemsDB.put("Gift Box", "Cardboard");
        ItemsDB.put("Can", "Metal");
        ItemsDB.put("Notebook", "Paper");
    }

    public String whereDoesThisGo(String item){
        if(ItemsDB.containsKey(item)){
            return ItemsDB.get(item);
        }else{
            return "We dont have info on that... YET";
        }
    }
}
