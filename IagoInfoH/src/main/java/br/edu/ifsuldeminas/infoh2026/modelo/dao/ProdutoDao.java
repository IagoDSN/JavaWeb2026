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

public class ProdutoDao extends GenericoDAO<Produto> {

    public void salvar(Produto objProduto) {
        String sql = "INSERT INTO PRODUTO(descricao, precoCompra, precoVenda, quantidadeEstoque) VALUES(?,?,?,?)";
        save(sql, objProduto.getDescricao(), objProduto.getPrecoCompra(), objProduto.getPrecoVenda(), objProduto.getQuantidadeEstoque());
    }

    public void alterar(Produto objProduto) {
        // Corrigido: Agora passa o CODIGO no final para o WHERE
        String sql = "UPDATE PRODUTO SET descricao = ? , precoCompra = ? , precoVenda = ? , quantidadeEstoque = ? WHERE CODIGO=?";
        save(sql, objProduto.getDescricao(), objProduto.getPrecoCompra(), objProduto.getPrecoVenda(), objProduto.getQuantidadeEstoque(), objProduto.getCodigo());
    }

    public void excluir(Produto objProduto) {
        // Corrigido: No DELETE, você só precisa passar o CODIGO
        String sql = "DELETE FROM PRODUTO WHERE CODIGO=?";
        save(sql, objProduto.getCodigo());
    }

    private static class ProdutoRowMapper implements RowMapper<Produto> {
        @Override
        public Produto mapRow(ResultSet rs) throws SQLException {
            Produto objProduto = new Produto();
            objProduto.setCodigo(rs.getInt("CODIGO"));
            objProduto.setDescricao(rs.getString("descricao")); // Verifique se no banco é minúsculo
            objProduto.setPrecoCompra(rs.getDouble("precoCompra"));
            objProduto.setPrecoVenda(rs.getDouble("precoVenda"));
            objProduto.setQuantidadeEstoque(rs.getInt("quantidadeEstoque"));
            return objProduto;
        }
    }

    public List<Produto> buscarTodosProdutos() {
        // CORREÇÃO AQUI: Estava SELECT * FROM CIDADE
        String sql = "SELECT * FROM PRODUTO"; 
        return buscarTodos(sql, new ProdutoRowMapper());
    }

    public Produto buscarProdutoPorId(int id) {
        // CORREÇÃO AQUI: Estava SELECT * FROM CIDADE
        String sql = "SELECT * FROM PRODUTO WHERE CODIGO=? ";
        return buscarPorId(sql, new ProdutoRowMapper(), id);
    }
}