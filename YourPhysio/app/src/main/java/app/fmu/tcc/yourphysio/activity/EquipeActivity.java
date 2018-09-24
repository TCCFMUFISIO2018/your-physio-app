package app.fmu.tcc.yourphysio.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import app.fmu.tcc.yourphysio.R;

public class EquipeActivity extends AppCompatActivity {

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equipe);

        toolbar = findViewById(R.id.toolbar);

        toolbar.setTitle(R.string.tituloToolbarEquipe);
        setSupportActionBar(toolbar);
    }
}
