package kr.board.controller;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class WeatherAPI {
    public static void main(String[] args) {
        String apiKey = "a54a36319b90f654c4c8fd41d472693b";
        String city = "Seoul";
        String urlString = "https://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + apiKey + "&units=metric";

        try {
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept", "application/json");

            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();
            System.out.println(content.toString());
            // Gson 라이브러리를 사용하여 온도를 추출
            JsonObject weatherData = JsonParser.parseString(content.toString()).getAsJsonObject();
            JsonObject mainData = weatherData.getAsJsonObject("main");
            double temp = mainData.get("temp").getAsDouble();
            
            // 서울의 온도 출력
            System.out.println("Seoul's temperature: " + temp + "℃");

            connection.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

