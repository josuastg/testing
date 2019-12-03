package com.enigma.actioncommand;

public enum ActionCommand {
    CREATE_PARKING_LOT ("create_parking_lot"),
    PARK("park"),
    LEAVE("leave"),
    STATUS("status");


    private String command;

    ActionCommand(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }
}
