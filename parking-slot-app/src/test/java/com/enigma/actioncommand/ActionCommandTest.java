package com.enigma.actioncommand;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ActionCommandTest {

    @Test
    public void commandCreateParkingLot_should_be_return_correct_value(){
        Assert.assertEquals(ActionCommand.CREATE_PARKING_LOT, ActionCommand.valueOf("CREATE_PARKING_LOT"));
    }

    @Test
    public void commandPark_should_be_return_correct_value(){
        Assert.assertEquals(ActionCommand.PARK, ActionCommand.valueOf("PARK"));
    }
    @Test
    public void commandLeave_should_be_return_correct_value(){
        Assert.assertEquals(ActionCommand.LEAVE, ActionCommand.valueOf("LEAVE"));
    }
    @Test
    public void commandStatus_should_be_return_correct_value(){
        Assert.assertEquals(ActionCommand.STATUS, ActionCommand.valueOf("STATUS"));
    }

    @Test
    public void commandCreateParkingLotGetValue_should_be_return_correct_value(){
        Assert.assertEquals(ActionCommand.CREATE_PARKING_LOT.getCommand(), ActionCommand.valueOf("CREATE_PARKING_LOT").getCommand());
    }
}