package com.example.josep.mascotascoursera;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by josep on 25/11/2017.
 */

public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder>
{
    ArrayList<InfoMascota> listaInfo;
    public MascotaAdaptador(ArrayList<InfoMascota> listaInfo)
    {
        this.listaInfo = listaInfo;
    }
    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota , parent,false);
        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final MascotaViewHolder holder, int position)
    {
        final InfoMascota infoMascota = listaInfo.get(position);
        holder.imgMascota.setImageResource(infoMascota.getFoto());
        holder.patamg.setImageResource(infoMascota.getPatamg());
        holder.pata.setImageResource(infoMascota.getPata());
        holder.nombre.setText(infoMascota.getNombre());
        holder.numRating.setText(infoMascota.getRating());
        holder.pata.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                int cont;
                if(infoMascota.isA())
                {
                    cont = Integer.parseInt( infoMascota.getRating()) - 1;
                    infoMascota.setA(false);
                    holder.pata.setImageResource(R.drawable.pata);
                }
                else
                {
                    cont = Integer.parseInt( infoMascota.getRating()) + 1;
                    holder.pata.setImageResource(R.drawable.patamg);
                    infoMascota.setA(true);
                }
                infoMascota.setRating(String.valueOf(cont));
                holder.numRating.setText(String.valueOf(cont));
            }
        });
    }

    @Override
    public int getItemCount()
    {
        return listaInfo.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder
    {
        private ImageView imgMascota , pata , patamg;
        private TextView numRating , nombre;
        public MascotaViewHolder(View itemView)
        {
            super(itemView);
            imgMascota = (ImageView)itemView.findViewById(R.id.fotoMascota);
            patamg = (ImageView)itemView.findViewById(R.id.patamg);
            pata = (ImageView)itemView.findViewById(R.id.pata);
            numRating = (TextView)itemView.findViewById(R.id.numRatings);
            nombre = (TextView)itemView.findViewById(R.id.nombre);
        }
    }

}
