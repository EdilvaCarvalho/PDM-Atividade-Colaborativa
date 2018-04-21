package br.edu.ifpb.atividadecolaborativa;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import br.edu.ifpb.atividadecolaborativa.dao.UsuarioDAO;
import br.edu.ifpb.atividadecolaborativa.formularioHelper.FormularioHelperLogin;
import br.edu.ifpb.atividadecolaborativa.modelo.Usuario;
import br.edu.ifpb.atividadecolaborativa.rest.NetworkUtils;

public class MainActivity extends AppCompatActivity {

    private ProgressDialog load;
    private FormularioHelperLogin helperLogin;
    public static final String PREFS_NAME = "MyPrefsFile";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        helperLogin = new FormularioHelperLogin(this);

        Button buttonLogin = (Button) findViewById(R.id.login_botao_entrar);
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UsuarioDAO dao = new UsuarioDAO(MainActivity.this);
                Usuario usuario = dao.login(helperLogin.getCampoEmail(), helperLogin.getCampoSenha());
                dao.close();
                if(usuario != null) {
                    SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
                    SharedPreferences.Editor editor = settings.edit();
                    editor.putLong("user", usuario.getId());
                    editor.commit();
                    Intent intent = new Intent(MainActivity.this, ListaAbastecimentoPorDataActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "Email ou senha inválidos!", Toast.LENGTH_LONG).show();
                }
            }
        });

        Button buttonCriarConta = (Button) findViewById(R.id.login_botao_criar_conta);
        buttonCriarConta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentVaiPraFormularioUsuario = new Intent(MainActivity.this, FormularioUsuarioActivity.class);
                startActivity(intentVaiPraFormularioUsuario);
            }
        });

      //  GetJson gj = new GetJson();
       // gj.execute();
        //String resultado = NetworkUtils.GetJASONFromApi("http://10.3.132.140:8080/webService/webapi/Abastecimentos/ultimo/1/ETANOL_COMUM");


    }/*
    private class GetJson extends AsyncTask<Void, Void, String>{

        @Override
        protected void onPreExecute(){
            load = ProgressDialog.show(MainActivity.this, "Por favor Aguarde ...", "Recuperando Informações do Servidor...");

        }

        @Override
        protected String doInBackground(Void... voids) {
            return NetworkUtils.GetJASONFromApi("http://desktop-ll3viks:8080/webService/webapi/Abastecimentos/ultimo/1/ETANOL_COMUM");
        }
        @Override
        protected void onPostExecute(String texto){
            Log.i("Resultado", texto);
            load.dismiss();
        }
    }*/

    @Override
    protected void onResume() {
        if(getIntent().getBooleanExtra("SAIR", false)){
            finish();
        }
        super.onResume();
    }
}
