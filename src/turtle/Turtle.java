package turtle;

import turtle.util.Pen;
import turtle.util.Rotation;

public interface Turtle {

    void setPen(Pen state);

    void changeTurtleBrash(char c);

    void rotateTurtle(Rotation r, int times);

    void markCurrentLocation();

    void move(int numberOfSteps);


}
