package com.example.domushouse;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

public class Settings extends AppCompatActivity {

    @Bind(R.id.msg_benvenuto)
    TextView textview_msg_benvenuto;

    @Bind(R.id.username)
    EditText editText_username;

    @Bind(R.id.password)
    EditText editText_password;

    @Bind(R.id.save_psw)
    Button button_save_psw;

    @Bind(R.id.text_add_user)
    TextView textview_text_add_user;

    @Bind(R.id.username_new)
    EditText editText_username_new;

    @Bind(R.id.password_new)
    EditText editText_password_new;

    @Bind(R.id.add_user)
    Button button_add_user;



    @Bind(R.id.button_utenti)
    Button utenti;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        ButterKnife.bind(this);

        textview_msg_benvenuto.setText("Benvenuto "+getIntent().getExtras().getString("username"));
        editText_username.setText(getIntent().getExtras().getString("username"));
        editText_username.setEnabled(false);
        if(getIntent().getExtras().getString("username").equals("admin")){
            Log.d("SETTING", "01 - SEI AMMINISTRATORE");
//            riempiTabellaUtenti();

        }else
        {
            Log.d("SETTING", "01 - NON SEI AMMINISTRATORE");
            textview_text_add_user.setVisibility(View.INVISIBLE);
            editText_username_new.setVisibility(View.INVISIBLE);
            editText_password_new.setVisibility(View.INVISIBLE);
            button_add_user.setVisibility(View.INVISIBLE);
            utenti.setVisibility(View.INVISIBLE);
        }


    }

    @OnClick(R.id.button_utenti)
    public void lista_utenti(Button button){
        Intent openPorte = new Intent(Settings.this,Utenti.class);
        openPorte.putExtra("username",this.getIntent().getExtras().getString("username"));
        startActivity(openPorte);

    }
    @OnClick(R.id.save_psw)
    public void save_psw(Button button){

        String URL= Costanti.URL_SERVER+Costanti.WEB_SERVER;
        AsyncHttpClient client=new AsyncHttpClient(true,80,443);

        RequestParams params=new RequestParams();
        params.add(Costanti.OPERAZIONE, Costanti.QUERY_MODIFICA_PASSWORD);
        params.add("username", editText_username.getText().toString());
        params.add("password", editText_password.getText().toString());

        final ProgressDialog pDialog= new ProgressDialog(Settings.this);
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
                Log.d("SETTING", "02 - onSuccess response Object: " + response.toString());
                try {
                    int isChange=response.getInt("stato");

                    if(isChange==0){
                        //PASSWORD NON MODIFICATA
                        Log.d("SETTING", " 03 - PASSWORD NON MODIFICATA!");
                        AlertDialog alert = new AlertDialog.Builder(Settings.this).create();
                        alert.setTitle("Errore");
                        alert.setMessage(response.get("msg")+"");
                        alert.setButton("OK", new DialogInterface.OnClickListener(){
                            public void onClick(DialogInterface dialog, int which){
                                editText_password.setText("");
                            }
                        });
                        alert.show();
                    }else if(isChange==1){
                        //PASSWORD MODIFICATA
                        Log.d("SETTING", " 03 - PASSWORD MODIFICATA!!");
                        AlertDialog alert = new AlertDialog.Builder(Settings.this).create();
                        alert.setTitle("Info");
                        alert.setMessage("Password modificata con successo!");
                        alert.setButton("OK", new DialogInterface.OnClickListener(){
                            public void onClick(DialogInterface dialog, int which){
                                editText_password.setText("");
                            }
                        });
                        alert.show();

                    }




                    pDialog.dismiss();

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }


            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                String respString = responseString.toString();
                Log.d("SETTING", "04 - onFailure response String: " + respString);
                pDialog.dismiss();
            }


        });

    }

    @OnClick(R.id.add_user)
    public void add_user(Button button){

        String URL= Costanti.URL_SERVER+Costanti.WEB_SERVER;
        AsyncHttpClient client=new AsyncHttpClient(true,80,443);

        RequestParams params=new RequestParams();
        params.add(Costanti.OPERAZIONE, Costanti.QUERY_INSERIMENTO_UTENTE);
        params.add("username", editText_username_new.getText().toString());
        params.add("password", editText_password_new.getText().toString());

        final ProgressDialog pDialog= new ProgressDialog(Settings.this);
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
                Log.d("SETTING", " 04 - onSuccess response Object: " + response.toString());
                try {
                    int isAdd=response.getInt("stato");

                    if(isAdd==0){
                        //UTENTE NON AGGIUNTO
                        Log.d("SETTING", "05 - UTENTE NON AGGIUNTO!");
                        AlertDialog alert = new AlertDialog.Builder(Settings.this).create();
                        alert.setTitle("Errore");
                        alert.setMessage(response.get("msg")+"");
                        alert.setButton("OK", new DialogInterface.OnClickListener(){
                            public void onClick(DialogInterface dialog, int which){
                                editText_username_new.setText("");
                                editText_password_new.setText("");
                            }
                        });
                        alert.show();
                    }else if(isAdd==1){
                        //UTENTE AGGIUNTO
                        Log.d("SETTING", "05 - UTENTE AGGIUNTO!!");
                        AlertDialog alert = new AlertDialog.Builder(Settings.this).create();
                        alert.setTitle("Info");
                        alert.setMessage(response.get("msg")+"");
                        alert.setButton("OK", new DialogInterface.OnClickListener(){
                            public void onClick(DialogInterface dialog, int which){
                                editText_username_new.setText("");
                                editText_password_new.setText("");
                            }
                        });
                        alert.show();


                    }


                    pDialog.dismiss();

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }


            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                String respString = responseString.toString();
                Log.d("SETTING", "06 - onFailure response String: " + respString);
                pDialog.dismiss();
            }


        });

    }


}
