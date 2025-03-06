package e2;

public class Soldier implements ChessPawn {

    private int y;
    private int x;

    public Soldier(int newX, int newY) {
        this.x = newX;
        this.y = newY;
    }

    @Override
    public void move(int newX, int newY) {
        if (!isLegalMove(newX, newY)) {
            throw new IllegalArgumentException();
        }
        this.x = newX;
        this.y = newY;
    }

    private boolean isLegalMove(int newX, int newY) {
        // in fact is a legal move also to move on x+1 and y+1 if there is an enemy in that position
        return newY == this.y + 1;
    }

    @Override
    public int getX() {
        return this.x;
    }

    @Override
    public int getY() {
        return this.y;
    }
}
