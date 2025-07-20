/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Adm
 */

import java.sql.PreparedStatement;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class ProdutosDAO {
    
    Connection conn;
    PreparedStatement prep;
    ResultSet resultset;
    ArrayList<ProdutosDTO> listagem = new ArrayList<>();
    
    public void cadastrarProduto (ProdutosDTO produto) throws SQLException {
        
        
        conn = new conectaDAO().connectDB();
        String sql = "INSERT INTO produtos (nome, valor, status) VALUES (?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, produto.getNome());
        stmt.setFloat(2, produto.getValor());
        stmt.setString(3, produto.getStatus());
        stmt.executeUpdate();
        stmt.close();
        
    }
    
    public ArrayList<ProdutosDTO> listarProdutos() throws SQLException{
        
        conn = new conectaDAO().connectDB();
        
        String sql = "SELECT * FROM produtos";
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery(sql);

        while (rs.next()) {
            ProdutosDTO p = new ProdutosDTO();
            p.setId(rs.getInt("id"));
            p.setNome(rs.getString("nome"));
            p.setValor(rs.getFloat("valor"));
            p.setStatus(rs.getString("status"));
            listagem.add(p);
            }

        rs.close();
        stmt.close();
        
        return listagem;
    }
    
    public void venderProduto(int id) throws SQLException {
        String sql = "SELECT 1 FROM produtos WHERE id = ? AND status = 'Vendido'";

        try (Connection conn = new conectaDAO().connectDB();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "Produto já foi vendido!");
            } else {                
                String updateSql = "UPDATE produtos SET status = ? WHERE id = ?";
                try (PreparedStatement updatePstm = conn.prepareStatement(updateSql)) {
                    updatePstm.setString(1, "Vendido");
                    updatePstm.setInt(2, id);
                    updatePstm.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Produto vendido com sucesso!");
                }
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao vender produto: " + erro.getMessage());
        }
    }
    
    public ArrayList<ProdutosDTO> buscarProdutosVendidos() {
        ArrayList<ProdutosDTO> lista = new ArrayList<>();
        String sql = "SELECT * FROM produtos WHERE status = 'Vendido'";

        try (Connection conn = new conectaDAO().connectDB();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                ProdutosDTO produto = new ProdutosDTO();
                produto.setId(rs.getInt("id"));
                produto.setNome(rs.getString("nome"));
                produto.setValor(rs.getFloat("valor"));
                produto.setStatus(rs.getString("status"));
                lista.add(produto);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar vendas: " + e.getMessage());
        }

        return lista;
    }
    
}

