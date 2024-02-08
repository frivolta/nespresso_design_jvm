package exercises.observable;

public class Event {
    private String event;

    public Event(String channel, String event) {
        this.event = event;
    }


    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }
}
