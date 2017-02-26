package bonaguasato.gui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;


public class homepage extends AppCompatActivity {
    ImageButton myImagebutton, myImagebutton2, myImagebutton3, myImagebutton4, myImagebutton5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

         myImagebutton = (ImageButton) findViewById(R.id.imgbtnUser);
        myImagebutton2 = (ImageButton) findViewById(R.id.imgbtnWeb);
        myImagebutton3 = (ImageButton) findViewById(R.id.imgbtnCamera);
        myImagebutton4 = (ImageButton) findViewById(R.id.imgbtnlocation);
        myImagebutton5 = (ImageButton) findViewById(R.id.imgbtnscan);

        myImagebutton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){

            Intent myIntent = new Intent(homepage.this, userprofiles.class);
            startActivity(myIntent);


        }
    } );myImagebutton2.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                Intent myIntent = new Intent(homepage.this, GUI.class);
                startActivity(myIntent);
            }}    );

        myImagebutton3.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                Intent myIntent = new Intent(homepage.this, GUI.class);
                startActivity(myIntent);
            }}    );
        myImagebutton4.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                Intent myIntent = new Intent(homepage.this, Web_location.class);
                startActivity(myIntent);
            }}    );
        }
    }

