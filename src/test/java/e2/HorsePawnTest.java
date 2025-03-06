package e2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class HorsePawnTest {

    private ChessPawn horse;

    @BeforeEach
    void init() {
        this.horse = new Horse(0, 0);
    }

    @Test
    void testMove() {
        this.horse.move(1, 1);
        assertEquals(1, this.horse.getX());
        assertEquals(1, this.horse.getY());
    }

    @Test
    void testLegalMove() {
        this.horse.move(2, 1);
        assertEquals(2, this.horse.getX());
        assertEquals(1, this.horse.getY());
    }

    @Test
    void testIllegalMove() {
        assertThrows(IllegalArgumentException.class, () -> this.horse.move(1, 1));
    }
}
