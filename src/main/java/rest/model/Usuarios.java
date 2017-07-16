package rest.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name="usuarios")
public class Usuarios {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long idUser;
    @NotNull
    private String nomeCompleto;
    @NotNull
    private String email;
    @NotNull
    private Date dataNascimento;
    @NotNull
    private Integer idTimeCoracao;



	/**
	* Returns value of idUser
	* @return
	*/
	public long getIdUser() {
		return idUser;
	}


	/**
	* Returns value of nomeCompleto
	* @return
	*/
	public String getNomeCompleto() {
		return nomeCompleto;
	}

	/**
	* Sets new value of nomeCompleto
	* @param
	*/
	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	/**
	* Returns value of email
	* @return
	*/
	public String getEmail() {
		return email;
	}

	/**
	* Sets new value of email
	* @param
	*/
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	* Returns value of dataNascimento
	* @return
	*/
	public Date getDataNascimento() {
		return dataNascimento;
	}

	/**
	* Sets new value of dataNascimento
	* @param
	*/
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
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
}
