package com.example.wemakeprice.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

@SpringBootTest
class DemoApplicationTests {

    @Test
    public void jsoup() {
        Document doc = null;
//        try {
//            var response = Jsoup.connect("https://www.x1fingers.me/wordpress")
//                    .timeout(20000)
//                    .execute();
//
//            if (response.statusCode() == 200) {
//                doc = response.parse();
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        System.out.println(doc.selectFirst("#profile-name").text());
    }

}
