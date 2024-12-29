import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static HashMap<String, Integer> stringMap = new HashMap<>();
	private static HashMap<Integer, String> intMap = new HashMap<>();
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n =  Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		for (int i = 1 ; i <= n ; i ++) {
			String name = br.readLine();

			stringMap.put(name, i);
			intMap.put(i, name);
		}

		for (int i = 0 ; i < m; i++) {

			String question = br.readLine();
			if (isNumber(question)) {
				int number = Integer.parseInt(question);
				sb.append(intMap.get(number)).append("\n");
			} else {

				sb.append(stringMap.get(question)).append("\n");
			}
		}

		System.out.print(sb.toString());
	}

	private static boolean isNumber(String str) {

		char[] arr = str.toCharArray();

		for (int i = 0 ; i < arr.length; i++) {
			if (!Character.isDigit(arr[i])) {
				return false;
			}
		}

		return true;
	}


}
