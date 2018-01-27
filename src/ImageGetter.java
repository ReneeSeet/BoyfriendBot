
import java.net.*;
import java.io.*;

public class ImageGetter {


    public String readURL() {

        try {
            URL oracle = new URL("http://www.oracle.com/");

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(oracle.openStream()));

            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println(inputLine);
            }

            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "s";
    }
}
