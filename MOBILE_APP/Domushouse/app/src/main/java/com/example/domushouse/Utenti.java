package com.example.domushouse;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;



import java.util.ArrayList;

public class Utenti extends AppCompatActivity {

    // definisco un array di stringhe
    ArrayList<Utente> lista_utenti = new ArrayList<Utente>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_utenti);

        String URL= Costanti.URL_SERVER+Costanti.WEB_SERVER;
        AsyncHttpClient client=new AsyncHttpClient(true,80,443);

        RequestParams params=new RequestParams();
        params.add(Costanti.OPERAZIONE, Costanti.QUERY_GET_UTENTI);

        final ProgressDialog pDialog= new ProgressDialog(Utenti.this);
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
                Log.d("UTENTI", "07 - onSuccess response Object: " + response.toString());

                try {
                    Log.d("UTENTI", " 08 - risposta: "+response.toString());


                    JSONArray data = response.getJSONArray("data");

                    if(data != null){

                        for(int i=0;i<data.length();i++) {
                            JSONObject element = (JSONObject) data.get(i);
                            Log.d("UTENTI", i+" "+element.get("id")+" "+element.get("username")+" "+element.get("password"));
                            Utente utente= new Utente((String)element.get("id") , (String)element.get("username") ,(String)element.get("password"));
                            lista_utenti.add(utente);
                            // recupero la lista dal layout




                        }

                        final ListView mylist = (ListView) findViewById(R.id.listView1);

                        MyAdapterList adapter = new MyAdapterList(Utenti.this, lista_utenti);
                        // creo e istruisco l'adattatore
//                            final ArrayAdapter <String> adapter = new ArrayAdapter<String>(Utenti.this, android.R.layout.simple_list_item_1, lista_utenti);

                        // inietto i dati
                        mylist.setAdapter(adapter);

                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                pDialog.dismiss();


            }


            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                String respString = responseString.toString();
                Log.d("UTENTI", "09 - onFailure response String: " + respString);
                pDialog.dismiss();
            }


        });





    }
}
