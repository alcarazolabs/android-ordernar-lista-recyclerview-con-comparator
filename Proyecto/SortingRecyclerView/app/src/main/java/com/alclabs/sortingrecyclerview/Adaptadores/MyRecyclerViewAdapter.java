package com.alclabs.sortingrecyclerview.Adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alclabs.sortingrecyclerview.Entidades.Empleado;
import com.alclabs.sortingrecyclerview.R;

import java.util.ArrayList;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> {

    Context context;
    ArrayList<Empleado> model;

    public MyRecyclerViewAdapter(Context context, ArrayList<Empleado> model) {
        this.context = context;
        this.model = model;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.lista_empleados, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtnombre.setText(model.get(position).getNombre());
        holder.txtid.setText(String.valueOf(model.get(position).getId()));
        holder.txtsalario.setText(String.valueOf(model.get(position).getSalario()));

    }

    @Override
    public int getItemCount() {
        return model.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
    private TextView txtnombre, txtid, txtsalario;
    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        txtnombre = itemView.findViewById(R.id.txtempleadonombre);
        txtid = itemView.findViewById(R.id.txtempleadoid);
        txtsalario = itemView.findViewById(R.id.txtempleadosalario);
    }
}

}
