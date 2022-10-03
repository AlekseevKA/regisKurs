package com.example.regis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpRequestPost {
    public static void main(String[] args){
        String urlAdress = "http://smarthome.madskill.ru/user";
        URL url;
        HttpURLConnection httpURLConnection;
        OutputStream os = null;
        InputStreamReader isR = null;
        BufferedReader bfR = null;




        try{
         url = new URL(urlAdress);
            httpURLConnection = (HttpURLConnection)url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);


            httpURLConnection.addRequestProperty("User-Agent", "Mozulla/5.0");
            httpURLConnection.addRequestProperty("Content-Type", "application/x-www-form-urlencoded");




        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            System.err.print(e.getMessage());
        }
    }
}
