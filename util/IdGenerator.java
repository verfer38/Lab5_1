package util;

public class IdGenerator {
    private static long currentId = 0;

    // Генерация нового ID
    public static long generate() {
        return ++currentId;
    }

    // Обновление максимального ID при загрузке данных из файла
    public static void updateMaxId(long id) {
        if (id > currentId) {
            currentId = id;
        }
    }
    public static void updateCurrentId(long id) {
        if (id > currentId) {
            currentId = id;
        }
    }

    // Сброс ID (для тестов)
    public static void reset() {
        currentId = 0;
    }
}