package _16유용한클래스;

import java.time.Clock;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class _01날짜와시간 {
	public static void main(String[] args) {
		
		// 1970년 1월 1일 0시 기준으로 현재까지 경과한 시간 1000분의 1(밀리세컨드)로 반환
		System.out.println(System.currentTimeMillis());
		
		LocalDate today = LocalDate.now();
		System.out.println(today);
		
		LocalTime nowTime = LocalTime.now();
		System.out.println(nowTime);
		
		System.out.println(Clock.systemDefaultZone());
		
		LocalDate tomrrow = today.plusDays(1);
		System.out.println(tomrrow);
		LocalDate tempDate = today.minusDays(90);
		System.out.println(tempDate);
		
		// 두 날짜 사이의 간격
		LocalDate test1 = LocalDate.of(2030, 5, 5);
		Period test2 = Period.between(test1, today);
		System.out.printf("%d년 %d월 %d일\n",test2.getYears(), test2.getMonths(),test2.getDays());
		
		Duration test3 = Duration.between(LocalDateTime.of(2025, 01,22,13,12), LocalDateTime.of(2025, 01,23,13,0));
		System.out.println(test3);
		System.out.println(test3.toDays());
		System.out.println(test3.toHours());
		System.out.println(test3.toMinutes());
		
		// 날짜를 원하는 스트링 값으로 환산
		DateTimeFormatter sdf1 = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 E요일 a hh시 mm분 ss초");
		LocalDateTime tday2 = LocalDateTime.now();
		System.out.println(tday2);
		System.out.println(tday2.format(sdf1));
		DateTimeFormatter sdf2 = DateTimeFormatter.ofPattern("yy년 MMM dd일 E요일 a HH:mm:ss");
		System.out.println(tday2.format(sdf2));
		
		// String -> 날짜객체
		String nowDate = "2025-01-22";
		DateTimeFormatter sdf3 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate time = LocalDate.parse(nowDate,sdf3);
		System.out.println(time);
		
	}
}
