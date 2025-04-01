package collection;

import model.*;
import util.IdGenerator;

import java.io.*;
import java.util.*;

public class CsvProcessor {
    // чтение  из CSV
    public static ArrayDeque<Vehicle> readFromCsv(String filename) throws IOException {
        ArrayDeque<Vehicle> vehicles = new ArrayDeque<>();
        File file = new File(filename);

        // проверка на дурака
        if (!file.exists()) {
            throw new FileNotFoundException("Файл не найден: " + filename);
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length < 7) {
                    throw new IOException("Некорректный формат строки: " + line);
                }

                // парсим данные
                long id = Long.parseLong(data[0]);
                String name = data[1];
                Float x = Float.parseFloat(data[2]);
                Long y = Long.parseLong(data[3]);
                float enginePower = Float.parseFloat(data[4]);
                VehicleType type = data[5].isEmpty() ? null : VehicleType.valueOf(data[5]);
                FuelType fuelType = FuelType.valueOf(data[6]);

                Vehicle vehicle = new Vehicle(name, new Coordinates(x, y), enginePower, type, fuelType);
                vehicle.setId(id);
                vehicles.add(vehicle);
            }
        }
        return vehicles;
    }
    //  в CSV
    public static void saveToCsv(String filename, ArrayDeque<Vehicle> vehicles) throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            for (Vehicle v : vehicles) {
                writer.println(v.toCsvString());
            }
        }
    }

    private static long parseLong(String s) throws IOException {
        try {
            return Long.parseLong(s);
        } catch (NumberFormatException e) {
            throw new IOException("Некорректное число: " + s);
        }
    }

    private static Float parseFloat(String s) throws IOException {
        try {
            return Float.parseFloat(s);
        } catch (NumberFormatException e) {
            throw new IOException("Некорректное число: " + s);
        }
    }

    private static VehicleType parseVehicleType(String s) throws IOException {
        if (s.isEmpty()) return null;
        try {
            return VehicleType.valueOf(s);
        } catch (IllegalArgumentException e) {
            throw new IOException("Некорректный тип транспорта: " + s);
        }
    }

    private static FuelType parseFuelType(String s) throws IOException {
        try {
            return FuelType.valueOf(s);
        } catch (IllegalArgumentException e) {
            throw new IOException("Некорректный тип топлива: " + s);
        }
    }
}