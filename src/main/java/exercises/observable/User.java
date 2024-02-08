package exercises.observable;

public class User implements Observer {
    @Override
    public void update(Event event) {
        System.out.printf("a new event has arrived " + event.getEvent() + "%n");
    }
}
