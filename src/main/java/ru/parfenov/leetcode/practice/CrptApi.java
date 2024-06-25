package ru.parfenov.leetcode.practice;

import com.google.gson.Gson;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class CrptApi {

    // доделать
    /**
     * Необходимо реализовать на языке Java (можно использовать 17
     * версию) класс для работы с API Честного знака. Класс должен быть
     * thread-safe и поддерживать ограничение на количество запросов к
     * API. Ограничение указывается в конструкторе в виде количества
     * запросов в определенный интервал времени. Например:
     * public CrptApi(TimeUnit timeUnit, int requestLimit)
     * timeUnit – указывает промежуток времени – секунда, минута и пр.
     * requestLimit – положительное значение, которое определяет
     * максимальное количество запросов в этом промежутке времени.
     * При превышении лимита запрос вызов должен блокироваться,
     * чтобы не превысить максимальное количество запросов к API и
     * продолжить выполнение, без выбрасывания исключения, когда
     * ограничение на количество вызов API не будет превышено в
     * результате этого вызова. В любой ситуации превышать лимит на
     * количество запросов запрещено для метода.
     * Реализовать нужно единственный метод – Создание документа для
     * ввода в оборот товара, произведенного в РФ. Документ и подпись
     * должны передаваться в метод в виде Java объекта и строки
     * соответственно.
     * Вызывается по HTTPS метод POST следующий URL:
     * https://ismp.crpt.ru/api/v3/lk/documents/create
     * В теле запроса передается в формате JSON документ: {"description":
     * { "participantInn": "string" }, "doc_id": "string", "doc_status": "string",
     * "doc_type": "LP_INTRODUCE_GOODS", 109 "importRequest": true,
     * "owner_inn": "string", "participant_inn": "string", "producer_inn":
     * "string", "production_date": "2020-01-23", "production_type": "string",
     * "products": [ { "certificate_document": "string",
     * "certificate_document_date": "2020-01-23",
     * "certificate_document_number": "string", "owner_inn": "string",
     * "producer_inn": "string", "production_date": "2020-01-23",
     * "tnved_code": "string", "uit_code": "string", "uitu_code": "string" } ],
     * "reg_date": "2020-01-23", "reg_number": "string"}
     * При реализации можно использовать библиотеки HTTP клиента,
     * JSON сериализации. Реализация должна быть максимально
     * удобной для последующего расширения функционала.
     * Решение должно быть оформлено в виде одного файла
     * CrptApi.java. Все дополнительные классы, которые используются
     * должны быть внутренними.
     * Можно прислать ссылку на файл в GitHub.
     * В задании необходимо просто сделать вызов указанного метода,
     * реальный API не должен интересовать.
     */

    private final String API_URL = "https://ismp.crpt.ru/api/v3/lk/documents/create";
    private final TimeUnit timeUnit;
    private final int requestLimit;
    private final AtomicInteger requestCount;
    private final Object lock = new Object();

    public CrptApi(TimeUnit timeUnit, int requestLimit) {
        this.timeUnit = timeUnit;
        this.requestLimit = requestLimit;
        this.requestCount = new AtomicInteger(0);
    }

    public void createDocument(String documentJson, String signature) {
        synchronized (lock) {
            while (requestCount.get() >= requestLimit) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            sendPostRequest(documentJson, signature);
            requestCount.incrementAndGet();
            lock.notifyAll();
        }
    }

    private void sendPostRequest(String documentJson, String signature) {
        try {
            HttpClient httpClient = HttpClients.createDefault();
            HttpPost request = new HttpPost(API_URL);
            StringEntity entity = new StringEntity(documentJson);
            request.setEntity(entity);
            request.setHeader("Accept", "application/json");
            request.setHeader("Content-type", "application/json");
            HttpResponse response = httpClient.execute(request);
            BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            StringBuilder result = new StringBuilder();
            String line;
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }
            System.out.println(result.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        CrptApi api = new CrptApi(TimeUnit.SECONDS, 5);
        String document = "{\"description\" : {\"participantInn\":\"1234567890\"}, \"doc_id\":\"doc123\", \"doc_status\":\"status123\", \"doc_type\":\"LP_INTRODUCE_GOODS\"," +
                "\"importRequest\":true,\"owner_inn\":\"owner123\",\"participant_inn\":\"participant123\",\"producer_inn\":\"producer123\",\"production_date\":\"2020-01-23\"," +
                "\"production_type\":\"type123\",\"products\":[{\"certificate_document\":\"cert123\",\"certificate_document_date\":\"2020-01-23\",\"certificate_document_number\":\"cert_number123\"," +
                "\"owner_inn\":\"owner123\",\"producer_inn\":\"producer123\",\"production_date\":\"2020-01-23\",\"tnved_code\":\"tnved123\",\"uit_code\":\"uit123\",\"uitu_code\":\"uitu123\"}]," +
                "\"reg_date\":\"2020-01-23\",\"reg_number\":\"reg_number123\"}";

        String signature = "sample_signature";
        api.createDocument(document, signature);
    }
}
