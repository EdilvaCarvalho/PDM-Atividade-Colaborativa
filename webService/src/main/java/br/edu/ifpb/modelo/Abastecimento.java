package br.edu.ifpb.modelo;


import java.io.Serializable;

import java.util.Date;
//import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
//import javax.persistence.ManyToOne;



/**
 * Created by Edilva on 27/03/2018.
 */

@Entity
public class Abastecimento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    //@ManyToOne(cascade = CascadeType.ALL)
    private long usuarioID;
    //@ManyToOne(cascade = CascadeType.ALL)
    private long postoDeCombustivelID;
    @Enumerated(EnumType.STRING)
    private TipoDeCombustivel tipoDeCombustivel;
    private double qtdeLitros;
    private double valorLitro;
    //private double valorPago;
    private double quilometragem;
    @Temporal(TemporalType.DATE)
    private Date horario;

    public Abastecimento() {
    }

//    public Abastecimento( int usuarioID, long postoDeCombustivelID, TipoDeCombustivel tipoDeCombustivel, double qtdeLitros, double valorLitro, double valorPago, Date horario) {
//        this.usuarioID = usuarioID;
//        this.postoDeCombustivelID = postoDeCombustivelID;
//        this.tipoDeCombustivel = tipoDeCombustivel;
//        this.qtdeLitros = qtdeLitros;
//        this.valorLitro = valorLitro;
//        this.valorPago = valorPago;
//        this.horario = horario;
//    }

    public Abastecimento(long usuarioID, long postoDeCombustivelID, TipoDeCombustivel tipoDeCombustivel, double qtdeLitros, double valorLitro, double quilometragem, Date horario) {
        this.usuarioID = usuarioID;
        this.postoDeCombustivelID = postoDeCombustivelID;
        this.tipoDeCombustivel = tipoDeCombustivel;
        this.qtdeLitros = qtdeLitros;
        this.valorLitro = valorLitro;
        this.quilometragem = quilometragem;
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

//    public double getValorPago() {
//        return qtdeLitros * valorLitro;
//    }
//
//    public void setValorPago(double valorPago) {
//        this.valorPago = valorPago;
//    }

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
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 37 * hash + (int) (this.usuarioID ^ (this.usuarioID >>> 32));
        hash = 37 * hash + (int) (this.postoDeCombustivelID ^ (this.postoDeCombustivelID >>> 32));
        hash = 37 * hash + (this.tipoDeCombustivel != null ? this.tipoDeCombustivel.hashCode() : 0);
        hash = 37 * hash + (int) (Double.doubleToLongBits(this.qtdeLitros) ^ (Double.doubleToLongBits(this.qtdeLitros) >>> 32));
        hash = 37 * hash + (int) (Double.doubleToLongBits(this.valorLitro) ^ (Double.doubleToLongBits(this.valorLitro) >>> 32));
        hash = 37 * hash + (int) (Double.doubleToLongBits(this.quilometragem) ^ (Double.doubleToLongBits(this.quilometragem) >>> 32));
        hash = 37 * hash + (this.horario != null ? this.horario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Abastecimento other = (Abastecimento) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.usuarioID != other.usuarioID) {
            return false;
        }
        if (this.postoDeCombustivelID != other.postoDeCombustivelID) {
            return false;
        }
        if (Double.doubleToLongBits(this.qtdeLitros) != Double.doubleToLongBits(other.qtdeLitros)) {
            return false;
        }
        if (Double.doubleToLongBits(this.valorLitro) != Double.doubleToLongBits(other.valorLitro)) {
            return false;
        }
        if (Double.doubleToLongBits(this.quilometragem) != Double.doubleToLongBits(other.quilometragem)) {
            return false;
        }
        if (this.tipoDeCombustivel != other.tipoDeCombustivel) {
            return false;
        }
        if (this.horario != other.horario && (this.horario == null || !this.horario.equals(other.horario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Abastecimento{" + "id=" + id + ", usuarioID=" + usuarioID + ", postoDeCombustivelID=" + postoDeCombustivelID + ", tipoDeCombustivel=" + tipoDeCombustivel + ", qtdeLitros=" + qtdeLitros + ", valorLitro=" + valorLitro + ", quilometragem=" + quilometragem + ", horario=" + horario + '}';
    }
}
