package tup.stock.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tup.stock.models.Stock;


 
@Repository
public interface StockRepository extends CrudRepository<Stock, Long> {

    void save(String precio);
}
