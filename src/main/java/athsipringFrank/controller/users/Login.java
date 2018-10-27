package athsipringFrank.controller.users;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.tomcat.util.digester.ObjectCreateRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import athsipringFrank.dao.User;
import athsipringFrank.services.users.UserServie;

@Controller
public class Login {

	@Autowired
	UserServie userServie;

	@RequestMapping("/index")
	public Object index() {
		return "index";

	}

	/**
	 * 用户注册
	 * 
	 * @param request
	 * @return
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	@RequestMapping("/register")
	public Object register(HttpServletRequest request) throws IllegalAccessException, InvocationTargetException {

		User user = new User();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String company = request.getParameter("company");
System.out.println("用户名："+username);
		user.setName(username);
		user.setPassword(password);
		user.setEmail(email);
		user.setPhone(phone);
		user.setCompany(company);
		int result=0;
		if (username!=null&&password!=null&&email!=null) {
			
			if (username!=""&&password!=""&&email!="") {
				// 添加对象
				result= userServie.add(user);
			}
		
		}
		
		if (result > 0) {
			System.out.println(user.toString());
			return "redirect:index.html";
		} else {
			//使用重定向 不携带数据
			return "redirect:register.html";
		}

	}

	@RequestMapping("/login")
	
	public Object  login(HttpServletRequest request) {

		String u = request.getParameter("user");
		String p = request.getParameter("pa");
		System.out.println("用户数据"+u + " : " + p);
		if (u!=null&&p!=null) {
			User user = userServie.queryUser(u, p);
			if (user != null) {
				System.out.println(user.toString());
				request.getSession().setAttribute("user", user);
				return "redirect:index.html";
		}else {
			return "redirect:login.html";
		}
		}else {
			return "redirect:login.html";
		}
}
}
