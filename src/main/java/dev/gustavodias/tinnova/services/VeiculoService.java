package dev.gustavodias.tinnova.services;

import dev.gustavodias.tinnova.models.Veiculo;

import java.util.List;

public interface VeiculoService {

    List<Veiculo> buscarTodosVeiculos();

    Veiculo buscarVeiculoPeloID(Long id);

    Veiculo cadastrarVeiculo(Veiculo veiculo);

    Veiculo atualizarVeiculo(Veiculo veiculo);

    Veiculo atualizarVeiculoStatus(Long id);

    void apagarVeiculoPeloID(Long id);
}
