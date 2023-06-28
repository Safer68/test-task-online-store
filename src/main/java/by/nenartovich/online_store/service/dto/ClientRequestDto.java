package by.nenartovich.online_store.service.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

import java.io.Serializable;

@Builder
public record ClientRequestDto(
        @Schema(defaultValue = "Ivan", description = "Client name")
        String name,
        @Schema(defaultValue = "Ivanov", description = "Client surname")
        String surname,
        @Schema(defaultValue = "Minsk", description = "Delivery city")
        String country,
        @Schema(defaultValue = "+375(25)123-45-67", description = "Client phone number")
        String phoneNumber,
        @Schema(defaultValue = "Pritytsky 1-5", description = "delivery address")
        String address) implements Serializable {
}