package com.alclabs.sortingrecyclerview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.alclabs.sortingrecyclerview.Adaptadores.MyRecyclerViewAdapter;
import com.alclabs.sortingrecyclerview.Entidades.Empleado;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<Empleado> listaEmpleados;
    MyRecyclerViewAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        listaEmpleados = new ArrayList<>();
        cargarLista();
        //Ordenar lista metodo nativo
        //Collections.sort(listaEmpleados); //esto ordena automaticamente por id

        //Collections.sort(listaEmpleados, Empleado.OrdenarPorNombreAscendente);
        //Collections.sort(listaEmpleados, Empleado.OrdenarPorNombreDescendente);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MyRecyclerViewAdapter( this,listaEmpleados);
        recyclerView.setAdapter(adapter);

    }
    public void cargarLista(){
        listaEmpleados.add(new Empleado(2,"Fredd",2300));
        listaEmpleados.add(new Empleado(3,"Daniel",850));
        listaEmpleados.add(new Empleado(1,"Amanda",1500));
        listaEmpleados.add(new Empleado(4,"Samuel",4500.50));
        listaEmpleados.add(new Empleado(5,"William",5400.40));
        listaEmpleados.add(new Empleado(6,"Fernando",20000));
        listaEmpleados.add(new Empleado(7,"Oliver",5000.20));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.asc:
                //Ordenar ascendentemente
                Toast.makeText(this, "Ordenar Ascendentemente", Toast.LENGTH_SHORT).show();
                Collections.sort(listaEmpleados, Empleado.OrdenarPorNombreAscendente);
                adapter.notifyDataSetChanged();
                //recyclerView.setAdapter(adapter);

                return true;
            case R.id.desc:
                Toast.makeText(this, "Ordenar Descendentemente", Toast.LENGTH_SHORT).show();
                Collections.sort(listaEmpleados, Empleado.OrdenarPorNombreDescendente);
                adapter.notifyDataSetChanged();
                //recyclerView.setAdapter(adapter);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }

    }
}
