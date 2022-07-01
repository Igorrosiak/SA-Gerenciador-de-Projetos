package br.senai.repository;

import br.senai.model.Permissao;
import br.senai.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PermissaoRepository extends JpaRepository<Permissao, Long> {

    public List<Permissao> findByUsuariosIn(Usuario ... usuarios);
}
