package com.alumina.nikol.eul;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.alumina.nikol.eul.Class.Paquetes;
import com.alumina.nikol.eul.Conexion.FacadeConnect;
import com.google.zxing.Result;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;

import cz.msebera.android.httpclient.Header;
import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class QrDetectorActivity extends AppCompatActivity implements ZXingScannerView.ResultHandler {

    private ZXingScannerView mScannerView;
    Paquetes paq=new Paquetes();
    EditText x;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr_detector);
        x= (EditText) findViewById(R.id.etQR);
    }

    @Override
    public void handleResult(Result result) {
        //Aqui mostrara el resultado con rawResult.getText();
        connectionGET(result.getText());
    }

    public void ComprobarCodigo(View view) {
        connectionGET(x.getText().toString());
    }

    public void BuscarCodigo(View view) {
        mScannerView = new ZXingScannerView(this);   // initialize the scanner view
        setContentView(mScannerView);
        mScannerView.setResultHandler(this); // Register ourselves as a handler for scan results.
        mScannerView.startCamera();         // Start camera
    }
    private void connectionGET(String paquete)
    {
        String path="api/offices";//packages/"+paquete;
        FacadeConnect.get(path,null,new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseString) {
                super.onSuccess(statusCode, headers, responseString);
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);
                try {
                    paq.setCodigo(response.getString("code"));
                    paq.setEstado(response.getInt("state"));
                    paq.setExpress(response.getBoolean("express"));
                    paq.setFragil(response.getBoolean("fragility"));
                    paq.setFechaEnt(response.getString("shipping_date"));
                    paq.setFechaLleg(response.getString("delivery_date"));
                    paq.setObservaciones(response.getString("observations"));
                    Intent a = new Intent(getContPadre(),PackageActivity.class);
                    a.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    a.putExtra("Package",paq);
                    startActivity(a);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
                super.onSuccess(statusCode, headers, response);
                listarPaquete(response);
                Intent a = new Intent(getContPadre(),PackageActivity.class);
                a.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                a.putExtra("ListaPackage",paq);
                startActivity(a);
            }

        });
    }

    private Context getContPadre()
    {
        return getApplicationContext();
    }
    private void listarPaquete(JSONArray response) {

    }
}
