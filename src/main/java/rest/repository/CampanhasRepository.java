package rest.repository;

import org.springframework.data.repository.CrudRepository;
import java.util.Date;
import java.util.List;

import rest.model.Campanhas;

public interface CampanhasRepository extends CrudRepository<Campanhas, Long> {

  List<Campanhas> findAllByDataFim(Date dataFim);

}
