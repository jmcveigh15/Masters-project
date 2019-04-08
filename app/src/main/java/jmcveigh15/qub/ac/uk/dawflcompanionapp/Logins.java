package jmcveigh15.qub.ac.uk.dawflcompanionapp;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Logins extends AppCompatActivity implements View.OnClickListener {

    private Button buttonRegister;

    private EditText editTextEmail;
    private EditText editTextPassword;
    private TextView textViewSignIn;

    private ProgressDialog mProgressDialog;

    private FirebaseAuth mFirebaseAuth;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logins);

        mFirebaseAuth = FirebaseAuth.getInstance();

        mProgressDialog = new ProgressDialog(this);

        buttonRegister = (Button) findViewById(R.id.buttonRegister);

        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);

        textViewSignIn = (TextView) findViewById(R.id.textViewSignIn);

        buttonRegister.setOnClickListener(this);
        textViewSignIn.setOnClickListener(this);

    }

    private void registerUser() {
        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

        if (TextUtils.isEmpty(email)) {
            // email is empty
            Toast.makeText(this, "Please enter email", Toast.LENGTH_SHORT).show();
            // return stops proceeding with empty email String
            return;
        }

        if (TextUtils.isEmpty(password)) {
            // password is empty
            Toast.makeText(this, "Please enter password", Toast.LENGTH_SHORT).show();
            // return stops proceeding with empty password String
            return;
        }

        // if validations are ok, we will show a progress dialog
        mProgressDialog.setMessage("Registering User...");
        mProgressDialog.show();

        mFirebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // user is successfully registered and logged in
                            // just use a Toast for now
                            Toast.makeText(Logins.this, "Successfully Registered", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(Logins.this, "Unable To Register", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

    }

    @Override
    public void onClick(View v) {
        if (v == buttonRegister) {
            registerUser();
        }

        if (v == textViewSignIn) {
            // sign in activity
        }
    }
}
