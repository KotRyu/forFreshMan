package jp.co.mediaseek.freshMan.controller;

import jp.co.mediaseek.freshMan.domains.Touban;
import jp.co.mediaseek.freshMan.domains.ToubanConstants;
import jp.co.mediaseek.freshMan.repositories.interfaces.ToubanRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ToubanDeleteController {
	private ToubanRepository toubanRepository;

	public ToubanDeleteController(ToubanRepository toubanRepository){
		this.toubanRepository = toubanRepository;
	}

	@PostMapping("/Delete")
	public String deleteTouban(@RequestParam int id){
		Touban touban = toubanRepository.getOne(id);
		touban.setDeleteflg(ToubanConstants.DELETE_FLG_ON);
		toubanRepository.saveAndFlush(touban);
		return "redirect:deletePaging";
	}

	@GetMapping("deletePaging")
	public String paging(){
		return "toubanDeleteComp";
	}
}
