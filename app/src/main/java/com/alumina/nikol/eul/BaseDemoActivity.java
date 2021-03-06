/*
 * Copyright 2013 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.alumina.nikol.eul;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.alumina.nikol.eul.Conexion.FacadeConnect;
import com.alumina.nikol.eul.model.MyItem;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;

public abstract class BaseDemoActivity extends FragmentActivity implements OnMapReadyCallback {
    private GoogleMap mMap;
    private List<MyItem> myItems;

    protected int getLayoutId() {
        return R.layout.map;
    }
    private void listarSucursales(JSONArray response) {
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

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myItems=new ArrayList<>();
        setContentView(getLayoutId());
        String myItems= (String) getIntent().getExtras().getString("ListaSucur");
        try {
            JSONArray s= new JSONArray(myItems);
            listarSucursales(s);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        setUpMap();
    }

    @Override
    protected void onResume() {
        super.onResume();
        setUpMap();
    }

    @Override
    public void onMapReady(GoogleMap map) {
        if (mMap != null) {
            return;
        }
        mMap = map;
        startDemo();
    }

    private void setUpMap() {
        ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map)).getMapAsync(this);
    }



    /**
     * Run the demo-specific code.
     */
    protected abstract void startDemo();

    protected GoogleMap getMap() {
        return mMap;
    }

    protected List<MyItem> getMyItems() {
        return myItems;
    }
}
