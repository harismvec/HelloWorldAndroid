package com.codenvy.template.android;

import android.os.AsyncTask;
import java.net.HttpURLConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.io.IOException;
import java.net.MalformedURLException;
import java.io.InputStream;

public class GetTask extends AsyncTask<Void, Void, Void> 
{
    String returnMessage = "initial message";
    
    @Override
    protected Void doInBackground(Void... params) 
    {
        try
        {
        	String urlStr = "http://test-2956.apphb.com/api/Values/login";
          
          	URL url = new URL(urlStr);
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            InputStream stream = conn.getInputStream();
          	BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
          
          	String line = "";
          
          	while (line != null)
          	{
            	line = reader.readLine();
            	returnMessage = returnMessage + line;
          	}
        }
        catch(MalformedURLException e)
        {
          e.printStackTrace();
        }
        catch(IOException e)
        {
          e.printStackTrace();
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
