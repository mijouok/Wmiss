package com.jinhui.wmiss.root;

//import com.ecquaria.lowcode.utils.StringUtil;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.URI;
import java.net.http.HttpResponse;
import java.util.Scanner;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jinhui.wmiss.entity.DeepSeekDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class TestDeepSeekService {
    public static final Logger logger = LoggerFactory.getLogger(TestDeepSeekService.class);
    private static final GsonBuilder gson = new GsonBuilder();

    public static void main(String[] args) throws IOException, InterruptedException {
        String userMessage;
        System.out.print("Enter your content: ");
        userMessage = new Scanner(System.in).nextLine();
        while(!StringUtils.isBlank(userMessage) && !userMessage.equals("Exit.")) {
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
                    .uri(URI.create("https://api.deepseek.com/chat/completions"))
                    .header("Content-Type", "application/json")
                    .header("Authorization", "Bearer sk-b851ec1211704fdb8d6568af44b9fc2c")
                    .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                    .build();

            // 发送请求并接收响应
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // 打印响应
            System.out.println("Status code: " + response.statusCode());
            String responseBody = response.body();
            // System.out.println("Response body: " + responseBody);
            // gson.create().fromJson(responseBody, DeepSeekDto.class);
            DeepSeekDto deepSeek = gson.create().fromJson(responseBody, DeepSeekDto.class);
            //DeepSeekDto deepSeekDto = JSON.parse(responseBody,DeepSeekDto.class);
            if (responseBody.contains("\"Insufficient Balance\"")) {
                System.err.println("Error: The request failed due to insufficient account balance.");
            }
            System.out.println("Response body: " + responseBody);
            System.out.println("Response content: " + deepSeek.getContent() );
            System.out.println("Response reason content: " + deepSeek.getReasonContent() );
            System.out.print("Enter your content: ");
            userMessage = new Scanner(System.in).nextLine();
        }
    }
}
