package nespresso.gossip;

public class From {
    public String from;
    private Gossips gossips;
    public From(String name, Gossips gossips){
        this.from = name;
        this.gossips=gossips;
    }

    public Gossips to(String to){
        this.gossips.mapTo(this.from, to);
        return this.gossips;
    }
}
