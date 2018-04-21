package br.edu.ifpb.modelo;

import br.edu.ifpb.modelo.TipoDeCombustivel;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-04-19T19:29:40")
@StaticMetamodel(Abastecimento.class)
public class Abastecimento_ { 

    public static volatile SingularAttribute<Abastecimento, Double> valorLitro;
    public static volatile SingularAttribute<Abastecimento, Date> horario;
    public static volatile SingularAttribute<Abastecimento, Double> qtdeLitros;
    public static volatile SingularAttribute<Abastecimento, Long> postoDeCombustivelID;
    public static volatile SingularAttribute<Abastecimento, TipoDeCombustivel> tipoDeCombustivel;
    public static volatile SingularAttribute<Abastecimento, Double> valorPago;
    public static volatile SingularAttribute<Abastecimento, Long> id;
    public static volatile SingularAttribute<Abastecimento, Double> quilometragem;
    public static volatile SingularAttribute<Abastecimento, Long> usuarioID;

}