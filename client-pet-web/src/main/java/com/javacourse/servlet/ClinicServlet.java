package com.javacourse.servlet;

import com.javacourse.clinic.pet.Dog;
import com.javacourse.clinic.pet.Pet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ClinicServlet extends HttpServlet {

    final List<Pet> pets = new CopyOnWriteArrayList<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        writer.append(
                "<!DOCTYPE html>" +
                        "<html>" +
                        "<head>" +
                            "<title>Clinic Pets</title>" +
                        "</head>" +
                        "<body>" +
                            "<form action='"+req.getContextPath()+"/' method='post'>" +
                                "Name: <input type='text' name='name'>" +
                                "<input type='submit' value='Submit'>" +
                            "</form>" +
                        this.viewPets() +
                        "</body>" +
                        "</html>"
        );
        writer.flush();
    }

    private String viewPets() {
        StringBuilder sb = new StringBuilder();
        sb.append("<table style='border: 1px solid black'>");
        for(Pet pet : pets) {
            sb.append("<tr><td>").append(pet.getName()).append("</td></tr>");
        }
        sb.append("<//table>");
        return sb.toString();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        pets.add(new Dog(req.getParameter("name")));
        doGet(req, resp);
    }


}
