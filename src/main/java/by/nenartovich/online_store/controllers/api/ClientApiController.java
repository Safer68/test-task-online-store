package by.nenartovich.online_store.controllers.api;

import by.nenartovich.online_store.controllers.exception.BadRequestException;
import by.nenartovich.online_store.service.ClientService;
import by.nenartovich.online_store.service.dto.ClientRequestDto;
import by.nenartovich.online_store.service.dto.ClientResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/clients")
public class ClientApiController {
    private final ClientService clientService;

    @PostMapping
    @Operation(summary = "Save client")
    public ResponseEntity<ClientRequestDto> save(@RequestBody ClientRequestDto clientRequestDto) {
        ClientRequestDto saveClient = clientService.save(clientRequestDto);
        return new ResponseEntity<>(saveClient, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get client by id")
    public ResponseEntity<ClientResponseDto> get(@PathVariable(name = "id") Long id) {
        ClientResponseDto clientResponseDto = clientService.getClient(id)
                .orElseThrow(() -> new BadRequestException("client by id not found"));
        return ResponseEntity.ok(clientResponseDto);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update client by id")
    public ResponseEntity<ClientRequestDto> update(@RequestBody ClientRequestDto clientRequestDto,
                                                   @PathVariable(name = "id") Long id) {
        ClientRequestDto clientResponseDto = clientService.update(id, clientRequestDto);
        return ResponseEntity.ok(clientResponseDto);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete client by id")
    public ResponseEntity delete(@PathVariable(name = "id") Long id) {
        clientService.delete(id);
        return ResponseEntity.ok(HttpEntity.EMPTY);
    }
}
