package by.nenartovich.online_store.service.impl;

import by.nenartovich.online_store.controllers.exception.BadRequestException;
import by.nenartovich.online_store.repository.model.Client;
import by.nenartovich.online_store.repository.ClientRepository;
import by.nenartovich.online_store.repository.OrderRepository;
import by.nenartovich.online_store.service.ClientService;
import by.nenartovich.online_store.service.dto.ClientRequestDto;
import by.nenartovich.online_store.service.dto.ClientResponseDto;
import by.nenartovich.online_store.service.mapper.ClientMapper;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;
    private final OrderRepository orderRepository;

    @Override
    @Transactional
    public ClientRequestDto save(ClientRequestDto clientRequestDto) {
        Client client = clientRepository.save(clientMapper.clientRequestDtoToClient(clientRequestDto));
        return clientMapper.clientToClientRequestDto(client);
    }

    @Override
    @Transactional
    public ClientRequestDto update(Long id, ClientRequestDto clientRequestDto) {
        Client client = clientMapper.update(clientRequestDto, clientRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("client by id not found")));
        return clientMapper.clientToClientRequestDto(client);
    }

    @Override
    public Optional<ClientResponseDto> getClient(Long id) {
        return clientRepository.findById(id).map(clientMapper::clientToClientResponseDto);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("client by id not found"));
        client.getOrders().forEach(orderRepository::delete);
        clientRepository.delete(client);
    }
}
