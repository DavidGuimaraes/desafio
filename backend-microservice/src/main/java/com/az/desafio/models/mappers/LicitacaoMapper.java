package com.az.desafio.models.mappers;

import com.az.desafio.models.Licitacao;
import com.az.desafio.models.dto.LicitacaoDto;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LicitacaoMapper {

    @Mappings({
            @Mapping(target = "id", source = "licitacaoId")
    })
    LicitacaoDto entityToDto(Licitacao licitacao);

    List<LicitacaoDto> entityToDto(List<Licitacao> licitacao);

    @Mappings({
            @Mapping(target = "licitacaoId", source = "id")
    })
    Licitacao dtoToEntity(LicitacaoDto licitacaoDto);

    List<Licitacao> dtoToEntity(List<LicitacaoDto> licitacaoDto);
}
