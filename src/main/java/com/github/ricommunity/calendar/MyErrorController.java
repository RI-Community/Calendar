package com.github.ricommunity.calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyErrorController implements ErrorController {

	@RequestMapping("/error")
	public String handleError(HttpServletRequest request, Model model) {
		Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
		if (status != null) {
			Integer statusCode = Integer.valueOf(status.toString());
			String title = "Error " + statusCode;
			if (HttpStatus.resolve(statusCode) != null) {
				title += " " + HttpStatus.resolve(statusCode).getReasonPhrase();
			}

			model.addAttribute("error_title", title);
			model.addAttribute("error_subtitle", "The Computer said 'No'");
			model.addAttribute("error_reason",
					"Unfortunately, the Computer is not in the right mood. You can try it later again.");
			model.addAttribute("error_backlink", "/");
		}
		return "error";
	}

	@Override
	public String getErrorPath() {
		return "/error";
	}
}
