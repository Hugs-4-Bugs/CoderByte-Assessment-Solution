import java.io.*;
import java.net.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // __define-ocg__
        String ChallengeToken = "peu28x9w3";
        String varOcg;

        URL url = new URL("https://coderbyte.com/api/challenges/json/age-counting");
        URLConnection connection = url.openConnection();
        InputStream inputStream = connection.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder response = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            response.append(line);
        }
        reader.close();

        varOcg = response.toString();
        int count = 0;
        String[] items = varOcg.substring(varOcg.indexOf(":") + 1, varOcg.length() - 1).split(", ");
        for (String item : items) {
            String[] keyValue = item.split("=");
            if (keyValue[0].trim().equals("age")) {
                try {
                    int age = Integer.parseInt(keyValue[1].trim());
                    if (age >= 50) {
                        count++;
                    }
                } catch (NumberFormatException e) {
                }
            }
        }

        String output = String.valueOf(count);
        for (char c : ChallengeToken.toCharArray()) {
            output = output.replace(String.valueOf(c), "--" + c + "--");
        }

        System.out.println(output);
    }
}
