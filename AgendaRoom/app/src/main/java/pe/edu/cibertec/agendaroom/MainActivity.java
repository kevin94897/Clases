package pe.edu.cibertec.agendaroom;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView rvContact;
    ContactAdapter adapter;
    List<Contact> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvContact = findViewById(R.id.rvContact);

        loadItems();
    }

    private void loadItems() {
        items = AppDatabase.getInstance(this).contactDao().getAll();

        adapter = new ContactAdapter(items);

        rvContact.setAdapter(adapter);
        rvContact.setLayoutManager(new LinearLayoutManager(this));

    }
}
