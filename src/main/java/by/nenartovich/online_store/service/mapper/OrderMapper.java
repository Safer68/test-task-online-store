package by.nenartovich.online_store.service.mapper;

import by.nenartovich.online_store.repository.model.Order;
import by.nenartovich.online_store.service.dto.OrderDto;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface OrderMapper {
    Order orderDtoToOrder(OrderDto orderDto);

    OrderDto OrderToOrderDto(Order order);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Order update(OrderDto orderDto, @MappingTarget Order order);
}