package view;

import org.apache.commons.lang.StringUtils;

public class Utils {
	public static boolean isEmpty(String str, String field) {
		if (StringUtils.isEmpty(str)) { // 아무것도 없는지를 물어보는 메소드
			System.out.println(field + "에 값을 입력해 주세요!!");
			return false;
		}
		return true;
	}

	public static boolean isNumeric(String str, String field) {
		if (StringUtils.isNumeric(str)) {
			return true;
		}

		System.out.println(field + "는 숫자만 입력해 주세요");
		return false;
	}

	public static boolean isLength(String name, String field, int length) {

		if (name == null) {
			System.out.println("이름이 없습니다.");
			return false;
		} else if (length < name.length()) {
			System.out.println(field + "는" + length + "문자 이하로 입력해 주세요");
			return false;
		}

		return true;
	}
}