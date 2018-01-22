package com.Dao;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.jruby.compiler.ir.operands.Array;
import org.springframework.context.MessageSource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.java.Emp;

public class EmpDao {
   // private MessageSource messageSource;
/*public MessageSource getMessageSource() {
		return messageSource;
	}
	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}
*/
	JdbcTemplate template;

public void setTemplate(JdbcTemplate template) {
	this.template = template;
}
public int save(Emp p){
	String sql="insert into emp99 values('"+p.getName()+"',"+p.getSalary()+",'"+p.getDesignation()+"')";
	System.out.println(sql);
	return template.update(sql);
}
/*public long getEmployees() {
	// TODO Auto-generated method stub
	System.out.println("inside getEmployees");
	String sql="select MAX(\"SALARY\") from emp99";
	System.out.println("SQL IS" +sql);
	return template.queryForLong(sql);
	return template.query(sql, new RowMapper<Emp>(){
		
		public Emp mapRow(ResultSet rs, int row) throws SQLException{
			Emp e = new Emp();
			    e.setName(rs.getString("NAME"));
				//e.setSalary(rs.getFloat("SALARY"));
				
				//e.setDesignation(rs.getString("DESIGNATION"));
				 
				 return e;
				 
			}
		
		}
	);
	
}
*/public Emp getEmpbyName(String name) {
	// TODO Auto-generated method stub
    String sql = "select * from emp99 where \"NAME\"=?";
	Emp sql2= template.queryForObject(sql, new Object[]{name}, new BeanPropertyRowMapper<Emp>(Emp.class));
	return sql2;
	
	
}

public int update(Emp emp) {
	// TODO Auto-generated method stub
	System.out.println("in update dao method");
	String sql = "update emp99 set \"SALARY\" ="+emp.getSalary()+",\"DESIGNATION\"='"+emp.getDesignation()+"' where \"NAME\" ='"+emp.getName()+"'";
	System.out.println("sql is:"+sql);
	return template.update(sql);
	
}
public int delete(String name) {
	// TODO Auto-generated method stub
	System.out.println("IN DELETE METHOD");
	String sql="DELETE FROM emp99 where \"NAME\"='"+name+"'";
			
	System.out.println("query is" +sql);
	return template.update(sql);
}
public List<Emp> getlist(int pageid, int total) {
	// TODO Auto-generated method stub\
	String sql = "Select * from emp99 limit "+total+" offset  "+pageid+"";
	System.out.println("sql is"+sql);
	return template.query(sql, new RowMapper<Emp>(){
		
		public Emp mapRow(ResultSet rs, int row) throws SQLException{
			Emp e = new Emp();
			    e.setName(rs.getString("NAME"));
				e.setSalary(rs.getFloat("SALARY"));
				e.setDesignation(rs.getString("DESIGNATION"));
				 
				 return e;
			}
		
		});
}
public List<Emp> getDate() {
	// TODO Auto-generated method stub
	System.out.println("inside getDate");
	String sql="select MAX(\"ISSUEDDATE\") from \"EMP9\"";
	System.out.println("SQL IS" +sql);
	List<Emp> list = new ArrayList<Emp>();
	List<Emp> list1 = new ArrayList<Emp>();
	List<Emp> list2 = new ArrayList<Emp>();
	list = template.query(sql, new RowMapper<Emp>(){
		
		public Emp mapRow(ResultSet rs, int row) throws SQLException{
			Emp e = new Emp();
			System.out.println("date is" +rs.getDate(1));
			    e.setDate(rs.getDate(1));
				 
				 return e;
			}
		
		});	
	String sql2="select MAX(\"SALARY\") from emp99";
	System.out.println("SQL IS" +sql2);
    list1 = template.query(sql2, new RowMapper<Emp>(){
		
		public Emp mapRow(ResultSet rs, int row) throws SQLException{
			Emp e = new Emp();
			   // e.setDate(rs.getDate(1));
			System.out.println("in get salary method");
			    e.setSalary(rs.getFloat(1));
			    System.out.println("SALARY IS"+e.getSalary() );
				 
				 return e;
			}
		
		});
    
    String sql3="select MAX(\"DELIVEREDDATE\") from \"EMP77\"";
	System.out.println("SQL IS" +sql3);
	list2 = template.query(sql, new RowMapper<Emp>(){
		
		public Emp mapRow(ResultSet rs, int row) throws SQLException{
			Emp e = new Emp();
			System.out.println("DELIVEREDdate is" +rs.getDate(1));
			    e.setDelivereddate(rs.getDate(1));
				 
				 return e;
			}
		
		});	
	
	list1.addAll(list);
	list2.addAll(list);
	return list2;
	
}
}
