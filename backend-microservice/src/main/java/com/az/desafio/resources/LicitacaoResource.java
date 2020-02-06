package com.az.desafio.resources;

import com.az.desafio.models.Licitacao;
import com.az.desafio.models.dto.LicitacaoDto;
import com.az.desafio.models.enums.TipoClassificacao;
import com.az.desafio.models.mappers.LicitacaoMapper;
import com.az.desafio.services.LicitacaoService;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.math.BigInteger;
import java.net.URI;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/rest/licitacoes")
public class LicitacaoResource {

    @Autowired
    private LicitacaoService licitacaoService;

    @Autowired
    private LicitacaoMapper licitacaoMapper;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
//    @PreAuthorize("isAuthenticated()")
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
//    @PreAuthorize("isAuthenticated()")
    public LicitacaoDto pesquisarPeloId(@PathVariable(value = "id") BigInteger id) throws Exception {
        Licitacao licitacao = licitacaoService.findById(id);
        return licitacaoMapper.entityToDto(licitacao);
    }

    /*@GetMapping(params = "classificacao")
    @PreAuthorize("isAuthenticated()")
    public Optional<LicitacaoDto> pesquisarPelaDescricao(@RequestParam TipoClassificacao classificacao, Pageable pageable) {
        Optional<Licitacao> bairros = licitacaoService.findByClassificacao(classificacao);
        return bairros.map(naBairro -> {
            return licitacaoMapper.entityToDto(naBairro);
        });
    }*/

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
