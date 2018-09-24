package app.fmu.tcc.yourphysio.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import app.fmu.tcc.yourphysio.R;
import app.fmu.tcc.yourphysio.helper.Preferencias;

public class LoginActivity extends AppCompatActivity {

    private Toolbar toolbar;

    private EditText nome; //editTextNomeUsuario
    private EditText senha; //editTextSenhaUsuarioCadastro
    private Button login; //botaoLogin
    private TextView semconta; //textViewUsuarioSemConta
    private TextView equipe; //textViewEquipe

    Preferencias preferencias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        toolbar = findViewById(R.id.toolbar);

        nome = findViewById(R.id.editTextNomeUsuario);
        senha = findViewById(R.id.editTextSenhaUsuarioCadastro);

        login = findViewById(R.id.botaoLogin);
        semconta = findViewById(R.id.textViewUsuarioSemConta);
        equipe = findViewById(R.id.textViewEquipe);

        toolbar.setTitle(R.string.app_name); //Informando título da toolbar
        setSupportActionBar(toolbar);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                preferencias = new Preferencias(getApplicationContext());
                String emailPreferencias = preferencias.getEmail();

                if(nome.getText().toString().equals(emailPreferencias)){
                    preferencias.login();

                    irMainActivity();
                }
                else{
                    Toast.makeText(getApplicationContext(), R.string.erroUsuarioSenhaInvalido, Toast.LENGTH_SHORT).show();
                }
            }
        });

        semconta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                irCadastroActivity();
            }
        });
        equipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                irEquipeActivity();
            }
        });
    }

    private void irMainActivity() {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    private void irCadastroActivity() {
        Intent intent = new Intent(getApplicationContext(), CadastroActivity.class);
        startActivity(intent);
    }
    private void irEquipeActivity() {
        Intent intent = new Intent(getApplicationContext(), EquipeActivity.class);
        startActivity(intent);
    }
}
