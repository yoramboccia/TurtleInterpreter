package turtle;

public class Paper {

  private char[][] grid;
  private final char EMPTY_CHAR = '\u0000';

  public Paper(int width, int height) {
    if (width < 0 || height < 0) {
      throw new IllegalArgumentException();
    }
    grid = new char[height][width];
  }

  public int getWidth() {
    return grid[0].length;
  }

  public int getHeight() {
    return grid.length;
  }

  public boolean isInBound(int x, int y) {
    return x < getWidth() && x >= 0 &&
           y < getHeight() && y >= 0;
  }

  public void markLocation(int x, int y, char c) {
    if (isInBound(x, y)) {
      grid[y][x] = c;
    }
  }

  @Override
  public String toString() {
    StringBuilder output = new StringBuilder();
    for (int y = grid.length - 1; y >= 0; y--) {
      for (int x = 0; x < grid[y].length; x++) {
        if (grid[y][x] == EMPTY_CHAR) {
          output.append(' ');
        } else {
          output.append(grid[y][x]);
        }
      }
      output.append('\n');
    }
    return output.toString();
  }
}
