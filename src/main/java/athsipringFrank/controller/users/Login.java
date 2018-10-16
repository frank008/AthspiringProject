package athsipringFrank.controller.users;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Login {
	
	@RequestMapping("/login")
	@ResponseBody
	public Object  login() {
		return "欢迎访问本网站 谢谢！";
		
	}

}
