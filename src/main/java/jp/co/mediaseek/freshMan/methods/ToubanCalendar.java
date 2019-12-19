package jp.co.mediaseek.freshMan.methods;

import jp.co.mediaseek.freshMan.domains.Touban;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ToubanCalendar {

	private Calendar calendar = null;

	private int lastDayOfMonth = 0;

	public ToubanCalendar(int year, int month){
		this.calendar = Calendar.getInstance();
		this.calendar.clear();
		this.calendar.set(year,month - 1,1);
		this.lastDayOfMonth = calendar.getActualMaximum(Calendar.DATE);
	}

	public List<Integer> getWorkDayList(){
		List<Integer> workDayList = new ArrayList<>();

		int dayOfWeek = 0;

		for(int day = 1;day <= this.lastDayOfMonth; day++){
			//月を指定したカレンダーに日にちを入れている
			this.calendar.set(Calendar.DAY_OF_MONTH,day);
			//月と日にちを入れたカレンダーから曜日を取得する
			dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
			//曜日が土日ではなかったら、日にちをリストに格納
			if(dayOfWeek != Calendar.SUNDAY && dayOfWeek != Calendar.SATURDAY){
				workDayList.add(day);
			}
		}

		return workDayList;
	}
}
