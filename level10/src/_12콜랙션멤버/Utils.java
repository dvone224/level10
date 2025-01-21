package _12콜랙션멤버;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Utils {
	private Utils() {
	};

	private static Utils instance;

	public static Utils getInstance() {
		if (instance == null)
			instance = new Utils();
		return instance;
	}

	private Scanner sc = new Scanner(System.in);
	private final String CUR_PATH = System.getProperty("user.dir") + "//src//" + Utils.class.getPackageName() + "//";

	public String getCurPath() {
		return CUR_PATH;
	}

	public int getIntValue(String msg, int start, int end) {
		System.out.print(msg);
		int sel = -1;
		try {
			sel = sc.nextInt();
			if (sel < start || sel > end) {
				System.out.println("범위 오류");
				return -1;
			}
		} catch (Exception e) {
			System.out.println("숫자를 입력해 주세요");
		}
		return sel;
	}

	public String getStrValue(String msg) {
		System.out.print(msg);
		return sc.next();
	}

	public void closeScanner() {
		sc.close();
	}

	public String loadFile(String fileName) {
		String data = "";
		try (FileReader fr = new FileReader(CUR_PATH + fileName); BufferedReader br = new BufferedReader(fr)) {
			while (true) {
				String line = br.readLine();
				if (line == null)
					break;

				data += line + "\n";
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		if (data.isBlank())
			data = null;
		return data;
	}
	
	public void saveFile(String data, String fileName) {
		try (FileWriter fw = new FileWriter(CUR_PATH + fileName);){
			fw.write(data);
			System.out.println("파일 저장 완료");
		} catch (IOException e) {
			System.out.println("파일 저장 실패");
		}
	}
}
