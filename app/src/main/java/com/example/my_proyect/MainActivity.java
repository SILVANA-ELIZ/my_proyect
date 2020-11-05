package com.example.my_proyect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    private ProgressBar pb;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pb = (ProgressBar)findViewById(R.id.pb);
        pb.setVisibility(View.INVISIBLE);
        btn = (Button)findViewById(R.id.btn);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Task().execute();

            }
        });
    }

    //implementar el Asyntask

    class Task extends AsyncTask<String, Void, String> {

        @Override // configura el proceso inciial de mi tarea
        protected void onPreExecute() {

            pb.setVisibility(View.VISIBLE);
        }
        @Override // emplea la tarea pesada
        protected String doInBackground(String... strings) {

            for(int i = 1; i<= 10; i++) {
                try {

                    Thread.sleep(1000);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return null;
        }


        @Override // finaliza mi tarea asincrona
        protected void onPostExecute(String s) {

            Intent i = new Intent(getBaseContext(), Menu_Act.class);
            startActivity(i);

        }
    }


    //tarea pesada
    public void Hilo(View v)
    {
        for(int i = 1; i<= 10; i++)
        {
            try {

                Thread.sleep( 2000);

            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }
}