package exercises.observable;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ProductObservable implements Observable{
    private ArrayList<Observer> observers = new ArrayList<>();

    @Override
    public void subscribe(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void unsubscribe(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObeservers(Event event) {
        for(Observer observer:observers){
            observer.update(event);
        }
    }

    public void productHasArrived(){
        Event e = new Event("PRODUCT", "Product has arrived");
        notifyObeservers(e);
    }
}
