import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


import java.io.IOException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HtmlParser {



    private static Document getPage() throws IOException {
        String url = "https://www.pogoda.spb.ru/";
        Document page = Jsoup.parse(new URL(url),3000);
        return page;
    }

    private static Pattern pattern = Pattern.compile("\\d{2}\\.\\d{2}");

    private static String getDateFromString(String strDate) throws Exception{
        Matcher matcher = pattern.matcher(strDate);
        if (matcher.find()){
            return matcher.group();
        }
        throw new Exception("Can't extract date from String");
    }


    private static int printFourValues(Elements values, int index){// index = 0; 4; 12; 16; 20
        int iterationCount = 4;
        for (int i = 0; i < iterationCount; i++) {
            Element valueLine = values.get(index+i);// 0 + 1; 4+1 8+1; ect
            for (Element td : valueLine.select("td")) {
                System.out.print(td.text() + " ");
            }
            System.out.println();
        }
        return iterationCount; // return 4
    }


    public static void main(String[] args) throws Exception {
        Document page = getPage();
        //css query
        Element tableWth = page.select("table[class=wt]").first();
        Elements names = tableWth.select("tr[class=wth]");
        Elements values = tableWth.select("tr[valign=top]");


        int index = 0;
        for (Element name : names) {
            String dateString = name.select("th[id=dt]").text();
            String date = getDateFromString(dateString);
            System.out.println(date+"     Явления     Температура     Давл     Влажность     Ветер");
            int iterationCount = printFourValues(values,index); // here var0 = var4
            index = index + iterationCount; // first iteration = 4; second iteration = 8;
        }

    }
}
