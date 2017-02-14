package com.example.domushouse;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONException;
import org.json.JSONObject;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnItemSelected;
import cz.msebera.android.httpclient.Header;

public class Termostato extends AppCompatActivity {

    @Bind(R.id.msg_benvenuto)
    TextView textview_msg_benvenuto;

    @Bind(R.id.text_umidita)
    TextView textview_umidita;

    @Bind(R.id.text_temp)
    TextView textview_temp;

    @Bind(R.id.temp_desiderata)
    Spinner spinner_temp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_termostato);
        ButterKnife.bind(this);
        textview_msg_benvenuto.setText("Benvenuto "+getIntent().getExtras().getString("username"));
        this.getTempUmidita(textview_temp, textview_umidita, spinner_temp);
    }

    private void getTempUmidita(final TextView temperatura, final TextView umidita, final Spinner spinner_temp){

        ArrayAdapter<Integer> adapter = new ArrayAdapter<Integer>(this , R.layout.support_simple_spinner_dropdown_item);

        for(int i=0; i<51 ;i ++)
            adapter.add(i);

        spinner_temp.setAdapter(adapter);

        Log.d("LOG --> ","AGGIORNO TEMPERATURA E UMIDITA' nell'activity");
        String URL= Costanti.URL_SERVER+Costanti.WEB_SERVER;
        AsyncHttpClient client=new AsyncHttpClient(true,80,443);

        RequestParams params=new RequestParams();
        params.add(Costanti.OPERAZIONE, Costanti.TEMPERATURE);

        final ProgressDialog pDialog= new ProgressDialog(Termostato.this);

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
                    JSONObject data = response.getJSONObject("data");
                    int temp=data.getInt("temp_attuale");
                    int umidita_attuale=data.getInt("umidita_attuale");
                    int temperatura_desiderata = data.getInt("temperatura");
                    temperatura.setText(temp+" °C");
                    umidita.setText(umidita_attuale+" %");
                    spinner_temp.setSelection(temperatura_desiderata);

                }catch (JSONException e) {
                    e.printStackTrace();
                }

                pDialog.dismiss();
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable exception , JSONObject response){
                Log.d("CREATED", "------- onFailure response --------");
                Log.d("CREATED", "statusCode: " + statusCode);
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

    @OnItemSelected(R.id.temp_desiderata)
    public void changeTemp(int position){
        Log.d("LOG --> ","AGGIORNO TEMPERATURA NEL DB");
        String URL= Costanti.URL_SERVER+Costanti.WEB_SERVER;
        AsyncHttpClient client=new AsyncHttpClient(true,80,443);

        RequestParams params=new RequestParams();
        params.add(Costanti.OPERAZIONE, Costanti.UPDATE_TEMPERATURA_DESIDERATA);
        params.add("val_temp", spinner_temp.getItemAtPosition(position)+"");

        final ProgressDialog pDialog= new ProgressDialog(Termostato.this);

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
