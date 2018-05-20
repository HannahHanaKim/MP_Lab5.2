package com.example.hannahkim.lab5_2;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static java.lang.Integer.parseInt;

public class MainActivity extends AppCompatActivity {

    TextView textView1;
    TextView textView2;
    TextView result;
    EditText editText;
    Button button;

    String string = "";
    int fact = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView1 = (TextView)findViewById(R.id.textView01);
        textView2 = (TextView)findViewById(R.id.textView02);
        result = (TextView)findViewById(R.id.textView03);
        editText = (EditText)findViewById(R.id.editText);
        button = (Button)findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                new FactorialTask().execute();
            }
        });

    }

    private class FactorialTask extends AsyncTask<Void, String, Void> {

        protected Void doInBackground(Void... params) {

            int value = Integer.parseInt(editText.getText().toString());

            for (int i = value; i > 0; i--) {
                try {
                    Thread.sleep(500);
                    fact *= i;
                    string += Integer.toString(i) + " ";
                    publishProgress(string);
                } catch (Exception e) {}
            }
            return null;
        }

        protected void onProgressUpdate(String... values) {
            textView2.setText(values[0]);
        }

        protected void onPostExecute(Void aVoid) {
            result.setText("= " + Integer.toString(fact));
        }
    }
}
