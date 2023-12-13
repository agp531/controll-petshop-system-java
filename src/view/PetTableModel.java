package view;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import model.Pet;


public class PetTableModel extends AbstractTableModel {
    public static final int COL_ID = 0;
    public static final int COL_NOME_TUTOR = 1;
    public static final int COL_CONTATO_TUTOR = 2;
    public static final int COL_RACA = 3;
    public static final int COL_NOME_PET = 4;
    public static final int COL_GENERO = 5;
    public static final int COL_COR = 6;
    public static final int COL_DATA = 7;
    public static final int COL_CPF = 8;
    public static final int COL_EMAIL = 9;
    public static final int COL_ROLE = 10;
    public static final int COL_GENERO_USUARIO = 11;
    public static final int COL_FOTO = 12;
    
    
    public ArrayList<Pet> listaPets;
    
    public PetTableModel(ArrayList<Pet> alPet){
        this.listaPets = alPet;
    }
    
    @Override
    public Object getValueAt(int linha, int coluna){
        Pet p = listaPets.get(linha);
        Object conteudo = "";
        if(coluna == COL_ID){conteudo = p.getId();}
        if(coluna == COL_NOME_TUTOR){conteudo = p.getNome_tutor();}
        if(coluna == COL_CONTATO_TUTOR){conteudo = p.getContato_tutor();}
        if(coluna == COL_RACA){conteudo = p.getRaca();}
        if(coluna == COL_NOME_PET){conteudo = p.getNome_pet();}
        if(coluna == COL_GENERO){conteudo = p.getGenero();}
        if(coluna == COL_COR){conteudo = p.getCor();}
        if(coluna == COL_DATA){conteudo = p.getDate();}
        if(coluna == COL_CPF){conteudo = p.getCpf();}
        if(coluna == COL_EMAIL){conteudo = p.getEmail();}
        if(coluna == COL_ROLE){conteudo = p.getRole();}
        if(coluna == COL_GENERO_USUARIO){conteudo = p.getGeneroUser();}
        if(coluna == COL_FOTO){conteudo = p.getFoto_usuario();}
        
        return conteudo;
    }
    
    @Override
    public int getColumnCount(){
        return 13;
    }
    
    @Override
    public int getRowCount(){
        return listaPets.size();
    }
    
    @Override
    public String getColumnName(int coluna){
        String nome = "";
        if(coluna == COL_ID){nome = "Código";}
        if(coluna == COL_NOME_TUTOR){nome = "Nome do Tutor";}
        if(coluna == COL_CONTATO_TUTOR){nome = "Contato do Tutor";}
        if(coluna == COL_RACA){nome = "Raça";}
        if(coluna == COL_NOME_PET){nome = "Nome Pet";}
        if(coluna == COL_GENERO){nome = "Gênero";}
        if(coluna == COL_COR){nome = "Cor";}
        if(coluna == COL_DATA){nome = "Data de Entrada";}
        if(coluna == COL_CPF){nome = "Cpf";}
        if(coluna == COL_EMAIL){nome = "Email";}
        if(coluna == COL_ROLE){nome = "Tipo";}
        if(coluna == COL_GENERO_USUARIO){nome = "Sexo";}
        if(coluna == COL_FOTO){nome = "Foto";}
        
        return nome;
    }
    
}
