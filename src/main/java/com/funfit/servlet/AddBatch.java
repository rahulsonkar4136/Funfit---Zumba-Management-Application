package com.funfit.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.funfit.models.Batch;
import com.funfit.operations.BatchOperations;

@WebServlet("/AddBatch")
public class AddBatch extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String name = req.getParameter("name");
		String time = req.getParameter("time");
		
		Batch batch=new Batch();
		batch.setName(name);
		batch.setTime(time);
		try {
			BatchOperations batchOperations=new BatchOperations();
			batchOperations.addNewBatch(batch);
			RequestDispatcher dispatcher = req.getRequestDispatcher("batch.html"); 
			dispatcher.forward(req, res);
		}catch(Exception e)
		{
			
		}
		
	
	}
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		res.getWriter().append("Served at: ").append(req.getContextPath());
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		doGet(req, res);
	}

	
	
	

}
