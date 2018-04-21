package br.edu.ifpb.atividadecolaborativa.formularioHelper;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.widget.EditText;
import android.widget.Spinner;

import java.time.LocalDateTime;

import br.edu.ifpb.atividadecolaborativa.FormularioAbastecimentoActivity;
import br.edu.ifpb.atividadecolaborativa.R;
import br.edu.ifpb.atividadecolaborativa.dao.PostoDeCombustivelDAO;
import br.edu.ifpb.atividadecolaborativa.modelo.Abastecimento;
import br.edu.ifpb.atividadecolaborativa.modelo.AbastecimentoLite;
import br.edu.ifpb.atividadecolaborativa.modelo.PostoDeCombustivel;
import br.edu.ifpb.atividadecolaborativa.modelo.TipoDeCombustivel;
import br.edu.ifpb.atividadecolaborativa.modelo.Usuario;

/**
 * Created by Edilva on 31/03/2018.
 */

public class FormularioHelperAbastecimento {

    private final EditText campoQtdeLitros;
    private final EditText campoValorLitro;
    private final EditText campoQuilometragem;
    private final Spinner campoPostoDeCombustivel;
    private final Spinner campoTipoDeCombustivel;
    private Usuario usuario;
    private AbastecimentoLite abastecimento;


    public FormularioHelperAbastecimento(FormularioAbastecimentoActivity activity, Usuario usuario) {
        this.campoQtdeLitros = (EditText) activity.findViewById(R.id.form_quant_litros);
        this.campoValorLitro = (EditText) activity.findViewById(R.id.form_valor_litro);
        this.campoQuilometragem = (EditText) activity.findViewById(R.id.form_quilometragem);
        this.campoPostoDeCombustivel = (Spinner) activity.findViewById(R.id.postos_spinner);
        this.campoTipoDeCombustivel = (Spinner) activity.findViewById(R.id.tipo_combust_spinner);
        this.usuario = usuario;
        this.abastecimento = new AbastecimentoLite();
    }

    public AbastecimentoLite pegaAbastecimento(Context context) {
        abastecimento.setUsuario(usuario.getId());
        abastecimento.setQuilometragem(Double.valueOf(campoQuilometragem.getText().toString()));
        abastecimento.setValorLitro(Double.valueOf(campoValorLitro.getText().toString()));
        abastecimento.setQtdeLitros(Double.valueOf(campoQtdeLitros.getText().toString()));
        TipoDeCombustivel tipo = (TipoDeCombustivel) campoTipoDeCombustivel.getSelectedItem();
        abastecimento.setTipoDeCombustivel(tipo);
        PostoDeCombustivel postoDeCombustivel = (PostoDeCombustivel) campoPostoDeCombustivel.getSelectedItem();
        abastecimento.setPostoDeCombustivelID(postoDeCombustivel.getId());
        return abastecimento;
    }
}
