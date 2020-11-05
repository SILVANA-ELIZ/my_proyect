package com.example.my_proyect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import java.util.ArrayList;

public class Menu_Act extends AppCompatActivity {

    private ViewFlipper vf;
    private int[]images = {R.drawable.a, R.drawable.b, R.drawable.c};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_);

        vf = (ViewFlipper)findViewById(R.id.slider);
        for(int i = 0; i < images.length; i++)
        {
            flip_image(images[i]);
        }
    }
//configuracion de slider
    public  void  flip_image(int i)
    {
        //configuracion del slider
        ImageView view = new ImageView(this);
        view.setBackgroundResource(i);

        vf.addView((view));   //añadimos imagenes al viewflipper
        vf.setFlipInterval(2300);  //su desplazamiento será de 2300 mill
        vf.setAutoStart(true); //inicir de forma automatica

        //sentido al slider.
        vf.setInAnimation(this, android.R.anim.slide_in_left);
        vf.setInAnimation(this, android.R.anim.slide_out_right);
    }
    public void Maps (View v)
    {
        Intent i = new Intent(this,Maps_act.class);
        startActivity(i);
    }

    public void info(View v)
    {
        Intent i = new Intent(this, info_Act.class);
        startActivity(i);
    }

    public void Clientes(View v)
    {
        ArrayList<String>clientes = new ArrayList<String>();
        ArrayList<String>planes = new ArrayList<String>();

        clientes.add("Silvana");
        clientes.add("Luciano");
        clientes.add("Elizabeth");
        clientes.add("Eduardo");

        planes.add("xtreme");
        planes.add("mindfullnes");
        planes.add("premium");
        planes.add("fitnes");

        Intent i = new Intent(this, Clientes_act.class);
        i.putExtra("listaClientes", clientes);
        i.putExtra("listaPlanes", planes);
        startActivity(i);
    }
}