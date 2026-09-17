public class Hanoi {

    // рекурс функц
    public static void hanoi(int n, char from, char to, char aux) {
        if (n == 1) {
            System.out.println("1 diskiig " + from + " -> " + to + " zuu");
            return;
        }

        // 1-р алхам
        hanoi(n - 1, from, aux, to);

        // 2-р алхам
        System.out.println(n + " diskiig " + from + " -> " + to + " zuu");

        // 3-р алхам
        hanoi(n - 1, aux, to, from);
    }

    public static void main(String[] args) {
        int n = 3; // дискний тоо
        hanoi(n, 'A', 'C', 'B');
    } 
    
}
