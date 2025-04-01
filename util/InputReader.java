package util;

import model.Coordinates;
import model.FuelType;
import model.Vehicle;
import model.VehicleType;
import java.util.Scanner;

public class InputReader {
    private static Scanner scanner = new Scanner(System.in);

    public static Scanner getScanner() {
        return scanner;
    }

    public static void setScanner(Scanner newScanner) {
        scanner = newScanner;
    }

    /**
     * Чтение строки с выводом подсказки.
     * @param prompt Приглашение для ввода (например, "Введите название: ").
     * @return Введенная строка (не может быть пустой или null).
     */


    public static String readString(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            if (!input.isEmpty()) {
                return input;
            }
            System.out.println("Ошибка: поле не может быть пустым.");
        }
    }



    /**
     * Чтение числа типа float.
     * @param prompt Приглашение для ввода (например, "Введите мощность двигателя: ").
     * @return Число > 0.
     */
    public static float readFloat(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                float value = Float.parseFloat(scanner.nextLine());
                if (value <= 0) throw new IllegalArgumentException();
                return value;
            } catch (Exception e) {
                System.out.println("Ошибка: введите число > 0.");
            }
        }
    }

    /**
     * Чтение значения перечисления (enum).
     * @param enumClass Класс перечисления(FuelType.class).
     * @param prompt Приглашение для ввода.
     * @return Значение перечисления (не null).
     */
    public static <T extends Enum<T>> T readEnum(Class<T> enumClass, String prompt) {
        while (true) {
            try {
                System.out.println(prompt + " Доступные варианты: " + String.join(", ", getEnumNames(enumClass)));
                String input = scanner.nextLine().trim().toUpperCase();
                if (input.isEmpty() && enumClass == VehicleType.class) {
                    return null; // VehicleType может быть null
                }
                return Enum.valueOf(enumClass, input);
            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка: некорректное значение.");
            }
        }
    }

    /**
     * Чтение координат (x и y).
     */
    public static Coordinates readCoordinates() {
        Float x = readFloat("Введите координату X: ");
        Long y = readLong("Введите координату Y: ");
        return new Coordinates(x, y);
    }

    /**
     * Чтение всех полей Vehicle (кроме id и creationDate).
     */
    public static Vehicle readVehicle() {
        String name = readString("Введите название: ");
        Coordinates coordinates = readCoordinates();
        float enginePower = readFloat("Введите мощность двигателя: ");
        VehicleType type = readEnum(VehicleType.class, "Введите тип транспорта (PLANE/BOAT/MOTORCYCLE/HOVERBOARD): ");
        FuelType fuelType = readEnum(FuelType.class, "Введите тип топлива: ");
        return new Vehicle(name, coordinates, enginePower, type, fuelType);
    }

    // Вспомогательные методы
    private static <T extends Enum<T>> String[] getEnumNames(Class<T> enumClass) {
        T[] constants = enumClass.getEnumConstants();
        String[] names = new String[constants.length];
        for (int i = 0; i < constants.length; i++) {
            names[i] = constants[i].name();
        }
        return names;
    }

    private static Long readLong(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Long.parseLong(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: введите целое число.");
            }
        }
    }
}