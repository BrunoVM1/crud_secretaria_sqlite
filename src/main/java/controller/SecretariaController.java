package controller;

import model.Secretaria;
import model.dao.SecretariaDAO;

import java.util.List;

public class SecretariaController {

    private SecretariaDAO repositorio;

    public SecretariaController() {
        this.repositorio = new SecretariaDAO();
    }

    public void save(String nome, String email, String setor) {
        Secretaria secretaria = new Secretaria(0, nome, email, setor);
        repositorio.save(secretaria);
    }

    public void update(int id, String nome, String email, String setor) {
        Secretaria secretaria = new Secretaria(id, nome, email, setor);
        repositorio.update(secretaria);
    }

    public boolean delete(int id) {
        Secretaria secretaria = new Secretaria();
        secretaria.setId(id);
        return repositorio.delete(secretaria);
    }

    public Secretaria find(int id) {
        Secretaria secretaria = new Secretaria();
        secretaria.setId(id);
        return repositorio.find(secretaria);
    }

    public List<Object> findAll() {
        return repositorio.findAll();
    }
}
