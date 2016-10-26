package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.DBUtil;

import entity.Employee;

public class EmployeeDAO {
	
	public List<Employee> search(String keyword) throws SQLException{
		List<Employee> employees = new ArrayList<Employee>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rst = null;
		
		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement("SELECT* FROM emp where name LIKE ?");
			ps.setString(1, "%"+keyword+"%");
			rst = ps.executeQuery();
			while(rst.next()){
				Employee e = new Employee();
				e.setId(rst.getInt("id"));
				e.setName(rst.getString("name"));
				e.setSalary(rst.getDouble("salary"));
				e.setAge(rst.getInt("age"));
				employees.add(e);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}finally{
			DBUtil.close(conn);
		}
		return employees;
	}
	public void modify(Employee e) throws Exception{
		Connection conn = null;
		PreparedStatement prep = null;
		try {
			conn = DBUtil.getConnection();
			prep = conn.prepareStatement(
					"UPDATE emp SET name=?," +
					"salary=?,age=? WHERE id=?");
			prep.setString(1, e.getName());
			prep.setDouble(2, e.getSalary());
			prep.setInt(3, e.getAge());
			prep.setInt(4, e.getId());
			prep.executeUpdate();
		} catch (Exception e1) {
			e1.printStackTrace();
			throw e1;
		}finally{
			DBUtil.close(conn);
		}
	}
	public Employee findById(int id) throws Exception{
		Employee e = null;
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet rst = null;
		try {
			conn = DBUtil.getConnection();
			prep = conn.prepareStatement(
					"SELECT * FROM emp WHERE id=?");
			prep.setInt(1, id);
			rst = prep.executeQuery();
			if(rst.next()){
				e = new Employee();
				e.setId(id);
				e.setName(rst.getString("name"));
				e.setSalary(rst.getDouble("salary"));
				e.setAge(rst.getInt("age"));
			}
		} catch (Exception e1) {
			e1.printStackTrace();
			throw e1;
		}finally{
			DBUtil.close(conn);
		}
		return e;
	}
	
	public void delete(int id) throws SQLException{
		Connection conn = null;
		PreparedStatement ps=null;
		try {
			conn=DBUtil.getConnection();
			ps=conn.prepareStatement
					("delete from emp where id=?");
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e1) {
			e1.printStackTrace();
			throw e1;
		}finally{
			DBUtil.close(conn);
		}
	}
	
	public void save(Employee e) throws SQLException{
			Connection conn = null;
			PreparedStatement ps=null;
			try {
				conn=DBUtil.getConnection();
				ps=conn.prepareStatement
						("INSERT INTO emp(name,salary,age) VALUES(?,?,?)");
				ps.setString(1, e.getName());
				ps.setDouble(2, e.getSalary());
				ps.setInt(3,e.getAge());
				ps.executeUpdate();
			} catch (SQLException e1) {
				e1.printStackTrace();
				throw e1;
			}finally{
				DBUtil.close(conn);
			}
	}
	public List<Employee> findAll() throws SQLException{
		List<Employee> employees = new ArrayList<Employee>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rst = null;
		
		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement("SELECT* FROM emp");
			rst = ps.executeQuery();
			while(rst.next()){
				Employee e = new Employee();
				e.setId(rst.getInt("id"));
				e.setName(rst.getString("name"));
				e.setSalary(rst.getDouble("salary"));
				e.setAge(rst.getInt("age"));
				employees.add(e);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}finally{
			DBUtil.close(conn);
		}
		return employees;
	}
}
