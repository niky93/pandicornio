package com.alumina.nikol.eul;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.alumina.nikol.eul.Class.Paquetes;

public class PackageActivity extends AppCompatActivity {

    Paquetes paquetes;
    TextView code,fe,fl,obs,est;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_package);
        paquetes= (Paquetes) getIntent().getExtras().getSerializable("Package");


        code=  (TextView) findViewById(R.id.txtCod);
        fl=    (TextView) findViewById(R.id.txtFL);
        fe =   (TextView) findViewById(R.id.txtFE);
        obs=   (TextView) findViewById(R.id.txtObs);
        est=   (TextView) findViewById(R.id.txtEst);
        est.setText(String.valueOf(paquetes.getEstado()));
        if (paquetes.getObservaciones()!=null)
            obs.setText(paquetes.getObservaciones());
        else
            obs.setText("No existen observaciones");
        String xx="No ha salido";
        if (paquetes.getEstado()==1)
            xx="Este paquete se encuentra en camino";
        else if (paquetes.getEstado()==2)
            xx="Este paquete ya llegado a su destino";
        code.setText(xx);
        fe.setText(paquetes.getFechaEnt());
        fl.setText(paquetes.getFechaLleg());

    }

    public void VolverInicio(View view) {
        Intent a = new Intent(getApplicationContext(),MainActivity.class);
        a.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(a);
    }
}
