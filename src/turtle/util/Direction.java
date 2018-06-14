package turtle.util;

public enum Direction {

  NORTH, NORTH_EAST, EAST,
  SOUTH_EAST, SOUTH, SOUTH_WEST,
  WEST, NORTH_WEST;

  public Direction rotate(Rotation rotation) {
    switch (this) {
      case NORTH:
        return rotation.isLeft() ? NORTH_WEST : NORTH_EAST;
      case NORTH_EAST:
        return rotation.isLeft() ? NORTH : EAST;
      case EAST:
        return rotation.isLeft() ? NORTH_EAST : SOUTH_EAST;
      case SOUTH_EAST:
        return rotation.isLeft() ? EAST : SOUTH;
      case SOUTH:
        return rotation.isLeft() ? SOUTH_EAST : SOUTH_WEST;
      case SOUTH_WEST:
        return rotation.isLeft() ? SOUTH : WEST;
      case WEST:
        return rotation.isLeft() ? SOUTH_WEST : NORTH_WEST;
      case NORTH_WEST:
        return rotation.isLeft() ? WEST : NORTH;
      default:
        throw new IllegalArgumentException();
    }
  }


  public Direction bounce() {

    return this.rotate(Rotation.LEFT)
               .rotate(Rotation.LEFT)
               .rotate(Rotation.LEFT)
               .rotate(Rotation.LEFT);
  }
}

