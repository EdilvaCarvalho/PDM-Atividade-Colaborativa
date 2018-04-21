package br.edu.ifpb.atividadecolaborativa.modelo;

import java.util.Date;

/**
 * Created by laerton on 18/04/2018.
 */

public class AbastecimentoLite {
    private long id;
    private long usuarioID;
    private long postoDeCombustivelID;
    private TipoDeCombustivel tipoDeCombustivel;
    private double qtdeLitros;
    private double valorLitro;
    private double valorPago;
    private double quilometragem;
    private Date horario;

    public AbastecimentoLite() {
    }

    public AbastecimentoLite( int usuarioID, long postoDeCombustivelID, TipoDeCombustivel tipoDeCombustivel, double qtdeLitros, double valorLitro, double valorPago, Date horario) {
        this.usuarioID = usuarioID;
        this.postoDeCombustivelID = postoDeCombustivelID;
        this.tipoDeCombustivel = tipoDeCombustivel;
        this.qtdeLitros = qtdeLitros;
        this.valorLitro = valorLitro;
        this.valorPago = valorPago;
        this.horario = horario;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getUsuarioID() {
        return usuarioID;
    }

    public void setUsuario(long id) {
        this.usuarioID = id;
    }

    public long getPostoDeCombustivelID() {
        return postoDeCombustivelID;
    }

    public void setPostoDeCombustivelID(long id) {
        this.postoDeCombustivelID = id;
    }

    public TipoDeCombustivel getTipoDeCombustivel() {
        return tipoDeCombustivel;
    }

    public void setTipoDeCombustivel(TipoDeCombustivel tipoDeCombustivel) {
        this.tipoDeCombustivel = tipoDeCombustivel;
    }

    public double getQtdeLitros() {
        return qtdeLitros;
    }

    public void setQtdeLitros(double qtdeLitros) {
        this.qtdeLitros = qtdeLitros;
    }

    public double getValorLitro() {
        return valorLitro;
    }

    public void setValorLitro(double valorLitro) {
        this.valorLitro = valorLitro;
    }

    public double getValorPago() {
        return qtdeLitros * valorLitro;
    }

    public void setValorPago(double valorPago) {
        this.valorPago = valorPago;
    }

    public double getQuilometragem() {
        return quilometragem;
    }

    public void setQuilometragem(double quilometragem) {
        this.quilometragem = quilometragem;
    }

    public Date getHorario() {
        return horario;
    }

    public void setHorario(Date horario) {
        this.horario = horario;
    }

    @Override
    public String toString() {
        return "Abastecimento{" +
                "id=" + id +
                ", usuario=" + usuarioID +
                ", postoDeCombustivel=" + postoDeCombustivelID +
                ", tipoDeCombustivel=" + tipoDeCombustivel +
                ", qtdeLitros=" + qtdeLitros +
                ", valorLitro=" + valorLitro +
                ", valorPago=" + valorPago +
                ", quilometragem=" + quilometragem +
                ", horario=" + horario +
                '}';
    }
}
