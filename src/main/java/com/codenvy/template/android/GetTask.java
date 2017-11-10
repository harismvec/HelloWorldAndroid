package com.codenvy.template.android;

import android.os.AsyncTask;
import java.net.HttpURLConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.io.IOException;
import java.net.MalformedURLException;
import java.io.InputStream;
import android.app.ProgressDialog;
import android.app.Activity;
import android.content.Context;


public class GetTask extends AsyncTask<Void, Void, Void> 
{

    String returnMessage = "initial message";
    private Context _ctx;
    private ProgressDialog _p;
    
    public GetTask(Context ctx)
    {
        this._ctx = ctx;
        this._p=new ProgressDialog(ctx);
    }
    
    @Override
    protected void onPreExecute() {
         super.onPreExecute();
        _p.setMessage("Authenticating...");
        _p.setIndeterminate(false);
        _p.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        _p.setCancelable(false);
        _p.show();
    }
    
    @Override
    protected Void doInBackground(Void... params) 
    {
        try
        {
            //HelloAndroidActivity.data.setText("processing...");
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
        
         if (_p.isShowing()) 
         {
            _p.dismiss();
        }

      
        HelloAndroidActivity.data.setText(returnMessage);
    }
}
