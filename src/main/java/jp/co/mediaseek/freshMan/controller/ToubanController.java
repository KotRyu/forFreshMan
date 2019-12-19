package jp.co.mediaseek.freshMan.controller;

import jp.co.mediaseek.freshMan.domains.Touban;
import jp.co.mediaseek.freshMan.domains.ToubanConstants;
import jp.co.mediaseek.freshMan.repositories.interfaces.ToubanRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ToubanController {

	private ToubanRepository toubanRepository;

	public ToubanController(ToubanRepository toubanRepository){
		this.toubanRepository = toubanRepository;
	}

	@GetMapping("touban")
	public String showTouban(Model model){

		List<Touban> toubanList = toubanRepository.findByDeleteflg(ToubanConstants.DELETE_FLG_OFF);
		model.addAttribute("toubanList", toubanList);
		return "Touban";
	}
}
