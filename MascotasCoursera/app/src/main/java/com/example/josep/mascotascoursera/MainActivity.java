package com.example.josep.mascotascoursera;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{

    private RecyclerView listaMascota;
    ArrayList<InfoMascota> listaInfo;
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar miToolbar = (Toolbar)findViewById(R.id.miToolbar);
        setSupportActionBar(miToolbar);
        final ImageView favoritos = (ImageView)findViewById(R.id.fav);
        favoritos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                favoritos(view);
            }
        });
        listaInfo = new ArrayList<>();
        listaInfo.add(new InfoMascota(R.drawable.mascota1,R.drawable.patamg,R.drawable.pata,"firulais","0",false));
        listaInfo.add(new InfoMascota(R.drawable.mascota2,R.drawable.patamg,R.drawable.pata,"firulais","0",false));
        listaInfo.add(new InfoMascota(R.drawable.mascota3,R.drawable.patamg,R.drawable.pata,"firulais","0",false));
        listaInfo.add(new InfoMascota(R.drawable.mascota4,R.drawable.patamg,R.drawable.pata,"firulais","0",false));
        listaInfo.add(new InfoMascota(R.drawable.mascota5,R.drawable.patamg,R.drawable.pata,"firulais","0",false));
        listaInfo.add(new InfoMascota(R.drawable.mascota6,R.drawable.patamg,R.drawable.pata,"firulais","0",false));
        listaInfo.add(new InfoMascota(R.drawable.mascota7,R.drawable.patamg,R.drawable.pata,"firulais","0",false));
        listaInfo.add(new InfoMascota(R.drawable.mascota8,R.drawable.patamg,R.drawable.pata,"firulais","0",false));

        listaMascota = (RecyclerView)findViewById(R.id.recyMascotas);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascota.setLayoutManager(llm);
        MascotaAdaptador adaptador = new MascotaAdaptador(listaInfo);
        listaMascota.setAdapter(adaptador);



    }
    public void favoritos(View v)
    {
        Intent intent = new Intent(MainActivity.this,MascotasFavoritas.class);
        ArrayList<InfoMascota> aux = new ArrayList<>();
        for(InfoMascota i : listaInfo)
        {
            Log.d("Info",i.getNombre());
            if(i.isA()) aux.add(i);

            if(aux.size() == 5) break;
        }
        intent.putExtra("Favoritos",aux);
        startActivity(intent);

    }
}
