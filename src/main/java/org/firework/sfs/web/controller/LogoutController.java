package org.firework.sfs.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LogoutController {

	@RequestMapping("/logout")
	public String get() {
		return "logout";
	}

}
