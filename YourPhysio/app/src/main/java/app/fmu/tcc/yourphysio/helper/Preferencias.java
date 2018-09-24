package app.fmu.tcc.yourphysio.helper;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by richard.ambrosio on 11/05/2018.
 */

public class Preferencias {
    private Context contexto;

    private final String NOME_ARQUIVO = "yourphysio.preferencias";
    private int MODE = 0;
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;

    private String CHAVE_EMAIL = "emailUsuarioLogado";
    private String CHAVE_NOME = "nomeUsuarioLogado";
    private String CHAVE_LOGADO = "flagUsuarioLogado";
    private String CHAVE_SENHA = "senhaUsuarioLogado";

    public Preferencias(Context contextoParametro) {
        contexto = contextoParametro;

        preferences = contexto.getSharedPreferences(NOME_ARQUIVO, MODE);
        editor = preferences.edit();
    }

    public void salvarDados(String nomeUsuario, String emailUsuario, String logado) {
        editor.putString(CHAVE_EMAIL, emailUsuario);
        editor.putString(CHAVE_NOME, nomeUsuario);
        editor.putString(CHAVE_LOGADO, logado);
        editor.commit();
    }

    public void sair(){
        editor.putString(CHAVE_LOGADO, null);
        editor.commit();
    }

    public void login(){
        editor.putString(CHAVE_LOGADO, "logado");
        editor.commit();
    }

    public String getEmail(){
        return preferences.getString(CHAVE_EMAIL, null);
    }

    public String getNome(){
        return preferences.getString(CHAVE_NOME, null);
    }

    public String getLogado(){
        return preferences.getString(CHAVE_LOGADO, null);
    }

}
