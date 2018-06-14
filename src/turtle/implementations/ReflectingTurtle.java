package turtle.implementations;

import turtle.Paper;
import turtle.util.Direction;
import turtle.util.Pen;
import turtle.util.Rotation;

public class ReflectingTurtle extends AbstractTurtle {

  public ReflectingTurtle(int x, int y, Direction direction,
      Pen pen, Paper paper, char turtleBrash) {
    super(x, y, direction, pen, paper, turtleBrash);
  }

  @Override
  protected void handleOutOfBounds(int nextX, int nextY) {
    reflect(nextX, nextY);
    markCurrentLocation();
  }

  private void reflect(int nextX, int nextY) {
    switch (getDirection()) {
      case NORTH:
        rotateTurtle(Rotation.RIGHT, 4);
        break;
      case NORTH_EAST:
        if (nextY >= getPaper().getHeight()) {
          updatePos(nextX, nextY - 1);
          rotateTurtle(Rotation.RIGHT, 2);
          break;
        }

        if (nextX >= getPaper().getWidth()) {
          updatePos(nextX - 1, nextY);
          rotateTurtle(Rotation.LEFT, 2);
          break;
        }
        break;
      case EAST:
        rotateTurtle(Rotation.RIGHT, 4);
        break;
      case SOUTH_EAST:
        if (nextY < 0) {
          updatePos(nextX, nextY + 1);
          rotateTurtle(Rotation.LEFT, 2);
          break;
        }

        if (nextX >= getPaper().getWidth()) {
          updatePos(nextX - 1, nextY);
          rotateTurtle(Rotation.RIGHT, 2);
          break;
        }
        break;
      case SOUTH:
        rotateTurtle(Rotation.RIGHT, 4);
        break;
      case SOUTH_WEST:
        if (nextY < 0) {
          updatePos(nextX, nextY + 1);
          rotateTurtle(Rotation.RIGHT, 2);
          break;
        }

        if (nextX < 0) {
          updatePos(nextX + 1, nextY);
          rotateTurtle(Rotation.LEFT, 2);
          break;
        }
        break;
      case WEST:
        rotateTurtle(Rotation.RIGHT, 4);
        break;
      case NORTH_WEST:
        if (nextX < 0) {
          updatePos(nextX + 1, nextY);
          rotateTurtle(Rotation.RIGHT, 2);
          break;
        }

        if (nextY >= getPaper().getHeight()) {
          updatePos(nextX, nextY - 1);
          rotateTurtle(Rotation.LEFT, 2);
          break;
        }
        break;
    }

  }
}
