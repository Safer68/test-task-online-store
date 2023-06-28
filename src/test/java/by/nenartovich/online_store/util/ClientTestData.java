package by.nenartovich.online_store.util;

import by.nenartovich.online_store.service.dto.ClientRequestDto;

public class ClientTestData {
    private static final String NAME = "Ivan";
    private static final String SURNAME = "Ivanov";
    private static final String COUNTRY = "Minsk";
    private static final String PHONE_NUMBER = "+375(25)123-45-67";
    private static final String ADDRESS = "Pritytsky 1-5";

    public static ClientRequestDto getClientRequestDto() {
        return new ClientRequestDto(
                NAME,
                SURNAME,
                COUNTRY,
                PHONE_NUMBER,
                ADDRESS);
    }
}
