package com.codingdojo.DisplayDate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Date;
import java.text.SimpleDateFormat;

@Controller
public class HomeController {
	@RequestMapping("/")
    public String index() {
        return "index.jsp";
    }
	
	@RequestMapping("/date")
	public String date(Model model) {
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("EEE d MMMM yyyy");
		model.addAttribute("date", formatter.format(date));
		return "date.jsp";
	}
	
	@RequestMapping("/time")
	public String time(Model model) {
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss" );
		model.addAttribute("date", formatter.format(date));
		return "time.jsp";
	}

}
