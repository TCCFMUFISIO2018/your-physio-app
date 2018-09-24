package app.fmu.tcc.yourphysio.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import app.fmu.tcc.yourphysio.R;
import app.fmu.tcc.yourphysio.activity.CorpoInterativoFrenteActivity;
import app.fmu.tcc.yourphysio.activity.LesoesComunsActivity;
import app.fmu.tcc.yourphysio.helper.Preferencias;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    private ImageView imageViewLesao;
    private ImageView imageViewLesoesComuns;
    private ImageView imageViewAjuda;

    private TextView boasVindas;

    private Preferencias preferencias;
    private String textoBoasVindas;
    private String nome;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        boasVindas = view.findViewById(R.id.textViewBoasVindas);

        imageViewLesao = view.findViewById(R.id.imageViewItemHomeLesao);
        imageViewLesoesComuns = view.findViewById(R.id.imageViewItemHomeLesoesComuns);
        imageViewAjuda = view.findViewById(R.id.imageViewItemHomeAjuda);

        preferencias = new Preferencias(getActivity());
        nome = preferencias.getNome();
        textoBoasVindas = "Olá, " + nome + "!\nO que deseja fazer?\n\nEscolha na lista abaixo";
        boasVindas.setText(textoBoasVindas);

        imageViewLesao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), CorpoInterativoFrenteActivity.class);
                startActivity(intent);
            }
        });

        imageViewLesoesComuns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), LesoesComunsActivity.class);
                startActivity(intent);
            }
        });

        imageViewAjuda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), R.string.textoAjudaHome, Toast.LENGTH_LONG).show();
            }
        });


        // Inflate the layout for this fragment
        return view;
    }

}
