package com.example.bai_thi_module3.repository;

import com.example.bai_thi_module3.model.PaymentMethods;
import com.example.bai_thi_module3.model.RentalRooms;
import com.example.bai_thi_module3.model.RentalRoomsDTO;

import java.util.List;

public interface IRentalRoomsRepository {
    List<RentalRoomsDTO> findAll();

    List<PaymentMethods> findAllPaymentMethods();

    void add(RentalRooms rentalRooms);

    void delete(int id);

    List<RentalRoomsDTO> search(String name);


}
