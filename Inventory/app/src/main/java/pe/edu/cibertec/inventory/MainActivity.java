package pe.edu.cibertec.inventory;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // Vista
    RecyclerView rvProduct;

    // Modelo: información a mostrar
    ArrayList<Product> items;

    // Adaptador
    AdapterProduct adapterProduct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Enlaza variable con su vista a partir del id
        rvProduct = findViewById(R.id.rvProduct);

        // Asigna espacio en memoria para el arreglo
        items = new ArrayList<>();

        // Carga la información a mostrar
        loadItems();

        // Inicaliza el adaptador
        adapterProduct = new AdapterProduct(items);
    }

    private void loadItems() {
        // Instancia un objeto de la clase Product
        Product productLaptop = new Product("Laptop",
                        "Marca Toshiba", 2);

        // Agrega el objeto creado a la lista
        items.add(productLaptop);

        Product productMouse = new Product("Mouse",
                "Modelo Genious", 122);
        items.add(productMouse);



    }
}
