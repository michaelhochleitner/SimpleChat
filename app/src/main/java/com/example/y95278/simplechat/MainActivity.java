package com.example.y95278.simplechat;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.net.URI;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "com.example.y95278.simplechat.MainActivity";
    private MyWebSocketClient mWebSocketClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String serverUrl = "ws://127.0.0.1:8080/chat";
        URI serverURI = URI.create(serverUrl);
        this.mWebSocketClient = new MyWebSocketClient(serverURI);
        mWebSocketClient.connect();
        Log.i(TAG,"Connecting to "+serverUrl);
    }

    public void sendMessage(View view){
        Log.i(TAG,"sendMessage called");
        EditText inputTextView = (EditText) findViewById(R.id.editText);
        String inputText = inputTextView.getText().toString();
        mWebSocketClient.send(inputText);
    }
}
