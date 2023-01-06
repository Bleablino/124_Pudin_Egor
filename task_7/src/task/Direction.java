package task;

public enum Direction { North ("North"), West("West"), South("South"), East("East");
    private final String direct;
    Direction(String direct){
        this.direct = direct;
    }
    public Vector2 move (Vector2 start, double distance) {
        double startX = start.getX();
        double startY = start.getY();
        switch (direct) {
            case "North" -> {
                startY = startY-distance;
                return new Vector2(startX,startY);
            }
            case "West" -> {
                startX = startX-distance;
                return new Vector2(startX,startY);
            }
            case "South" -> {
                startY = startY+distance;
                return new Vector2(startX,startY);
            }
            case "East" -> {
                startX = startX+distance;
                return new Vector2(startX,startY);
            }
        }return start;
    }
}