import java.io.*;
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int cookingTime = Integer.parseInt(bf.readLine());

        MicrowaveOven microwaveOven = new MicrowaveOven(cookingTime);

        if (!microwaveOven.possibleToCalculate()) {
            System.out.println(-1);
            return;
        }

        List<String> pressCounts = microwaveOven.getCalculatedPressCount();

        System.out.println(String.join(" ", pressCounts));
    }

    static class MicrowaveOven {

        private int cookingTime; // unit : sec
        private List<Integer> buttonTimes = List.of(300, 60, 10);
        private List<String> pressCounts = new ArrayList<>();

        public MicrowaveOven(int cookingTime) {
            this.cookingTime = cookingTime;
        }

        public boolean possibleToCalculate() {
            int tmpTime = cookingTime;

            for (Integer time : buttonTimes) {
                tmpTime = tmpTime % time;
            }

            return tmpTime == 0;
        }

        public List<String> getCalculatedPressCount() {
            for (Integer time : buttonTimes) {
                pressCounts.add(String.valueOf(cookingTime / time));
                cookingTime = cookingTime % time;
            }
            return pressCounts;
        }

    }
}