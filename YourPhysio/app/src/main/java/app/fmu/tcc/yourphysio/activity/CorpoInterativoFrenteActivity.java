package app.fmu.tcc.yourphysio.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.TextureView;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import app.fmu.tcc.yourphysio.R;

public class CorpoInterativoFrenteActivity extends AppCompatActivity implements View.OnClickListener{

    private TextureView rosto;
    private TextureView ombroDireito;
    private TextureView ombroEsquerdo;
    private TextureView pulsoDireito;
    private TextureView pulsoEsquerdo;
    private TextureView maoDireita;
    private TextureView maoEsquerda;
    private TextureView joelhoDireito;
    private TextureView joelhoEsquerdo;
    private TextureView peDireito;
    private TextureView peEsquerdo;

    private ImageView flip;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_corpo_interativo_frente);

        rosto = findViewById(R.id.textureViewRosto);
        ombroDireito = findViewById(R.id.textureViewOmbroDireito);
        ombroEsquerdo = findViewById(R.id.textureViewOmbroEsquerdo);
        pulsoDireito = findViewById(R.id.textureViewPulsoDireito);
        pulsoEsquerdo = findViewById(R.id.textureViewPulsoEsquerdo);
        maoDireita = findViewById(R.id.textureViewMaoDireita);
        maoEsquerda = findViewById(R.id.textureViewMaoEsquerda);
        joelhoDireito = findViewById(R.id.textureViewJoelhoDireito);
        joelhoEsquerdo = findViewById(R.id.textureViewJoelhoEsquerdo);
        peDireito = findViewById(R.id.textureViewPeDireito);
        peEsquerdo = findViewById(R.id.textureViewPeEsquerdo);

        flip = findViewById(R.id.imageViewFlipFrente);

        //Aplicando evento de clique nos TextureView's
        rosto.setOnClickListener(this);
        ombroDireito.setOnClickListener(this);
        ombroEsquerdo.setOnClickListener(this);
        pulsoDireito.setOnClickListener(this);
        pulsoEsquerdo.setOnClickListener(this);
        maoDireita.setOnClickListener(this);
        maoEsquerda.setOnClickListener(this);
        joelhoDireito.setOnClickListener(this);
        joelhoEsquerdo.setOnClickListener(this);
        peDireito.setOnClickListener(this);
        peEsquerdo.setOnClickListener(this);

        flip.setOnClickListener(this);

    }


    //Método para capturar os eventos de clique em todos os TextureView's e na ImageView Flip(para trocar a imagem do corpo). Necessário implementar o View.OnClickListener
    @Override
    public void onClick(View view){
        switch (view.getId()){
            case R.id.textureViewRosto:
                Toast.makeText(getApplicationContext(), "Rosto", Toast.LENGTH_SHORT).show();
                break;
            case R.id.textureViewOmbroDireito:
                Toast.makeText(getApplicationContext(), "Ombro Direito", Toast.LENGTH_SHORT).show();
                break;
            case R.id.textureViewOmbroEsquerdo:
                Toast.makeText(getApplicationContext(), "Ombro Esquerdo", Toast.LENGTH_SHORT).show();
                break;
            case R.id.textureViewPulsoDireito:
                Toast.makeText(getApplicationContext(), "Pulso Direito", Toast.LENGTH_SHORT).show();
                break;
            case R.id.textureViewPulsoEsquerdo:
                Toast.makeText(getApplicationContext(), "Pulso Esquerdo", Toast.LENGTH_SHORT).show();
                break;
            case R.id.textureViewMaoDireita:
                Toast.makeText(getApplicationContext(), "Mão Direita", Toast.LENGTH_SHORT).show();
                break;
            case R.id.textureViewMaoEsquerda:
                Toast.makeText(getApplicationContext(), "Mão Esquerda", Toast.LENGTH_SHORT).show();
                break;
            case R.id.textureViewJoelhoDireito:
                Toast.makeText(getApplicationContext(), "Joelho Direito", Toast.LENGTH_SHORT).show();
                break;
            case R.id.textureViewJoelhoEsquerdo:
                Toast.makeText(getApplicationContext(), "Joelho Esquerdo", Toast.LENGTH_SHORT).show();
                break;
            case R.id.textureViewPeDireito:
                Toast.makeText(getApplicationContext(), "Pé Direito", Toast.LENGTH_SHORT).show();
                break;
            case R.id.textureViewPeEsquerdo:
                Toast.makeText(getApplicationContext(), "Pé Esquerdo", Toast.LENGTH_SHORT).show();
                break;

            case R.id.imageViewFlipFrente:
                IrCorpoInterativoCostasActivity();
                break;
        }
    }

    private void IrCorpoInterativoCostasActivity(){
        Intent intent = new Intent(getApplicationContext(), CorpoInterativoCostasActivity.class);
        startActivity(intent);
        finish();
    }
}