package turtle.implementations;

import turtle.Paper;
import turtle.util.Direction;
import turtle.util.Pen;

public class WrappingTurtle extends AbstractTurtle {

  public WrappingTurtle(int x, int y, Direction direction,
      Pen pen, Paper paper, char turtleBrash) {
    super(x, y, direction, pen, paper, turtleBrash);
  }

  @Override
  protected void handleOutOfBounds(int nextX, int nextY) {
    int width = getPaper().getWidth();
    int height = getPaper().getHeight();

    updatePos((nextX % width + width) % width,
        (nextY % height + height) % height);
    markCurrentLocation();

  }
}
