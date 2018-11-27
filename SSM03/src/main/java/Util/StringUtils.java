package Util;

public class StringUtils {

	public static boolean isEmpty(String str) {
		if(str == "" || str == null || str.equals("")) {
			return true;
		}else {
			return false;
		}
	}
}
