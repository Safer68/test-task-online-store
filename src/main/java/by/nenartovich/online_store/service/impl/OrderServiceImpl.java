package by.nenartovich.online_store.service.impl;

import by.nenartovich.online_store.repository.ClientRepository;
import by.nenartovich.online_store.repository.OrderRepository;
import by.nenartovich.online_store.repository.model.Client;
import by.nenartovich.online_store.repository.model.Order;
import by.nenartovich.online_store.service.OrderService;
import by.nenartovich.online_store.service.dto.OrderDto;
import by.nenartovich.online_store.service.mapper.OrderMapper;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final ClientRepository clientRepository;
    private final OrderMapper orderMapper;

    @Override
    @Transactional
    public OrderDto save(Long clientId, OrderDto orderDto) {
        Order order = orderMapper.orderDtoToOrder(orderDto);
        Client client = clientRepository.findById(clientId).orElseThrow();
        order.setClient(client);
        orderRepository.save(order);
        return orderMapper.OrderToOrderDto(order);
    }

    @Override
    public OrderDto getByIdAndClientId(Long id, Long clientId) {
        Optional<Order> order = orderRepository.findByIdAndClientId(id, clientId);
        return orderMapper.OrderToOrderDto(order.orElseThrow());
    }

    @Override
    public List<OrderDto> getAllByClientId(Long clientId) {
        return orderRepository.findAllOrdersByClientId(clientId)
                .stream().map(orderMapper::OrderToOrderDto).toList();
    }

    @Override
    @Transactional
    public OrderDto update(Long id, Long clientId, OrderDto orderDto) {
        Order order = orderRepository.findByIdAndClientId(id, clientId).orElseThrow();
        order = orderRepository.save(orderMapper.update(orderDto, order));
        return orderMapper.OrderToOrderDto(order);
    }

    @Override
    @Transactional
    public void delete(Long id, Long clientId) {
        Order order = orderRepository.findByIdAndClientId(id, clientId).orElseThrow();
        orderRepository.delete(order);
    }
}
