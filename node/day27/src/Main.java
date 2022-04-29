import java.util.*;
// 迷宫问题

// 存放当前位置 (x, y)
class Node {
    int x;
    int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 迷宫矩阵
        int row = scanner.nextInt();
        int col = scanner.nextInt();
        int[][] maze = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                maze[i][j] = scanner.nextInt();
            }
        }
        // 搜索最短路径
        ArrayList<Node> path = new ArrayList<>();
        ArrayList<Node> minPath = new ArrayList<>();
        int[][] book = new int[row][col];
        getMinPath(maze, row, col ,0, 0, book, path, minPath);
        // 打印最短路径
        for (Node node : minPath) {
            System.out.println("(" + node.x + ","  + node.y + ")");
        }
    }

    /**
     * @param maze 迷宫矩阵
     * @param row col 行 列
     * @param x y 当前位置
     * @param book 标记当前矩阵，标记当前位置是否走过
     * @param path 保存当前路径的每一个位置
     * @param  minPath 记录最短路径
     */
    private static void getMinPath(int[][] maze, int row, int col, int x, int y, int[][] book, ArrayList<Node> path, ArrayList<Node> minPath) {
        // 1、判断 (x, y) 是否越界、走过、有障碍
        if (x < 0 || x >= row || y < 0 || y >= col
                || book[x][y] == 1 || maze[x][y] == 1) {
            return;
        }
        // 2、把当前位置 存入路径
        path.add(new Node(x, y));
        // 3、标记当前为位置
        book[x][y] = 1;
        // 4、判断当前位置是否为出口
        if (x == row - 1 && y == col - 1) {
            // 到出口，一条新的路径产生，判断是否要更新最短路径
            if (minPath.isEmpty() || path.size() < minPath.size()) {
                minPath.clear();
                for (Node node : path) {
                    minPath.add(node);
                }
            }
        }
        // 5、继续搜索以 (x, y) 的上下左右四个方向
        getMinPath(maze, row, col, x - 1, y, book, path, minPath);
        getMinPath(maze, row, col, x + 1, y, book, path, minPath);
        getMinPath(maze, row, col, x, y - 1, book, path, minPath);
        getMinPath(maze, row, col, x, y + 1, book, path, minPath);
        // 6、回退到当前位置，把当前位置，从路径中删除，寻找新的路径
        path.remove(path.size() - 1);
        book[x][y] = 0;
    }
}