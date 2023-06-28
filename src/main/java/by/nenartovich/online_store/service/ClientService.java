package by.nenartovich.online_store.service;

import by.nenartovich.online_store.service.dto.ClientRequestDto;
import by.nenartovich.online_store.service.dto.ClientResponseDto;

import java.util.Optional;

public interface ClientService {
    ClientRequestDto save(ClientRequestDto clientRequestDto);

    ClientRequestDto update(Long id, ClientRequestDto clientRequestDto);

    Optional<ClientResponseDto> getClient(Long id);

    void delete(Long id);
}
