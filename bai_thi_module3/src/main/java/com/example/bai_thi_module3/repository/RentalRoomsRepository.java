package com.example.bai_thi_module3.repository;

import com.example.bai_thi_module3.model.PaymentMethods;
import com.example.bai_thi_module3.model.RentalRooms;
import com.example.bai_thi_module3.model.RentalRoomsDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class RentalRoomsRepository implements IRentalRoomsRepository{
    private static final String SELECT_RENTAL_ROOMS = "select r.room_id, r.tenant_name, r.phone_number, r.star_date, r.notes, p.payment_method_id, p.payment_method_name\n" +
            "from RentalRooms r\n" +
            "join PaymentMethods p on r.payment_method_id = p.payment_method_id;";

    private static final String SELECT_PAYMENT = "select * from PaymentMethods;";

    private static final String INSERT_RENTAL_ROOMS = "insert into RentalRooms(tenant_name,phone_number,star_date,notes,payment_method_id) values (?,?,?,?,?)";
    private static final String DELETE_RENTAL_ROOMS = "delete from RentalRooms where room_id=?";
    private static final String SEARCH_RENTAL_ROOMS = "select r.room_id, r.tenant_name, r.phone_number, r.star_date, r.notes,p.payment_method_id, p.payment_method_name\n" +
            "from RentalRooms r\n" +
            "join PaymentMethods p on r.payment_method_id = p.payment_method_id\n" +
            "where r.tenant_name like ?\n";
    @Override
    public List<RentalRoomsDTO> findAll() {
        List<RentalRoomsDTO> list = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_RENTAL_ROOMS);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("room_id");
                String tenantName = resultSet.getString("tenant_name");
                String phoneNumber = resultSet.getString("phone_number");
                String starDate = resultSet.getString("star_date");
                String notes = resultSet.getString("notes");
                int paymentMethodId = resultSet.getInt("payment_method_id");
                String paymentMethodName = resultSet.getString("payment_method_name");

                RentalRoomsDTO rentalRoomsDTO = new RentalRoomsDTO(id, tenantName, phoneNumber, starDate, notes, paymentMethodId, paymentMethodName);
                list.add(rentalRoomsDTO);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return list;

    }

    @Override
    public List<PaymentMethods> findAllPaymentMethods() {
        List<PaymentMethods> paymentList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PAYMENT);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int paymentMethodId = resultSet.getInt("payment_method_id");
                String paymentMethodName = resultSet.getString("payment_method_name");
                PaymentMethods paymentMethods = new PaymentMethods(paymentMethodId, paymentMethodName);
                paymentList.add(paymentMethods);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return paymentList;
    }

    @Override
    public void add(RentalRooms rentalRooms) {
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_RENTAL_ROOMS);
            preparedStatement.setString(1, rentalRooms.getTenantName());
            preparedStatement.setString(2, rentalRooms.getPhoneNumber());
            preparedStatement.setString(3, rentalRooms.getStarDate());
            preparedStatement.setString(4, rentalRooms.getNotes());
            preparedStatement.setInt(5,rentalRooms.getPaymentId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }

    @Override
    public void delete(int id) {
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_RENTAL_ROOMS);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public List<RentalRoomsDTO> search(String name) {
        Connection connection = BaseRepository.getConnectDB();
        List<RentalRoomsDTO> resultSearch = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_RENTAL_ROOMS);
            preparedStatement.setString(1, '%' + name + '%');
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("room_id");
                String tenantName = resultSet.getString("tenant_name");
                String phoneNumber = resultSet.getString("phone_number");
                String starDate = resultSet.getString("star_date");
                String notes = resultSet.getString("notes");
                int paymentMethodId = resultSet.getInt("payment_method_id");
                String paymentMethodName = resultSet.getString("payment_method_name");

                RentalRoomsDTO rentalRoomsDTO = new RentalRoomsDTO(id, tenantName, phoneNumber, starDate, notes, paymentMethodId, paymentMethodName);
                resultSearch.add(rentalRoomsDTO);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return resultSearch;
    }
}
