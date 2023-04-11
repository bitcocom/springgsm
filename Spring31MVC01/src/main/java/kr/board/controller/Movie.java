package kr.board.controller;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Movie {
    public static void main(String[] args) {
        String urlString = "https://movie.naver.com/movie/bi/mi/pointWriteFormList.naver?code=81888&page=1";

        try {
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String inputLine;

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                Document doc = Jsoup.parse(response.toString());
                Elements scores = doc.select("div.score_result div.star_score em");
                Elements reviews = doc.select("div.score_reple p");

                for (int i = 0; i < scores.size(); i++) {
                    String score = scores.get(i).text();
                    String review = reviews.get(i).text();

                    // Remove '관람객' label from the review text if it exists
                    if (review.startsWith("관람객")) {
                        review = review.substring(3).trim();
                    }

                    System.out.println("평점: " + score);
                    System.out.println("리뷰: " + review);
                    System.out.println();
                }
            } else {
                System.out.println("GET request failed. Response code: " + responseCode);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
