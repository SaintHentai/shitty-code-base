
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.net.*;
import java.util.*;

public class Test {

    static List<String> glns = new ArrayList<>();
    static List<String> hash = new ArrayList<>();
    static Core core = new Core();

    public static void init(){
        String resUrl = "";
        try {
            URL url = new URL("https://leradata.pro/supp/artyomus/dbreqsql.php");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            StringBuilder postData = new StringBuilder("inmul=select varGln from leradata_glns where varGln LIKE '98798700%'");
            OutputStream os = connection.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os,"UTF-8");
            osw.write(String.valueOf(postData));
            osw.flush();
            osw.close();
            connection.getResponseCode();
            resUrl = connection.getURL().toString();
            connection.disconnect();

            Document doc = Jsoup.parse(new URL(resUrl),3000);
            Element table = doc.select("table").first();
            Elements rows = table.select("tr");
            for (int i = 1; i < rows.size(); i++) {
                Element row = rows.get(i);
                Elements cols = row.select("td");
                glns.add(cols.get(0).text());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Collections.sort(glns);
    }

    static void getNonExistentGlns(int in){
        List<String> input = core.createdListGln(in);
        if (hash.size() != in) {
            for (int i = 0; i < in; i++) {
                if (!glns.contains(input.get(i)) && !hash.contains(input.get(i))) {
                    hash.add(input.get(i));
                }else {
                    getNonExistentGlns(in);
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        //init();
        //getNonExistentGlns(10);
        //System.out.println(hash);

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {

            }
        }

        /*Thread run = new Thread(new Runnable() {
            int count = 0;
            boolean flag = true;
            @Override
            public void run() {
                while(flag){
                    try {
                        System.out.println("Request " + count);
                        init();
                        getNonExistentGlns(2);
                        System.out.println("result request " + hash);
                        count++;
                        if (count==2) flag = false;
                        Thread.sleep(30 * 1000); //1000 - 1 сек
                    } catch (InterruptedException ex) {
                    }
                }
            }
        });
        run.start(); // заводим*/

        //System.out.println(test(100));

        /*StringBuilder response = new StringBuilder();
        List<String> glns = new ArrayList<>();
        try {
            URL url = new URL("https://leradata.pro/supp/artyomus/dbreqsql.php");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            StringBuilder postData = new StringBuilder("inmul=select varGln from leradata_glns");

            OutputStream os = connection.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os,"UTF-8");
            osw.write(String.valueOf(postData));
            osw.flush();
            osw.close();

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();
            } else {
                System.out.println("Запрос завершился неудачей. Код ответа: " + responseCode);
            }
            connection.disconnect();
            System.out.println(response.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }*/
    }
}
