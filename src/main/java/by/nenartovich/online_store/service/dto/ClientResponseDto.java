package by.nenartovich.online_store.service.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;
import java.util.List;

public record ClientResponseDto(@Schema(defaultValue = "Ivan", description = "Client name")
                                String name,
                                @Schema(defaultValue = "Ivanov", description = "Client surname")
                                String surname,
                                @Schema(defaultValue = "Minsk", description = "Delivery city")
                                String country,
                                @Schema(defaultValue = "+375(25)123-45-67", description = "Client phone number")
                                String phoneNumber,
                                @Schema(defaultValue = "Pritytsky 1-5", description = "delivery address")
                                String address,
                                List<OrderDto> orders) implements Serializable {
}