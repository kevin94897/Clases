package pe.edu.cibertec.activitylifecycle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btSecondActivity;

    public static final String TAG = "LifyCicle1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btSecondActivity = findViewById(R.id.btSecondActivity);

        btSecondActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                startActivity(intent);
            }
        });

        Log.d(TAG, "Ingresé al método onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.d(TAG, "Ingresé al método onStart");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG,"Ingresé al método onResume");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "Ingresé al método onPause");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "Ingresé al método onStop");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "Ingresé al método onDestroy");

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "Ingresé al método onRestart");

    }
}
