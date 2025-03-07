package e2;

import java.util.Random;

public class LogicsImpl implements Logics {

    private final ChessPawn soldier;
    private ChessPawn knight;
    private final Random random = new Random();
    private final int size;

    public LogicsImpl(int size) {
        this.size = size;
        var randomSoldierPosition = this.randomEmptyPosition();
        this.soldier = new Soldier(randomSoldierPosition.getX(), randomSoldierPosition.getY());
        var randomKnightPosition = this.randomEmptyPosition();
        this.knight = new Horse(randomKnightPosition.getX(), randomKnightPosition.getY());
    }

    private final Pair<Integer, Integer> randomEmptyPosition() {
        Pair<Integer, Integer> pos = new Pair<>(this.random.nextInt(size), this.random.nextInt(size));
        // the recursive call below prevents clash with an existing pawn
        return this.soldier != null &&
                (this.soldier.getX() == pos.getX() && this.soldier.getY() == pos.getY())
                ? randomEmptyPosition()
                : pos;
    }

    @Override
    public boolean hit(int row, int col) {
        if (row < 0 || col < 0 || row >= this.size || col >= this.size) {
            throw new IndexOutOfBoundsException();
        }
        // Below a compact way to express allowed moves for the knight
        int x = row - this.knight.getX();
        int y = col - this.knight.getY();
        if (x != 0 && y != 0 && Math.abs(x) + Math.abs(y) == 3) {
            this.knight.move(row, col);
            return checkWin();
        }
        return false;
    }

    @Override
    public boolean hasKnight(int row, int col) {
        return this.knight.getX() == row && this.knight.getY() == col;
    }

    @Override
    public boolean hasPawn(int row, int col) {
        return this.soldier.getX() == row && this.soldier.getY() == col;
    }

    private boolean checkWin() {
        return this.knight.getX() == this.soldier.getX() && this.knight.getY() == this.soldier.getY();
    }



}
