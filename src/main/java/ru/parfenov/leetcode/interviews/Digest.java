package ru.parfenov.leetcode.interviews;

import java.util.HashMap;
import java.util.Map;

/**
 * Ваш коллега написал такой код и отправил его на ревью.
 * Посмотрите пожалуйста данный блок кода и перечислите все проблемы, которые вы видите: логические, архитектурные итд
 */

public abstract class Digest {

    /**
    * Данный код представляет собой шаблонный класс для работы с кэшированием результатов хэширования
    * в байтовом представлении. Он пытается поддерживать кэширование результатов вычислений,
    * чтобы избежать повторного вычисления для одних и тех же входных данных. Однако, реализация кэширования
    * не является безопасной для многопоточной среды из-за отсутствия синхронизации.
    */

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

    protected abstract byte[] doDigest(byte[] input);

}
