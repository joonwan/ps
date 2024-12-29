import java.io.*;
import java.util.PriorityQueue;

public class Main {

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static PriorityQueue<Integer> pq = new PriorityQueue<>(
		(n1, n2) -> {

			if (Math.abs(n1) == Math.abs(n2)) {
				return n1 - n2;
			}

			return Math.abs(n1) - Math.abs(n2);
		}
	);

	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int i = 0 ; i < n; i++) {

			int number = Integer.parseInt(br.readLine());

			if (number != 0) {
				pq.offer(number);
			} else {
				if (pq.isEmpty()) {
					sb.append(0);
				} else {
					sb.append(pq.poll());
				}

				sb.append("\n");
			}
		}

		System.out.print(sb.toString());
	}


}
