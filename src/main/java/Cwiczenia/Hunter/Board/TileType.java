package Cwiczenia.Hunter.Board;

public enum TileType {
    FLOOR(true, "[ ]"),
    HEDGE(true, "[#]"),
    WALL(false, "[=]");

    private final boolean traversable;
    private final String boardMark;

    TileType(boolean traversable, String boardMark) {
        this.traversable = traversable;
        this.boardMark = boardMark;
    }

    public boolean isTraversable() {
        return traversable;
    }

    public String getBoardMark() {
        return boardMark;
    }
}
