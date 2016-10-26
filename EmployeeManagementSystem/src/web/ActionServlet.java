package web;

import java.io.IOException;
import java.io.PrintWriter;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmployeeDAO;
import entity.Employee;

public class ActionServlet extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		request.setAttribute("date",sdf.format(date));
		
		String uri = request.getRequestURI();
		String action= uri.substring(uri.lastIndexOf("/"),uri.lastIndexOf("."));
		EmployeeDAO dao = new EmployeeDAO();
		if("/list".equals(action)){
	
			try {
				List<Employee> employees = dao.findAll();
				request.setAttribute("employees",employees);
				RequestDispatcher rd = request.getRequestDispatcher("listEmp1.jsp");
				rd.forward(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
				throw new ServletException(e);
			}
		}else if("/add".equals(action)){
			String name = request.getParameter("name");
			String salary = request.getParameter("salary");
			String age = request.getParameter("age");
			
			try {
				Employee e = new Employee();
				e.setName(name);
				e.setSalary(Double.parseDouble(salary));
				e.setAge(Integer.parseInt(age));
				dao.save(e);
				response.sendRedirect("list.do");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	}else if("/del".equals(action)){
		 int id = Integer.parseInt(request.getParameter("id"));
		 try {
			dao.delete(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 response.sendRedirect("list.do");
	}else if("/load".equals(action)){
		int id = Integer.parseInt(request.getParameter("id"));
		Employee e;
		try {
			e = dao.findById(id);
			request.setAttribute("e",e);
			request.getRequestDispatcher("updateEmp.jsp").forward(request, response);		
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}else if("/modify".equals(action)){
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		double salary = Double.parseDouble(request.getParameter("salary"));
		int age = Integer.parseInt(request.getParameter("age"));
			Employee e = new Employee();
			e.setId(id);
			e.setName(name);
			e.setSalary(salary);
			e.setAge(age);
			try {			
				dao.modify(e);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			response.sendRedirect("list.do"); 
	}else if("/search".equals(action)){
		try {
			String keyword = request.getParameter("search");
			List<Employee> employees = dao.search(keyword);
			request.setAttribute("employees",employees);
			RequestDispatcher rd = request.getRequestDispatcher("listEmp1.jsp");
			rd.forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
	}
	}
}


