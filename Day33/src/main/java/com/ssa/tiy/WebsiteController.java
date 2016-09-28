package com.ssa.tiy;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@ComponentScan(basePackages=" com.ssa")
public class WebsiteController {
	@RequestMapping("/")
    public ModelAndView home(HttpServletRequest request, ModelAndView mv) {
		
        if(request.getParameter("name") != null){
            mv.addObject("name", request.getParameter("name"));
      }
        mv.setViewName("home");
        return mv;
    }
	@RequestMapping("/about")
	public ModelAndView about(HttpServletRequest request, ModelAndView mv) {
		mv.setViewName("about");
		return mv;
	}
	@RequestMapping("/help")
	  public ModelAndView help(HttpServletRequest request, ModelAndView mv) {
	       HashMap<String, String> helpMessages = new HashMap<String, String>();
	       helpMessages.put("1", "WHAAAAAAAA!");
	       helpMessages.put("2", "TOODALOOP");
	       helpMessages.put("3", "Hakuna Matata");
	       helpMessages.put("4", "Knowing is half the battle");
	       helpMessages.put("5", "YOU HAD ONE JOB!");
	       String str = request.getParameter("id");
	       mv.addObject("desc", helpMessages.get(str));
	       
	      mv.setViewName("help");
	      return mv;
	}
	
	

}
