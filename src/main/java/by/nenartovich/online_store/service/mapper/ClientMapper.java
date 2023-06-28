package by.nenartovich.online_store.service.mapper;

import by.nenartovich.online_store.repository.model.Client;
import by.nenartovich.online_store.service.dto.ClientRequestDto;
import by.nenartovich.online_store.service.dto.ClientResponseDto;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;


@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING, uses = {OrderMapper.class})
public interface ClientMapper {
    Client clientRequestDtoToClient(ClientRequestDto clientRequestDto);

    ClientRequestDto clientToClientRequestDto(Client client);

    ClientResponseDto clientToClientResponseDto(Client client);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Client update(ClientRequestDto clientRequestDto, @MappingTarget Client client);
}