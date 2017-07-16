package rest.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="campanhas_usuarios")
public class CampanhasUsuarios {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long idCampanhaUsuario;
    private Integer idUser;
    private Integer idCampanha;

	/**
	* Returns value of idUser
	* @return
	*/
	public Integer getIdUser() {
		return idUser;
	}

	/**
	* Sets new value of idUser
	* @param
	*/
	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}

	/**
	* Returns value of idCampanha
	* @return
	*/
	public Integer getIdCampanha() {
		return idCampanha;
	}

	/**
	* Sets new value of idCampanha
	* @param
	*/
	public void setIdCampanha(Integer idCampanha) {
		this.idCampanha = idCampanha;
	}
}
