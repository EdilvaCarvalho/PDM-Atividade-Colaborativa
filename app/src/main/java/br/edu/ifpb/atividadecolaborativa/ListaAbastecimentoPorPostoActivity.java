package br.edu.ifpb.atividadecolaborativa;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Spinner;

import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.edu.ifpb.atividadecolaborativa.dao.AbastecimentoDAO;
import br.edu.ifpb.atividadecolaborativa.dao.PostoDeCombustivelDAO;
import br.edu.ifpb.atividadecolaborativa.dao.UsuarioDAO;
import br.edu.ifpb.atividadecolaborativa.modelo.Abastecimento;
import br.edu.ifpb.atividadecolaborativa.modelo.AbastecimentoLite;
import br.edu.ifpb.atividadecolaborativa.modelo.PostoDeCombustivel;
import br.edu.ifpb.atividadecolaborativa.modelo.Usuario;
import br.edu.ifpb.atividadecolaborativa.rest.DateDeserializer;
import br.edu.ifpb.atividadecolaborativa.rest.NetworkUtils;

public class ListaAbastecimentoPorPostoActivity extends AppCompatActivity {

    public static final String PREFS_NAME = "MyPrefsFile";
    private ListView listaAbastecimentos;
    PostoDeCombustivel posto;
    private ProgressDialog load;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_abastecimento_por_posto);

        PostoDeCombustivelDAO daoPosto = new PostoDeCombustivelDAO(ListaAbastecimentoPorPostoActivity.this);
        List<PostoDeCombustivel> postos = daoPosto.listarPostos();
        daoPosto.close();

        final Spinner spinnerPostoCombustivel = (Spinner) findViewById(R.id.postos_spinner);
        spinnerPostoCombustivel.setAdapter(new ArrayAdapter<PostoDeCombustivel>(this,
                android.R.layout.simple_list_item_1, postos));

        Button buttonPesquisar = (Button) findViewById(R.id.botao_pesquisar);
        buttonPesquisar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listaAbastecimentos = (ListView) findViewById(R.id.lista_abastecimento_posto);
                posto = (PostoDeCombustivel) spinnerPostoCombustivel.getSelectedItem();
                carregaLista();

                listaAbastecimentos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> lista, View item, int position, long id) {
                        Abastecimento abastecimento = (Abastecimento) listaAbastecimentos.getItemAtPosition(position);
                        Intent intentVaiPraDescricao = new Intent(ListaAbastecimentoPorPostoActivity.this, DescricaoAbastecimentoActivity.class);
                        intentVaiPraDescricao.putExtra("abastecimento", abastecimento);
                        startActivity(intentVaiPraDescricao);
                    }
                });
            }
        });

        Button novoAbastecimento = (Button) findViewById(R.id.botao_novo_abastecimento);
        novoAbastecimento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentVaiProFormulario = new Intent(ListaAbastecimentoPorPostoActivity.this, FormularioAbastecimentoActivity.class);
                startActivity(intentVaiProFormulario);
            }
        });
    }

    private void carregaLista() {

        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        Long id = settings.getLong("user", 0);

        /*UsuarioDAO daoUsuario = new UsuarioDAO(ListaAbastecimentoPorPostoActivity.this);
        Usuario usuario = daoUsuario.buscarUsuario(id);
        daoUsuario.close();

        AbastecimentoDAO dao = new AbastecimentoDAO(this);
        List<Abastecimento> abastecimentos  = null;
        try {
            abastecimentos = dao.abastecimentosDoPosto(usuario, posto);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        dao.close();

        listaAbastecimentos.setAdapter(new ArrayAdapter<Abastecimento>(this,
                android.R.layout.simple_list_item_1, abastecimentos));*/
        GetJson gj = new GetJson();
        gj.execute();
    }

    @Override
    protected void onRestart() {
        carregaLista();
        super.onRestart();
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
                Intent intentListaPorData = new Intent(ListaAbastecimentoPorPostoActivity.this, ListaAbastecimentoPorDataActivity.class);
                startActivity(intentListaPorData);
                break;
            case R.id.menu_novo_posto:
                Intent intentNovoPosto = new Intent(ListaAbastecimentoPorPostoActivity.this, FormularioPostoDeCombustivelActivity.class);
                startActivity(intentNovoPosto);
                break;
            case R.id.menu_novo_abastecimento:
                Intent intentNovoAbastecimento = new Intent(ListaAbastecimentoPorPostoActivity.this, FormularioAbastecimentoActivity.class);
                startActivity(intentNovoAbastecimento);
                break;
            case R.id.menu_sair:
                Sair sair = new Sair(this);
                sair.sair();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    private class GetJson extends AsyncTask<Void, Void, String> {

        @Override
        protected void onPreExecute() {
            load = ProgressDialog.show(ListaAbastecimentoPorPostoActivity.this, "Por favor Aguarde ...", "Recuperando Informações do Servidor...");

        }

        @Override
        protected String doInBackground(Void... voids) {
            SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
            Long id = settings.getLong("user", 0);
            Log.i("Id", String.valueOf(id));
            return NetworkUtils.GetJASONFromApi("http://192.168.2.11:8080/webService/webapi/Abastecimentos/postoAndUser/" + posto.getId() + "/" + id);


        }

        @Override
        protected void onPostExecute(String abastecimentos) {

            //Tipando uma coleção para Json Converter
            Type collectionType = new TypeToken<List<AbastecimentoLite>>() {
            }.getType();
            //Convertendo o Json em uma lista de Abastecimento Lite
            List<AbastecimentoLite> abs = new GsonBuilder().registerTypeAdapter(Date.class, new DateDeserializer()).create().fromJson(abastecimentos, collectionType);

            //Tratamento para lista nula ou vazia
            if (abs != null && abs.size() > 0) {
                //Daos nescesário para a busca
                PostoDeCombustivelDAO dao = new PostoDeCombustivelDAO(ListaAbastecimentoPorPostoActivity.this);
                UsuarioDAO daoUser = new UsuarioDAO(ListaAbastecimentoPorPostoActivity.this);

                //Lista de resultado
                List<Abastecimento> lista = new ArrayList<>();
                //Formatando a data
                SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

                for (AbastecimentoLite item : abs) {

                    //Busca usuário
                    Usuario user = daoUser.buscarUsuario(item.getUsuarioID());
                    Log.i("Usuario:", String.valueOf(item.getUsuarioID()));

                    //Busca Posto
                    PostoDeCombustivel posto = dao.buscarPosto(item.getPostoDeCombustivelID());
                    Log.i("Posto:", String.valueOf(item.getPostoDeCombustivelID()));

                    //Cria o Abastecimento com os dados do item repassado.
                    Abastecimento ab = new Abastecimento();
                    ab.setHorario(item.getHorario());
                    ab.setId(item.getId());
                    ab.setPostoDeCombustivel(posto);
                    ab.setQtdeLitros(item.getQtdeLitros());
                    ab.setQuilometragem(item.getQuilometragem());
                    ab.setTipoDeCombustivel(item.getTipoDeCombustivel());
                    ab.setUsuario(user);
                    ab.setValorLitro(item.getValorLitro());
                    ab.setValorPago(item.getValorPago());

                    //Add lista
                    lista.add(ab);

                }
                //Preenche os dados na tela.
                listaAbastecimentos.setAdapter(new ArrayAdapter<Abastecimento>(ListaAbastecimentoPorPostoActivity.this,
                        android.R.layout.simple_list_item_1, lista));
            }

            Log.i("Resultado", abastecimentos);
            load.dismiss();
        }
    }
}
