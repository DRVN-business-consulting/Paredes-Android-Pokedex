package dev.joely.a3rdday;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import dev.joely.a3rdday.R;

public class MainActivity extends AppCompatActivity {

    private EditText usernameEditText, passwordEditText;
    private TextView errorTextView;

    private static final String VALID_USERNAME = "admin";
    private static final String VALID_PASSWORD = "12345";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernameEditText = findViewById(R.id.usernameEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        errorTextView = findViewById(R.id.errorTextView);
        Button loginButton = findViewById(R.id.loginButton);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                if (validateLogin(username, password)) {
                    Intent intent = new Intent(MainActivity.this, PokemonListActivity.class);
                    startActivity(intent);
                } else {
                    errorTextView.setVisibility(View.VISIBLE);
                    errorTextView.setText("Invalid username or password");
                }
            }
        });
    }

    private boolean validateLogin(String username, String password) {
        return username.equals(VALID_USERNAME) && password.equals(VALID_PASSWORD);
    }
}
