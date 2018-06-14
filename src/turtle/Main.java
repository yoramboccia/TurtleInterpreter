package turtle;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        TurtleInterpreter turtleInterpreter;
        if (args.length == 0) {
            turtleInterpreter =
                new TurtleInterpreter(new Scanner(System.in), System.out);
            turtleInterpreter.readAndProcess();
        } else if (args.length == 1) {
            turtleInterpreter =
                new TurtleInterpreter(new Scanner(args[0]), System.out);
            turtleInterpreter.readAndProcess();
        } else {
            PrintStream file = new PrintStream(args[1]);
            turtleInterpreter =
                new TurtleInterpreter(new Scanner(new FileInputStream
                    (args[0])), file);
            turtleInterpreter.readAndProcess();
            file.close();
        }

    }
}