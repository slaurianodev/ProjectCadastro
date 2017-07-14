package rest.db;

import org.springframework.data.repository.CrudRepository;

import rest.db.Usuarios;

public interface UsuariosRepository extends CrudRepository<Usuarios, Long> {

}