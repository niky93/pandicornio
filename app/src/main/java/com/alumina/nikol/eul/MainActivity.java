package com.alumina.nikol.eul;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.alumina.nikol.eul.Conexion.FacadeConnect;
import com.alumina.nikol.eul.model.MyItem;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;


public class MainActivity extends AppCompatActivity{

    private List<MyItem> myItems;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        connectionGET();

    }
    private void listarSucursales(JSONArray response) {
        myItems=new ArrayList<>();
        for (int q=0;q<response.length();q++){
            try {
                JSONObject jsonObject= response.getJSONObject(q);
                MyItem er= new MyItem(jsonObject.getDouble("lat"),jsonObject.getDouble("lon"),jsonObject.getString("description"),String.valueOf(jsonObject.getInt("id")));
                myItems.add(er);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
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
                listarSucursales(response);
                //Intent a = new Intent(getContPadre(),PackageActivity.class);
                //a.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                //a.putExtra("Package",);
                //startActivity(a);
            }

            @Override
            public boolean isUseRFC5179CompatibilityMode() {
                return super.isUseRFC5179CompatibilityMode();
            }

            @Override
            public void setUseRFC5179CompatibilityMode(boolean useRFC5179CompatibilityMode) {
                super.setUseRFC5179CompatibilityMode(useRFC5179CompatibilityMode);
            }

            @Override
            protected Object parseResponse(byte[] responseBody) throws JSONException {
                return super.parseResponse(responseBody);
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
}
