package com.example.domushouse;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Home extends AppCompatActivity {

    @Bind(R.id.luci)
    Button button_luci;

    @Bind(R.id.porte)
    Button button_porte;

    @Bind(R.id.settings)
    Button button_settings;

    @Bind(R.id.termostato)
    Button button_termostato;

    @Bind(R.id.msg_benvenuto)
    TextView textview_msg_benvenuto;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        textview_msg_benvenuto.setText("Benvenuto "+getIntent().getExtras().getString("username"));

    }

    @OnClick(R.id.luci)
    public void luci(Button button){
        Intent openLuci = new Intent(Home.this,Lights.class);
        openLuci.putExtra("username",this.getIntent().getExtras().getString("username"));
        startActivity(openLuci);

    }

    @OnClick(R.id.porte)
    public void porte(Button button){

        Intent openPorte = new Intent(Home.this,Doors.class);
        openPorte.putExtra("username",this.getIntent().getExtras().getString("username"));
        startActivity(openPorte);

    }

    @OnClick(R.id.settings)
    public void settings(Button button){

        Intent openSettings = new Intent(Home.this,Settings.class);
        openSettings.putExtra("username",this.getIntent().getExtras().getString("username"));
        startActivity(openSettings);

    }

    @OnClick(R.id.termostato)
    public void termostato(Button button){

        Intent openSettings = new Intent(Home.this,Termostato.class);
        openSettings.putExtra("username",this.getIntent().getExtras().getString("username"));
        startActivity(openSettings);

    }




}
