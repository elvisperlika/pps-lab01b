package e2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SoldierPawnTest {

    private ChessPawn soldier;

    @BeforeEach
    void init() {
        this.soldier = new Soldier(0, 0);
    }

    @Test
    void testLegalMove() {
        this.soldier.move(0, 1);
        assertEquals(0, this.soldier.getX());
        assertEquals(1, this.soldier.getY());
    }

    @Test
    void testIllegalMove() {
        assertThrows(IllegalArgumentException.class, () -> this.soldier.move(3, 2));
    }
}
