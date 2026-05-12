package com.kaede.ordem_paranormal_api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@Document(collection = "agentes")
@JsonPropertyOrder({"id", "nome", "idade", "classe", "patente", "nex", "prestigio", "vidaMaxima", "sanidadeMaxima", "peMaximo", "itens", "rituais"})
public class Agente {

    @Id
    private String id;
    
    private String nome;
    private Integer idade;
    private String classe;     // Combatente, Especialista ou Ocultista
    private String patente;    // Recruta, Operador, Agente Especial
    private int nex;           // Nível de Exposição Paranormal (Usando 'int' para o motor não quebrar)
    private Integer prestigio; // Pontos de prestígio
    
    // Nossos Status Automáticos
    private int vidaMaxima;  
    private int sanidadeMaxima; // Corrigido para terminar com 'a'
    private int peMaximo;       // Subiu para ficar com os outros atributos

    private List<String> itens;    // Inventário do agente
    private List<String> rituais;  // Rituais conhecidos
    
    
    // --- Daqui para baixo, apenas os Getters e Setters ---
    
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
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
    
    public int getNex() {
        return nex;
    }
    public void setNex(int nex) {
        this.nex = nex;
    }
    
    public Integer getPrestigio() {
        return prestigio;
    }
    public void setPrestigio(Integer prestigio) {
        this.prestigio = prestigio;
    }

    public int getVidaMaxima() {
        return vidaMaxima;
    }
    public void setVidaMaxima(int vidaMaxima) {
        this.vidaMaxima = vidaMaxima;
    }

    public int getSanidadeMaxima() {
        return sanidadeMaxima;
    }
    public void setSanidadeMaxima(int sanidadeMaxima) {
        this.sanidadeMaxima = sanidadeMaxima;
    }

    public int getPeMaximo() {
        return peMaximo;
    }
    public void setPeMaximo(int peMaximo) {
        this.peMaximo = peMaximo;
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
}