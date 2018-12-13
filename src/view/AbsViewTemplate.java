package view;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;

public abstract class AbsViewTemplate extends AbsView {

	@Override
	public void show() {
		showMenu(); // 메뉴 보여줌
		String input = getKeyInputString("번호 "); // 번호 입력받음

		if (isValidNumber(input)) {
			execute(Integer.parseInt(input)); // 번호에 해당하는거 실행함
		}
	}

	protected boolean isValidNumber(String input) {
		if (StringUtils.isBlank(input)) {
			return false;
		}

		if (!StringUtils.isNumeric(input)) {
			return false;
		}

		int number = NumberUtils.toInt(input);

		if (getMinMenuNumber() <= number && getMaxMenuNumber() >= number) {
			return true;
		}

		return false;
	}

	abstract public void showMenu();

	abstract public int getMinMenuNumber();

	abstract public int getMaxMenuNumber();

	abstract public void execute(int number);
}