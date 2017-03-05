package com.example.service.impl;

import com.example.entity.OrderList;
import com.example.entity.OrderMenu;
import com.example.service.IKitchenService;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;
/**
 * Created by Forunh on 05-Mar-17.
 */
public class KitchenService {

    private final String USER_AGENT = "Mozilla/5.0";
    // HTTP POST request
    public void addKitchen(OrderMenu orderMenu,Integer userId){
        try {
            String url = "http://52.187.62.107:10500/kitchen/add_order";
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();

            // Setting basic post request
            con.setRequestMethod("POST");
            con.setRequestProperty("User-Agent", USER_AGENT);
            con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
            con.setRequestProperty("Content-Type", "application/json");
            String postJsonData = "{\"orderid\":"+orderMenu.getOrderId()+",\"menuid\":"+orderMenu.getMenuId()+",\"quantity\":"+orderMenu.getQuantity()+",\"userid\":"+userId+",\"status\":\"waiting\"}";

            // Send post request
            con.setDoOutput(true);
            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            wr.writeBytes(postJsonData);
            wr.flush();
            wr.close();

            int responseCode = con.getResponseCode();
            System.out.println("\nSending 'POST' request to URL : " + url);
            System.out.println("Post Data : " + postJsonData);
            System.out.println("Response Code : " + responseCode);

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String output;
            StringBuffer response = new StringBuffer();

            while ((output = in.readLine()) != null) {
                response.append(output);
            }
            in.close();

            //printing result from response
            System.out.println(response.toString());
        }
        catch (Exception e) {
            System.out.println(e);

        }
    }

}

