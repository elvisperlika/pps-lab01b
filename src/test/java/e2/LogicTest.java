package e2;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LogicTest {

  private static final int TABLE_SIZE = 10;
  private Logics logic;

  @BeforeEach
  void init() {
    this.logic = new LogicsImpl(TABLE_SIZE);
  }

  @Test
  public void testKnightExist() {
    var knightPosition = findKnightPosition();
    assertTrue(knightPosition.isPresent());
  }

  @Test
  public void testPawnExist() {
    var pawnPosition = findPawnPosition();
    assertTrue(pawnPosition.isPresent());
  }

  @Test
  public void testLegalMoveKnight() {
    var knightPosition = findKnightPosition().get();
    var newLegalPosition = findLegalPositionsForKnight(knightPosition).get(0);
    logic.hit(newLegalPosition.getX(), newLegalPosition.getY());
    assertTrue(logic.hasKnight(newLegalPosition.getX(), newLegalPosition.getY()));
  }

  @Test
  public void testIllegalPosition() {
    var knightPosition = findKnightPosition().get();
    var illegalPosition = new Pair<>(knightPosition.getX() + 1, knightPosition.getY() + 1);
    assertFalse(logic.hasKnight(illegalPosition.getX(), illegalPosition.getY()));
  }

  @Test
  public void testKnightBeatPawn() {
    var knightPosition = findKnightPosition().get();
    var pawnPosition = findPawnPosition().get();
    int moves = 0;
    while (!logic.hasKnight(pawnPosition.getX(), pawnPosition.getY())) {
      knightPosition = findKnightPosition().get();
      var legalPositions = findLegalPositionsForKnight(knightPosition);
      var newKnightPosition = legalPositions.get(new Random().nextInt(0, legalPositions.size()));
      //var newKnightPosition = legalPositions.getFirst();
      logic.hit(newKnightPosition.getX(), newKnightPosition.getY());
      moves++;
    }
    System.out.println(moves);
    assertTrue(logic.hasKnight(pawnPosition.getX(), pawnPosition.getY()));
  }

  private List<Pair<Integer, Integer>> findLegalPositionsForKnight(Pair<Integer, Integer> knightPosition) {
    List<Pair<Integer, Integer>> legalPositions = new ArrayList<>();
    Pair<Integer, Integer> pair;

    if (isValidCoordinateValue(knightPosition.getX() + 2)) {
      if (isValidCoordinateValue(knightPosition.getY() + 1)) {

        pair = new Pair<>(knightPosition.getX() + 2, knightPosition.getY() + 1);
        legalPositions.add(pair);
      }
      if (isValidCoordinateValue(knightPosition.getY() - 1)) {

        pair = new Pair<>(knightPosition.getX() + 2, knightPosition.getY() - 1);
        legalPositions.add(pair);
      }
    }
    if (isValidCoordinateValue(knightPosition.getX() - 2)) {
      if (isValidCoordinateValue(knightPosition.getY() + 1)) {

        pair = new Pair<>(knightPosition.getX() - 2, knightPosition.getY() + 1);
        legalPositions.add(pair);
      }
      if (isValidCoordinateValue(knightPosition.getY() - 1)) {

        pair = new Pair<>(knightPosition.getX() - 2, knightPosition.getY() - 1);
        legalPositions.add(pair);
      }
    }
    if (isValidCoordinateValue(knightPosition.getY() + 2)) {
      if (isValidCoordinateValue(knightPosition.getX() + 1)) {

        pair = new Pair<>(knightPosition.getX() + 1, knightPosition.getY() + 2);
        legalPositions.add(pair);
      }
      if (isValidCoordinateValue(knightPosition.getX() - 1)) {

        pair = new Pair<>(knightPosition.getX() - 1, knightPosition.getY() + 2);
        legalPositions.add(pair);
      }
    }
    if (isValidCoordinateValue(knightPosition.getY() - 2)) {
      if (isValidCoordinateValue(knightPosition.getX() + 1)) {

        pair = new Pair<>(knightPosition.getX() + 1, knightPosition.getY() - 2);
        legalPositions.add(pair);
      }
      if (isValidCoordinateValue(knightPosition.getX() - 1)) {

        pair = new Pair<>(knightPosition.getX() - 1, knightPosition.getY() - 2);
        legalPositions.add(pair);
      }
    }

    return legalPositions;
  }

  private boolean isValidCoordinateValue(int i) {
    return i >= 0 && i < TABLE_SIZE;
  }

  private Optional<Pair<Integer, Integer>> findPawnPosition() {
    for (int i = 0; i < TABLE_SIZE; i++) {
      for (int j = 0; j < TABLE_SIZE; j++) {
        if (logic.hasPawn(i, j)) {
          return Optional.of(new Pair<>(i, j));
        }
      }
    }
    return Optional.empty();
  }

  private Optional<Pair<Integer, Integer>> findKnightPosition() {
    for (int i = 0; i < TABLE_SIZE; i++) {
      for (int j = 0; j < TABLE_SIZE; j++) {
        if (logic.hasKnight(i, j)) {
          return Optional.of(new Pair<>(i, j));
        }
      }
    }
    return Optional.empty();
  }
}
