package com.inchel.Sep08.BMIModel2;

import com.inchel.Sep08.BMIModel2.Doctor;
import com.inchel.Sep08.BMIModel2.Guest;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/HomeController")
public class HomeController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	request.getRequestDispatcher("InfoInput.html").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	Doctor.CalculateBMI(request);
	request.getRequestDispatcher("BMIOutput.jsp").forward(request, response);
		
	}

}
