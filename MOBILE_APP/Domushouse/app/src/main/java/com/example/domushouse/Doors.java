package com.example.domushouse;

import android.app.ProgressDialog;
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

public class Doors extends AppCompatActivity {

    @Bind(R.id.auto)
    Button button_auto;



    @Bind(R.id.portone)
    Button button_portone;

    @Bind(R.id.porta)
    Button button_porta;


    @Bind(R.id.msg_benvenuto)
    TextView textview_msg_benvenuto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doors);
        ButterKnife.bind(this);
        textview_msg_benvenuto.setText("Benvenuto "+getIntent().getExtras().getString("username"));
        this.statoInterruttori(button_auto, button_portone, button_porta);
    }

    @OnClick(R.id.auto)
    public void auto(Button button){
        Log.d("LOG --> ","PREMUTO AUTO");
        String URL= Costanti.URL_SERVER+Costanti.WEB_SERVER;
        AsyncHttpClient client=new AsyncHttpClient(true,80,443);

        RequestParams params=new RequestParams();
        params.add(Costanti.OPERAZIONE, Costanti.AUTO);

        final ProgressDialog pDialog= new ProgressDialog(Doors.this);

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

            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable exception , JSONObject response){
                Log.d("CREATED", "------- onFailure response --------");
                Log.d("CREATED", "statusCode: " + statusCode);
                Log.d("CREATED", "Errore: il server sta impiegando troppo tempo per rispondere (il chè è normale in questo caso poichè sta attendendo il tempo necessario ad aprire il cancello) ");
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



    @OnClick(R.id.portone)
    public void portone(Button button){
        Log.d("LOG --> ","PREMUTO PORTONE");
        String URL= Costanti.URL_SERVER+Costanti.WEB_SERVER;
        AsyncHttpClient client=new AsyncHttpClient(true,80,443);

        RequestParams params=new RequestParams();
        params.add(Costanti.OPERAZIONE, Costanti.PORTONE);

        final ProgressDialog pDialog= new ProgressDialog(Doors.this);

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
                pDialog.dismiss();
            }


            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable exception , JSONObject response){
                Log.d("CREATED", "------- onFailure response --------");
                Log.d("CREATED", "statusCode: " + statusCode);
                Log.d("CREATED", "Errore: il server sta impiegando troppo tempo per rispondere ");
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

    @OnClick(R.id.porta)
    public void porta(Button button){
        Log.d("LOG --> ","PREMUTO PORTA");
        String URL= Costanti.URL_SERVER+Costanti.WEB_SERVER;
        AsyncHttpClient client=new AsyncHttpClient(true,80,443);

        RequestParams params=new RequestParams();
        params.add(Costanti.OPERAZIONE, Costanti.PORTA);

        final ProgressDialog pDialog= new ProgressDialog(Doors.this);

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
//                pDialog.dismiss();
            }


            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable exception , JSONObject response){
                Log.d("CREATED", "------- onFailure response --------");
                Log.d("CREATED", "statusCode: " + statusCode);
                Log.d("CREATED", "Errore: il server sta impiegando troppo tempo per rispondere ");
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

    public void statoInterruttori(final Button auto,final Button portone, final Button porta){
        Log.d("LOG --> ","AGGIORNAMENTO STATO PORTE");
        String URL= Costanti.URL_SERVER+Costanti.WEB_SERVER;
        AsyncHttpClient client=new AsyncHttpClient(true,80,443);

        RequestParams params=new RequestParams();
        params.add(Costanti.OPERAZIONE, Costanti.UPDATE_DOOR);

        final ProgressDialog pDialog= new ProgressDialog(Doors.this);

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
                        if(obj.get("descrizione").equals("auto")){
                            if(obj.getInt("stato")==0)
                                auto.setBackgroundResource(R.mipmap.lock);
                            else
                                auto.setBackgroundResource(R.mipmap.unlock);
                        }else if(obj.get("descrizione").equals("portone")){
                            if(obj.getInt("stato")==0)
                                portone.setBackgroundResource(R.mipmap.lock);
                            else
                                portone.setBackgroundResource(R.mipmap.unlock);

                        }else if(obj.get("descrizione").equals("porta")){
                            if(obj.getInt("stato")==0)
                                porta.setBackgroundResource(R.mipmap.lock);
                            else
                                porta.setBackgroundResource(R.mipmap.unlock);
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
