package pe.edu.cibertec.agendaroom;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class ContactActivity extends AppCompatActivity {

    TextInputEditText etName, etTelephone;
    Contact contact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        etName = findViewById(R.id.etName);
        etTelephone = findViewById(R.id.etTelephone);

        // Si se trata de un nuevo contacto el valor será -1
        // Si se trata de un contacto a modificar el id es mayor a -1

        int id = getIntent().getIntExtra("id", -1);

        // Validar si se está modificando un contacto
        if (id > -1) {
            String name = getIntent().getStringExtra("name");
            String telephone = getIntent().getStringExtra("telephone");

            contact = new Contact(id, name, telephone);
            etName.setText(name);
            etTelephone.setText(telephone);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_contact, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.optionSave:
                String name = etName.getText().toString();
                String telephone = etTelephone.getText().toString();
                if (contact != null) {
                    contact.setName(name);
                    contact.setTelephone(telephone);
                    AppDatabase.getInstance(this).contactDao().update(contact);

                } else {
                    contact = new Contact(name, telephone);
                    AppDatabase.getInstance(this).contactDao().insert(contact);
                }
                break;
            case R.id.optionDelete:
                AppDatabase.getInstance(this).contactDao().delete(contact);
                break;
        }

        finish();
        return true;
    }
}
