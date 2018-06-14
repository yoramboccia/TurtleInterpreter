package turtle.implementations;

import turtle.Paper;
import turtle.util.Direction;
import turtle.util.Pen;

public class NormalTurtle extends AbstractTurtle {

  public NormalTurtle(int x, int y, Direction direction,
      Pen pen, Paper paper, char turtleBrash) {
    super(x, y, direction, pen, paper, turtleBrash);
  }

  @Override
  protected void handleOutOfBounds(int nextX, int nextY) {
    markCurrentLocation();
  }

}
