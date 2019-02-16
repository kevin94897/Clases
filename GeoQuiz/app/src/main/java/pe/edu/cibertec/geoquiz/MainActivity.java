package pe.edu.cibertec.geoquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btYes, btNo, btNext, btPrevious;
    TextView tvQuestion;
    int actualPosition;

    ArrayList<Question> questions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btYes = findViewById(R.id.btYes);
        btNo = findViewById(R.id.btNo);
        btNext = findViewById(R.id.btNext);
        btPrevious = findViewById(R.id.btPrevious);


        tvQuestion = findViewById(R.id.tvQuestion);

        actualPosition = 0;

        questions = new ArrayList<>();
        loadQuestions();

        tvQuestion.setText(questions.get(actualPosition).getName());

        btYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,
                        getString(R.string.answer_correct)
                        , Toast.LENGTH_SHORT).show();
            }
        });

        btNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,
                        getString(R.string.answer_incorrect)
                        , Toast.LENGTH_SHORT).show();
            }
        });

        btNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actualPosition += 1;
                tvQuestion.setText(questions.get(actualPosition).getName());

            }
        });

    }

    private void loadQuestions() {
        Question questionPeru =
                new Question(getString(R.string.peru_question), true);

        questions.add(questionPeru);

        Question questionChile =
                new Question(getString(R.string.chile_question), false);

        questions.add(questionChile);


        Question questionColombia =
                new Question(getString(R.string.colombia_question), false);
        questions.add(questionColombia);


    }
}
