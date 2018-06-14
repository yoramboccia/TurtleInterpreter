package turtle.implementations;

import java.util.Random;
import turtle.Paper;
import turtle.util.Direction;
import turtle.util.Pen;

public class NinjaTurtle extends AbstractTurtle {

  private Random randomPosition;

  public NinjaTurtle(int x, int y, Direction direction,
      Pen pen, Paper paper, char turtleBrash) {
    super(x, y, direction, pen, paper, turtleBrash);
  }

  @Override
  protected void handleOutOfBounds(int nextX, int nextY) {

    randomPosition = new Random();

    setX(randomPosition.nextInt(getPaper().getWidth()));
    setY(randomPosition.nextInt(getPaper().getHeight()));

  }
}
