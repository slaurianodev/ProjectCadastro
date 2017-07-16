package rest.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="timecoracao")
public class TimeCoracao {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long idTime;

    @NotNull
    private String nomeTime;

	public long getIdTime() {
		return idTime;
	}

	public void setIdTime(Integer idTime) {
		this.idTime = idTime;
	}

	public String getNomeTime() {
		return nomeTime;
	}

	public void setNomeTime(String nomeTime) {
		this.nomeTime = nomeTime;
	}

}
