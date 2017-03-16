package br.usjt.arqdesis.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.usjt.arqdesis.dao.ConnectionFactory;
import br.usjt.arqdesis.model.Usuario;



public class UsuarioDAO {

	
	//
	public int criar(Usuario usuario) {
		String sqlInsert = "INSERT INTO user(cpf, name, email, telefone, empresa, username, password) VALUES (?, ?, ?, ?, ? ,? ,?)";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setString(1, usuario.getCpf());
			stm.setString(2, usuario.getNome());
			stm.setString(3, usuario.getEmail());
			stm.setString(4, usuario.getTelefone());
			stm.setString(5, usuario.getEmpresa());
			stm.setString(6, usuario.getUsername());
			stm.setString(7, usuario.getPassword());
			stm.execute();
			String sqlQuery = "SELECT LAST_INSERT_ID()";
			try (PreparedStatement stm2 = conn.prepareStatement(sqlQuery);
					ResultSet rs = stm2.executeQuery();) {
				if (rs.next()) {
					usuario.setId(rs.getInt(1));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuario.getId();
	}
	
	//
	public void atualizar(Usuario usuario) {
		String sqlUpdate = "UPDATE user SET name=?, email=?, telefone=?, empresa=?, username=?, password=? WHERE id=?";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setString(1, usuario.getNome());
			stm.setString(2, usuario.getEmail());
			stm.setString(3, usuario.getTelefone());
			stm.setString(4, usuario.getEmpresa());
			stm.setString(5, usuario.getUsername());
			stm.setString(6, usuario.getPassword());
			stm.setInt(7, usuario.getId());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//
	public void excluir(int id) {
		String sqlDelete = "DELETE FROM user WHERE id = ?";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setInt(1, id);
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//
	public Usuario carregar(int id) {
		Usuario usuario = new Usuario();
		usuario.setId(id);
		String sqlSelect = "SELECT name, cpf, email, telefone, empresa, username, password FROM user WHERE id = ?";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, usuario.getId());
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					usuario.setNome(rs.getString("name"));
					usuario.setCpf(rs.getString("cpf"));
					usuario.setEmail(rs.getString("email"));
					usuario.setEmail(rs.getString("telefone"));
					usuario.setEmail(rs.getString("empresa"));
					usuario.setEmail(rs.getString("username"));
					usuario.setEmail(rs.getString("password"));
				} else {
					usuario.setId(-1);
					usuario.setCpf(null);
					usuario.setNome(null);
					usuario.setEmail(null);
					usuario.setTelefone(null);
					usuario.setEmpresa(null);
					usuario.setUsername(null);
					usuario.setPassword(null);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return usuario;
	}

	
}
