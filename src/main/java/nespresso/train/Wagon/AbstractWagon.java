package nespresso.train.Wagon;

public abstract class AbstractWagon {
    private final String wagonString;
    public AbstractWagon(String wagonString){
        this.wagonString = wagonString;
    }
    public String getWagon(){
       return wagonString;
    }
}
