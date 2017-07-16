package rest.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="campanhas")
public class Campanhas {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long idCampanha;
    @NotNull
    private String nomeCampanha;
    @NotNull
    private Integer idTimeCoracao;
    @NotNull
    private Date dataInicio;
    @NotNull
    private Date dataFim;

	/**
	* Returns value of idCampanha
	* @return
	*/
	public long getIdCampanha() {
		return idCampanha;
	}

	/**
	* Sets new value of idCampanha
	* @param
	*/
	public void setIdCampanha(Integer idCampanha) {
		this.idCampanha = idCampanha;
	}

	/**
	* Returns value of nomeCampanha
	* @return
	*/
	public String getNomeCampanha() {
		return nomeCampanha;
	}

	/**
	* Sets new value of nomeCampanha
	* @param
	*/
	public void setNomeCampanha(String nomeCampanha) {
		this.nomeCampanha = nomeCampanha;
	}

	/**
	* Returns value of idTimeCoracao
	* @return
	*/
	public Integer getIdTimeCoracao() {
		return idTimeCoracao;
	}

	/**
	* Sets new value of idTimeCoracao
	* @param
	*/
	public void setIdTimeCoracao(Integer idTimeCoracao) {
		this.idTimeCoracao = idTimeCoracao;
	}

	/**
	* Returns value of data_inicio
	* @return
	*/
	public Date getData_inicio() {
		return dataInicio;
	}

	/**
	* Sets new value of data_inicio
	* @param
	*/
	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	/**
	* Returns value of data_final
	* @return
	*/
	public Date getDataFim() {
		return dataFim;
	}

	/**
	* Sets new value of data_final
	* @param
	*/
	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}
}
