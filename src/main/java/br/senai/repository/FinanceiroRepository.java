package br.senai.repository;

import br.senai.model.Financeiro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FinanceiroRepository extends JpaRepository<Financeiro, Long> {
     public Financeiro findByValorGasto(Double valorGasto);
    public Financeiro findByValorInserido(Double valorInserido);
    public List<Financeiro> findByFinalidadeLike(String finalidade);
}
