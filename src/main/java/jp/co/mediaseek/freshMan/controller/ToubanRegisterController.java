package jp.co.mediaseek.freshMan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ToubanRegisterController {

	@GetMapping("Register")
	public String showRegisterPage(){

		return "toubanRegister";
	}
}
