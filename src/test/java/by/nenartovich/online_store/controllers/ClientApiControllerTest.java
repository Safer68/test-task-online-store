package by.nenartovich.online_store.controllers;

import by.nenartovich.online_store.controllers.api.ClientApiController;
import by.nenartovich.online_store.service.ClientService;
import by.nenartovich.online_store.service.dto.ClientRequestDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static by.nenartovich.online_store.util.ClientTestData.getClientRequestDto;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = ClientApiController.class)
@AutoConfigureMockMvc(addFilters = false)
class ClientApiControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;
    @MockBean
    private ClientService clientService;

    @Test
    void shouldReturn201WhenSave() throws Exception {
        ClientRequestDto clientRequestDto = getClientRequestDto();
        when(clientService.save(clientRequestDto)).thenReturn(clientRequestDto);
        mockMvc.perform(post("/api/v1/clients")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsBytes(getClientRequestDto())))
                .andExpect(status().isCreated())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON));
    }
}