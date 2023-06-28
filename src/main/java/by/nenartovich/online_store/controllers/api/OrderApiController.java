package by.nenartovich.online_store.controllers.api;

import by.nenartovich.online_store.service.OrderService;
import by.nenartovich.online_store.service.dto.OrderDto;
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

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/clients/{client_id}/orders")
public class OrderApiController {
    private final OrderService orderService;

    @PostMapping()
    @Operation(summary = "Save order")
    public ResponseEntity<OrderDto> save(@RequestBody OrderDto orderDto, @PathVariable(name = "client_id") Long id) {
        OrderDto saveOrder = orderService.save(id, orderDto);
        return new ResponseEntity<>(saveOrder, HttpStatus.CREATED);
    }

    @GetMapping()
    @Operation(summary = "Get all orders by client id")
    public ResponseEntity<List<OrderDto>> getAllByClientId(@PathVariable Long client_id) {
        List<OrderDto> orderDtoList = orderService.getAllByClientId(client_id);
        return ResponseEntity.ok(orderDtoList);
    }

    @GetMapping("/orders/{id}")
    @Operation(summary = "Get order by id and client id")
    public ResponseEntity<OrderDto> getByIdAndClientId(@PathVariable Long client_id, @PathVariable Long id) {
        OrderDto orderDto = orderService.getByIdAndClientId(id, client_id);
        return ResponseEntity.ok(orderDto);
    }

    @PutMapping("/orders/{id}")
    @Operation(summary = "Update order by id and client id")
    public ResponseEntity<OrderDto> getById(@RequestBody OrderDto orderDto, @PathVariable Long client_id, @PathVariable Long id) {
        OrderDto updateOrder = orderService.update(id, client_id, orderDto);
        return ResponseEntity.ok(updateOrder);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete order by id and client id")
    public ResponseEntity delete(@PathVariable Long client_id, @PathVariable Long id) {
        orderService.delete(id, client_id);
        return ResponseEntity.ok(HttpEntity.EMPTY);
    }
}
