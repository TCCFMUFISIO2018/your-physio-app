package app.fmu.tcc.yourphysio.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import app.fmu.tcc.yourphysio.R;
import app.fmu.tcc.yourphysio.helper.Preferencias;

public class CadastroActivity extends AppCompatActivity {

    private Toolbar toolbar;

    private EditText nome; //editTextNomeUsuarioCadastro
    private EditText email; //editTextEmailUsuarioCadastro
    private EditText senha; //editTextSenhaUsuarioCadastro
    private EditText senhaRepet; //editTextSenhaUsuarioCadastroRepetido
    private Button cadastrar; //botaoCadastrar

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        toolbar = findViewById(R.id.toolbar);

        nome = findViewById(R.id.editTextNomeUsuarioCadastro);
        email = findViewById(R.id.editTextEmailUsuarioCadastro);
        senha = findViewById(R.id.editTextSenhaUsuarioCadastro);
        senhaRepet = findViewById(R.id.editTextSenhaUsuarioCadastroRepetido);

        toolbar.setTitle(R.string.tituloToolbarCadastro); //Informando título da toolbar
        setSupportActionBar(toolbar); //passando o suporte de ação na toolbar, para aparecer os ícones e deixá-los funcionais

        cadastrar = findViewById(R.id.botaoCadastrar);

        cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String senhaComparacao, senhaRepetidaComparacao, campoVazio;
                campoVazio = "";
                senhaComparacao = senha.getText().toString();
                senhaRepetidaComparacao = senhaRepet.getText().toString();

                /*Compara se todos os campos estão preenchidos, se as senhas estão corretas e depois tenta cadastrar*/
                if(nome.getText().toString().equals(campoVazio)){
                    Toast.makeText(getApplicationContext(), R.string.erroCampoNomeUsuarioVazio, Toast.LENGTH_SHORT).show();
                }
                else if(email.getText().toString().equals(campoVazio)){
                    Toast.makeText(getApplicationContext(), R.string.erroCampoEmailUsuarioVazio, Toast.LENGTH_SHORT).show();
                }
                else if(senha.getText().toString().equals(campoVazio)){
                    Toast.makeText(getApplicationContext(), R.string.erroCampoSenhaUsuarioVazia, Toast.LENGTH_SHORT).show();
                }
                else if(senha.getText().toString().equals(campoVazio)){
                    Toast.makeText(getApplicationContext(), R.string.erroCampoSenhaRepetidaUsuarioVazia, Toast.LENGTH_SHORT).show();
                }
                else if(!(senhaComparacao.equals(senhaRepetidaComparacao))){
                    Toast.makeText(getApplicationContext(), R.string.erroSenhasDesiguais, Toast.LENGTH_SHORT).show();
                }
                else{
                    salvarUsuario(nome.getText().toString(), email.getText().toString(), senha.getText().toString());
                    irMainActivity();
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_cadastro, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.itemAjudaCadastro:
                Toast.makeText(getApplicationContext(), R.string.textoAjudaCadastro, Toast.LENGTH_LONG).show();
                return true;
            case R.id.itemTermosCondicoes:
                Toast.makeText(getApplicationContext(), "Termos e Condições Cadastro", Toast.LENGTH_LONG).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void irMainActivity() {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    private void salvarUsuario(String nomeUsuario, String emailUsuario, String senhaUsuario){
        Preferencias preferencias = new Preferencias(getApplicationContext());
        preferencias.salvarDados(nomeUsuario, emailUsuario, "logado");
    }
}
