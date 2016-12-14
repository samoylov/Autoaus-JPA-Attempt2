package parse;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

public class ViaSearch {

    public static void main(String[] args) throws IOException {


        parse();

    }

    public static void parse() throws IOException {

        Document document =
                Jsoup.connect("https://auto.ru/catalog/").get();


        for (Element element : document.select("a.search-form-v2-item")) {
            System.out.println(element.text());
        }

        System.out.println(document.select("a.search-form-v2-item")
                .text());

    }


}