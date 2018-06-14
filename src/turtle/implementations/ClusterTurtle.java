package turtle.implementations;

import turtle.Turtle;
import turtle.util.Pen;
import turtle.util.Rotation;

public class ClusterTurtle implements Turtle {

  private Turtle[] turtles;

  public ClusterTurtle(Turtle[] turtles) {
    this.turtles = turtles;
  }


  @Override
  public void setPen(Pen state) {
    for (Turtle turtle : turtles) {
      turtle.setPen(state);
    }
  }

  @Override
  public void changeTurtleBrash(char c) {
    for (Turtle turtle : turtles) {
      turtle.changeTurtleBrash(c);
    }
  }

  @Override
  public void rotateTurtle(Rotation r, int times) {
    for (Turtle turtle : turtles) {
      turtle.rotateTurtle(r, times);
    }

  }

  @Override
  public void markCurrentLocation() {
    for (Turtle turtle : turtles) {
      turtle.markCurrentLocation();
    }

  }

  @Override
  public void move(int numberOfSteps) {
    for (Turtle turtle : turtles) {
      turtle.move(numberOfSteps);
    }

  }
}
