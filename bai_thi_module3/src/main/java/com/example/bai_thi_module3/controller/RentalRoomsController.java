package com.example.bai_thi_module3.controller;

import com.example.bai_thi_module3.model.RentalRooms;
import com.example.bai_thi_module3.service.IRentalRoomsService;
import com.example.bai_thi_module3.service.RentalRoomsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RentalRoomsController", value = "/rental-rooms")
public class RentalRoomsController extends HttpServlet {
    private IRentalRoomsService rentalRoomsService = new RentalRoomsService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "add":
                addForm(req,resp);
                break;
            case "search":
                searchForm(req,resp);
                break;
            default:
                showListRentalRooms(req,resp);
        }
    }

    private void searchForm(HttpServletRequest req, HttpServletResponse resp) {
        try {
            req.getRequestDispatcher("view/search.jsp").forward(req,resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void addForm(HttpServletRequest req, HttpServletResponse resp) {
        req.setAttribute("payments",rentalRoomsService.findAllPaymentMethods());
        try {
            req.getRequestDispatcher("view/add.jsp").forward(req,resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showListRentalRooms(HttpServletRequest req, HttpServletResponse resp) {
        req.setAttribute("rentalRoomsList", rentalRoomsService.findAll());
        try {
            req.getRequestDispatcher("view/list.jsp").forward(req,resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "add":
                addRentalRooms(req,resp);
                break;
            case "delete":
                deleteRental(req,resp);
                break;
            case "search":
                searchName(req,resp);
                break;
        }
    }

    private void searchName(HttpServletRequest req, HttpServletResponse resp) {
        String name = req.getParameter("name");
        req.setAttribute("result", rentalRoomsService.search(name));
        try {
            req.getRequestDispatcher("view/search.jsp").forward(req,resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void deleteRental(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("id"));
        rentalRoomsService.delete(id);

        try {
            resp.sendRedirect("rental-rooms");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void addRentalRooms(HttpServletRequest req, HttpServletResponse resp) {
        String tenantName = req.getParameter("tenantName");
        String phoneNumber = req.getParameter("phoneNumber");
        String startDate = req.getParameter("startDate");
        String notes = req.getParameter("notes");
        int paymentId = Integer.parseInt(req.getParameter("paymentId"));

        RentalRooms rentalRooms = new RentalRooms(tenantName,phoneNumber,startDate,notes,paymentId);
        rentalRoomsService.add(rentalRooms);

        try {
            resp.sendRedirect("rental-rooms");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
