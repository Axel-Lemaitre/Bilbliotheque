package com.example.vbobet.bilbliotheque;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnVoirLivres = (Button) findViewById(R.id.btnVoirLivres);
        btnVoirLivres.setOnClickListener(observerClickButton);
    }

    private View.OnClickListener observerClickButton = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            switch (v.getId()){
                case R.id.btnVoirLivres:
                    Intent i;
                    i = new Intent(getApplicationContext(), ListeLivres.class);
                    startActivity(i);
            }
        }
    };
}
