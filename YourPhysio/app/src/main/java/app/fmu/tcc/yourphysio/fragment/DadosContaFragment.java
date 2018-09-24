package app.fmu.tcc.yourphysio.fragment;



import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import app.fmu.tcc.yourphysio.R;
import app.fmu.tcc.yourphysio.activity.LoginActivity;
import app.fmu.tcc.yourphysio.activity.MainActivity;
import app.fmu.tcc.yourphysio.helper.Base64Custom;
import app.fmu.tcc.yourphysio.helper.Preferencias;


public class DadosContaFragment extends Fragment{

    private Preferencias preferencias;
    private TextView textoEditar;
    private TextView textoSair;
    private ImageView imagemEditar;
    private ImageView imagemSair;

    private ImageView imagemUsuario;
    private TextView nomeUsuario;
    private TextView emailUsuario;
    private TextView idUsuario;

    private String nome;
    private String email;
    private String id;


    public DadosContaFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_dados_conta, container, false);

        imagemUsuario = view.findViewById(R.id.imageViewFotoUsuario);
        nomeUsuario = view.findViewById(R.id.textViewNomeUsuario);
        emailUsuario = view.findViewById(R.id.textViewEmailUsuario);
        idUsuario = view.findViewById(R.id.textViewIdUsuario);

        textoEditar = view.findViewById(R.id.textViewEditarDadosConta);
        imagemEditar = view.findViewById(R.id.imageViewEditarDadosConta);
        textoSair = view.findViewById(R.id.textViewSair);
        imagemSair = view.findViewById(R.id.imageViewSair);

        preferencias = new Preferencias(getActivity());

        nome = preferencias.getNome();
        email = preferencias.getEmail();

        nomeUsuario.setText(nome);
        emailUsuario.setText(email);
        id = Base64Custom.codificarBase64(email);
        idUsuario.setText(id);

        textoEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Editar", Toast.LENGTH_SHORT).show();
            }
        });

        imagemEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Editar", Toast.LENGTH_SHORT).show();
            }
        });

        textoSair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                preferencias.sair();

                IrLoginActivity();
            }
        });

        imagemSair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                preferencias.sair();

                IrLoginActivity();
            }
        });

        return view;
    }

    private void IrLoginActivity() {
        Intent intent = new Intent(getActivity(), LoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

}
