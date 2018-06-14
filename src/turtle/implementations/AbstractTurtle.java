package turtle.implementations;

import turtle.Paper;
import turtle.Turtle;
import turtle.util.*;

public abstract class AbstractTurtle implements Turtle {

  private int x;
  private int y;
  private Direction direction;
  private Pen pen;
  private Paper paper;
  private char turtleBrush;

  public AbstractTurtle(int x, int y, Direction direction, Pen pen, Paper paper,
      char turtleBrush) {
    this.x = x;
    this.y = y;
    this.direction = direction;
    this.pen = pen;
    this.paper = paper;
    this.turtleBrush = turtleBrush;
  }

  public Pen getPen() {
    return pen;
  }

  @Override
  public void setPen(Pen state) {
    pen = state;
  }

  @Override
  public void changeTurtleBrash(char c) {
    turtleBrush = c;

  }

  @Override
  public void rotateTurtle(Rotation r, int times) {
    for (int i = 0; i < times; i++) {
      direction = direction.rotate(r);
    }
  }

  @Override
  public void markCurrentLocation() {
    if (paper.isInBound(x, y) && pen.equals(Pen.DOWN)) {
      paper.markLocation(x, y, turtleBrush);
    }
  }

  public void setX(int x) {
    this.x = x;
  }

  public void setY(int y) {
    this.y = y;
  }

  @Override
  public void move(int numberOfSteps) {
    for (int i = 0; i < numberOfSteps; i++) {
      int nextY = y;
      int nextX = x;

      switch (direction) {
        case NORTH:
          nextY = y + 1;
          break;
        case NORTH_EAST:
          nextX = x + 1;
          nextY = y + 1;
          break;
        case EAST:
          nextX = x + 1;
          break;
        case SOUTH_EAST:
          nextX = x + 1;
          nextY = y - 1;
          break;
        case SOUTH:
          nextY = y - 1;
          break;
        case SOUTH_WEST:
          nextY = y - 1;
          nextX = x - 1;
          break;
        case WEST:
          nextX = x - 1;
          break;
        case NORTH_WEST:
          nextY = y + 1;
          nextX = x - 1;
          break;
      }

      if (!(paper.isInBound(nextX, nextY))) {
        handleOutOfBounds(nextX, nextY);
        continue;
      }

      updatePos(nextX, nextY);
      markCurrentLocation();
    }
  }


  public void updatePos(int nextX, int nextY) {
    x = nextX;
    y = nextY;
  }

  protected abstract void handleOutOfBounds(int nextX, int nextY);

  public void setDirection(Direction direction) {
    this.direction = direction;
  }

  public Direction getDirection() {
    return direction;
  }

  public Paper getPaper() {
    return paper;
  }
}

