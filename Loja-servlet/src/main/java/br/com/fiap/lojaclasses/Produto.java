package br.com.fiap.lojaclasses;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Produto {
	
	private int idProduto;
	private String descricao;
	private double preco;
	private Categoria categoria;
	
	@Override
	public String toString() {
		return "Produto [idProduto=" + idProduto + ", descricao=" + descricao + ", preco=" + preco + ", categoria="
				+ categoria + "]";
	}

	public int getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	public void inserirProduto() {
		Connection cnx = ConnectionDB.obterConexao();
		PreparedStatement pstmt;
		String sql = "INSERT INTO produto (idproduto, descricao, preco, idcategoria) VALUES(?,?,?,?)";
		
		try {
			pstmt = cnx.prepareStatement(sql);
			pstmt.setInt(1, this.idProduto);
			pstmt.setString(2, this.descricao);
			pstmt.setDouble(3, this.preco);
			pstmt.setInt(4, this.categoria.getIdCategoria());
			pstmt.executeUpdate();
			System.out.println("Sucesso");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void alterarProduto() {
		Connection cnx = ConnectionDB.obterConexao();
		PreparedStatement pstmt;
		String sql = "UPDATE produto SET descricao=?, preco=? WHERE idproduto=?";
		
		try {
			pstmt = cnx.prepareStatement(sql);
			pstmt.setString(1, this.descricao);
			pstmt.setDouble(2, this.preco);
			pstmt.setInt(3, this.idProduto);
			pstmt.executeUpdate();
			System.out.println("Sucesso");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
