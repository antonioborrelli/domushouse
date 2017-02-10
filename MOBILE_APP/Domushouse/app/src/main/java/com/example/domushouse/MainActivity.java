package com.example.domushouse;

import android.app.ProgressDialog;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;


import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONException;
import org.json.JSONObject;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cz.msebera.android.httpclient.Header;
import android.app.AlertDialog;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.login)
    Button button_login;

    @Bind(R.id.username)
    TextView textview_username;

    @Bind(R.id.password)
    TextView textview_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.login)
    public void login(Button button){



        String URL= Costanti.URL_SERVER+Costanti.WEB_SERVER;
        AsyncHttpClient client=new AsyncHttpClient(true,80,443);

        RequestParams params=new RequestParams();
        params.add(Costanti.OPERAZIONE, Costanti.QUERY_LOGIN);
        params.add("username", textview_username.getText().toString());
        params.add("password", textview_password.getText().toString());

        final ProgressDialog pDialog= new ProgressDialog(MainActivity.this);

        client.post(URL, params, new JsonHttpResponseHandler() {
            @Override
            public void onStart(){
                pDialog.setMessage("Loading...");
                pDialog.setIndeterminate(false);
                pDialog.setCancelable(true);
                pDialog.show();
            }


            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {

                Log.d("CREATED", "onSuccess response Object: " + response.toString());
                try {
                    int isLog=response.getInt("stato");

                    if(isLog==0){
                        //NON LOGGATO
                        Log.d("CREATED", "NON LOGGATO!");

                        AlertDialog alert = new AlertDialog.Builder(MainActivity.this).create();
                        alert.setTitle("Errore");
                        alert.setMessage("Username o password errati!");
                        alert.setButton("OK", new DialogInterface.OnClickListener(){
                            public void onClick(DialogInterface dialog, int which){
                                textview_username.setText("");
                                textview_password.setText("");
                            }
                        });
                        alert.show();

                    }else if(isLog==1){
                        //LOGGATO
                        Log.d("CREATED", "LOGGATO!");
                        Intent openHome = new Intent(MainActivity.this,Home.class);
                        openHome.putExtra("username",textview_username.getText().toString());
                        startActivity(openHome);
                    }


                    pDialog.dismiss();

                } catch (JSONException e) {

                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable exception , JSONObject response){
                Log.d("CREATED", "------- onFailure response --------");
                Log.d("CREATED", "statusCode: " + statusCode);
                Log.d("CREATED", "Errore: il server sta impiegando troppo tempo per rispondere ");
                pDialog.dismiss();
                AlertDialog alert = new AlertDialog.Builder(MainActivity.this).create();
                alert.setTitle("Errore");
                alert.setMessage("Mancata comunicazione con il server! Riprovare più tardi ...");
                alert.setButton("OK", new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int which){

                    }
                });
                alert.show();

            }


            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                String respString = responseString.toString();
                Log.d("CREATED", "onFailure response String: " + respString);
                pDialog.dismiss();

                AlertDialog alert = new AlertDialog.Builder(MainActivity.this).create();
                alert.setTitle("Errore");
                alert.setMessage("Mancata comunicazione con il server! Riprovare più tardi ...");
                alert.setButton("OK", new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int which){

                    }
                });
                alert.show();
            }

            @Override
            public void onFinish() {
                super.onFinish();
                Log.d("CREATED", "SONO QUI AL FINISH !!! ");
            }

        });
    }
}
