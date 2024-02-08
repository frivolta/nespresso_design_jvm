package nespresso.train;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class TrainTest {

    @Test
    public void passengerTrain() {
        Train train = new Train("HPP");
        assertEquals("<HHHH::|OOOO|::|OOOO|", train.print());
    }

    @Test
    public void restaurantTrain() {
        Train train = new Train("HPRP");
        assertEquals("<HHHH::|OOOO|::|hThT|::|OOOO|", train.print());
    }

    @Test
    public void cargoTrain() {
        Train train = new Train("HCCC");
        assertEquals("<HHHH::|____|::|____|::|____|", train.print());
        train.fill();
        assertEquals("<HHHH::|^^^^|::|____|::|____|", train.print());
        train.fill();
        assertEquals("<HHHH::|^^^^|::|^^^^|::|____|", train.print());
        train.fill();
        assertEquals("<HHHH::|^^^^|::|^^^^|::|^^^^|", train.print());
        assertFalse(train.fill());
    }

    @Test
    public void mixedTrain() {
        Train train = new Train("HPCPC");
        assertEquals("<HHHH::|OOOO|::|____|::|OOOO|::|____|", train.print());
        train.fill();
        assertEquals("<HHHH::|OOOO|::|^^^^|::|OOOO|::|____|", train.print());
        train.fill();
        assertEquals("<HHHH::|OOOO|::|^^^^|::|OOOO|::|^^^^|", train.print());
        assertFalse(train.fill());
    }
}