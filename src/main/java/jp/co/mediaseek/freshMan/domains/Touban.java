package jp.co.mediaseek.freshMan.domains;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Data
@Component
@Entity
@Table(name = "touban")
public class Touban {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int id;
	@Column
	private String personName;
	@Column
	private int denwaCount = ToubanConstants.KAISU_ZERO;
	@Column
	private int coffeeCount = ToubanConstants.KAISU_ZERO;
	@Column
	private int seihyokiCount = ToubanConstants.KAISU_ZERO;
	@Column
	private int checkMonday = ToubanConstants.CHECK_ZERO;
	@Column
	private int checkTuesday = ToubanConstants.CHECK_ZERO;
	@Column
	private int checkWednesday = ToubanConstants.CHECK_ZERO;
	@Column
	private int checkThursday = ToubanConstants.CHECK_ZERO;
	@Column
	private int checkFriday = ToubanConstants.CHECK_ZERO;
	@Column
	private int junban;
	@Column
	private String deleteflg = ToubanConstants.DELETE_FLG_OFF;
}
