package com.example.domushouse;


import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

import cz.msebera.android.httpclient.Header;

/**
 * Created by antonio on 31/01/17.
 */

public class MyAdapterList extends BaseAdapter {

    Context context;
    ArrayList<Utente> data;
    private static LayoutInflater inflater = null;

    public MyAdapterList(Context context, ArrayList<Utente> data) {
        // TODO Auto-generated constructor stub
        this.context = context;
        this.data = data;
        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public View getView(final int position, View convertView, final ViewGroup parent) {
        // TODO Auto-generated method stub
        Log.d("POSITION: ", position+"");
        View vi = convertView;
        if (vi == null)
            vi = inflater.inflate(R.layout.myitemlist, null);

        Utente utente = data.get(position);


        TextView user = (TextView) vi.findViewById(R.id.user);
        ImageView img = (ImageView) vi.findViewById(R.id.imguser);
        Button btn = (Button) vi.findViewById(R.id.delete);

        user.setText(utente.getUsername());

        if(utente.getUsername().equals("admin")){
            img.setBackgroundResource(R.mipmap.admin);
            btn.setVisibility(View.INVISIBLE);
        }else{
            img.setBackgroundResource(R.mipmap.user_01);

            btn.setId(Integer.parseInt(utente.getId()));

            final View finalVi = vi;
            btn.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    // Perform action on click
                    Button button = (Button)v;
                    int id= button.getId();
                    Log.d("SETTING:"," hai premuto elimina, id: "+id);
                    removeUser(id);
                    data.remove(position);
                    parent.refreshDrawableState();

                    ((Activity)context).finish();
                    Intent intent = new Intent(context, Utenti.class);
                    context.startActivity(intent);
                }
            });
        }



        return vi;
    }


    private void removeUser(int id){

        String URL= Costanti.URL_SERVER+Costanti.WEB_SERVER;
        AsyncHttpClient client=new AsyncHttpClient(true,80,443);

        RequestParams params=new RequestParams();
        params.add(Costanti.OPERAZIONE, Costanti.QUERY_ELIMINA_UTENTE);
        params.add("id", ""+id);

        final ProgressDialog pDialog= new ProgressDialog(this.context);
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
                Log.d("SETTING", "07 - onSuccess response Object: " + response.toString());
                try {
                    int isDelete=response.getInt("stato");

                    if(isDelete==0){
                        //NON ELIMINATO
                        Log.d("SETTING", "05 - UTENTE NON ELIMINATO!");
                    }else if(isDelete==1){
                        //ELIMINATO
                        Log.d("SETTING", "06 - UTENTE ELIMINATO!!");


                    }




                } catch (JSONException e) {
                    e.printStackTrace();
                }


                pDialog.dismiss();

            }


            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                String respString = responseString.toString();
                Log.d("SETTING", "09 - onFailure response String: " + respString);
                pDialog.dismiss();
            }


        });

    }
}
