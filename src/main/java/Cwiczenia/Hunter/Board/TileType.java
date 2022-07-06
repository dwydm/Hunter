package Cwiczenia.Hunter.Board;

public enum TileType {
    FLOOR(true),
    HEDGE(true),
    WALL(false);

    private final boolean traversable;

    TileType(boolean traversable) {
        this.traversable = traversable;
    }

    public boolean isTraversable(){
        return traversable;
    }
}
