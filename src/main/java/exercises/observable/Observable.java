package exercises.observable;

public interface Observable {
    public void subscribe(Observer observer);
    public void unsubscribe(Observer observer);
    public void notifyObeservers(Event event);
}
