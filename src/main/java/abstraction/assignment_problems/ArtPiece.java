package abstraction.assignment_problems;

public abstract class ArtPiece {

    private static int pieceCounter = 1000;
    private final String pieceId;

    protected ArtPiece() {
        pieceCounter++;
        this.pieceId = "ART-" + pieceCounter;
    }

    public abstract String describe();

    public String getPieceId() {
        return pieceId;
    }
}