//Estrutura de Dados
//Diogo e Alvaro


import java.util.Scanner;

public class Labirinto {

    static String[][] labyrinth = {{}};
    static int numberCommands = 0;
    static int x = 0;
    static int y = 0;

    public static void main(String[] args) {
        labyrinth = sample3.clone();

        Queue<Integer> q = new Queue<>();

        while(true){
            System.out.println("Programe seus passos para chegar em S");

            PrintLabirinty(labyrinth);

            System.out.println("Comandos Realizados: " + numberCommands);
            System.out.println();
            System.out.println("Escolha uma das opcçõs:");
            System.out.println("1 - Direita");
            System.out.println("2 - Esquerda");
            System.out.println("3 - Cima");
            System.out.println("4 - Baixo");
            System.out.println("5 - Começar");
            System.out.println("6 - reiniciar");
            System.out.println("7 - rever comandos passados");

            Scanner userop = new Scanner(System.in);
            int d = userop.nextInt();

            if(d >  0 && d < 5){
                //stack;
                q.insert(d);
                numberCommands++;
            }
            else if(d == 5){
                startCrawling(q);

                q.clearQueue();
                numberCommands = 0;
                ClearLabyrinth(labyrinth);
            }
            else if(d == 6){
                q.clearQueue();
                numberCommands = 0;
                ClearLabyrinth(labyrinth);
            }
            else if(d == 7){
                q.printQueue();
            }
            else{
                System.out.println("Comando Invalido");
            }
        }
    }

    static boolean startCrawling(Queue<Integer> q){
        findEntrance(labyrinth);

        int movingTo = 0;
        boolean faceOnWall = false;
        boolean sucess = false;
        int numeroComando = 0;

        while((!q.empty() && !faceOnWall && !sucess)){
            movingTo =  q.dequeue();
            numeroComando++;
            System.out.println("comando " + numeroComando);
            if(movingTo == 1){
            //Direita
                if(x < 9){
                    x++;
                }
                else{
                    System.out.println("impossivel ir além do limite");
                }

                if (labyrinth[y][x] == " ") {
                    labyrinth[y][x] = "X";
                }
                else if(labyrinth[y][x] == "#"){
                    faceOnWall = true;
                }
                else if(labyrinth[y][x] == "S"){
                    sucess = true;
                }
            }
            else if(movingTo == 2){
            //Esquerda
                if(x > 0){
                    x--;
                }
                else{
                    System.out.println("impossivel ir além do limite");
                }

                if (labyrinth[y][x] == " ") {
                    labyrinth[y][x] = "X";
                }
                else if(labyrinth[y][x] == "#"){
                    faceOnWall = true;
                }
                else if(labyrinth[y][x] == "S"){
                    sucess = true;
                }

            }
            else if(movingTo == 3){
            //Cima
                if(y > 0){
                    y--;
                }
                else{
                    System.out.println("impossivel ir além do limite");
                }

                if (labyrinth[y][x] == " ") {
                    labyrinth[y][x] = "X";
                }
                else if(labyrinth[y][x] == "#"){
                    faceOnWall = true;
                }
                else if(labyrinth[y][x] == "S"){
                    sucess = true;
                }

            }
            else{
            //Baixo
                if(y < 9){
                    y++;
                }
                else{
                    System.out.println("impossivel ir além do limite");
                }

                if (labyrinth[y][x] == " ") {
                    labyrinth[y][x] = "X";
                }
                else if(labyrinth[y][x] == "#"){
                    faceOnWall = true;
                }
                else if(labyrinth[y][x] == "S"){
                    sucess = true;
                }
            }
            PrintLabirinty(labyrinth);
        }

        if(faceOnWall){
            System.out.println("Que pena, voce bateu de frente com um muro!");
            return false;
        }
        if(sucess){
            System.out.println("parabens, voce completou o trajeto!");
            return true;
        }
        else{
            System.out.println("Que pena, faltaram alguns passos!");
            return false;
        }
    }

    static private void PrintLabirinty(String[][] labirintySample) {
        for (int l = 0; l < labirintySample.length; l++) {
            System.out.println();
            for (int c = 0; c < labirintySample[l].length; c++) {
                System.out.print(labirintySample[l][c]);
            }
        }
        System.out.println();
    }


    static void findEntrance(String[][] labirintySample) {
        for (int l = 0; l < labirintySample.length; l++) {
            for (int c = 0; c < labirintySample[l].length; c++) {
                if (labirintySample[l][c] == "E") {
                    x = c;
                    y = l;
                    System.out.println("entrada localizada em- x: " + x+ " e y: "+ y);
                }
            }
        }
    }


    static void ClearLabyrinth(String[][] labirintySample) {
        for (int l = 0; l < labirintySample.length; l++) {
            for (int c = 0; c < labirintySample[l].length; c++) {
                if (labirintySample[l][c] == "X") {
                    labirintySample[l][c] = " ";
                }
            }
        }
    }

    ///--------samples
    static String[][] sample1 = {
            {"#", "E", "#", "#", "#", "#", "#", "#", "#", "#", "#"},//0
            {"#", " ", "#", "#", "S", "#", "#", "#", "#", "#", "#"},//1
            {"#", " ", "#", "#", " ", "#", "#", "#", "#", "#", "#"},//2
            {"#", " ", "#", "#", " ", " ", " ", " ", " ", "#", "#"},//3
            {"#", " ", "#", "#", "#", "#", "#", "#", " ", "#", "#"},//4
            {"#", " ", " ", " ", " ", " ", "#", "#", " ", "#", "#"},//6
            {"#", "#", "#", "#", "#", " ", "#", "#", " ", "#", "#"},//5
            {"#", " ", " ", " ", " ", " ", "#", "#", " ", "#", "#"},//7
            {"#", " ", "#", "#", "#", "#", "#", "#", " ", "#", "#"},//8
            {"#", " ", " ", " ", " ", " ", " ", " ", " ", "#", "#"},//9
            {"#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#"}};//10

    static String[][] sample2 = {
            {"#", "#","#","#","#","#","#","#","#","#"},//0
            {"#", "#","E","#","#"," "," "," "," ","#"},//1
            {"#", "#"," ","#","#"," ","#","#"," ","#"},//2
            {"#", "#"," ","#","#","S","#","#"," ","#"},//3
            {"#", "#"," ","#"," ","#"," "," "," ","#"},//4
            {"#", "#"," ","#"," ","#","#","#"," ","#"},//6
            {"#", " "," "," "," "," "," ","#"," ","#"},//5
            {"#", " ","#","#","#","#"," ","#"," ","#"},//7
            {"#", " ","#","#","#","#"," ","#"," ","#"},//8
            {"#", " ","#","#","#","#"," "," "," ","#"},//9
            {"#", "#","#","#","#","#","#","#","#","#"}};//10



    static String[][] sample3 = {
            {"#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#"},//0
            {"#", "#", "#", "#", "S", " ", " ", " ", "E", "#", "#"},//1
            {"#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#"},//2
            {"#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#"},//3
            {"#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#"},//4
            {"#", "#", " ", " ", "#", "#", "#", "#", "#", "#", "#"},//6
            {"#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#"},//5
            {"#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#"},//7
            {"#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#"},//8
            {"#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#"},//9
            {"#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#"}};//10
}