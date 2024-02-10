package nespresso.gossip;


import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class GossipsTest {

    @Test
    public void bePropagatedByAnyMister() {
        Gossips gossips = new Gossips("Mr White", "Mr Black", "Mr Blue")
                .from("White").to("Black")
                .from("Black").to("Blue");
        gossips.say("Hello").to("White");

        assertEquals("Hello", gossips.ask("White"));

        gossips.spread();

        assertEquals("", gossips.ask("White"));
        assertEquals("Hello", gossips.ask("Black"));

        gossips.spread();

        assertEquals("", gossips.ask("Black"));
        assertEquals("Hello", gossips.ask("Blue"));


    }



}