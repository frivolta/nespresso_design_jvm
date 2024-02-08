package nespresso.restaurant.Restaurant;

import nespresso.restaurant.Restaurant.Table.Table;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private final List<Table> tables;
    public Restaurant(){
        this.tables = new ArrayList<>();
    }
    private Table findTable(int tableId){
        return tables.stream().filter(t->t.tableId==tableId).findFirst().orElseThrow();
    }
    public int initTable(Integer numberOfClients){
       int newTableId = 0;
        if(!tables.isEmpty()){
          newTableId = tables.get(tables.size()-1).tableId+1;
       }
        tables.add(new Table(newTableId, numberOfClients));
        return newTableId;
    }
    public void customerSays(int tableId, String order)throws IllegalArgumentException{
        String[] orderArr = order.split(": ");
        if(orderArr.length<2){
            throw new IllegalArgumentException();
        }
        Table table = this.findTable(tableId);
        table.addToOrder(orderArr[0], orderArr[1]);
    }
    public String createOrder(int tableId){
        return this.findTable(tableId).getOrder();
    }
}
