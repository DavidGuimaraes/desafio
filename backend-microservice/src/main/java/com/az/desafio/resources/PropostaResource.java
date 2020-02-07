package com.az.desafio.resources;

import com.az.desafio.models.Proposta;
import com.az.desafio.models.dto.PropostaDto;
import com.az.desafio.models.mappers.PropostaMapper;
import com.az.desafio.services.PropostaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.math.BigInteger;
import java.net.URI;

// TODO - resolver o problema com CORS para que a anotação @CrossOrigin não seja mais necessária
// TODO - implementar uma classe ExceptionHandler

@CrossOrigin
@RestController
@RequestMapping("/rest/propostas")
public class PropostaResource {

    @Autowired
    private PropostaService propostaService;

    @Autowired
    private PropostaMapper propostaMapper;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Page<PropostaDto> listar(Pageable pageable) throws Exception {
        try {
            pageable = pageable.previousOrFirst();
            Page<Proposta> propostas = propostaService.findAll(pageable);
            return propostas.map(propostaMapper::entityToDto);
        } catch (Exception e) {
            throw new Exception("Erro ao buscar dados: " + e.getMessage());
        }
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public PropostaDto pesquisarPeloId(@PathVariable(value = "id") BigInteger id) throws Exception {
        Proposta proposta = propostaService.findById(id);
        return propostaMapper.entityToDto(proposta);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PropostaDto> salvar(@Valid @RequestBody PropostaDto propostaDto){
        Proposta proposta = propostaMapper.dtoToEntity(propostaDto);

        Proposta propostaSalva = propostaService.save(proposta);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(proposta.getPropostaId()).toUri();

        return ResponseEntity.created(uri).body(propostaMapper.entityToDto(propostaSalva));
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PropostaDto> editar(@Valid @RequestBody PropostaDto propostaDto) throws Exception {

        Proposta proposta = propostaMapper.dtoToEntity(propostaDto);
        Proposta propostaSalva = propostaService.update(proposta);

        return ResponseEntity.ok(propostaMapper.entityToDto(propostaSalva));
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> deletar(@PathVariable("id") BigInteger id) throws Exception{
        propostaService.delete(id);

        return ResponseEntity.noContent().build();
    }
}
