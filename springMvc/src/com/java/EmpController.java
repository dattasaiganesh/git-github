package com.java;

import java.sql.Date;
import java.util.List;

import org.junit.runner.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.Dao.EmpDao;

@Controller
public class EmpController {
    @Autowired
	EmpDao dao;//will inject dao from xml file
    
    /*It displays a form to input data, here "command" is a reserved request attribute
     *which is used to display object data into form
     */
	@RequestMapping("/empform")
	public ModelAndView showform(){
		System.out.println("in showform");
		return new ModelAndView("empform","command",new Emp());
	}
	/*It saves object into database. The @ModelAttribute puts request data
	 *  into model object. You need to mention RequestMethod.POST method 
	 *  because default request is GET*/
	@RequestMapping(value="/save",method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("emp") Emp emp){
		dao.save(emp);
		return new ModelAndView("redirect:/viewemp");//will redirect to viewemp request mapping
	}
	/* It provides list of employees in model object */
	@RequestMapping("/viewemp")
	public ModelAndView viewemp(){
		//float sal = dao.getEmployees();
		List<Emp> list = dao.getDate();
		//System.out.println("sal is" +sal);
		System.out.println("date is" +list.get(0));
		return new ModelAndView("viewemp","list",list);
	}
	
	@RequestMapping(value="/editemp/{name}")
	public ModelAndView edit(@PathVariable String name){
		Emp emp = dao.getEmpbyName(name);
		return new ModelAndView("empeditform","command",emp);
	}
	
	@RequestMapping(value="/editsave")
	public ModelAndView update(@ModelAttribute("emp") Emp emp){
		System.out.println("in emp controller2");
		dao.update(emp);
		return new ModelAndView("redirect:/viewemp");
	}
	
	@RequestMapping(value="/deleteemp/{name}", method=RequestMethod.GET)
	public ModelAndView delete(@PathVariable String name){
		dao.delete(name);
		return new ModelAndView("redirect:/viewemp");
	}
	
	
	@RequestMapping(value="/viewemp2/{pageid}")
	public ModelAndView paging(@PathVariable int pageid){
		int total=3;
		if (pageid==1){}
		else
		{
			pageid = (pageid-1)*total+1;
		}
		System.out.println("page id is" +pageid);
		List<Emp> list = dao.getlist(pageid,total);
	for(int i = 0;i<list.size();i++){
		System.out.println("list is :"+list.get(i));
	}
		return new ModelAndView("viewemp2","list",list);
	}
}