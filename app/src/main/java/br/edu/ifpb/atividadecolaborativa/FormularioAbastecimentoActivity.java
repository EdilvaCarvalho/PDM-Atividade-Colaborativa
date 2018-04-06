package br.edu.ifpb.atividadecolaborativa;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import br.edu.ifpb.atividadecolaborativa.dao.AbastecimentoDAO;
import br.edu.ifpb.atividadecolaborativa.dao.PostoDeCombustivelDAO;
import br.edu.ifpb.atividadecolaborativa.dao.UsuarioDAO;
import br.edu.ifpb.atividadecolaborativa.formularioHelper.FormularioHelperAbastecimento;
import br.edu.ifpb.atividadecolaborativa.modelo.Abastecimento;
import br.edu.ifpb.atividadecolaborativa.modelo.PostoDeCombustivel;
import br.edu.ifpb.atividadecolaborativa.modelo.TipoDeCombustivel;
import br.edu.ifpb.atividadecolaborativa.modelo.Usuario;

public class FormularioAbastecimentoActivity extends AppCompatActivity {

    private FormularioHelperAbastecimento helperAbastecimento;
    public static final String PREFS_NAME = "MyPrefsFile";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_abastecimento);

        Spinner spinnerTipoCombustivel = (Spinner) findViewById(R.id.tipo_combust_spinner);
        spinnerTipoCombustivel.setAdapter(new ArrayAdapter<TipoDeCombustivel>(this,
                android.R.layout.simple_list_item_1, TipoDeCombustivel.values()));

        PostoDeCombustivelDAO daoPosto = new PostoDeCombustivelDAO(FormularioAbastecimentoActivity.this);
        List<PostoDeCombustivel> postos = daoPosto.listarPostos();
        daoPosto.close();

        Spinner spinnerPostoCombustivel = (Spinner) findViewById(R.id.postos_spinner);
        spinnerPostoCombustivel.setAdapter(new ArrayAdapter<PostoDeCombustivel>(this,
                android.R.layout.simple_list_item_1, postos));

        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        Long id = settings.getLong("user", 0);

        UsuarioDAO daoUsuario = new UsuarioDAO(FormularioAbastecimentoActivity.this);
        Usuario usuario = daoUsuario.buscarUsuario(id);
        daoUsuario.close();

        helperAbastecimento = new FormularioHelperAbastecimento(this, usuario);

        Button buttonSalvarAbastecimento = (Button) findViewById(R.id.botao_salvar_abastecimento);
        buttonSalvarAbastecimento.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                AbastecimentoDAO daoAbastecimento = new AbastecimentoDAO(FormularioAbastecimentoActivity.this);
                Abastecimento abastecimento = helperAbastecimento.pegaAbastecimento(FormularioAbastecimentoActivity.this);
                Date data = new Date();
                abastecimento.setHorario(data);
                daoAbastecimento.salvarAbastecimento(abastecimento);
                daoAbastecimento.close();
                Toast.makeText(FormularioAbastecimentoActivity.this, "Abastecimento salvo!", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.menu_historico_data:
                Intent intentListaPorData = new Intent(FormularioAbastecimentoActivity.this, ListaAbastecimentoPorDataActivity.class);
                startActivity(intentListaPorData);
                break;
            case R.id.menu_historico_posto:
                Intent intentListaPorPosto = new Intent(FormularioAbastecimentoActivity.this, ListaAbastecimentoPorPostoActivity.class);
                startActivity(intentListaPorPosto);
                break;
            case R.id.menu_novo_posto:
                Intent intentNovoPosto = new Intent(FormularioAbastecimentoActivity.this, FormularioPostoDeCombustivelActivity.class);
                startActivity(intentNovoPosto);
                break;
            case R.id.menu_sair:
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
