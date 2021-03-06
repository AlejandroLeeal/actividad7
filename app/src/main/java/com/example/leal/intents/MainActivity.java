package com.example.leal.intents;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.URLUtil;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText tele;
    EditText web;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tele = (EditText)findViewById(R.id.textele);
        web = (EditText)findViewById(R.id.textweb);
    }
    public void intentTelefono(View view){
        String numero = tele.getText().toString();
        if(TextUtils.isDigitsOnly(numero)&& numero.length()==10){
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:" + numero));
            startActivity(intent);
        }
        else {
            tele.setError("El telefono tiene qye ser de 10 digitos");
        }
    }
        public void intentPaguina(View view) {
            String url = web.getText().toString();

            if(URLUtil.isValidUrl(url)) {
                Intent intWeb = new Intent(Intent.ACTION_VIEW);
                intWeb.setData(Uri.parse(url));
                startActivity(intWeb);
            } else {
                web.setError("Debe ser una pagina valida");
            }
        }

        public void intentMapas (View view) {
            Uri gmmIntentUri = Uri.parse("geo:37.7749,-122.4194");
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
            mapIntent.setPackage("com.google.android.apps.maps");
            startActivity(mapIntent);
        }
    }

