package jp.co.mediaseek.freshMan.controller;

import jp.co.mediaseek.freshMan.domains.ErrorMsgConstants;
import jp.co.mediaseek.freshMan.domains.Touban;
import jp.co.mediaseek.freshMan.repositories.interfaces.ToubanRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ToubanRegisterController {
	private ToubanRepository toubanRepository;

	public ToubanRegisterController(ToubanRepository toubanRepository){
		this.toubanRepository = toubanRepository;
	}

	@GetMapping("Register")
	public String showRegisterPage(){

		return "toubanRegister";
	}

	@PostMapping("NewRegister")
	public String newRegister(Model model, @ModelAttribute Touban touban){

		System.out.println(touban);

		if(touban.getPersonName()
				.replaceFirst("^[\\s　]+", "")
				.replaceFirst("[\\s　]+$", "")
				.length() == 0){
			model.addAttribute("errMsg", ErrorMsgConstants.PERSON_MAME_BLANK);
			return "toubanRegister";

		} else {
			toubanRepository.saveAndFlush(touban);
			return "toubanRegisterComp";

		}



	}
}
