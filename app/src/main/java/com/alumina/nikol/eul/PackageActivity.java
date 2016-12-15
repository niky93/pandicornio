package com.alumina.nikol.eul;

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
        est.setText(paquetes.getEstado());
        obs.setText(paquetes.getObservaciones());
        code.setText(paquetes.getCodigo());
        fe.setText(paquetes.getFechaEnt());
        fl.setText(paquetes.getFechaLleg());

    }

    public void VolverInicio(View view) {

    }
}
