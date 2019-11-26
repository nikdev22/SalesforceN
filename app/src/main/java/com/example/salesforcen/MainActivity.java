package com.example.salesforcen;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.salesforce.android.chat.core.ChatConfiguration;
import com.salesforce.android.chat.ui.ChatUI;
import com.salesforce.android.chat.ui.ChatUIClient;
import com.salesforce.android.chat.ui.ChatUIConfiguration;
import com.salesforce.android.chat.ui.model.QueueStyle;
import com.salesforce.android.knowledge.ui.KnowledgeUI;
import com.salesforce.android.knowledge.ui.KnowledgeUIClient;
import com.salesforce.android.service.common.utilities.control.Async;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class MainActivity extends AppCompatActivity  {
    

    //luis org ID
    /*public static final String ORG_ID = "00D1y0000008l3w";
    public static final String DEPLOYMENT_ID = "5720o000000HJS8";
    public static final String BUTTON_ID = "5731y0000008OIZ";
    public static final String LIVE_AGENT_POD = "d.la2-c1cs-hnd.salesforceliveagent.com"; */

    //trove
    public static final String ORG_ID = "00D0k0000009HZ8";
    public static final String DEPLOYMENT_ID = "5720o000000HJS8";
    public static final String BUTTON_ID = "5730k0000008OWC";
    public static final String LIVE_AGENT_POD = "d.la1-c1cs-hnd.salesforceliveagent.com";
    ChatConfiguration chatConfiguration = new ChatConfiguration.Builder(ORG_ID,BUTTON_ID, DEPLOYMENT_ID, LIVE_AGENT_POD).build();
   // private Button mButton = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //mButton = findViewById(R.id.button);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChatUI.configure(ChatUIConfiguration.create(chatConfiguration))
                        .createClient(getApplicationContext())
                        .onResult(new Async.ResultHandler<ChatUIClient>() {
                            @Override
                            public void handleResult(Async<?> async, @NonNull ChatUIClient chatUIClient) {
                                chatUIClient.startChatSession(MainActivity.this);
                            }
                        });
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
   /*public void invokeChatUi(View view){
        ChatUI.configure(ChatUIConfiguration.create(chatConfiguration))
                .createClient(getApplicationContext())
                .onResult(new Async.ResultHandler<ChatUIClient>() {
                    @Override
                    public void handleResult(Async<?> async, @NonNull ChatUIClient chatUIClient) {
                        chatUIClient.startChatSession(MainActivity.this);
                    }
                });

    }*/



}
