package com.example.domushouse;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cz.msebera.android.httpclient.Header;

public class Lights extends AppCompatActivity {

    @Bind(R.id.ingresso)
    Button button_ingresso;

    @Bind(R.id.cucina)
    Button button_cucina;

    @Bind(R.id.letto)
    Button button_letto;

    @Bind(R.id.bagno)
    Button button_bagno;

    @Bind(R.id.msg_benvenuto)
    TextView textview_msg_benvenuto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lights);
        ButterKnife.bind(this);
        textview_msg_benvenuto.setText("Benvenuto "+getIntent().getExtras().getString("username"));
        statoInterruttori(button_ingresso, button_cucina, button_bagno, button_letto);
    }

    @OnClick(R.id.ingresso)
    public void ingresso(Button button){
        Log.d("LOG --> ","PREMUTO INGRESSO");
        final ProgressDialog pDialog= new ProgressDialog(Lights.this);
        pDialog.setMessage("Loading...");
        pDialog.setIndeterminate(false);
        pDialog.setCancelable(true);
        pDialog.show();

        String URL= Costanti.URL_SERVER+Costanti.WEB_SERVER;
        AsyncHttpClient client=new AsyncHttpClient(true,80,443);

        RequestParams params=new RequestParams();
        params.add(Costanti.OPERAZIONE, Costanti.INGRESSO);



        client.post(URL, params, new JsonHttpResponseHandler() {
            @Override
            public void onStart(){
//                pDialog.setMessage("Loading...");
//                pDialog.setIndeterminate(false);
//                pDialog.setCancelable(true);
//                pDialog.show();
            }


            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                Log.d("CREATED", "onSuccess response Object: " + response.toString());
//                pDialog.dismiss();

            }


            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                String respString = responseString.toString();
                Log.d("CREATED", "onFailure response String: " + respString);
                pDialog.dismiss();
            }


        });


        try {
            Thread.sleep(1000);
            pDialog.dismiss();
            finish();
            startActivity(getIntent());
        }catch(Exception e){
            e.printStackTrace();
        }


    }

    @OnClick(R.id.cucina)
    public void cucina(Button button){
        Log.d("LOG --> ","PREMUTO CUCINA");
        final ProgressDialog pDialog= new ProgressDialog(Lights.this);
        pDialog.setMessage("Loading...");
        pDialog.setIndeterminate(false);
        pDialog.setCancelable(true);
        pDialog.show();

        String URL= Costanti.URL_SERVER+Costanti.WEB_SERVER;
        AsyncHttpClient client=new AsyncHttpClient(true,80,443);

        RequestParams params=new RequestParams();
        params.add(Costanti.OPERAZIONE, Costanti.CUCINA);

//        final ProgressDialog pDialog= new ProgressDialog(Lights.this);

        client.post(URL, params, new JsonHttpResponseHandler() {
            @Override
            public void onStart(){
//                pDialog.setMessage("Loading...");
//                pDialog.setIndeterminate(false);
//                pDialog.setCancelable(true);
//                pDialog.show();
            }


            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                Log.d("CREATED", "onSuccess response Object: " + response.toString());
//                pDialog.dismiss();

            }


            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                String respString = responseString.toString();
                Log.d("CREATED", "onFailure response String: " + respString);
                pDialog.dismiss();
            }


        });

        try {
            Thread.sleep(1000);
            pDialog.dismiss();
            finish();
            startActivity(getIntent());
        }catch(Exception e){
            e.printStackTrace();;
        }
    }

    @OnClick(R.id.letto)
    public void letto(Button button){

        Log.d("LOG --> ","PREMUTO LETTO");
        final ProgressDialog pDialog= new ProgressDialog(Lights.this);
        pDialog.setMessage("Loading...");
        pDialog.setIndeterminate(false);
        pDialog.setCancelable(true);
        pDialog.show();

        String URL= Costanti.URL_SERVER+Costanti.WEB_SERVER;
        AsyncHttpClient client=new AsyncHttpClient(true,80,443);

        RequestParams params=new RequestParams();
        params.add(Costanti.OPERAZIONE, Costanti.LETTO);

//        final ProgressDialog pDialog= new ProgressDialog(Lights.this);

        client.post(URL, params, new JsonHttpResponseHandler() {
            @Override
            public void onStart(){
//                pDialog.setMessage("Loading...");
//                pDialog.setIndeterminate(false);
//                pDialog.setCancelable(true);
//                pDialog.show();
            }


            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                Log.d("CREATED", "onSuccess response Object: " + response.toString());
//                pDialog.dismiss();

            }


            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                String respString = responseString.toString();
                Log.d("CREATED", "onFailure response String: " + respString);
                pDialog.dismiss();
            }


        });


        try {
            Thread.sleep(1000);
            pDialog.dismiss();
            finish();
            startActivity(getIntent());
        }catch(Exception e){
            e.printStackTrace();;
        }
    }

    @OnClick(R.id.bagno)
    public void bagno(Button button){
        Log.d("LOG --> ","PREMUTO BAGNO");
        final ProgressDialog pDialog= new ProgressDialog(Lights.this);
        pDialog.setMessage("Loading...");
        pDialog.setIndeterminate(false);
        pDialog.setCancelable(true);
        pDialog.show();

        String URL= Costanti.URL_SERVER+Costanti.WEB_SERVER;
        AsyncHttpClient client=new AsyncHttpClient(true,80,443);

        RequestParams params=new RequestParams();
        params.add(Costanti.OPERAZIONE, Costanti.BAGNO);

//        final ProgressDialog pDialog= new ProgressDialog(Lights.this);

        client.post(URL, params, new JsonHttpResponseHandler() {
            @Override
            public void onStart(){
//                pDialog.setMessage("Loading...");
//                pDialog.setIndeterminate(false);
//                pDialog.setCancelable(true);
//                pDialog.show();
            }


            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                Log.d("CREATED", "onSuccess response Object: " + response.toString());
//                pDialog.dismiss();

            }


            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable exception , JSONObject response){
                Log.d("CREATED", "------- onFailure response --------");
                pDialog.dismiss();
            }


            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                String respString = responseString.toString();
                Log.d("CREATED", "onFailure response String: " + respString);
                pDialog.dismiss();
            }


        });

        try {
            Thread.sleep(1000);
            pDialog.dismiss();
            finish();
            startActivity(getIntent());
        }catch(Exception e){
            e.printStackTrace();;
        }
    }

    public void statoInterruttori(final Button ingresso,final Button cucina, final Button bagno, final Button letto){
        Log.d("LOG --> ","AGGIORNAMENTO STATO LUCI");
        String URL= Costanti.URL_SERVER+Costanti.WEB_SERVER;
        AsyncHttpClient client=new AsyncHttpClient(true,80,443);

        RequestParams params=new RequestParams();
        params.add(Costanti.OPERAZIONE, Costanti.UPDATE_LIGHTS);

        final ProgressDialog pDialog= new ProgressDialog(Lights.this);

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

                try{
                    JSONArray data = response.getJSONArray("data");
                    for(int i=0; i< data.length();i++){
                        JSONObject obj = data.getJSONObject(i);
                        if(obj.get("descrizione").equals("ingresso")){
                            if(obj.getInt("stato")==1)
                                ingresso.setBackgroundResource(R.mipmap.luxon);
                            else
                                ingresso.setBackgroundResource(R.mipmap.luxoff);
                        }else if(obj.get("descrizione").equals("cucina")){
                            if(obj.getInt("stato")==1)
                                cucina.setBackgroundResource(R.mipmap.luxon);
                            else
                                cucina.setBackgroundResource(R.mipmap.luxoff);

                        }else if(obj.get("descrizione").equals("bagno")){
                            if(obj.getInt("stato")==1)
                                bagno.setBackgroundResource(R.mipmap.luxon);
                            else
                                bagno.setBackgroundResource(R.mipmap.luxoff);
                        }else if(obj.get("descrizione").equals("letto")){
                            if(obj.getInt("stato")==1)
                                letto.setBackgroundResource(R.mipmap.luxon);
                            else
                                letto.setBackgroundResource(R.mipmap.luxoff);
                        }

                    }
                }catch(JSONException e){
                    e.printStackTrace();
                }

                pDialog.dismiss();
            }


            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable exception , JSONObject response){
                Log.d("CREATED", "------- onFailure response --------");
                pDialog.dismiss();
            }


            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                String respString = responseString.toString();
                Log.d("CREATED", "onFailure response String: " + respString);
                pDialog.dismiss();
            }


        });
    }
}
