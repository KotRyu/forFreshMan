package jp.co.mediaseek.freshMan.controller;

import jp.co.mediaseek.freshMan.domains.ErrorMsgConstants;
import jp.co.mediaseek.freshMan.domains.Touban;
import jp.co.mediaseek.freshMan.repositories.interfaces.ToubanRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ToubanEditController {
	private ToubanRepository toubanRepository;

	public ToubanEditController(ToubanRepository toubanRepository){
		this.toubanRepository = toubanRepository;
	}

	@PostMapping("/Edit")
	public String editPaging(Model model, @RequestParam int id){
		Touban toubanToEdit = toubanRepository.getOne(id);
		model.addAttribute("toubanToEdit", toubanToEdit);
		return "toubanEdit";
	}

	@PostMapping("/EditTouban")
	public String edit(Model model, @ModelAttribute Touban touban){
		if(touban.getPersonName()
				.replaceFirst("^[\\s　]+", "")
				.replaceFirst("[\\s　]+$", "")
				.length() == 0){
			model.addAttribute("errMsg", ErrorMsgConstants.PERSON_MAME_BLANK);
			Touban toubanToEdit = toubanRepository.getOne(touban.getId());
			model.addAttribute("toubanToEdit", toubanToEdit);
			return "toubanEdit";

		} else {
			toubanRepository.saveAndFlush(touban);
			return "redirect:editPaging";

		}

	}

	@GetMapping("editPaging")
	public String editComp(){
		return "toubanEditComp";
	}
}
