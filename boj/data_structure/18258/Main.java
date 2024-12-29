import java.io.*;
import java.util.StringTokenizer;
import java.util.ArrayDeque;

public class Main{
	
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {

		int n = Integer.parseInt(br.readLine());
		Q q = new Q();


		for (int i = 0 ; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			String command = st.nextToken();

			if (command.equals("push")) {
				int number = Integer.parseInt(st.nextToken());
				q.push(number);
			} else {
				sb.append(q.handleCommand(command)).append("\n");
			}
		}

		System.out.print(sb.toString());
	}

	static class Q {

		private ArrayDeque<Integer> q = new ArrayDeque<>();
		int size;

		public void push(int n) {
			size++;
			q.offer(n);
		}

		public int handleCommand(String command) {

			if (command.equals("pop")) {
				if (size == 0) {
					return -1;
				}
				size--;
				return q.poll();
			}

			if (command.equals("size")) {
				return size;
			}

			if (command.equals("empty")) {
			
				if (size == 0) {
					return 1;
				}

				return 0;
			}

			if (command.equals("front")) {

				if (size == 0) {
					return -1;
				}
				return q.peekFirst();
			}


			if (size == 0) {
				return -1;
			}
			
			return q.peekLast();
		}
	}
}
