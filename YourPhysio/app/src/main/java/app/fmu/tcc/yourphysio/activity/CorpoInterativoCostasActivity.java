package app.fmu.tcc.yourphysio.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.TextureView;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import app.fmu.tcc.yourphysio.R;

public class CorpoInterativoCostasActivity extends AppCompatActivity implements View.OnClickListener{

    private TextureView nuca; //textureViewNucaCostas
    private TextureView dorsoBracoEsquerdo; //textureViewDorsoBracoEsquerdoCostas
    private TextureView dorsoBracoDireito; //textureViewDorsoBracoDireitoCostas
    private TextureView coluna; //textureViewColunaCostas
    private TextureView dorsoAnteBracoEsquerdo; //textureViewDorsoAnteBracoEsquerdoCostas
    private TextureView dorsoAnteBracoDireito; //textureViewDorsoAnteBracoDireitoCostas
    private TextureView nadegas; //textureViewNadegasCostas
    private TextureView dorsoCoxaEsquerda; //textureViewDorsoCoxaEsquerdaCostas
    private TextureView dorsoCoxaDireita; //textureViewDorsoCoxaDireitaCostas
    private TextureView panturrilhaEsquerda; //textureViewPanturrilhaEsquerdaCostas
    private TextureView panturrilhaDireita; //textureViewPanturrilhaDireitaCostas
    private TextureView calcanharEsquerdo; //textureViewCalcanharEsquerdoCostas
    private TextureView calcanharDireito; //textureViewCalcanharDireitoCostas

    private ImageView flip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_corpo_interativo_costas);

        nuca = findViewById(R.id.textureViewNucaCostas);
        dorsoBracoEsquerdo = findViewById(R.id.textureViewDorsoBracoEsquerdoCostas);
        dorsoBracoDireito = findViewById(R.id.textureViewDorsoBracoDireitoCostas);
        coluna = findViewById(R.id.textureViewColunaCostas);
        dorsoAnteBracoEsquerdo = findViewById(R.id.textureViewDorsoAnteBracoEsquerdoCostas);
        dorsoAnteBracoDireito = findViewById(R.id.textureViewDorsoAnteBracoDireitoCostas);
        nadegas = findViewById(R.id.textureViewNadegasCostas);
        dorsoCoxaEsquerda = findViewById(R.id.textureViewDorsoCoxaEsquerdaCostas);
        dorsoCoxaDireita = findViewById(R.id.textureViewDorsoCoxaDireitaCostas);
        panturrilhaEsquerda = findViewById(R.id.textureViewPanturrilhaEsquerdaCostas);
        panturrilhaDireita = findViewById(R.id.textureViewPanturrilhaDireitaCostas);
        calcanharEsquerdo = findViewById(R.id.textureViewCalcanharEsquerdoCostas);
        calcanharDireito = findViewById(R.id.textureViewCalcanharDireitoCostas);

        flip = findViewById(R.id.imageViewFlipCostas);


        //Aplicando evento de clique nos TextureView's e na ImageView flip
        nuca.setOnClickListener(this);
        dorsoBracoEsquerdo.setOnClickListener(this);
        dorsoBracoDireito.setOnClickListener(this);
        coluna.setOnClickListener(this);
        dorsoAnteBracoEsquerdo.setOnClickListener(this);
        dorsoAnteBracoDireito.setOnClickListener(this);
        nadegas.setOnClickListener(this);
        dorsoCoxaEsquerda.setOnClickListener(this);
        dorsoCoxaDireita.setOnClickListener(this);
        panturrilhaEsquerda.setOnClickListener(this);
        panturrilhaDireita.setOnClickListener(this);
        calcanharEsquerdo.setOnClickListener(this);
        calcanharDireito.setOnClickListener(this);

        flip.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.textureViewNucaCostas:
                Toast.makeText(getApplicationContext(), "Nuca", Toast.LENGTH_SHORT).show();
                break;
            case R.id.textureViewDorsoBracoEsquerdoCostas:
                Toast.makeText(getApplicationContext(), "Dorso Braço Esquerdo", Toast.LENGTH_SHORT).show();
                break;
            case R.id.textureViewDorsoBracoDireitoCostas:
                Toast.makeText(getApplicationContext(), "Dorso Braço Direito", Toast.LENGTH_SHORT).show();
                break;
            case R.id.textureViewColunaCostas:
                Toast.makeText(getApplicationContext(), "Coluna", Toast.LENGTH_SHORT).show();
                break;
            case R.id.textureViewDorsoAnteBracoEsquerdoCostas:
                Toast.makeText(getApplicationContext(), "Dorso Ante Braço Esquerdo", Toast.LENGTH_SHORT).show();
                break;
            case R.id.textureViewDorsoAnteBracoDireitoCostas:
                Toast.makeText(getApplicationContext(), "Dorso Ante Braço Direito", Toast.LENGTH_SHORT).show();
                break;
            case R.id.textureViewNadegasCostas:
                Toast.makeText(getApplicationContext(), "Nadegas", Toast.LENGTH_SHORT).show();
                break;
            case R.id.textureViewDorsoCoxaEsquerdaCostas:
                Toast.makeText(getApplicationContext(), "Dorso Coxa Esquerda", Toast.LENGTH_SHORT).show();
                break;
            case R.id.textureViewDorsoCoxaDireitaCostas:
                Toast.makeText(getApplicationContext(), "Dorso Coxa Direita", Toast.LENGTH_SHORT).show();
                break;
            case R.id.textureViewPanturrilhaEsquerdaCostas:
                Toast.makeText(getApplicationContext(), "Panturrilha Esquerda", Toast.LENGTH_SHORT).show();
                break;
            case R.id.textureViewPanturrilhaDireitaCostas:
                Toast.makeText(getApplicationContext(), "Panturrilha Direita", Toast.LENGTH_SHORT).show();
                break;
            case R.id.textureViewCalcanharEsquerdoCostas:
                Toast.makeText(getApplicationContext(), "Calcanhar Esquerdo", Toast.LENGTH_SHORT).show();
                break;
            case R.id.textureViewCalcanharDireitoCostas:
                Toast.makeText(getApplicationContext(), "Calcanhar Direito", Toast.LENGTH_SHORT).show();
                break;

            case R.id.imageViewFlipCostas:
                IrCorpoInterativoFrenteActivity();
                break;
        }
    }

    private void IrCorpoInterativoFrenteActivity() {
        Intent intent = new Intent(getApplicationContext(), CorpoInterativoFrenteActivity.class);
        startActivity(intent);
        finish();
    }
}
