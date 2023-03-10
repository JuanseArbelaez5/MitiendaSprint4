package com.example.mitiendac4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.example.mitiendac4.Adaptadores.ProductoAdapter;
import com.example.mitiendac4.DataBases.DBFirebases;
import com.example.mitiendac4.Entidades.Producto;

import java.util.ArrayList;

public class Catalogo extends AppCompatActivity {
    private ListView listViewProd;
    private ArrayList<Producto> arrayProductos;
    private ProductoAdapter productoAdapter;
    private DBFirebases dbFirebases;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalogo);

        listViewProd = (ListView) findViewById(R.id.listViewProd);
        arrayProductos = new ArrayList<>();
        dbFirebases = new DBFirebases();
        /*
        //****PRODUCTOS
        Producto producto1 = new Producto("Producto1", "Desc1", 10000, "", "");
        Producto producto2 = new Producto("Producto2", "Desc2", 20000, "", "");
        Producto producto3 = new Producto("Producto3", "Desc3", 30000, "", "");
        Producto producto4 = new Producto("Producto4", "Desc4", 40000, "", "");
        Producto producto5 = new Producto("Producto5", "Desc5", 50000, "", "");
        Producto producto6 = new Producto("Producto6", "Desc6", 60000, "", "");
        Producto producto7 = new Producto("Producto7", "Desc7", 70000, "", "");

        arrayProductos.add(producto1);
        arrayProductos.add(producto2);
        arrayProductos.add(producto3);
        arrayProductos.add(producto4);
        arrayProductos.add(producto5);
        arrayProductos.add(producto6);
        arrayProductos.add(producto7);
        */
        //**** *** ***
        productoAdapter = new ProductoAdapter(this , arrayProductos);
        listViewProd.setAdapter(productoAdapter);

        dbFirebases.getData(productoAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent intent;
        switch (item.getItemId()){
            case R.id.itemAdd:
                intent = new Intent(getApplicationContext(), Form.class);
                startActivity(intent);
                return true;
                /*
            case R.id.itemMap:
                intent = new Intent(getApplicationContext(), Map.class);
                startActivity(intent);
                return true;

                 */
            default:
        return super.onOptionsItemSelected(item);
    }
}
}


