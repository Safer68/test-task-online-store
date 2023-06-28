package by.nenartovich.online_store.repository.utile;


import by.nenartovich.online_store.repository.StatusOrder;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.stream.Stream;

@Converter(autoApply = true)
public class StatusOrderConverter implements AttributeConverter<StatusOrder, String> {

    @Override
    public String convertToDatabaseColumn(StatusOrder status) {
        if (status == null) {
            return null;
        }
        return status.getCode();
    }

    @Override
    public StatusOrder convertToEntityAttribute(String code) {
        if (code == null) {
            return null;
        }
        return Stream.of(StatusOrder.values())
                .filter(c -> c.getCode().equals(code))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}