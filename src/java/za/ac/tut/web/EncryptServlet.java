/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package za.ac.tut.web;

import jakarta.ejb.EJB;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import za.ac.tut.entity.CipherRecord;
import za.ac.tut.entity.bl.CipherRecordFacadeLocal;

/**
 *
 * @author Aya
 */
public class EncryptServlet extends HttpServlet {

 @EJB
    private CipherRecordFacadeLocal cipherFacade;

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String text = request.getParameter("text");
        String keyStr = request.getParameter("key");

        // Validation
        if (text == null || text.trim().isEmpty()) {
            forward(request, response, "Please enter some text to encrypt.");
            return;
        }
        int shift;
        try {
            shift = Integer.parseInt(keyStr);
            if (shift < 1 || shift > 25) throw new NumberFormatException();
        } catch (NumberFormatException e) {
            forward(request, response, "Shift key must be a whole number between 1 and 25.");
            return;
        }
        
        // Encrypt
        String encrypted = cipherFacade.encrypt(text, shift);

        // Save record
        CipherRecord record = new CipherRecord(text, encrypted, "Encrypt", shift);
        cipherFacade.create(record);

        // Send to JSP
        request.setAttribute("original", text);
        request.setAttribute("processed", encrypted);
        request.setAttribute("operation", "Encrypt");
        request.setAttribute("shift", shift);
        request.setAttribute("totalOps", cipherFacade.totalOperations());

        request.getRequestDispatcher("/result.jsp").forward(request, response);
    }

      private void forward(HttpServletRequest req, HttpServletResponse resp, String msg)
            throws ServletException, IOException {
        req.setAttribute("error", msg);
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }

}
