package by.nenartovich.online_store.service.dto;

import by.nenartovich.online_store.repository.StatusOrder;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

import java.io.Serializable;

@Builder
public record OrderDto(
        @Schema(defaultValue = "12345", description = "Order number")
        Long number,
        @Schema(defaultValue = "phone", description = "Product name")
        String product,
        @Schema(defaultValue = "1500", description = "product price")
        double price,
        @Schema(defaultValue = "IN_PROCESSING", description = "Status order")
        StatusOrder status) implements Serializable {
}