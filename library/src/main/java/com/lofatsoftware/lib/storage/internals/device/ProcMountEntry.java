package com.lofatsoftware.lib.storage.internals.device;

public class ProcMountEntry {

    private static final String SPLIT_CHAR = " ";
    private static final int MIN_NUMBER_OF_TILES = 6;

    String device;
    String mountPoint;
    String fileSystemType;
    String options;

    ProcMountEntry( String device, String mountPoint, String fileSystemType, String options ) {
        this.device = device;
        this.mountPoint = mountPoint;
        this.fileSystemType = fileSystemType;
        this.options = options;
    }

    static ProcMountEntry getInstance( String lineToParse ) {
        if ( lineToParse == null ) {
            return null;
        }
        String[] tiles = lineToParse.split( SPLIT_CHAR );
        if ( tiles.length < MIN_NUMBER_OF_TILES ) {
            return null;
        }
        return new ProcMountEntry( tiles[0], tiles[1], tiles[2], tiles[3] );
    }

    @Override
    public String toString() {
        return device + " "
                + mountPoint + " "
                + fileSystemType + " "
                + mountPoint;
    }
}
