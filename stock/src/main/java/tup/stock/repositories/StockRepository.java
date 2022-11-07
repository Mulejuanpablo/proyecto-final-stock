package tup.stock.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tup.stock.models.Stock;

/*contiene la anotación @Repository ; indica que StockRepository extiende CrudRepository y es candidata a la inyección de dependencias  */
 
@Repository
public interface StockRepository extends CrudRepository<Stock, Long> {

    void save(String precio);
}
