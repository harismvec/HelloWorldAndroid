package com.codenvy.template.android;

import android.os.AsyncTask;
import java.net.HttpURLConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.io.IOException;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;
public class GetTask extends AsyncTask<Void, Void, Void> 
{
    String returnMessage = "";
    
    @Override
    protected Void doInBackground(Void... params) 
    {
        try
        {
            String urlStr = "http://test-2956.apphb.com/api/Values/login";
            HttpURLConnection urlConnection = null;
            URL url = new URL(urlStr);
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.setReadTimeout(10000 /* milliseconds */ );
            urlConnection.setConnectTimeout(15000 /* milliseconds */ );
            urlConnection.setDoOutput(true);
            urlConnection.connect();

            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
            StringBuilder sb = new StringBuilder();

            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line + "\n");
            }
            
            br.close();

            returnMessage = sb.toString();
        }
        catch(IOException ex)
        {
            throw new RuntimeException(ex);
        }
        
        return null;
    }
    
    @Override
    protected void onPostExecute(Void result) 
    {
        super.onPostExecute(result);
      
      HelloAndroidActivity.data.setText(returnMessage);
    }
}
