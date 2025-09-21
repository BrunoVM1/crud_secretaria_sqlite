package model.dao;

import factory.Persistencia;
import model.Secretaria;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SecretariaDAO implements IDao {

    @Override
    public void save(Object obj) {
        Secretaria secretaria = (Secretaria) obj;
        String sql = "INSERT INTO secretaria(nome, email, setor) VALUES (?,?,?)";

        try (PreparedStatement stmt = Persistencia.getConnection().prepareStatement(sql)) {
            stmt.setString(1, secretaria.getNome());
            stmt.setString(2, secretaria.getEmail());
            stmt.setString(3, secretaria.getSetor());
            stmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao salvar Secretaria: " + e.getMessage(), e);
        }
    }

    @Override
    public void update(Object obj) {
        Secretaria secretaria = (Secretaria) obj;
        String sql = "UPDATE secretaria SET nome=?, email=?, setor=? WHERE id=?";

        try (PreparedStatement stmt = Persistencia.getConnection().prepareStatement(sql)) {
            stmt.setString(1, secretaria.getNome());
            stmt.setString(2, secretaria.getEmail());
            stmt.setString(3, secretaria.getSetor());


            stmt.setInt(4, secretaria.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar Secretaria: " + e.getMessage(), e);
        }
    }

    @Override
    public boolean delete(Object obj) {
        Secretaria secretaria = (Secretaria) obj;
        String sql = "DELETE FROM secretaria WHERE id=?";

        try (PreparedStatement stmt = Persistencia.getConnection().prepareStatement(sql)) {
            stmt.setInt(1, secretaria.getId());
            int affectedRows = stmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar Secretaria: " + e.getMessage(), e);
        }
    }

    @Override
    public Secretaria find(Object obj) {
        Secretaria secretaria = (Secretaria) obj;
        String sql = "SELECT * FROM secretaria WHERE id=?";

        try (PreparedStatement stmt = Persistencia.getConnection().prepareStatement(sql)) {
            stmt.setInt(1, secretaria.getId());
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Secretaria(
                            rs.getInt("id"),
                            rs.getString("nome"),
                            rs.getString("email"),
                            rs.getString("setor")
                    );
                }
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar Secretaria: " + e.getMessage(), e);
        }
    }

    @Override
    public List<Object> findAll() {
        List<Object> list = new ArrayList<>();
        String sql = "SELECT * FROM secretaria ORDER BY id";

        try (PreparedStatement stmt = Persistencia.getConnection().prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Secretaria secretaria = new Secretaria(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("email"),
                        rs.getString("setor")
                );
                list.add(secretaria);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar Secretarias: " + e.getMessage(), e);
        }

        return list;
    }
}
