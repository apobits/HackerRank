/**
 * 
 */
package hacker.rank.jobs.geniussports;

/**
 * @author aposo
 *
 */
public class CompilerBraceletChecker {

	public static String[] braces(String[] values) {

		String[] result = new String[values.length];

		for (int i = 0; i < values.length; i++) {
			result[i] = checkComplement(values[i]);
		}

		return result;

	}

	private static String checkComplement(String data) {

		for (int i = 0; i <= 100; i++) {
			data = data.replace("{}", "");
			data = data.replace("[]", "");
			data = data.replace("()", "");
		}

		if (data.length() > 0) {
			return "NO";
		} else {
			return "YES";
		}

	}

	public static void main(String args[]) {

		String[] values = {
				"{{({{({{({{({{({{({{({{({{({{({{({{({{({{({{({{()}})}})}})}})}})}})}})}})}})}})}})}})}})}})}})}}",
				"{{({{({{({{({{({{({{({{({{({{({{({{({{({{({{({{(})}})}})}})}})}})}})}})}})}})}})}})}})}})}})}}" };

		System.out.println(braces(values));

	}

}
