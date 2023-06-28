package by.nenartovich.online_store.service;

import by.nenartovich.online_store.service.dto.OrderDto;

import java.util.List;

public interface OrderService {
    OrderDto save(Long clientId, OrderDto orderDto);

    OrderDto getByIdAndClientId(Long id,Long clientId);

    List<OrderDto> getAllByClientId(Long clientId);

    OrderDto update(Long id, Long clientId, OrderDto orderDto);
    void delete(Long id,Long clientId);
}
