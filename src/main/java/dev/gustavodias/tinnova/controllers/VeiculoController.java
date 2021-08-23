package dev.gustavodias.tinnova.controllers;

import dev.gustavodias.tinnova.models.Veiculo;
import dev.gustavodias.tinnova.services.VeiculoService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/veiculos", produces = MediaType.APPLICATION_JSON_VALUE)
public class VeiculoController {

    private final VeiculoService veiculoService;

    public VeiculoController(VeiculoService veiculoService) {
        this.veiculoService = veiculoService;
    }

    @GetMapping( produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Veiculo>> listarTodosVeiculos(){
        HttpStatus httpStatus = HttpStatus.OK;
        List<Veiculo> veiculos = null;
        try {
            veiculos = veiculoService.buscarTodosVeiculos();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(veiculos,httpStatus);
    }

    @GetMapping( path = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Veiculo> buscarVeiculoPeloID(@PathVariable Long id){
        HttpStatus httpStatus = HttpStatus.OK;
        Veiculo veiculo = null;
        try {
            veiculo = veiculoService.buscarVeiculoPeloID(id);
            if (veiculo == null){
                httpStatus = HttpStatus.NOT_FOUND;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(veiculo,httpStatus);
    }


    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Veiculo> cadastrarVeiculo(@RequestBody Veiculo veiculo){
        HttpStatus httpStatus = HttpStatus.CREATED;
        try {
           veiculo  = veiculoService.cadastrarVeiculo(veiculo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(veiculo, httpStatus);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Veiculo> atualizarVeiculo(@RequestBody Veiculo veiculo){
        HttpStatus httpStatus = HttpStatus.OK;
        try {
            veiculo =  veiculoService.atualizarVeiculo(veiculo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(httpStatus);
    }

    @PatchMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Atuliza para status vendido = True", notes = "Endpoit para status de vendido")
    public ResponseEntity<Veiculo> atualizarVeiculoParte(@PathVariable Long id){
        HttpStatus httpStatus = HttpStatus.OK;
        Veiculo veiculo = null;
        try {
            veiculo = veiculoService.atualizarVeiculoStatus(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(veiculo, httpStatus);
    }

    @DeleteMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Veiculo> apagarVeiculoPeloID(@PathVariable Long id){
        HttpStatus httpStatus = HttpStatus.OK;
        try {
            veiculoService.apagarVeiculoPeloID(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(httpStatus);
    }
}
