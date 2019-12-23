package jp.co.mediaseek.freshMan.domains;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class WeekDay {
	private String dayOfWeek;
	private int month;
	private int workDay;
	private String denwaTouban1;
	private String denwaTouban2;
	private String coffeeTouban;
	private String seihyokiTouban;

}
