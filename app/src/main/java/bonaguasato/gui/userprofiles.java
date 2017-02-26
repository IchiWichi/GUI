package bonaguasato.gui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

public class userprofiles extends AppCompatActivity {
    ImageButton myimagebutton, myimagebutton2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userprofiles);

        myimagebutton = (ImageButton) findViewById(R.id.imageButtonowner);
        myimagebutton2 = (ImageButton)findViewById(R.id.imageButtonguest);

        myimagebutton2.setOnClickListener(new OnClickListener() {
                                              @Override
                                              public void onClick(View view) {
                                                  Intent myIntent = new Intent(userprofiles.this, homepage.class);
                                                  startActivity(myIntent);
                                              }
                                          });
        myimagebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){

                Intent myIntent = new Intent(userprofiles.this, GUI.class);
                startActivity(myIntent);



        }
    });
}}
