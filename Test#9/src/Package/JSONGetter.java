package Package;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;

//@JsonIgnoreProperties(ignoreUnknown = true)
public class JSONGetter extends Thread {
    public String jsonIn;
    public static String url;
    private String outJson;

    //Считывание данных из API
    private String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    public String ConnectAndGetData() {
        jsonIn = "";
        InputStream is = null;
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection)new URL(url).openConnection();
            is = httpURLConnection.getInputStream();

            try {
                BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
                try {
                    jsonIn = readAll(rd);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } finally {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonIn;
    }
    @Override
    public void run(){
        outJson = ConnectAndGetData();
        super.run();
    }
    public String getOutJson() {
        return outJson;
    }
}