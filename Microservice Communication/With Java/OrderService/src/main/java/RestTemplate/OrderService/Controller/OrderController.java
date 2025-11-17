package RestTemplate.OrderService.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @GetMapping("/{id}")
    public ResponseEntity<String> getOrder(@PathVariable int id) {

        // Creating a HttpURLConnection, is like an envelop,
        // in which we specify the URL, Request Method and Timeouts
        HttpURLConnection httpURLConnection = null;

        try {
            String url = "http://localhost:8082/products/" + id;
            URL obj = new URL(url);

            // TCP Connection is created
            httpURLConnection = (HttpURLConnection) obj.openConnection();

            // Setting HTTP Request Method and Header
            httpURLConnection.setRequestMethod("GET");
            HttpURLConnection.setDefaultRequestProperty("Accept", "application/json");

            // Max time to establish TCP Connection and timeout
            httpURLConnection.setConnectTimeout(100);
            httpURLConnection.setReadTimeout(500);

            // Opens the TCP Connection and trigger the HTTP request and read the response
            BufferedReader in = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            StringBuffer response = new StringBuffer();
            String responseInline;

            while ((responseInline = in.readLine()) != null) {
                response.append(responseInline);
            }

            in.close();
            System.out.println("Response : " + response.toString());
        }
        catch (Exception e) {
            //nothing
        }
        finally {
            if(httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
        }
        return ResponseEntity.ok("order call successful");
    }
}
