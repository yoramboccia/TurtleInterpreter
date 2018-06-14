package turtle;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import turtle.implementations.*;
import turtle.util.Direction;
import turtle.util.Pen;
import turtle.util.Rotation;

public class TurtleInterpreter {

  private final Map<String, Turtle> turtles;
  private Paper currentPaper;
  private Scanner input;
  private PrintStream output;

  private final int ANGLE_ROTATION = 45;


  public TurtleInterpreter(Scanner input, PrintStream output) {
    this.currentPaper = new Paper(10,10);
    this.input = input;
    this.output = output;
    turtles = new HashMap<String, Turtle>();
  }

  private ClusterTurtle createCluster(String name, int size) {
    Turtle[] turtlesArray = new Turtle[size];

    for (int i = 0; i < size; i++) {

      if (!input.next().equals("new")) {
        throw new IllegalArgumentException();
      }
      String type = input.next();
      String subName = name + "." + input.next();
      Turtle subTurtle = cmdNew(type, subName);
      turtlesArray[i] = subTurtle;
      turtles.put(subName, subTurtle);
    }
    return new ClusterTurtle(turtlesArray);
  }

  public void readAndProcess() {
    while (input.hasNext()) {
      String cmd = input.next();

      switch (cmd) {
        case "paper":
          cmdPaper(input.nextInt(), input.nextInt());
          break;
        case "new":
          String type = input.next();
          String name = input.next();
          turtles.put(name, cmdNew(type, name));
          break;
        case "pen":
          cmdPen(input.next(), input.next());
          break;
        case "move":
          cmdMove(input.next(), input.nextInt());
          break;
        case "right":
          cmdRight(input.next(), input.nextInt());
          break;
        case "left":
          cmdLeft(input.next(), input.nextInt());
          break;
        case "show":
          cmdShow();
          break;
      }

    }

  }

  private void cmdPaper(int width, int height) {
    currentPaper = new Paper(width, height);
    turtles.clear();
  }

  private Turtle cmdNew(String type, String name) {
    switch (type){
      case "normal":
        return new NormalTurtle(input.nextInt(), input.nextInt(),
            Direction.NORTH, Pen.UP, currentPaper, '*');
      case "bouncy":
        return new BouncyTurtle(input.nextInt(), input.nextInt(),
            Direction.NORTH, Pen.UP, currentPaper, '*');
      case "continuous":
       return new ContinuousTurtle(input.nextInt(), input.nextInt(),
           Direction.NORTH, Pen.UP, currentPaper, '*');
      case "reflecting":
        return new ReflectingTurtle(input.nextInt(), input.nextInt(),
            Direction.NORTH, Pen.UP, currentPaper, '*');
      case "wrapping":
        return new WrappingTurtle(input.nextInt(), input.nextInt(),
            Direction.NORTH, Pen.UP, currentPaper, '*');
      case "ninja":
        return new NinjaTurtle(input.nextInt(), input.nextInt(),
            Direction.NORTH, Pen.UP, currentPaper, '*');
      case "cluster":
        return createCluster(name, input.nextInt());
      default:
          throw new IllegalArgumentException();
    }

  }

  private void cmdPen(String name, String state) {
    Turtle t = getTurtle(name);
    switch (state) {
      case "down":
        t.setPen(Pen.DOWN);
        break;
      case "up":
        t.setPen(Pen.UP);
        break;
      default:
        t.changeTurtleBrash(state.charAt(0));
        break;
    }
  }

  private void cmdMove(String name, int distance) {
    Turtle t = getTurtle(name);
    t.move(distance);
  }

  private void cmdRight(String name, int angle) {
    if (angle % ANGLE_ROTATION != 0) {
      throw new IllegalArgumentException();
    }
    Turtle t = getTurtle(name);
    t.rotateTurtle(Rotation.RIGHT, angle / ANGLE_ROTATION);
  }

  private void cmdLeft(String name, int angle) {
    if (angle % ANGLE_ROTATION != 0) {
      throw new IllegalArgumentException();
    }
    Turtle t = getTurtle(name);
    t.rotateTurtle(Rotation.LEFT, angle / ANGLE_ROTATION);
  }

  private void cmdShow() {
    output.println(currentPaper.toString());
  }

  private Turtle getTurtle(String name) {
    if (turtles.containsKey(name)) {
      return turtles.get(name);
    }
    throw new IllegalArgumentException();
  }
}
