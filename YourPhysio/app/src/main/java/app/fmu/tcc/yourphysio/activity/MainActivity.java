package app.fmu.tcc.yourphysio.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.TextView;

import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import app.fmu.tcc.yourphysio.R;
import app.fmu.tcc.yourphysio.fragment.DadosContaFragment;
import app.fmu.tcc.yourphysio.fragment.ExerciciosFragment;
import app.fmu.tcc.yourphysio.fragment.HomeFragment;
import app.fmu.tcc.yourphysio.helper.Preferencias;


public class MainActivity extends AppCompatActivity {
    private FrameLayout frameLayoutContainerFragment;
    BottomNavigationView navigation;
    private boolean noReplaceFragment; //Variável de controle para não criar outro Fragment quando estiver já ativo na tela
    private static final String HOME_FRAGMENT = "homeFragment";
    private static final String EXERCICIOS_FRAGMENT = "exerciciosFragment";
    private static final String DADOS_CONTA_FRAGMENT = "dadosContaFragment";

    private Preferencias preferencias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        frameLayoutContainerFragment = findViewById(R.id.idContainerFragment);
        navigation = findViewById(R.id.bottom_navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        //Implementando o Fragment quando a ActivityMain é criada
        HomeFragment homeFragment = new HomeFragment();
        managerFragment(homeFragment, "homeFragment");

        preferencias = new Preferencias(getApplicationContext());
        String logado = preferencias.getLogado();
        if(logado == null){
            irLoginActivity();
        }

    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    if(!noReplaceFragment) { //Fragment será true apenas caso o usuário aperte o botão voltar do dispositivo, é usado apenas para mudar a cor do icon no bottomNavigation
                        HomeFragment homeFragment = new HomeFragment();
                        managerFragment(homeFragment, "homeFragment");
                    }
                    return true;
                case R.id.navigation_exercicios:
                    if(!noReplaceFragment) {
                        ExerciciosFragment exerciciosFragment = new ExerciciosFragment();
                        managerFragment(exerciciosFragment, "exerciciosFragment");
                    }
                    return true;
                case R.id.navigation_dados_conta:
                    if(!noReplaceFragment) {
                        DadosContaFragment dadosContaFragment = new DadosContaFragment();
                        managerFragment(dadosContaFragment, "dadosContaFragment");
                    }
                    return true;
            }
            return false;
        }
    };

    //Método para alterar os Fragments na Activity
    private void managerFragment(Fragment fragment, String tag) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.idContainerFragment, fragment, tag);
        fragmentTransaction.addToBackStack(null);//É usado para colocar os fragments na fila de gerenciamento de pilha da activity, para usar o botão de voltar no dispositivo e ir para a aba home no bottomNavigation
        fragmentTransaction.commit();
    }

    //Método usado quando o botão voltar(onBackPressed) é pressionado
    @Override
    public void onBackPressed() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment homeFragment = fragmentManager.findFragmentByTag(HOME_FRAGMENT);
        //Caso a HomeFragment estiver ativa quando o apertar o botão de voltar, fechará a activity
        if(homeFragment != null){
            if(homeFragment.isVisible()){
                finish();
                return;
            }
        }

        super.onBackPressed();
        managerIconesDoBottomNavigation(fragmentManager);
    }

    //Usad
    private void managerIconesDoBottomNavigation(FragmentManager fragmentManager) {
        //Usado para mudar a cor dos ícones da BottomNavigation
        Fragment fragmentHomeAux = fragmentManager.findFragmentByTag(HOME_FRAGMENT);
        if(fragmentHomeAux != null){
            if(fragmentHomeAux.isVisible()){
                noReplaceFragment = true;
                navigation.setSelectedItemId(R.id.navigation_home);
                noReplaceFragment = false;
            }
        }

        Fragment fragmentExerciciosAux = fragmentManager.findFragmentByTag(EXERCICIOS_FRAGMENT);
        if(fragmentExerciciosAux != null){
            if(fragmentExerciciosAux.isVisible()){
                noReplaceFragment = true;
                navigation.setSelectedItemId(R.id.navigation_exercicios);
                noReplaceFragment = false;
            }
        }

        Fragment fragmentDadosContaAux = fragmentManager.findFragmentByTag(DADOS_CONTA_FRAGMENT);
        if(fragmentDadosContaAux != null){
            if(fragmentDadosContaAux.isVisible()){
                noReplaceFragment = true;
                navigation.setSelectedItemId(R.id.navigation_dados_conta);
                noReplaceFragment = false;
            }
        }
    }

    private void irLoginActivity() {
        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}