package model;

import com.mysql.cj.jdbc.Blob;
import java.sql.Date;

public class Pet {
    private Integer id;
    private String nome_tutor;
    private String contato_tutor;
    private String cpf;
    private String email;
    private String role;
    private String cep;
    private String rua;
    private String bairro;
    private Integer numero_casa;
    private String nome_pet;
    private String raca;
    private Genero genero;
    private GeneroUser generoUser;
    private String cor;
    private Date date;
    private String observacao;
    private byte[] foto_usuario;

    public String getNome_tutor() {
        return nome_tutor;
    }
    public void setNome_tutor(String nome_tutor) {
        this.nome_tutor = nome_tutor;
    }
    public String getContato_tutor() {
        return contato_tutor;
    }
    public void setContato_tutor(String contato_tutor) {
        this.contato_tutor = contato_tutor;
    }
    public String getCep() {
        return cep;
    }
    public void setCep(String cep) {
        this.cep = cep;
    }
    public String getRua() {
        return rua;
    }
    public void setRua(String rua) {
        this.rua = rua;
    }
    public String getBairro() {
        return bairro;
    }
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
    public Integer getNumero_casa() {
        return numero_casa;
    }
    public void setNumero_casa(Integer numero_casa) {
        this.numero_casa = numero_casa;
    }
    public String getNome_pet() {
        return nome_pet;
    }
    public void setNome_pet(String nome_pet) {
        this.nome_pet = nome_pet;
    }
    public String getRaca() {
        return raca;
    }
    public void setRaca(String raca) {
        this.raca = raca;
    }
    public Genero getGenero() {
        return genero;
    }
    public void setGenero(Genero genero) {
        this.genero = genero;
    }
    public String getCor() {
        return cor;
    }
    public void setCor(String cor) {
        this.cor = cor;
    }
    public String getObservacao() {
        return observacao;
    }
    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the role
     */
    public String getRole() {
        return role;
    }

    /**
     * @param role the role to set
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * @return the generoUser
     */
    public GeneroUser getGeneroUser() {
        return generoUser;
    }

    /**
     * @param generoUser the generoUser to set
     */
    public void setGeneroUser(GeneroUser generoUser) {
        this.generoUser = generoUser;
    }

    /**
     * @return the foto_usuario
     */
    public byte[] getFoto_usuario() {
        return foto_usuario;
    }

    /**
     * @param foto_usuario the foto_usuario to set
     */
    public void setFoto_usuario(byte[] foto_usuario) {
        this.foto_usuario = foto_usuario;
    }


 

    
}



