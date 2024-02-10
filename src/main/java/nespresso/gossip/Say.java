package nespresso.gossip;

public class Say {
    public String what;
    public String to;
    public Gossips gossips;

    Say(String what, Gossips gossips){
        this.to="";
        this.what=what;
        this.gossips=gossips;
    }

    public Gossips to(String who){
        this.to=who;
        this.gossips.mapSay(this.to, this.what);
        return this.gossips;
    }
}
