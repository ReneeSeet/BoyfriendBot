import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class News {
    public String callWebAPI(String datasetName, String keyref) throws Exception {
        // Step 1: Construct URL
        String url = "https://newsapi.org/v1/articles?apikey=3e22f2fcc1344975ae2b2e69379e2a6e&sortBy=latest&source=bloomberg";

        // Step 2: Call API Url
        URL obj = new URL(url);
        String str;
        HttpURLConnection con = (HttpURLConnection)obj.openConnection();
        con.setRequestMethod("GET");
        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : "+ url);
        System.out.println("Response Code : "+ responseCode);
        // Step 3: Check the response status
        if(responseCode == 200) {
            // Step 3a: If response status == 200
            // print the received xml
            str = readStream(con.getInputStream());
        } else {
            // Step 3b: If response status != 200
            // print the error received from server
            str = "Error in accessing API - " +
                    readStream(con.getErrorStream());
        }
        str = parseStr(str);
        return str;
    }
    // Read the responded result
    private String readStream(InputStream inputStream) throws Exception {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(inputStream));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while((inputLine = reader.readLine()) != null) {
            response.append(inputLine);
        }
        reader.close();
        return response.toString();
    }

    private String parseStr(String str) {
//        String hello = JsonPath.read(str, "$['articles'][0]['url']");
//
//        System.out.println(hello); //prints hello
//        return hello;


        JSONObject jsonObject = null;

            /*  */
        JSONParser pars = new JSONParser();

            /*  */

        try {
            Object obj = pars.parse(str);
            jsonObject = (JSONObject) obj;

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        JSONArray arr = null;

        try {
            Object j = jsonObject.get("articles");
            arr = (JSONArray) j;
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        String temp = null;
        ArrayList<String> tempArr = new ArrayList<String>();
        for (Object t : arr) {
            temp = ((JSONObject) t).get("url").toString();
            tempArr.add(temp);
        }
        Random r = new Random();
        int choice = r.nextInt(tempArr.size());
        return tempArr.get(choice);
    }
}
