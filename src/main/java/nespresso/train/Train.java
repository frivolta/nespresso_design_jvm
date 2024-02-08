package nespresso.train;

import nespresso.train.Wagon.WagonFactory;
import nespresso.train.Wagon.WagonType;

import java.util.*;
import java.util.stream.Collectors;

public class Train {
    private String wagons;
    private final String separator = "::";
    private ArrayList<String> train;
    private final WagonFactory wf = new WagonFactory();
    public Train(String wagons){
        this.wagons=wagons;
        this.buildTrain();
    }

    public boolean fill(){
        String[] ws = this.wagons.split("");
        boolean found = false;
        for(int i=0; i<ws.length; i++){
            WagonType wt = WagonType.fromString(ws[i]).orElseThrow();
            if(wt==WagonType.CARGO && !found){
                found = true;
                ws[i]=WagonType.FILLED.toString();
            }
        }
        this.wagons = String.join("", ws);
        this.buildTrain();
        return found;
    }

    private void buildTrain(){
        String[] ws = this.wagons.split("");
        this.train = new ArrayList<>();
        for (String w : ws){
            WagonType wagonKey = WagonType.fromString(w).orElseThrow();
            String wagonValue = wf.getWagon(wagonKey);
            this.train.add(wagonValue);
        }
    }
    public String print(){
        StringBuilder t = new StringBuilder();
        int size = this.train.size();
        int count = 0;
        for(String entry : this.train){
            count++;
           t.append(entry);
            if(count<size){
                t.append(this.separator);
            }
        }
        return t.toString();
    }
}
