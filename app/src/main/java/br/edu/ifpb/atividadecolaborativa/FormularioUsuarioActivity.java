package br.edu.ifpb.atividadecolaborativa;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.net.HttpURLConnection;
import java.net.ProtocolException;

import br.edu.ifpb.atividadecolaborativa.dao.UsuarioDAO;
import br.edu.ifpb.atividadecolaborativa.formularioHelper.FormularioHelperUsuario;
import br.edu.ifpb.atividadecolaborativa.modelo.Usuario;

public class FormularioUsuarioActivity extends AppCompatActivity {

    private FormularioHelperUsuario helperUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_usuario);


        helperUsuario = new FormularioHelperUsuario(this);

        Button buttonCriarConta = (Button) findViewById(R.id.botao_criar_conta);
        buttonCriarConta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UsuarioDAO dao = new UsuarioDAO(FormularioUsuarioActivity.this);
                Usuario usuario = helperUsuario.pegaUsuario();
                dao.salvarUsuario(usuario);
                dao.close();
                Toast.makeText(FormularioUsuarioActivity.this, "Usuario " + usuario.getNome() + " salvo!", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }



}
