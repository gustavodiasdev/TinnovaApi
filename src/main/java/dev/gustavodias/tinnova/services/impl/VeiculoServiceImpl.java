package dev.gustavodias.tinnova.services.impl;

import dev.gustavodias.tinnova.models.Veiculo;
import dev.gustavodias.tinnova.repositories.VeiculoRepository;
import dev.gustavodias.tinnova.services.VeiculoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Service
@Transactional(readOnly = true)
public class VeiculoServiceImpl implements VeiculoService {

    private final VeiculoRepository veiculoRepository;

    public VeiculoServiceImpl(VeiculoRepository veiculoRepository) {
        this.veiculoRepository = veiculoRepository;
    }

    @Override
    public List<Veiculo> buscarTodosVeiculos() {
        return veiculoRepository.findAll();
    }

    @Override
    public Veiculo buscarVeiculoPeloID(Long id) {
        return veiculoRepository.findById(id)
                .orElse(null);
    }

    @Override
    @Transactional
    public Veiculo cadastrarVeiculo(Veiculo veiculo) {
        return veiculoRepository.save(veiculo);
    }

    @Override
    @Transactional
    public Veiculo atualizarVeiculo(Veiculo veiculo) {
        Veiculo findVeiculo = buscarVeiculoPeloID(veiculo.getId());
        findVeiculo.setNome(veiculo.getNome());
        findVeiculo.setDescricao(veiculo.getDescricao());
        findVeiculo.setAno(veiculo.getAno());
        findVeiculo.setVendido(veiculo.getVendido());
        veiculo.setUpdated(LocalDate.now());
        return veiculoRepository.save(findVeiculo);
    }

    @Override
    @Transactional
    public Veiculo atualizarVeiculoStatus(Long id) {
        Veiculo findVeiculo = buscarVeiculoPeloID(id);
        if (findVeiculo != null){
            findVeiculo.setVendido(Boolean.TRUE);
            findVeiculo.setUpdated(LocalDate.now());
            veiculoRepository.save(findVeiculo);
        }
        return findVeiculo;
    }

    @Override
    @Transactional
    public void apagarVeiculoPeloID(Long id) {
        Veiculo veiculo = buscarVeiculoPeloID(id);
        if (veiculo != null) {
            veiculoRepository.delete(veiculo);
        }

    }
}
