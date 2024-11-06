package com.example.bai_thi_module3.service;

import com.example.bai_thi_module3.model.PaymentMethods;
import com.example.bai_thi_module3.model.RentalRooms;
import com.example.bai_thi_module3.model.RentalRoomsDTO;
import com.example.bai_thi_module3.repository.IRentalRoomsRepository;
import com.example.bai_thi_module3.repository.RentalRoomsRepository;

import java.util.List;

public class RentalRoomsService implements IRentalRoomsService {
    private IRentalRoomsRepository rentalRoomsRepository = new RentalRoomsRepository();
    @Override
    public List<RentalRoomsDTO> findAll() {
        return rentalRoomsRepository.findAll();
    }

    @Override
    public List<PaymentMethods> findAllPaymentMethods() {
        return rentalRoomsRepository.findAllPaymentMethods();
    }

    @Override
    public void add(RentalRooms rentalRooms) {
        rentalRoomsRepository.add(rentalRooms);
    }

    @Override
    public void delete(int id) {
        rentalRoomsRepository.delete(id);
    }

    @Override
    public List<RentalRoomsDTO> search(String name) {
        return rentalRoomsRepository.search(name);
    }
}
