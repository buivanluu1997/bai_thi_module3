package com.example.bai_thi_module3.service;

import com.example.bai_thi_module3.model.PaymentMethods;
import com.example.bai_thi_module3.model.RentalRooms;
import com.example.bai_thi_module3.model.RentalRoomsDTO;

import java.util.List;

public interface IRentalRoomsService {
    List<RentalRoomsDTO> findAll();

    List<PaymentMethods> findAllPaymentMethods();

    void add(RentalRooms rentalRooms);

    void delete(int id);

    List<RentalRoomsDTO> search(String name);
}
