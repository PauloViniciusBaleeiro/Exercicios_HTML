package br.fatec.projetofinal.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Emprestimo")

public class Emprestimo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idEmprestimo;
	
	public Integer getIdEmprestimo() {
		return idEmprestimo;
	}

	public void setIdEmprestimo(Integer idEmprestimo) {
		this.idEmprestimo = idEmprestimo;
	}

	public String getId_Emprestimo() {
		return id_Emprestimo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idEmprestimo == null) ? 0 : idEmprestimo.hashCode());
		result = prime * result + ((id_Emprestimo == null) ? 0 : id_Emprestimo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Emprestimo other = (Emprestimo) obj;
		if (idEmprestimo == null) {
			if (other.idEmprestimo != null)
				return false;
		} else if (!idEmprestimo.equals(other.idEmprestimo))
			return false;
		if (id_Emprestimo == null) {
			if (other.id_Emprestimo != null)
				return false;
		} else if (!id_Emprestimo.equals(other.id_Emprestimo))
			return false;
		return true;
	}

	public void setId_Emprestimo(String id_Emprestimo) {
		this.id_Emprestimo = id_Emprestimo;
	}

	@org.hibernate.annotations.NaturalId
	private String id_Emprestimo;


}
