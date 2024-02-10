package nespresso.gossip;

public class Message {
    private final String message;
    Message(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

