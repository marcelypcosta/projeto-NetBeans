package persistência;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Contato;

public class JDBCContato {
    Connection conexão;
    
    public JDBCContato(Connection conexão) {
        this.conexão = conexão;
    }
    
    public void inserirContato(Contato c) {
        String sql = "INSERT INTO contato (nome, sobrenome, numero) VALUES (?, ?, ?)";
        PreparedStatement ps;
        
        try {
            ps = this.conexão.prepareStatement(sql);
            ps.setString(1, c.getNome());
            ps.setString(2, c.getSobrenome());
            ps.setString(3, c.getNumero());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public ArrayList<Contato> listarContatos() {
        ArrayList<Contato> contatos = new ArrayList<>();
        String sql = "SELECT * FROM contato";
                
        try {
            Statement declaração = conexão.createStatement();
            ResultSet resposta = declaração.executeQuery(sql);
            
            while (resposta.next()) {
                int id = resposta.getInt("id");
                String nome = resposta.getString("nome");
                String sobrenome = resposta.getString("sobrenome");
                String numero = resposta.getString("numero");
                
                Contato c = new Contato(id, nome, sobrenome, numero);
                contatos.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return contatos;
    }
    
    public void apagarTudo() {
        String sql = "DELETE FROM contato";
        PreparedStatement ps;
        
        try {
            ps = this.conexão.prepareStatement(sql);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
