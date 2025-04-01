package model;

import java.util.Date;

public class Vehicle implements Comparable<Vehicle> {
    private Long id;
    private String name;
    private Coordinates coordinates;
    private Date creationDate;
    private float enginePower;
    private VehicleType type;
    private FuelType fuelType;

    public Vehicle(String name, Coordinates coordinates, float enginePower, VehicleType type, FuelType fuelType) {
        setName(name);
        setCoordinates(coordinates);
        setEnginePower(enginePower);
        setType(type);
        setFuelType(fuelType);
        this.creationDate = new Date();
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public Coordinates getCoordinates() { return coordinates; }
    public Date getCreationDate() { return creationDate; }
    public float getEnginePower() { return enginePower; }
    public VehicleType getType() { return type; }
    public FuelType getFuelType() { return fuelType; }

    public void setId(Long id) {
        if (id == null || id <= 0) throw new IllegalArgumentException("ID должен быть > 0.");
        this.id = id;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) throw new IllegalArgumentException("Название не может быть пустым.");
        this.name = name;
    }

    public void setCoordinates(Coordinates coordinates) {
        if (coordinates == null) throw new IllegalArgumentException("Координаты не могут быть null.");
        this.coordinates = coordinates;
    }

    public void setEnginePower(float enginePower) {
        if (enginePower <= 0) throw new IllegalArgumentException("Мощность двигателя должна быть > 0.");
        this.enginePower = enginePower;
    }

    public void setType(VehicleType type) { this.type = type; }

    public void setFuelType(FuelType fuelType) {
        if (fuelType == null) throw new IllegalArgumentException("Тип топлива не может быть null.");
        this.fuelType = fuelType;
    }

    @Override
    public int compareTo(Vehicle other) {
        return this.id.compareTo(other.id);
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public String toString() {
        return String.format(
                "Vehicle[id=%d, name='%s', coordinates=%s, enginePower=%.1f, type=%s, fuelType=%s]",
                id, name, coordinates, enginePower, type, fuelType
        );
    }

    public String toCsvString() {
        return String.join(",",
                String.valueOf(id),
                name,
                String.valueOf(coordinates.getX()),
                String.valueOf(coordinates.getY()),
                String.valueOf(enginePower),
                (type == null) ? "" : type.name(),
                fuelType.name(),
                String.valueOf(creationDate.getTime())
        );
    }
}