package rest.repository;

import org.springframework.data.repository.CrudRepository;

import rest.model.Usuarios;

public interface UsuariosRepository extends CrudRepository<Usuarios, Long> {

}
