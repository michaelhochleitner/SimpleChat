package com.example.y95278.simplechat;

import android.os.Build;
import android.util.Log;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.URI;
import java.nio.channels.NotYetConnectedException;

import static android.content.ContentValues.TAG;

/**
 * Created by y95278 on 27.10.17.
 */

public class MyWebSocketClient extends WebSocketClient {
    public MyWebSocketClient(URI serverURI) {
        super(serverURI);
    }


    @Override
    public void onOpen(ServerHandshake handshakedata) {
        this.send("Hello from "+ Build.MANUFACTURER + " "+ Build.MODEL);
        Log.i(TAG, "Opened connection to "+ this.getURI());
        Log.i(TAG, "HTTP Status Message: "+handshakedata.getHttpStatusMessage());
    }

    @Override
    public void onMessage(String message) {
        Log.i(TAG,"Receiving message "+message);
    }

    @Override
    public void onClose(int code, String reason, boolean remote) {
        Log.i(TAG,"Connection close. Reason: "+reason);
    }

    @Override
    public void onError(Exception ex) {
        Log.i(TAG,"Error occured: "+ex.getMessage());
    }
}
