package com.alumina.nikol.eul;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.alumina.nikol.eul.Conexion.FacadeConnect;
import com.alumina.nikol.eul.model.MyItem;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;


public class MainActivity extends AppCompatActivity{

    private String myItems;
    private boolean qx;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        connectionGET();
        qx=false;

    }

    private void connectionGET()
    {
        String path="api/offices";
        FacadeConnect.get(path,null,new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseString) {
                super.onSuccess(statusCode, headers, responseString);
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
                super.onSuccess(statusCode, headers, response);
                myItems=response.toString();
                qx=true;
                //Intent a = new Intent(getContPadre(),PackageActivity.class);
                //a.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                //a.putExtra("Package",);
                //startActivity(a);
            }
            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                super.onFailure(statusCode, headers, throwable, errorResponse);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONArray errorResponse) {
                super.onFailure(statusCode, headers, throwable, errorResponse);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                super.onFailure(statusCode, headers, responseString, throwable);
            }
        });
    }

    public void llamar(){
        if (qx) {
            Intent a = new Intent(this, ClusteringDemoActivity.class);
            a.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            a.putExtra("ListaSucur", myItems);
            startActivity(a);
        }
    }
    private Context getCon(){
        return getApplicationContext();
    }
    public void VerSucursales(View view) {
        llamar();
    }

    public void VerPaquetes(View view) {
        Intent a = new Intent(getCon(), QrDetectorActivity.class);
        a.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(a);
    }
}
