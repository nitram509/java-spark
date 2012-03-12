public class Spark {

    public static void main(String[] args) {
        System.out.println(spark(args));
    }

    public static String spark(String... input) {
        double[] numbers = new double[input.length];

        for (int i = 0; i < input.length; i++) {
            try {
                numbers[i] = Double.parseDouble(input[i]);
            } catch (NumberFormatException e) {
                numbers[i] = input[i].charAt(0);
            }
        }

        return spark(numbers);
    }

    public static String spark(double[] input) {
        double min = Double.POSITIVE_INFINITY;
        double max = Double.NEGATIVE_INFINITY;

        for (double d : input) {
            if (d < min) {
                min = d;
            }
            if (d > max) {
                max = d;
            }
        }
        double intervalSize = max - min;

        StringBuilder sb = new StringBuilder(input.length);
        String sparks = "\u2581\u2582\u2583\u2584\u2585\u2586\u2587\u2588";
        for (double d : input) {
            int sparkIndex = (int) ((d - min) / intervalSize * (sparks.length() - 1));
            sb.append(sparks.charAt(sparkIndex));
        }

        return sb.toString();
    }
}
