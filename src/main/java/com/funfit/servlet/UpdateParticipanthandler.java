package com.funfit.servlet;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.funfit.operations.ParticipantOperations;

@WebServlet("/update-participant-handler")
public class UpdateParticipanthandler extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int updatedId = Integer.parseInt(request.getParameter("updateId"));
        String updatedName = request.getParameter("updateName");
        String updatedGender = request.getParameter("updateGender");
        int updatedBatchId = Integer.parseInt(request.getParameter("updateBatchId"));

        
        ParticipantOperations participantOperations = null;
		try {
			participantOperations = new ParticipantOperations();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        try {
        	
           
            String result = participantOperations.updateParticipant(updatedId, updatedName, updatedGender, updatedBatchId);

            
            if ("Success".equals(result)) {
                
                response.sendRedirect(request.getContextPath() + "/update-participant");
            } else {
                
                response.sendRedirect("error.html");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            // Redirect to an error page or handle accordingly
            response.sendRedirect("error.html");
        }
    }
}


