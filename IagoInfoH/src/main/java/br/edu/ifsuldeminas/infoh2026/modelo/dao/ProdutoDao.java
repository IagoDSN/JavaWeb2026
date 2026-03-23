/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsuldeminas.infoh2026.modelo.dao;

import br.edu.ifsuldeminas.infoh2026.modelo.entidade.Produto;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
/**
 *
 * @author 13410289682
 */
public class ProdutoDao extends GenericoDAO<Produto>{
    public void salvar(Produto objProduto){
        String sql = "INSERT INTO PRODUTO(descricao, precoCompra, precoVenda, quantidadeEstoque) VALUES(?,?,?,?)";
        save(sql, objProduto.getDescricao(), objProduto.getPrecoCompra(), objProduto.getPrecoVenda(), objProduto.getQuantidadeEstoque());
        
    }
    
    public void alterar(Produto objProduto){
        String sql = "UPDATE PRODUTO SET descricao = ? , precoCompra = ? , precoVenda = ? , quantidadeEstoque = ? WHERE CODIGO=?";
        save(sql, objProduto.getDescricao(), objProduto.getPrecoCompra(), objProduto.getPrecoVenda(), objProduto.getQuantidadeEstoque());
        
    }
    public void excluir(Produto objProduto){
        String sql = "DELETE FROM PRODUTO WHERE CODIGO=?";
        save(sql, objProduto.getDescricao(), objProduto.getPrecoCompra(), objProduto.getPrecoVenda(), objProduto.getQuantidadeEstoque());
        
    }
    
    private static class ProdutoRowMapper implements RowMapper<Produto>{

        @Override
        public Produto mapRow(ResultSet rs) throws SQLException {
           Produto objProduto = new Produto();
           objProduto.setCodigo(rs.getInt("CODIGO"));
           objProduto.setDescricao(rs.getString("Descricao"));
           objProduto.setPrecoCompra(rs.getDouble("precoCompra"));
           objProduto.setPrecoVenda(rs.getDouble("precoVenda"));
           objProduto.setQuantidadeEstoque(rs.getInt("quantidadeEstoque"));
           System.out.println("Mapeando o objeto cidade"+objProduto.toString());
           return objProduto;
        }
        
    }
    
    public List<Produto> buscarTodosProdutos(){
        String sql = "SELECT * FROM CIDADE";
        return buscarTodos(sql, new ProdutoRowMapper());
    }
    
    public Produto buscarProdutoPorId(int id){
        String sql = "SELECT * FROM CIDADE WHERE CODIGO=? ";
        return buscarPorId(sql, new ProdutoRowMapper(), id);
    }
}
