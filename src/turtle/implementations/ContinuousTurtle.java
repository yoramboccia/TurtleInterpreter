package turtle.implementations;

import turtle.Paper;
import turtle.util.Direction;
import turtle.util.Pen;

public class ContinuousTurtle extends AbstractTurtle {

  public ContinuousTurtle(int x, int y, Direction direction,
      Pen pen, Paper paper, char turtleBrash) {
    super(x, y, direction, pen, paper, turtleBrash);
  }

  @Override
  protected void handleOutOfBounds(int nextX, int nextY) {
    updatePos(nextX, nextY);
  }
}
