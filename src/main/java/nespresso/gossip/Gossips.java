package nespresso.gossip;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Gossips {
    private final Map<Person, Person> fromTo;
    private Map<Person, Message> gossips;

    public Gossips(String ...args){
        this.fromTo=new HashMap<>();
        this.initGossips(args);
    }
    public Person getPersonFromGossipsByName(String name) {
        for (Person person : gossips.keySet()) {
            if (person.getName().equals(name)) {
                return person;
            }
        }
        return null;
    }
    private void initGossips(String ...args){
        Map<Person, Message> newGossips = new HashMap<>();
        for(String arg:args){
            newGossips.put(new Person(arg), new Message(""));
        }
        this.gossips = newGossips;
    }

    public From from(String name){
        From from = new From(name, this);
        return from;
    }

    public void mapTo(String from, String to){
        Person pFrom = this.getPersonFromGossipsByName(from);
        Person pTo = this.getPersonFromGossipsByName(to);
        this.fromTo.put(pFrom, pTo);
    }

    public Say say(String what){
        Say say=new Say(what, this);
        return say;
    }

    public void mapSay(String who, String what){
        Person pWho = this.getPersonFromGossipsByName(who);
        this.gossips.put(pWho, new Message(what));
    }

    public String ask(String who){
        Person pWho = this.getPersonFromGossipsByName(who);
        return this.gossips.get(pWho).getMessage();
    }
    public void spread(){
        List<Person> hasReceived = new ArrayList<>();

        fromTo.forEach((k,v)->{
            // only if has not just got a message
            if(!hasReceived.contains(k)) {
                // take message
                Message m = this.gossips.get(k);
                // message from starter is removed
                this.gossips.put(k, new Message(""));
                // tell the message to the receiver
                this.gossips.put(v, m);
                // ensure that will not spread until next spread
                hasReceived.add(k);
                // remove the from fromTo so it will skip next time
            }
        });

    }
}
