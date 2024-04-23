package ru.parfenov.leetcode.interviews;

import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

public abstract class Digest {

    /*
    * Ревью кода
    * Перечислить все проблемы, которые видите. На что похож этот код?
    *
    * Данный код представляет собой шаблонный класс для работы с кэшированием результатов хэширования
    * в байтовом представлении. Он пытается поддерживать кэширование результатов вычислений,
    * чтобы избежать повторного вычисления для одних и тех же входных данных. Однако, реализация кэширования
    * не является безопасной для многопоточной среды из-за отсутствия синхронизации.
    * */

    // 1 byte[] в качестве ключа, 2 final, 3 byte[], byte[]
    private Map<byte[], byte[]> cache = new HashMap<byte[], byte[]>();
    // Доступ к кэшу не синхронизирован
    // Смешивание логики кэширования и вычисления хэша
    public byte[] digest(byte[] input) {
        byte[] result = cache.get(input);
        if (result == null) {
            synchronized (cache) {
                result = cache.get(input);
                if (result == null) {
                    result = doDigest(input);
                    cache.put(input, result);
                }
            }
        }
        return result;
    }

    // Исправленный метод
    private final Map<ByteBuffer, byte[]> cache2 = new HashMap<>();
    public synchronized byte[] digest2(byte[] input) {
        byte[] result = cache2.get(ByteBuffer.wrap(input)); // ByteBuffer, чтобы гарантировать правильное сравнение байтовых массивов
        if (result == null) {
            result = doDigest(input);
            cache2.put(ByteBuffer.wrap(input), result); // ByteBuffer.wrap удобен для передачи байтовых данных в методы, которые ожидают объекты класса
        }
        return result;
    }

    // Использование неопределенной реализации doDigest(), лучше написать реализацию
    protected abstract byte[] doDigest(byte[] input);

    public static void main(String[] args) {}

}
