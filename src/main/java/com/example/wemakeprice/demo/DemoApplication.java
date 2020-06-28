package com.example.wemakeprice.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) throws IOException {
        String lowestProdNm = "";
        String lowestPrice = "";

        SpringApplication.run(DemoApplication.class, args);
        System.out.println("hello");

        Document doc = Jsoup.connect("https://search.shopping.naver.com/search/all?frm=NVSHATC&pagingIndex=1&pagingSize=40&productSet=total&query=%EB%85%B8%ED%8A%B8%EB%B6%81&sort=price_asc&timestamp=&viewType=list").get();
        Elements prodNm = doc.select("[class^=basicList_title] [title]");
        Elements price = doc.select("[class^=price_num]");

        for (int i = 0; i < prodNm.size(); i++) {
            //System.out.println("층수 :" + stories.get(i).html() + " \t| 아파트이름 : " + apartName.get(i).html());
            System.out.println("상품명 :" + prodNm.get(i).html() );
            if (i==0) lowestProdNm =  prodNm.get(i).html();
        }

        for (int i = 0; i < price.size(); i++) {
            //System.out.println("층수 :" + stories.get(i).html() + " \t| 아파트이름 : " + apartName.get(i).html());
            System.out.println("가격 :" + price.get(i).html() );
            if (i==0) lowestPrice =  price.get(i).html();
        }

        int data = 0;
        String res = "";
        res = "상품 : " + lowestProdNm + "\n최저가 : " + lowestPrice;
        System.out.println(res);

        try {
            File file = new File("/Users/we/Downloads/hw/hw.txt");

            // FileOutputStream 은 무조건 해당 파일을 생성한다. 존재하는 파일일 경우 덮어쓰기함.
            FileOutputStream fos = new FileOutputStream(file);
            byte[] by = res.getBytes();
            fos.write(by);
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
