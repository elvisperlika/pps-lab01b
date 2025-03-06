package e2;

public class Horse implements ChessPawn {

    private int x;
    private int y;
    public Horse(int newX, int newY) {
        this.x = newX;
        this.y = newY;
    }

    @Override
    public void move(int newX, int newY) {
        if (!isLegalMove(newX, newY)) {
            throw new IllegalArgumentException("Illegal Move");
        }
        this.x = newX;
        this.y = newY;
    }

    private boolean isLegalMove(int newX, int newY) {
        if (newX == x + 2 || newX == x - 2) {
            return newY == y + 1 || newY == y - 1;
        }
        if (newY == y + 2 || newY == y - 2) {
            return newX == x + 1 || newX == x - 1;
        }
        return false;
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
