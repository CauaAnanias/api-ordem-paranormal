package com.kaede.ordem_paranormal_api.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@Document(collection = "agentes")
@JsonPropertyOrder({"id", "nome", "idade", "classe", "patente", "nex", "prestigio", "itens", "rituais"})
public class Agente {

	@Id
    private String id;
    
    private String nome;
    private Integer idade;
    private String classe;    //Combatente, Especialista ou Ocultista
    private String patente;   // Recruta, Operador, Agente Especial.
    private Integer nex;      // Nível de Exposição Paranormal
    private Integer prestigio; // Pontos de prestígio
    
    private List<String> itens;    // Inventário do agente
    private List<String> rituais;  // Rituais conhecidos
	public String getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getIdade() {
		return idade;
	}
	public void setIdade(Integer idade) {
		this.idade = idade;
	}
	public String getClasse() {
		return classe;
	}
	public void setClasse(String classe) {
		this.classe = classe;
	}
	public String getPatente() {
		return patente;
	}
	public void setPatente(String patente) {
		this.patente = patente;
	}
	public Integer getNex() {
		return nex;
	}
	public void setNex(Integer nex) {
		this.nex = nex;
	}
	public Integer getPrestigio() {
		return prestigio;
	}
	public void setPrestigio(Integer prestigio) {
		this.prestigio = prestigio;
	}
	public List<String> getItens() {
		return itens;
	}
	public void setItens(List<String> itens) {
		this.itens = itens;
	}
	public List<String> getRituais() {
		return rituais;
	}
	public void setRituais(List<String> rituais) {
		this.rituais = rituais;
	}
	public void setId(String id) {
		this.id = id;
	}
	
}
