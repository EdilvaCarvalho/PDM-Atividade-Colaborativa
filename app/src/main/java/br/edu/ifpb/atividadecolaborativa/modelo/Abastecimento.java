package br.edu.ifpb.atividadecolaborativa.modelo;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;



/**
 * Created by Edilva on 27/03/2018.
 */

public class Abastecimento implements Serializable {

    private Long id;
    private Usuario usuario;
    private PostoDeCombustivel postoDeCombustivel;
    private TipoDeCombustivel tipoDeCombustivel;
    private double qtdeLitros;
    private double valorLitro;
    private double valorPago;
    private double quilometragem;

    private Date horario;


    public Abastecimento() {
    }

    public Abastecimento(Usuario usuario, PostoDeCombustivel postoDeCombustivel, TipoDeCombustivel tipoDeCombustivel,
                         double qtdeLitros, double valorLitro, double quilometragem, Date horario) {
        this.usuario = usuario;
        this.postoDeCombustivel = postoDeCombustivel;
        this.tipoDeCombustivel = tipoDeCombustivel;
        this.qtdeLitros = qtdeLitros;
        this.valorLitro = valorLitro;
        this.quilometragem = quilometragem;
        this.horario = horario;
    }

    public Abastecimento(Long id, Usuario usuario, PostoDeCombustivel postoDeCombustivel, TipoDeCombustivel tipoDeCombustivel,
                         double qtdeLitros, double valorLitro, double valorPago, double quilometragem,  Date horario) {
        this.id = id;
        this.usuario = usuario;
        this.postoDeCombustivel = postoDeCombustivel;
        this.tipoDeCombustivel = tipoDeCombustivel;
        this.qtdeLitros = qtdeLitros;
        this.valorLitro = valorLitro;
        this.valorPago = valorPago;
        this.quilometragem = quilometragem;
        this.horario = horario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public PostoDeCombustivel getPostoDeCombustivel() {
        return postoDeCombustivel;
    }

    public void setPostoDeCombustivel(PostoDeCombustivel postoDeCombustivel) {
        this.postoDeCombustivel = postoDeCombustivel;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Abastecimento that = (Abastecimento) o;

        if (Double.compare(that.qtdeLitros, qtdeLitros) != 0) return false;
        if (Double.compare(that.valorLitro, valorLitro) != 0) return false;
        if (Double.compare(that.valorPago, valorPago) != 0) return false;
        if (Double.compare(that.quilometragem, quilometragem) != 0) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (usuario != null ? !usuario.equals(that.usuario) : that.usuario != null) return false;
        if (postoDeCombustivel != null ? !postoDeCombustivel.equals(that.postoDeCombustivel) : that.postoDeCombustivel != null)
            return false;
        if (tipoDeCombustivel != that.tipoDeCombustivel) return false;
        return horario != null ? horario.equals(that.horario) : that.horario == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id != null ? id.hashCode() : 0;
        result = 31 * result + (usuario != null ? usuario.hashCode() : 0);
        result = 31 * result + (postoDeCombustivel != null ? postoDeCombustivel.hashCode() : 0);
        result = 31 * result + (tipoDeCombustivel != null ? tipoDeCombustivel.hashCode() : 0);
        temp = Double.doubleToLongBits(qtdeLitros);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(valorLitro);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(valorPago);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(quilometragem);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (horario != null ? horario.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String s = dateFormat.format(horario);
        return s + " - " + postoDeCombustivel.getNome();
    }
}
