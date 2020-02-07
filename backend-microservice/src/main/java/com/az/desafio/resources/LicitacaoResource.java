package com.az.desafio.resources;

import com.az.desafio.models.Licitacao;
import com.az.desafio.models.dto.LicitacaoDto;
import com.az.desafio.models.enums.TipoClassificacao;
import com.az.desafio.models.mappers.LicitacaoMapper;
import com.az.desafio.services.LicitacaoService;
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
import java.util.ArrayList;
import java.util.List;

// TODO - resolver o problema com CORS para que a anotação @CrossOrigin não seja mais necessária
// TODO - implementar uma classe ExceptionHandler

@CrossOrigin
@RestController
@RequestMapping("/rest/licitacoes")
public class LicitacaoResource {

    @Autowired
    private LicitacaoService licitacaoService;

    @Autowired
    private LicitacaoMapper licitacaoMapper;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Page<LicitacaoDto> listar(Pageable pageable) throws Exception {
        try {
            pageable = pageable.previousOrFirst();
            Page<Licitacao> licitacoes = licitacaoService.findAll(pageable);
            return licitacoes.map(licitacaoMapper::entityToDto);
        } catch (Exception e) {
            throw new Exception("Erro ao buscar dados: " + e.getMessage());
        }
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public LicitacaoDto pesquisarPeloId(@PathVariable(value = "id") BigInteger id) throws Exception {
        Licitacao licitacao = licitacaoService.findById(id);
        return licitacaoMapper.entityToDto(licitacao);
    }

    @GetMapping(value = "/classificacoes")
    public List<String> pesquisarTiposDeClassificacao() throws Exception {
        List<TipoClassificacao> tipos = licitacaoService.findTiposClassificacao();
        List<String> tiposEmString = new ArrayList<>();
        tipos.forEach(tipoClassificacao -> {
            tiposEmString.add(tipoClassificacao.getTipo());
        });
        return tiposEmString;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LicitacaoDto> salvar(@Valid @RequestBody LicitacaoDto licitacaoDto){
        Licitacao licitacao = licitacaoMapper.dtoToEntity(licitacaoDto);

        Licitacao licitacaoSalva = licitacaoService.save(licitacao);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(licitacao.getLicitacaoId()).toUri();

        return ResponseEntity.created(uri).body(licitacaoMapper.entityToDto(licitacaoSalva));
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LicitacaoDto> editar(@Valid @RequestBody LicitacaoDto licitacaoDto) throws Exception {

        Licitacao licitacao = licitacaoMapper.dtoToEntity(licitacaoDto);
        Licitacao licitacaoSalva = licitacaoService.update(licitacao);

        return ResponseEntity.ok(licitacaoMapper.entityToDto(licitacaoSalva));
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> deletar(@PathVariable("id") BigInteger id) throws Exception{
        licitacaoService.delete(id);

        return ResponseEntity.noContent().build();
    }
}
