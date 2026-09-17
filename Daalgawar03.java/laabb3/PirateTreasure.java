public class PirateTreasure {

    static int maxGold(int[][] grid, int i, int j) {

        int n = grid.length;
        int m = grid[0].length;

        // Хүснэгтээс хэтэрвэл
        if (i < 0 || i >= n || j >= m) {
            return 0;
        }

        // Баруун
        int right = maxGold(grid, i, j + 1);

        // Баруун-дээш
        int rightUp = maxGold(grid, i - 1, j + 1);

        // Баруун-доош
        int rightDown = maxGold(grid, i + 1, j + 1);

        return grid[i][j] + Math.max(right,
                Math.max(rightUp, rightDown));
    }

    public static void main(String[] args) {

        int[][] gold = {
                {1, 3, 1, 5},
                {2, 2, 4, 1},
                {5, 0, 2, 3},
                {0, 6, 1, 2}
        };

        int max = 0;

        // Эхний баганын бүх мөрөөс эхэлж шалгана
        for (int i = 0; i < gold.length; i++) {
            max = Math.max(max, maxGold(gold, i, 0));
        }

        System.out.println("Hamgiin ih alt: " + max);
    }
}
