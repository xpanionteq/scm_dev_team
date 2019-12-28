package com.xpanion.scm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/*
 * @author : Ashlin Abraham
 * @date : 25.03.2019
 * @purpose : display login.jsp
 */
@Controller
public class IndexController {
	@RequestMapping("/")
	String index() {
		return "login";
	}
}
