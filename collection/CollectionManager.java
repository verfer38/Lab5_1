package collection;

import model.Vehicle;
import model.VehicleType;
import util.IdGenerator;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Date;
import java.util.stream.Collectors;

public class CollectionManager {
    private ArrayDeque<Vehicle> vehicles = new ArrayDeque<>();
    private final Date initializationDate = new Date();
    
    public void initialize(ArrayDeque<Vehicle> loadedVehicles) {
        vehicles = loadedVehicles;
        long maxId = vehicles.stream()
                .mapToLong(Vehicle::getId)
                .max()
                .orElse(0);
        IdGenerator.updateCurrentId(maxId);
        sortCollection();
    }

    public void add(Vehicle vehicle) {
        vehicle.setId(IdGenerator.generate());
        vehicles.add(vehicle);
        sortCollection();
    }

    public boolean removeById(Long id) {
        boolean isRemoved = vehicles.removeIf(v -> v.getId().equals(id));
        if (isRemoved) sortCollection();
        return isRemoved;
    }

    public Vehicle getById(long id) {
        return vehicles.stream()
                .filter(v -> v.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public void update(Vehicle oldVehicle, Vehicle newVehicle) {
        vehicles.remove(oldVehicle);
        vehicles.add(newVehicle);
        sortCollection();
    }

    public void clear() {
        vehicles.clear();
    }

    public Vehicle getMax() {
        return vehicles.stream()
                .max(Comparator.naturalOrder())
                .orElse(null);
    }

    public int removeLower(Vehicle reference) {
        int initialSize = vehicles.size();
        vehicles.removeIf(v -> v.compareTo(reference) < 0);
        return initialSize - vehicles.size();
    }

    public long countLessThanType(VehicleType type) {
        return vehicles.stream()
                .filter(v -> v.getType() != null && v.getType().ordinal() < type.ordinal())
                .count();
    }

    private void sortCollection() {
        vehicles = vehicles.stream()
                .sorted()
                .collect(Collectors.toCollection(ArrayDeque::new));
    }

    public ArrayDeque<Vehicle> getVehicles() { return vehicles; }
    public String getCollectionType() { return "ArrayDeque<Vehicle>"; }
    public Date getInitializationDate() { return initializationDate; }
    public int getSize() { return vehicles.size(); }
}