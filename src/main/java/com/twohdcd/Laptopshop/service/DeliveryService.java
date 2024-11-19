package com.twohdcd.Laptopshop.service;


import com.twohdcd.Laptopshop.domain.Delivery;
import com.twohdcd.Laptopshop.repository.DeliveryRepository;
import com.twohdcd.Laptopshop.repository.DeliveryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliveryService {
    private final DeliveryRepository deliveryRepository;

    public DeliveryService(DeliveryRepository deliveryRepository) {
        this.deliveryRepository = deliveryRepository;
    }

    public List<Delivery> getAllDeliveries() {
        return deliveryRepository.findAll();
    }

    public Delivery getDeliveryById(int id) {
        return deliveryRepository.findById(id);
    }

    public Delivery addDelivery(Delivery Delivery) {
        return deliveryRepository.save(Delivery);
    }

    public Delivery updateDelivery(Delivery Delivery) {
        return deliveryRepository.save(Delivery);
    }

    public void deleteDeliveryById(int id) {
        deliveryRepository.deleteById(id);
    }
}
