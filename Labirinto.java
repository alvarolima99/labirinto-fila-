import java.util.*;

public class Labirinto {
    private static final int N = 5;
    private static final int M = 5;
    private static int d;

    int n = N, m = M;

    private static boolean[][] visited = new boolean[N][M];

    public static void main(String[] args)
    {

        setVisited(true);

        int labirinto[][] = {{ 1, 0, 1, 1, 0 },
                             { 1, 1, 1, 0, 1 },
                             { 0, 1, 0, 1, 1 },
                             { 1, 1, 1, 1, 1 },
                             { 0, 0, 0, 0, 0 }};

        if (isReachable(labirinto))
        {
            printSolution(labirinto);
            System.out.println("Caminho encontrado!\n");
        }
        else
            System.out.println("Caminho não encontrado!\n");
    }

    private static void printSolution(int labirinto[][])
    {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                System.out.print(" " + labirinto[i][j] + " ");
            System.out.println();
        }
    }

    private static void setVisited(boolean b)
    {
        for (int i = 0; i < visited.length; i++)
        {
            for (int j = 0; j < visited[i].length; j++)
            {
                visited[i][j] = b;
            }
        }
    }

    private static boolean isReachable(int labirinto[][]) {
        int i = 0, j = 0;

        int fx, fy;
        fx = 1;
        fy = 4;

        Queue<No> q = new Queue<No>();

        No temp = new No(i, j);

        q.enqueue(temp);

        while (!q.empty()) {

            temp = q.peek();
            i = temp.getX();
            j = temp.getY();
            temp.setDir(temp.getDir() + 1);
            q.enqueue(temp);

            if (i == fx && j == fy) {
                return true;
            }

            System.out.printf("\n");
            labirinto[i][j] = 2;
            System.out.println("Legenda:");
            System.out.println("0 = casas ocupadas");
            System.out.println("1 = casas livres");
            System.out.println("2 = Jogador");
            System.out.println();
            System.out.println("Opção:");
            System.out.println("0) cima");
            System.out.println("1) direita");
            System.out.println("2) baixo");
            System.out.println("3) esquerda");
            printSolution(labirinto);
            System.out.print("Cordenadas atuais (Y/X):");
            System.out.print(i);
            System.out.println(j);
            System.out.print("Cordenadas do objetivo (Y/X):");
            System.out.print(fx);
            System.out.println(fy);
            Scanner userop = new Scanner(System.in);
            int d = userop.nextInt();

            if (d == 0) {
                if (i - 1 >= 0 && labirinto[i - 1][j] == 1 && visited[i - 1][j]) {
                    No temp1 = new No(i - 1, j);
                    visited[i - 1][j] = false;
                    q.enqueue(temp1);
                }

            } else if (d == 1) {
                if (j - 1 >= 0 && labirinto[i][j - 1] == 1 && visited[i][j - 1]) {
                    No temp1 = new No(i, j - 1);
                    visited[i][j - 1] = false;
                    q.enqueue(temp1);
                }

            } else if (d == 2) {
                if (i + 1 < N && labirinto[i + 1][j] == 1 && visited[i + 1][j]) {
                    No temp1 = new No(i + 1, j);
                    visited[i + 1][j] = false;
                    q.enqueue(temp1);
                }

            } else if (d == 3) {
                if (j + 1 < M && labirinto[i][j + 1] == 1 && visited[i][j + 1]) {
                    No temp1 = new No(i, j + 1);
                    visited[i][j + 1] = false;
                    q.enqueue(temp1);
                }
            } else {
                visited[temp.getX()][temp.getY()] = true;
                q.dequeue();
            }
        }
        return false;
    }
}
