package jp.co.mediaseek.freshMan.controller;

import jp.co.mediaseek.freshMan.domains.WeekDay;
import jp.co.mediaseek.freshMan.methods.ToubanCalendar;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Controller
public class ToubanFuriwakeController {

	@GetMapping("/Furiwake")
	public String toubanFuriwake(Model model){
		Date date = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		System.out.println(calendar);
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH) + 1;
		ToubanCalendar tc = new ToubanCalendar(year, month);
		List<Integer> workDayList = tc.getWorkDayList();
		List<WeekDay> weekDayList = new ArrayList<>();
		String[] week = new String[7];
		week[0] = "日";
		week[1] = "月";
		week[2] = "火";
		week[3] = "水";
		week[4] = "木";
		week[5] = "金";
		week[6] = "土";

		for (Integer i : workDayList){
			WeekDay wd = new WeekDay();
			wd.setWorkDay(i);
			wd.setMonth(month);
			calendar.set(Calendar.DAY_OF_MONTH,i);
			wd.setDayOfWeek(week[calendar.get(Calendar.DAY_OF_WEEK) - 1]);
			System.out.println(wd);
			weekDayList.add(wd);
		}

		model.addAttribute("weekDayList", weekDayList);


		return "toubanFuriwakeComp";
	}

}
