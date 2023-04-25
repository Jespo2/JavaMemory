

import java.util.Random;
import java.util.Scanner;
public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char [][] spielfeldA =
                {       {'*', '*', '*', '*'},
                        {'*', '*', '*', '*'},
                        {'*', '*', '*', '*'},
                        {'*', '*', '*', '*'},
                };
        char [][] spielfeldB = {
                {'1', '1', '2', '2'},
                {'3', '3', '4', '4'},
                {'5', '5', '6', '6'},
                {'7', '7', '8', '8'},
        };

        shuffle(spielfeldB);
        spielfeldAusgeben(spielfeldB);
        boolean a = false;
        while (a==false){
            spielfeldAusgeben(spielfeldA);

            System.out.println("Gibt die x und danach die y Koordinate deiner Wahl an");
            int x = sc.nextInt();
            int y = sc.nextInt();
            if(isValid(x,y,spielfeldA)){
                spielfeldA[x][y]=spielfeldB[x][y];
            }
            spielfeldAusgeben(spielfeldA);
            System.out.println("Gibt nochmal die x und danach die y Koordinate deiner Wahl an");
            int b = sc.nextInt();
            int c = sc.nextInt();
            if(isValid(b,c,spielfeldA)){
                spielfeldA[b][c]=spielfeldB[b][c];
                if(spielfeldA[x][y]==spielfeldA[b][c]){
                    spielfeldA=fillWithPair(x,y,b,c,spielfeldA,spielfeldB);
                }else
                    spielfeldA[x][y]='*';
                    spielfeldA[b][c]='*';

            }
        }

    }

    static public void spielfeldAusgeben(char [][] a){
        System.out.print("    ");

        for(int k = 0 ; k < a.length ; k++){
            System.out.print((k+1)+"\t");
        }
        System.out.println("");
        System.out.print("   ---------------");
        System.out.println("");


        for(int i = 0 ; i < a.length ; i++){
            System.out.print((i+1)+"|"+"\t");
            for (int j = 0 ; j < a[i].length;j++){
                System.out.print(a[i][j] +"\t");

            }
            System.out.println("");
        }
    }
    static public boolean isValid(int a , int b , char [][] c){
        if(a<=c.length&&b<=c.length&&c[a][b]=='*') {
            return true;
        }else
            return false;
    }

    static public char [][] fillWithPair(int x, int y, int b, int c , char [][] aA,char [][] aB ){
        aA[x][y] = aB[x][y];
        aA[b][c] = aB[b][c];
        return aA;
    }

    static public boolean isGameOver(char[][] a){
        int counter = 0;
        for(int i = 0 ; i < a.length ; i++){
            for (int j = 0 ; j < a[i].length;j++){
                if(a[i][j]=='*');
                counter++;
            }
        }
        if(counter>0){
            return false;
        }else
            return true;
    }

    public static void shuffle(char a[][])
    {
        int counter = 0;
        for(int i = 0 ; i < a.length ; i++){
            for (int j = 0 ; j < a[i].length;j++){
                int i1 = (int) (Math.random()*a.length);
                int j1 = (int) (Math.random()*a[i].length);

                char temp = a[i][j];
                a[i][j] = a [i1][j1];
                a[i1][j1] = temp;

            }
        }
    }

}
