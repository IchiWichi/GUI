package bonaguasato.gui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by kouichisato on 1/31/17.
 */


public class Success extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        //Attaching to views
        //TextView goHome = (TextView) findViewById(R.id.home);
        //TextView goSignUp = (TextView) findViewById(R.id.sign);
        //Underlining TextView
       // goHome.setPaintFlags(goHome.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);
       // goSignUp.setPaintFlags(goSignUp.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);
        //Onclick to navigate to other .classes.
      //  BtnLogin.setOnClickListener(new View.OnClickListener() {
         //   public void onClick(View v) {
                // Perform action on click
           //     Intent toMain = new Intent(Success.this, GUI.class);
             //   startActivity(toMain);
          //  }
        //});
        //goSignUp.setOnClickListener(new View.OnClickListener() {
          //  public void onClick(View v) {
                // Perform action on click
              //  Intent toSuc = new Intent(Success.this, GUI.class);
            //    startActivity(toSuc);
          //  }
       // });
    }
}

