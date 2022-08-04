package SDATasks.Zad22;

public class PrinterDemo {
    public static void main(String[] args) {


        Printer shout = (text) -> System.out.println(text.toUpperCase() + "!");
        Printer shorter = (text) -> {
            String result = "";
            String[] words = text.split("\s");
            for (int i = 0; i < words.length; i++) {
                result += words[i].charAt(0);
            }

            System.out.println(result);

        };

        shout.print("hello world");
        shorter.print("lets joint all first letters");

    }

}
