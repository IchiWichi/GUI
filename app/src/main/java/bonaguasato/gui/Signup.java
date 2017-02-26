package bonaguasato.gui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;



/**
 * Created by kouichisato on 1/31/17.
 */

public class Signup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);

        TextView goHome = (TextView) findViewById(R.id.home);
      //  Button register = (Button) findViewById(R.id.reg);



        goHome.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                Intent toMain = new Intent(Signup.this, homepage.class);
                startActivity(toMain);
            }
        });

      //  register.setOnClickListener(new View.OnClickListener() {
     //       public void onClick(View v) {
      //          // Perform action on click
       //         DBHandler db = new DBHandler(v.getContext());
        //        Intent toMain = new Intent(Signup.this, homepage.class);
         //       EditText user = (EditText) findViewById(R.id.etUsername);
          //      EditText pass = (EditText) findViewById(R.id.etPassword);
           //     String userValue = user.getText().toString();
            //    String passValue = pass.getText().toString();
             //   int charUserLength = userValue.length();
               // int charPassLength = passValue.length();
               // boolean userMatch = db.sameUser(userValue);

//                if (userMatch) { //Checks to see if the UserName already exists
  //                  Toast.makeText(Signup.this, "UserName Already Taken", Toast.LENGTH_LONG).show();
    //            }
      //          else if (userValue.equals("") && passValue.equals("")) {
        //            Toast.makeText(Signup.this, "Fields Empty", Toast.LENGTH_SHORT).show();
          //      }
            //    else if (charUserLength <= 5 && charPassLength <= 5) {
              //      Toast.makeText(Signup.this, "Characters too short", Toast.LENGTH_SHORT).show();
               // }
                //else {
                  //  db.addUsers(new UBAS(null, userValue, passValue));
                  //  startActivity(toMain);
               // }

           // }

        //});

    }
}
