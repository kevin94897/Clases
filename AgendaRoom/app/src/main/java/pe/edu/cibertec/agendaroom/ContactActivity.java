package pe.edu.cibertec.agendaroom;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class ContactActivity extends AppCompatActivity {

    TextInputEditText etName, etTelephone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        etName = findViewById(R.id.etName);
        etTelephone = findViewById(R.id.etTelephone);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_contact, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        String name = etName.getText().toString();
        String telephone = etTelephone.getText().toString();

        Contact contact = new Contact(name, telephone);

        AppDatabase.getInstance(this).contactDao().insert(contact);
        finish();
        return true;
    }
}
