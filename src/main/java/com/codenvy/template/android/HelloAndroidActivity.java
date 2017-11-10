package com.codenvy.template.android;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;
import android.widget.Button;
import android.view.View;
import android.content.Intent;

public class HelloAndroidActivity extends Activity {

    public static TextView data;
    Button click;
    /**
     * Called when the activity is first created.
     *
     * @param savedInstanceState
     *         If the activity is being re-initialized after
     *         previously being shut down then this Bundle contains the data it most
     *         recently supplied in onSaveInstanceState(Bundle). <b>Note: Otherwise it is null.</b>
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        click = (Button) findViewById(R.id.button_id);
        data = (TextView) findViewById(R.id.text_view_id);
        
        click.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view){
                GetTask process = new GetTask(HelloAndroidActivity.this);
                process.execute();
            }
        });
        
       /*to link register to new activity*/
       
       TextView registerLink = (TextView) findViewById(R.id.register_link);
       
        registerLink.setOnClickListener(new View.OnClickListener()
        {
            @Override
           public void onClick(View v){
             Intent intent = new Intent(HelloAndroidActivity.this, RegisterActivity.class);
             startActivity(intent);
       } 
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(com.codenvy.template.android.R.menu.main, menu);
        return true;
    }

}

