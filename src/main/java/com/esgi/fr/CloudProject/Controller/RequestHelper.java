package com.esgi.fr.CloudProject.Controller;

import java.io.*;
import java.net.*;

public class RequestHelper {

    private static URL obj;
    private static HttpURLConnection con;

    public static String get(String url)throws Exception
    {
        connect(url,"GET");
        if(con.getErrorStream() == null) {
            boolean state = getRequestState(con.getResponseCode());
            if (state) {
                String data = getResponse();
                System.out.println(data);
                return data;
            }
        }
        return null;
    }

    private static void connect(String url, String type)throws Exception
    {
        try{
            obj = new URL(url);
            con = (HttpURLConnection) obj.openConnection();
            con.setConnectTimeout(5000);
            con.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            con.setDoOutput(true);
            con.setDoInput(true);
            con.setRequestMethod(type);

        }catch(ConnectException ex)
        {
            throw  new ConnectException("Unable to connect to the API");
        }

    }

    private static boolean getRequestState(int responseCode)
    {
        boolean state = false;

        if(responseCode == HttpURLConnection.HTTP_OK) state = true;

        return state;
    }

    private static String getResponse() throws IOException
    {
        StringBuffer response;
        try{
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);

            }
            in.close();
        }
        catch(IOException ex){
            throw new IOException("Error on reading API response");
        }

        return response.toString();
    }
}