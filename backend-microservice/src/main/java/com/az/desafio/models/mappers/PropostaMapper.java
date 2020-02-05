package com.az.desafio.models.mappers;

import com.az.desafio.models.Proposta;
import com.az.desafio.models.dto.PropostaDto;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PropostaMapper {

    @Mappings({
            @Mapping(target = "id", source = "propostaId"),
            @Mapping(target = "licitacaoId", source = "licitacao.id")
    })
    PropostaDto entityToDto(Proposta proposta);

    List<PropostaDto> entityToDto(List<Proposta> proposta);

    @Mappings({
            @Mapping(target = "propostaId", source = "id"),
            @Mapping(target = "licitacao.id", source = "licitacaoId")
    })
    Proposta dtoToEntity(PropostaDto propostaDto);

    List<Proposta> dtoToEntity(List<PropostaDto> propostaDto);
}
