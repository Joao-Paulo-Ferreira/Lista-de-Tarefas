/**
 * Classe de criação do objeto TarefasLista e seus construtores
 * classe possui os getters e setters de cada atributo
 * @author @author João Paulo Ferreira de Moraes - TADS - 22/01/2022
 */

public class TarefasLista {
	
	private int identificador;
	private String nome;
	private String descricao;
	private boolean urgente;
	
	
	public TarefasLista () {
		this.identificador = 0;
		this.nome = null;
		this.descricao = null;
		this.urgente = false;
	}
	
	public TarefasLista (int identificador, String nome, String descricao, boolean urgente) {
		this.identificador = identificador;
		this.nome = nome;
		this.descricao = descricao;
		this.urgente = urgente;
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getIdentificador() {
		return identificador;
	}

	public void setIdentificador(int identificador) {
		this.identificador = identificador;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public boolean getUrgente() {
		return urgente;
	}

	public void setUrgente(boolean urgente) {
		this.urgente = urgente;
	}

	@Override
	public String toString() {
		return "Identificador = " + identificador + ", Nome = " + nome + ", Descrição = " + descricao
				+ ", Urgente = " + urgente;
	}
		
}
