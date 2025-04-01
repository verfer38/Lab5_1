package model;

public class Coordinates {
    private Float x;
    private Long y;
    // не  null

    @Override
    public String toString() {
        return String.format("(x=%.1f, y=%d)", x, y);
    }

    public Coordinates(Float x, Long y) {
        this.x = x;
        this.y = y;
    }

    // Геттеры (getX(), getY())
    public Float getX() { return x; }
    public Long getY() { return y; }
}

