package parse;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class ViaSearchAndCollection {

    public static void main(String[] args) throws IOException {


        parse();

    }

    public static void parse() throws IOException {

        Document document =
                Jsoup.connect("http://www.shopbookshop.com/collections/books").get();


        String[] data = new String[document.select("span.grid-product__title").size()];

        for (int i = 0; i < document.select("span.grid-product__title").size(); i++) {
            data[i] = document.select("span.grid-product__title").get(i).text().split("by")[1];
        }
        for (String s : data) {
            System.out.println(s);
        }


    }
}