import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    static Scanner scanner;
    static Random random;
    static char[][] map;

    static final int MAP_SIZE = 3;

    static final char EMPTY_FIELD = '*';
    static final char O_FIELD = 'O';
    static final char X_FIELD = 'X';


    public static void main(String[] args) {
        init();
        printMap();
        humanTurn();
        printMap();
    }

    static void init(){
        map = new char[MAP_SIZE][MAP_SIZE];
        for (int i = 0; i < MAP_SIZE; i++) {
            for (int j = 0; j < MAP_SIZE; j++) {
                map[i][j] = EMPTY_FIELD;

            }

        }
        scanner = new Scanner(System.in);
    }


    //Данная функция рисует поле для крестиков ноликов
    static void printMap(){
        // 0 1 2 3
        // 1 * * *
        // 2 * * *
        // 3 * * *
        for (int i = 0; i < MAP_SIZE; i++) {
            System.out.println(i + " ");
        }
        System.out.println();
        for (int i = 0; i < MAP_SIZE; i++) {
            System.out.println((i + 1) + " ");
            for (int j = 0; j < MAP_SIZE; j++) {
                System.out.println(map[i][j] + " ");
            }
            System.out.println();
        }

    }

    static boolean isCellEmpty(int x, int y){
        if(x < 0 || y < 0 || x >= MAP_SIZE || y >= MAP_SIZE){
            return false;
        }
        if(map[y][x] != EMPTY_FIELD) {
            return false;
        }
        return true;
    }

    public static void humanTurn(){
        int x, y;
        do {
            System.out.println("Введите X и Y ");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
            map[y][x] = X_FIELD;
        }while(!isCellEmpty(x,y));
        System.out.println("Вы ввели " + x + " " + y );
    }

    public static void AiTurn(){
        int x, y;
        do {
            x = (int)(Math.random()* MAP_SIZE);
            y = (int)(Math.random()* MAP_SIZE);
            map[y][x] = O_FIELD;
        }while(!isCellEmpty(x,y));
        System.out.println("Ai Ввел " + x + " " + y );
    }


}