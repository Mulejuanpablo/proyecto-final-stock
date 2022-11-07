package tup.stock.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
/*: se encuentra la anotación @Data que genera todo el código boiler plate que normalmente se asocia con POJO simples (plain old java objects) y beans como getters para todos los campos y setters para todos los campos no finales e implementaciones apropiadas de toString, equals y hashCode que involucran los campos de la clase y un constructor que inicializa todo los campos no finales, asi como todos los campos no finales isn inicializador que se haya marcado con @NonNull, para garantizar que el campo nunca sea nulo. Esta anotación no tiene nada que ver con el mecanismo de inyección de dependencias, lo que hace es evitarnos la necesidad de programar por nosotros mismos todos estos métodos. */

@Data
/*Y también encontramos la anotación @Entity la cual le dice a Hibernate(convertirá los datos entre los tipos utilizados por Java y los definidos por SQL, luego generará sentencias SQL y liberará al desarrollador del manejo manual de los datos, manteniendo la portabilidad entre todos los motores de bases de datos acelerando el tiempo de ejecución) que haga una tabla con esta clase. */
@Entity
/*Luego se declaran la variable con la anotación @Id para determinar el ID de una entidad es tan simple como poner la anotación @Id sobre la propiedad que sería el ID de la entidad; y la anotación @GenerateValue. Y a continuación las otras variables de nuestro programa */
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String producto;

    private String cantidad;
    private String precio;
}
