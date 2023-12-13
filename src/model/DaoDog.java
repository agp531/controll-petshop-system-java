package model;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class DaoDog {
    private Connection conn;
    private java.sql.Statement st;

    public void conectar(){
        try{
            this.conn = ConnectionManager.getConnection();
            st = conn.createStatement();
        } catch(ClassNotFoundException e1){
            System.out.println("Erro ao carregar o driver " + e1.getMessage());
        } catch(SQLException e2){
            System.out.println("Erro ao conectar ao banco de dados " + e2.getMessage());
        }
        
    }

    private void desconectar(){
        try{
            st.close();
            conn.close();
        } catch(SQLException e){
            System.out.println("Erro ao desconectar do banco de dados" + e.getMessage());
        }
    }

    public boolean inserir(Pet p){
        boolean resultado = false;
        
        try{
            this.conectar();
            java.util.Date dt = new java.util.Date();
            java.text.SimpleDateFormat sdf = 
                new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String currentTime = sdf.format(dt);
            String comando = "INSERT INTO dados_pets (nome_tutor, contato_tutor, cep, rua, numero_casa, bairro, nome_pet, raca, genero, cor, data_entrada, observacao, cpf, email, role, genero_user, foto_usuario) VALUES ('" + p.getNome_tutor() + "', '" + p.getContato_tutor() + "', '" + p.getCep() + "', '" + p.getRua() + "', " + p.getNumero_casa() + ", '" + p.getBairro() + "', '" + p.getNome_pet() + "', '" + p.getRaca() + "', '" + p.getGenero() + "',"
                    + " '" + p.getCor() + "', '" + currentTime + "', '" + p.getObservacao() + "', '" + p.getCpf() + "', '" + p.getEmail() + "', '" + p.getRole() + "', '" + p.getGeneroUser() + "', '" + p.getFoto_usuario() + "');";      
            System.out.println(comando);
            st.executeUpdate(comando);
            resultado = true;
        } catch(Exception e){
            System.out.println("Erro ao inserir pet: " + e.getMessage());
        } finally{
            this.desconectar();
        }
        return resultado;
    }
    
public ArrayList<Pet> verTodos() {
    ArrayList<Pet> pets = new ArrayList<>();
    
    try {
        this.conectar();
        String comando = "SELECT * FROM dados_pets;";
        ResultSet rs = st.executeQuery(comando);
        
        while (rs.next()) {
            Pet p = new Pet();
            p.setId(rs.getInt("id"));
            p.setNome_tutor(rs.getString("nome_tutor"));
            p.setContato_tutor(rs.getString("contato_tutor"));
            p.setCep(rs.getString("cep"));
            p.setRua(rs.getString("rua"));
            p.setNumero_casa(rs.getInt("numero_casa"));
            p.setBairro(rs.getString("bairro"));
            p.setNome_pet(rs.getString("nome_pet"));
            p.setRaca(rs.getString("raca"));
            p.setGenero(Genero.valueOf(rs.getString("genero")));
            p.setCor(rs.getString("cor"));
            p.setDate(rs.getDate("data_entrada"));
            p.setObservacao(rs.getString("observacao"));
            p.setCpf(rs.getString("cpf"));
            p.setEmail(rs.getString("email"));
            p.setRole(rs.getString("role"));
            p.setGeneroUser(GeneroUser.valueOf(rs.getString("genero_user")));
            p.setFoto_usuario(rs.getBytes("foto_usuario"));
            pets.add(p);
        }
    } catch (Exception e) {
        System.out.println("Erro ao recuperar pets: " + e.getMessage());
    } finally {
        this.desconectar();
    }
    
    return pets;
}

public ArrayList<Pet> buscarPetsMachos() {
    ArrayList<Pet> pets = new ArrayList<>();
    
    try {
        this.conectar();
        String comando = "SELECT * FROM dados_pets WHERE genero = 'Macho';";
        ResultSet rs = st.executeQuery(comando);
        
        while (rs.next()) {
            Pet p = new Pet();
            p.setId(rs.getInt("id"));
            p.setNome_tutor(rs.getString("nome_tutor"));
            p.setContato_tutor(rs.getString("contato_tutor"));
            p.setCep(rs.getString("cep"));
            p.setRua(rs.getString("rua"));
            p.setNumero_casa(rs.getInt("numero_casa"));
            p.setBairro(rs.getString("bairro"));
            p.setNome_pet(rs.getString("nome_pet"));
            p.setRaca(rs.getString("raca"));
            p.setGenero(Genero.valueOf(rs.getString("genero")));
            p.setCor(rs.getString("cor"));
            p.setDate(rs.getDate("data_entrada"));
            p.setObservacao(rs.getString("observacao"));
            pets.add(p);
        }
    } catch (Exception e) {
        System.out.println("Erro ao recuperar pets machos: " + e.getMessage());
    } finally {
        this.desconectar();
    }
    
    return pets;
}

public ArrayList<Pet> buscarPetsFemeas() {
    ArrayList<Pet> pets = new ArrayList<>();
    
    try {
        this.conectar();
        String comando = "SELECT * FROM dados_pets WHERE genero = 'Femea';";
        ResultSet rs = st.executeQuery(comando);
        
        while (rs.next()) {
            Pet p = new Pet();
            p.setId(rs.getInt("id"));
            p.setNome_tutor(rs.getString("nome_tutor"));
            p.setContato_tutor(rs.getString("contato_tutor"));
            p.setCep(rs.getString("cep"));
            p.setRua(rs.getString("rua"));
            p.setNumero_casa(rs.getInt("numero_casa"));
            p.setBairro(rs.getString("bairro"));
            p.setNome_pet(rs.getString("nome_pet"));
            p.setRaca(rs.getString("raca"));
            p.setGenero(Genero.valueOf(rs.getString("genero")));
            p.setCor(rs.getString("cor"));
            p.setDate(rs.getDate("data_entrada"));
            p.setObservacao(rs.getString("observacao"));
            pets.add(p);
        }
    } catch (Exception e) {
        System.out.println("Erro ao recuperar pets machos: " + e.getMessage());
    } finally {
        this.desconectar();
    }
    
    return pets;
}


public ArrayList<Pet> buscarUserNormal() {
    ArrayList<Pet> pets = new ArrayList<>();
    
    try {
        this.conectar();
        String comando = "SELECT * FROM dados_pets WHERE role = 'Normal';";
        ResultSet rs = st.executeQuery(comando);
        
        while (rs.next()) {
            Pet p = new Pet();
            p.setId(rs.getInt("id"));
            p.setNome_tutor(rs.getString("nome_tutor"));
            p.setContato_tutor(rs.getString("contato_tutor"));
            p.setCep(rs.getString("cep"));
            p.setRua(rs.getString("rua"));
            p.setNumero_casa(rs.getInt("numero_casa"));
            p.setBairro(rs.getString("bairro"));
            p.setNome_pet(rs.getString("nome_pet"));
            p.setRaca(rs.getString("raca"));
            p.setGenero(Genero.valueOf(rs.getString("genero")));
            p.setCor(rs.getString("cor"));
            p.setDate(rs.getDate("data_entrada"));
            p.setObservacao(rs.getString("observacao"));
            pets.add(p);
        }
    } catch (Exception e) {
        System.out.println("Erro ao recuperar pets machos: " + e.getMessage());
    } finally {
        this.desconectar();
    }
    
    return pets;
}


public ArrayList<Pet> buscarUserPlanoDogCounter() {
    ArrayList<Pet> pets = new ArrayList<>();
    
    try {
        this.conectar();
        String comando = "SELECT * FROM dados_pets WHERE role = 'PlanoDogCounter';";
        ResultSet rs = st.executeQuery(comando);
        
        while (rs.next()) {
            Pet p = new Pet();
            p.setId(rs.getInt("id"));
            p.setNome_tutor(rs.getString("nome_tutor"));
            p.setContato_tutor(rs.getString("contato_tutor"));
            p.setCep(rs.getString("cep"));
            p.setRua(rs.getString("rua"));
            p.setNumero_casa(rs.getInt("numero_casa"));
            p.setBairro(rs.getString("bairro"));
            p.setNome_pet(rs.getString("nome_pet"));
            p.setRaca(rs.getString("raca"));
            p.setGenero(Genero.valueOf(rs.getString("genero")));
            p.setCor(rs.getString("cor"));
            p.setDate(rs.getDate("data_entrada"));
            p.setObservacao(rs.getString("observacao"));
            pets.add(p);
        }
    } catch (Exception e) {
        System.out.println("Erro ao recuperar pets machos: " + e.getMessage());
    } finally {
        this.desconectar();
    }
    
    return pets;
}

public ArrayList<Pet> buscarUserConvenio() {
    ArrayList<Pet> pets = new ArrayList<>();
    
    try {
        this.conectar();
        String comando = "SELECT * FROM dados_pets WHERE role = 'Conveniado';";
        ResultSet rs = st.executeQuery(comando);
        
        while (rs.next()) {
            Pet p = new Pet();
            p.setId(rs.getInt("id"));
            p.setNome_tutor(rs.getString("nome_tutor"));
            p.setContato_tutor(rs.getString("contato_tutor"));
            p.setCep(rs.getString("cep"));
            p.setRua(rs.getString("rua"));
            p.setNumero_casa(rs.getInt("numero_casa"));
            p.setBairro(rs.getString("bairro"));
            p.setNome_pet(rs.getString("nome_pet"));
            p.setRaca(rs.getString("raca"));
            p.setGenero(Genero.valueOf(rs.getString("genero")));
            p.setCor(rs.getString("cor"));
            p.setDate(rs.getDate("data_entrada"));
            p.setObservacao(rs.getString("observacao"));
            pets.add(p);
        }
    } catch (Exception e) {
        System.out.println("Erro ao recuperar pets machos: " + e.getMessage());
    } finally {
        this.desconectar();
    }
    
    return pets;
}

public ArrayList<Pet> buscarUserMasculino() {
    ArrayList<Pet> pets = new ArrayList<>();
    
    try {
        this.conectar();
        String comando = "SELECT * FROM dados_pets WHERE genero_user = 'MASCULINO';";
        ResultSet rs = st.executeQuery(comando);
        
        while (rs.next()) {
            Pet p = new Pet();
            p.setId(rs.getInt("id"));
            p.setNome_tutor(rs.getString("nome_tutor"));
            p.setContato_tutor(rs.getString("contato_tutor"));
            p.setCep(rs.getString("cep"));
            p.setRua(rs.getString("rua"));
            p.setNumero_casa(rs.getInt("numero_casa"));
            p.setBairro(rs.getString("bairro"));
            p.setNome_pet(rs.getString("nome_pet"));
            p.setRaca(rs.getString("raca"));
            p.setGenero(Genero.valueOf(rs.getString("genero")));
            p.setCor(rs.getString("cor"));
            p.setDate(rs.getDate("data_entrada"));
            p.setObservacao(rs.getString("observacao"));
            pets.add(p);
        }
    } catch (Exception e) {
        System.out.println("Erro ao recuperar pets machos: " + e.getMessage());
    } finally {
        this.desconectar();
    }
    
    return pets;
}

public ArrayList<Pet> buscarUserFeminino() {
    ArrayList<Pet> pets = new ArrayList<>();
    
    try {
        this.conectar();
        String comando = "SELECT * FROM dados_pets WHERE genero_user = 'FEMININO';";
        ResultSet rs = st.executeQuery(comando);
        
        while (rs.next()) {
            Pet p = new Pet();
            p.setId(rs.getInt("id"));
            p.setNome_tutor(rs.getString("nome_tutor"));
            p.setContato_tutor(rs.getString("contato_tutor"));
            p.setCep(rs.getString("cep"));
            p.setRua(rs.getString("rua"));
            p.setNumero_casa(rs.getInt("numero_casa"));
            p.setBairro(rs.getString("bairro"));
            p.setNome_pet(rs.getString("nome_pet"));
            p.setRaca(rs.getString("raca"));
            p.setGenero(Genero.valueOf(rs.getString("genero")));
            p.setCor(rs.getString("cor"));
            p.setDate(rs.getDate("data_entrada"));
            p.setObservacao(rs.getString("observacao"));
            pets.add(p);
        }
    } catch (Exception e) {
        System.out.println("Erro ao recuperar pets machos: " + e.getMessage());
    } finally {
        this.desconectar();
    }
    
    return pets;
}


public ArrayList<Pet> buscarUserOutros() {
    ArrayList<Pet> pets = new ArrayList<>();
    
    try {
        this.conectar();
        String comando = "SELECT * FROM dados_pets WHERE genero_user = 'OUTROS';";
        ResultSet rs = st.executeQuery(comando);
        
        while (rs.next()) {
            Pet p = new Pet();
            p.setId(rs.getInt("id"));
            p.setNome_tutor(rs.getString("nome_tutor"));
            p.setContato_tutor(rs.getString("contato_tutor"));
            p.setCep(rs.getString("cep"));
            p.setRua(rs.getString("rua"));
            p.setNumero_casa(rs.getInt("numero_casa"));
            p.setBairro(rs.getString("bairro"));
            p.setNome_pet(rs.getString("nome_pet"));
            p.setRaca(rs.getString("raca"));
            p.setGenero(Genero.valueOf(rs.getString("genero")));
            p.setCor(rs.getString("cor"));
            p.setDate(rs.getDate("data_entrada"));
            p.setObservacao(rs.getString("observacao"));
            pets.add(p);
        }
    } catch (Exception e) {
        System.out.println("Erro ao recuperar pets machos: " + e.getMessage());
    } finally {
        this.desconectar();
    }
    
    return pets;
}


public ArrayList<Pet> buscarUserNi() {
    ArrayList<Pet> pets = new ArrayList<>();
    
    try {
        this.conectar();
        String comando = "SELECT * FROM dados_pets WHERE genero_user = 'NI';";
        ResultSet rs = st.executeQuery(comando);
        
        while (rs.next()) {
            Pet p = new Pet();
            p.setId(rs.getInt("id"));
            p.setNome_tutor(rs.getString("nome_tutor"));
            p.setContato_tutor(rs.getString("contato_tutor"));
            p.setCep(rs.getString("cep"));
            p.setRua(rs.getString("rua"));
            p.setNumero_casa(rs.getInt("numero_casa"));
            p.setBairro(rs.getString("bairro"));
            p.setNome_pet(rs.getString("nome_pet"));
            p.setRaca(rs.getString("raca"));
            p.setGenero(Genero.valueOf(rs.getString("genero")));
            p.setCor(rs.getString("cor"));
            p.setDate(rs.getDate("data_entrada"));
            p.setObservacao(rs.getString("observacao"));
            pets.add(p);
        }
    } catch (Exception e) {
        System.out.println("Erro ao recuperar pets machos: " + e.getMessage());
    } finally {
        this.desconectar();
    }
    
    return pets;
}


    public boolean atualizar(Pet p) {
        boolean resultado = false;
        
        try {
            this.conectar();
            String comando = "UPDATE dados_pets SET nome_tutor='" + p.getNome_tutor() + "', contato_tutor='" + p.getContato_tutor() + "', nome_pet='" 
                    + p.getNome_pet() + "', raca='" + p.getRaca() + "', genero='" + p.getGenero() +
                    "', cor='" + p.getCor() + "', cpf='" + p.getCpf() + "', email='" + p.getEmail() + "', genero_user='" + p.getGeneroUser()+ "', role='" + p.getRole() + "' WHERE id=" + p.getId() + ";";
            st.executeUpdate(comando);
            resultado = true;
        } catch (Exception e) {
            System.out.println("Erro ao atualizar pet: " + e.getMessage());
        } finally {
            this.desconectar();
        }
        
        return resultado;
    }
    
    
    public boolean deletar(int id) {
        boolean resultado = false;
        
        try {
            this.conectar();
            String comando = "DELETE FROM dados_pets WHERE id=" + id + ";";
            st.executeUpdate(comando);
            resultado = true;
        } catch (Exception e) {
            System.out.println("Erro ao deletar pet: " + e.getMessage());
        } finally {
            this.desconectar();
        }
        
        return resultado;
    }

    public ArrayList<Pet> buscarCampos(String termo, Date dataInicio, Date dataFim){
        ArrayList<Pet> resultados = new ArrayList<Pet>();
        try{
            this.conectar();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM dados_pets WHERE (data_entrada BETWEEN ? AND ?);");
            ps.setTimestamp(1, new java.sql.Timestamp(dataInicio.getTime()));
            ps.setTimestamp(2, new java.sql.Timestamp(dataFim.getTime()));
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Pet p = new Pet();
                p.setId(rs.getInt("id"));
                p.setNome_tutor(rs.getString("nome_tutor"));
                p.setContato_tutor(rs.getString("contato_tutor"));
                p.setNome_pet(rs.getString("nome_pet"));
                p.setRaca(rs.getString("raca"));
                p.setGenero(Genero.valueOf(rs.getString("genero")));
                p.setCor(rs.getString("cor"));
                p.setDate(rs.getDate("data_entrada"));
                
                if (p.getNome_tutor().toLowerCase().contains(termo.toLowerCase()) ||
                    p.getContato_tutor().toLowerCase().contains(termo.toLowerCase()) ||
                    p.getNome_pet().toLowerCase().contains(termo.toLowerCase()) ||
                    p.getRaca().toLowerCase().contains(termo.toLowerCase()) ||
                    p.getGenero().name().toLowerCase().contains(termo.toLowerCase()) ||
                    p.getCor().toLowerCase().contains(termo.toLowerCase())) {
                        resultados.add(p);
                    }
            }  
        } catch(Exception e){
            System.out.println("Erro ao buscar pets: " + e.getMessage());
        } finally{
            this.desconectar();
        }
        return resultados;
    }
    

    
    

    
}
