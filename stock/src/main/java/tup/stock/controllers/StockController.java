
package tup.stock.controllers;
/*: la clase StockController pertenece al paquete Controllers, su tarea es atender los request HTTP y según el método que reciba  analiza el contenido del request y decide a que método llamar y le pasa los parámetros necesarios. */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tup.stock.models.Stock;
import tup.stock.repositories.StockRepository;

/*Contiene la anotación @RestController la cual es la combinación de @Controller y @ReponseBody; y la anotación @RequestMapping  con la cual nos permite en la URL agregarle luego del localhost8080 la anotación correspondientes para realizar las llamadas de esta aplicación el en browser. */
@RestController

@RequestMapping("")
public class StockController {
/*También posee la anotación @Autowired lo que significa que spring va a inyectar en esta clase un bean llamado stockRepository, con la cual extiende CrudRepositori en la interfaz StockRepository; y de esta forma solo declaramos la variable stockRepository  de tipo StockRepository  y invocando a la anotación @Autowired se configura e inicializa automáticamente para que podamos utilizarla. */
  @Autowired
  private StockRepository userRepository;
/*Luego están declaradas las anotaciones @PostMapping(“/add”) y (“/delete/{id}”) para agregar y o eliminar un producto, lo cual se realiza a travez del POSTMAN ya que es un Post; como asi también @GetMapping (“/id”) y (“/all”) para poder visualizar un producto especifico o toda la tabla, con su correspondiente declaración de HTML que le da un estilo de visualización. Y al final de la clase un @GetMapping(“”) el cual esta vacion y al no poner nada luego del 8080 en el browser le dará un mensaje de bienvenida al usuario.  */
  @PostMapping("/add") 
  
  public String addNewUser(@RequestParam Long id, @RequestParam String producto, @RequestParam String cantidad, @RequestParam String precio) {

    Stock user = new Stock();
    user.setId(id);
    user.setProducto(producto);
    user.setCantidad(cantidad);
    user.setPrecio(precio);
    userRepository.save(user);
    return "Se grabó el nuevo producto.";
  }
  @PostMapping("/edit") 
  
  public String editUser(@RequestParam Long id, @RequestParam String producto, @RequestParam String cantidad, @RequestParam String precio) {

    Stock user = new Stock();
    user.setId(id);
    user.setProducto(producto);
    user.setCantidad(cantidad);
    user.setPrecio(precio);
    userRepository.save(user);
    return "Se edito el producto.";
  }

  @PostMapping("/delete/{id}") // Map ONLY POST Requests
 
  public String deleteUserById(@PathVariable Long id) {
    userRepository.deleteById(id);
    return "Producto eliminado";
  }

  @GetMapping("/{id}")
  public String findUserById(@PathVariable Long id) {
   
    String resp = primeraParte();
    
    if (userRepository.findById(id).isPresent()) {
      
      Stock user = userRepository.findById(id).get();

      resp += "<tr>"
          + "<td>" + user.getId() + "</td>"
          + "<td>" + user.getProducto() + "</td>"
          + "<td>" + user.getCantidad() + "</td>"
          + "<td> $" + user.getPrecio() + "</td>"
          + "</tr>";
    } else {
      resp += "<tr>"
          + "<td>" + "-" + "</td>"
          + "<td>" + "-" + "</td>"
          + "<td>" + "-" + "</td>"
          + "</tr>";

    }
    return resp + "</table>";
  }

  @GetMapping("/all")
  public String getAllUsers() {
    
    Iterable<Stock> iterable = userRepository.findAll();
    String resp = primeraParte();
    
    for (Stock user : iterable) {
      resp += "<tr>"
      + "<td>" + user.getId() + "</td>"
      + "<td>" + user.getProducto() + "</td>"
      + "<td>" + user.getCantidad() + "</td>"
      + "<td> $" + user.getPrecio() + "</td>"
          + "</tr>";
    }
    return resp + "</table>";
    
    
  }


  @GetMapping("")
  public String hola() {
    return "Bienvenido al control de stock de una ferreteria";
  }

  private String primeraParte() {
  
     
    return """
          <style>
            #users {
              font-family: Arial, Helvetica, sans-serif;
              border-collapse: collapse;
              width: 70%;
              justify-content: center;
              align-items: center;

            }
            #users td, #users th {
              border: 1px solid #010100;
              padding: 5px;
            }
            #users tr:nth-child(even){background-color: #F0E4C3;}
            
            #users th {
              padding-top: 12px;
              padding-bottom: 12px;
              text-align: left;
              background-color: #C6B986;
              color: #000100;
              d
            }

            
            
          </style>
          <table id='users'>
            <tr>
              <th>Id</th>
              <th>Producto</th>
              <th>Cantidad</th>
              <th>Precio</th>
            </tr>

        """;
  }
}
