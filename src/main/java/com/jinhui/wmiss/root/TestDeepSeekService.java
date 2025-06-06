package com.jinhui.wmiss.root;

//import com.ecquaria.lowcode.utils.StringUtil;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.URI;
import java.net.http.HttpResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.google.gson.GsonBuilder;
import com.jinhui.pojo.DeepSeekDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class TestDeepSeekService {
    public static final Logger logger = LoggerFactory.getLogger(TestDeepSeekService.class);
    private static final GsonBuilder gson = new GsonBuilder();
    @Value(value = "${deepSeek.api.auth.key}")
    private static final String auth = "Bearer sk-b851ec1211704fdb8d6568af44b9fc2c";
    @Value(value = "${deepSeek.api.url}")
    private static final String url = "https://api.deepseek.com/chat/completions";

    public String retrieveAnswer(String userMessage ) {
        String modelName = "deepseek-reasoner";
        double temperature = 0.7;

        // 创建 HttpClient
        HttpClient client = HttpClient.newHttpClient();
        // 构造请求体(JSON)
        String requestBody = """
            {
              "model": "%s",
              "messages": [
                {"role": "system", "content": "You are a helpful assistant."},
                {"role": "user", "content": "%s"}
              ],
              "temperature": %.1f
            }
            """.formatted(modelName, userMessage, temperature);

        // 构建 HTTP 请求
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Content-Type", "application/json")
                .header("Authorization", auth)
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();

        // 发送请求并接收响应
        HttpResponse<String> response = null;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (Exception e) {
            logger.error("Error on retrieving deepSeek api response");
        }

        // 打印响应
        logger.info("Retrieving deepSeek api: response status: " + response.statusCode());
        String responseBody = response.body();
        // System.out.println("Response body: " + responseBody);
        // gson.create().fromJson(responseBody, DeepSeekDto.class);
        DeepSeekDto deepSeek = gson.create().fromJson(responseBody, DeepSeekDto.class);
        return deepSeek.getContent();
    }
}
