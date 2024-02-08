package nespresso.restaurant.Restaurant.Table;
import java.util.*;

public class Table {
    public int tableId;
    private Map<String,String> orderMap;
    private Map<String, Integer> plates;
    private List<String> orderList;
    private int numberOfClients;

    public Table(int tableId, int numberOfClients){
        this.orderMap = new LinkedHashMap<>();
        this.plates = new LinkedHashMap<>();
        this.tableId=tableId;
        this.numberOfClients=numberOfClients;
        this.orderList=new ArrayList<>();
    }

    public void addToOrder(String customerName, String dishName){
        if(dishName.equals("Same")){
           dishName=orderList.get(orderList.size()-1);
        }
        orderMap.put(customerName, dishName);
        orderList.add(dishName);
    }
    private void orderToPlates(){
        Map<String, Integer> tmp =new LinkedHashMap<>();
        orderMap.forEach((key, val)->{
            if(val.endsWith("for 2")){
                String[] plateAndQuantity = val.split(" ");
                tmp.put(val, tmp.getOrDefault(val,0)+1);
            }else{
                tmp.put(val, 1);
            }
        });
        this.plates=tmp;
    }
    private String verifyOrder(){

        if(orderMap.size()<numberOfClients){
            return "MISSING " + (numberOfClients - orderMap.size());
        }
        this.orderToPlates();
        String error="";
        for (Map.Entry<String, Integer> entry : this.plates.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            if (key.endsWith("for 2") && value < 2) {
                error= "MISSING 1 for " + key;
            }
        }
        return error;
    }
    public String getOrder(){
        String err = this.verifyOrder();
        if(err.length()>1){
            return err;
        }
        return String.join(", ",this.orderMap.values());
    }


}
