import java.io.*;
import java.util.PriorityQueue;

public class Main {

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static PriorityQueue<Long> pq = new PriorityQueue<>((l1, l2) -> -1 * l1.compareTo(l2));
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] agrs) throws IOException {

		int n = Integer.parseInt(br.readLine());

		for (int i = 0; i < n; i++) {
			long num = Long.parseLong(br.readLine());

			if (num > 0) {
				pq.offer(num);
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
