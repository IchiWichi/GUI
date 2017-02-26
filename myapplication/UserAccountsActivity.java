package bonaguasato.gui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageButton;
import android.view.View;
import android.content.Intent;


public class UserAccountsActivity extends AppCompatActivity {

    ImageButton ic_launcher;



    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_accounts);

     ic_launcher = (ImageButton) findViewById(R.id.ownerbutton);

        ic_launcher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserAccountsActivity.this, GUI.class);
                startActivity(intent);
            }
    }
     });
}