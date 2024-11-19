package com.twohdcd.Laptopshop.controller;

import com.twohdcd.Laptopshop.domain.Delivery;
import com.twohdcd.Laptopshop.service.DeliveryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DeliveryController {
    private final DeliveryService deliveryService;

    public DeliveryController(DeliveryService deliveryService) {
        this.deliveryService = deliveryService;
    }

    @GetMapping("/deliveries")
    public ResponseEntity<List<Delivery>> getAllDelivery() {
        List<Delivery> deliveries = deliveryService.getAllDeliveries();

        if (deliveries.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(deliveries);
    }

    @GetMapping("/deliveries/{id}")
    public ResponseEntity<Delivery> getDeliveryById(@PathVariable int id) {
        Delivery delivery = deliveryService.getDeliveryById(id);
        return ResponseEntity.ok(delivery);
    }

    @PostMapping("/deliveries")
    public ResponseEntity<Delivery> createDelivery(@RequestBody Delivery delivery) {
        return ResponseEntity.ok(deliveryService.addDelivery(delivery));
    }

    @PutMapping("/deliveries/{id}")
    public ResponseEntity<Delivery> updateDeliveryById(@RequestBody Delivery deliveryParam, @PathVariable int id) {
        Delivery delivery = deliveryService.getDeliveryById(id);
        delivery.setDeliveryMethod(deliveryParam.getDeliveryMethod());
        delivery.setDeliveryCost(deliveryParam.getDeliveryCost());
        delivery.setEstimatedTime(deliveryParam.getEstimatedTime());
        return ResponseEntity.ok(deliveryService.updateDelivery(delivery));
    }

    @DeleteMapping("/deliveries/{id}")
    public ResponseEntity<String> deleteDeliveryById(@PathVariable int id) {
        deliveryService.deleteDeliveryById(id);
        return ResponseEntity.ok("Delivery deleted successfully");
    }

}
