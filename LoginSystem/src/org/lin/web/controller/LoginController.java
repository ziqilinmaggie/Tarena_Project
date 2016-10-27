package org.lin.web.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.lin.dao.EmpDao;
import org.lin.entity.Emp;
import org.lin.entity.Page;
import org.lin.service.UserService;
import org.lin.util.Constant;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	@Resource
	private EmpDao empDao;
	@Resource
	private UserService userService;
	//@Resource
//	private EmpDao empDao;
	@RequestMapping("/tologin.do")
	public String tologin(){
		return "login";
	}
	@RequestMapping("/login.do")
	public ModelAndView login(HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		String name = request.getParameter("username");
		String password=request.getParameter("password");
		int status = userService.checkLogin(name, password);
		if(status==Constant.LOGIN_OK){
			mav.setViewName("ok");
			request.getSession().setAttribute("user", name);
			mav.getModel().put("user",name);
//			return "ok";
		}else if(status==Constant.LOGIN_NAME_ERROR){
			mav.setViewName("login");
			mav.getModel().put("name_error", "name_error");
//			return "login";//失败进入 login.jsp
		}else if(status==Constant.LOGIN_PWD_ERROR){
			mav.setViewName("login");
			mav.getModel().put("pwd_error", "pwd_error");
		}
		return mav;
	}
	@RequestMapping("/emp_list.do")
	public String emplist(Page page,Model model){
		
//		EmpDao dao = session.getMapper(EmpDao.class);
//		page.setPage(1);
//		page.setPageSize(3);
		List<Emp> list = empDao.findPage(page);
		int totalPage = empDao.countTotal();
		int pageTotal = 0;
		if(totalPage%page.getPageSize()==0){
			pageTotal=totalPage/page.getPageSize();
		}else{
			pageTotal=totalPage/page.getPageSize()+1;
		}
//		List<Emp> list = dao.findAll();
//		List<Emp> list = dao.findPage(page);
//		List<Emp> list = session.selectList("findAll");
		model.addAttribute("emplist",list);
		model.addAttribute("currentPage", page.getPage());
		model.addAttribute("totalPage", pageTotal);
		return "emp_list";
	}
}
