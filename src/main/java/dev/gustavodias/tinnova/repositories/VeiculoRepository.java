package dev.gustavodias.tinnova.repositories;

import dev.gustavodias.tinnova.models.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VeiculoRepository extends JpaRepository <Veiculo, Long> {
}
