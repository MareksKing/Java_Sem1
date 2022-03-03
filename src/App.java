
import java.util.Random;

public class App {
    public static void main(String[] args){

        //Exercise 0 - Warmup
        System.err.println("------------------------------------------");
        String[] names = { "Elena", "Thomas", "Hamilton", "Suzie", "Phil", "Matt",
                            "Alex", "Emma", "John", "James", "Jane", "Emily", "Daniel", "Neda", "Aaron",
                            "Kate" };
        int[] times = { 341, 273, 278, 329, 445, 402, 388, 275, 243, 334, 412, 393,
                        299, 343, 317, 265 };
        
        int n = names.length;
        for (int i = 0; i < n; i++){
            System.err.println("["+names[i] + " : " + times[i]+"]");
        } 
        System.out.println("------------------------------------------");

        //Exercise 1 - Gravity
        double gravity = -9.81; // Earth's gravity in m/s^2
        double initialVelocity = 0.0;
        double fallingTime = 10.0;
        double initialPosition = 0.0;
        double finalPosition = 0.0;
        finalPosition = positionCalc(gravity, initialVelocity, initialPosition, fallingTime);
        System.out.println("Pos in "+fallingTime+"sec :"+finalPosition);
        System.out.println("------------------------------------------");

        //Exercise 2 - Factorial
        System.err.println("Loop Factorial: "+factorialForLoop(10)); 
        System.err.println("Recursive Fact: "+factorialRecursive(10));
        System.out.println("------------------------------------------");

        //Exercise 3 - Arrays
        double[] array = generateArray(9, 30.0, 90.0);
        System.out.print("Matrica: ");
        for (int i = 0; i < array.length; i++){
            System.out.print(array[i] + "; ");
        }
        System.out.print("\nVideja: " +getMean(array));   
        System.out.print("\nMazakais: " +getMin(array));   
        System.out.print("\nLielakais: " +getMax(array));
        arraySort(array);
        System.out.print("\nSakartots: ");
        for (int i = 0; i < array.length; i++){
            System.out.print(array[i] + "; ");
        }
        System.out.println("\n------------------------------------------");

        //Exercise 4 - MD Array
        double mdMatrix[][] = generateMatrix(5);
        System.out.println("Multi dimensionala matrica");
        for (int i = 0; i <mdMatrix.length; i++){
            for (int j = 0; j<mdMatrix.length; j++){
                System.out.print(mdMatrix[i][j] + "; ");
            }
            System.out.println();
        }
        System.out.println("Mekletais produkts: " +getProduct(mdMatrix, 3, 2));
        System.out.println("------------------------------------------");

        //Exercise 5 - Chances - Coinflip/Dice
        /**
         * Monetas mesanas simulacija
         * @param N
         * return Probability 
         */

        double[] metieni = coinFlip(10000);
        for (int i = 0; i < metieni.length; i++){
            if (i == 0){
                System.out.println("Heads: " + metieni[i]);
            } else if (i == 1){
                System.out.println("Tails: " + metieni[i]);
            } else{
                System.out.println("Ratio: " + metieni[i]);
            }
            // System.out.println(metieni[i]);
        }

        int[] kaulins = rollDice(10);
        for (int i = 0; i < kaulins.length; i++){
            System.out.println(i+1 + ": "+kaulins[i]);
        }

        roll2Dices();
        System.out.println("------------------------------------------");
        //Exercise 6 - Byte -> String

        /**
         * Parvers bitus uz stringu
         * 
         */

        byte[] bitArray = {72, 101, 108, 108, 111, 33, 32, 77, 121, 32, 115, 107, 105, 108, 108, 115, 32, 97, 114, 101,
                           32, 103, 114, 101, 97, 116, 32, 97, 108, 114, 101, 97, 100, 121, 33};
        String bituArray = getTextFromBytes(bitArray);
        System.out.println(bituArray);
        System.out.println("------------------------------------------");

        //Exercise 7 - Pascal's triangle
        String rinda = pascalsTriangle(6);
        System.out.println("[" + rinda + "]");
        System.out.println("------------------------------------------");


    }
    /**
     * 
     * @param gravity - zemes pievilksanas speks
     * @param initialVelocity - sakuma atrums
     * @param initialPosition - sakuma pozicija
     * @param fallingTime - laiks cik ilgi kritis
     * @return - double tipa beigu pozicija
     */
    static double positionCalc(double gravity, double initialVelocity, double initialPosition, double fallingTime){
        double finalPosition = 0.5*(gravity*Math.pow(fallingTime, 2)+(initialVelocity*fallingTime) + initialPosition);
        return finalPosition;
    }
    /**
     * 
     * @param N - skaitlis kuram aprekinas faktorialu
     * @return - faktorials no skaitla N
     */
    static int factorialForLoop(int N){
        int rez = 1;
        if (N < 0){
            return 0;
        }
        for (int i = 1; i <= N; i++){
            rez *= i;
        }

        return rez;
    }
    static int factorialRecursive(int N){
        if (N < 0){
            return 0;
        }
        if (N == 1){
            return N;
        } else {
            return N*factorialRecursive(N - 1);
        }
    }
    /**
     * 
     * @param N - masiva lielums
     * @param lower - mazakais pielaujamais skaitlis
     * @param upper - lielakais pielaujamais skaitlis
     * @return - matricu ar nejausiem skaitliem
     */
    static double[] generateArray(int N, double lower, double upper){
        double[] matrica;
        matrica = new double[N];
        if (lower > upper){
            return matrica;
        }
        for (int i = 0; i <N; i++){
            matrica[i] = Math.round(Math.random() * (upper-lower+1)+lower);
        }
        return matrica;
    }
    /**
     * 
     * @param array - matrica kurai velas iegut videjo
     * @return - matricas videjo vertibu
     */
    static double getMean(double[] array){
        double vid = 0.0;
        for (int i = 0; i < array.length; i++){
            vid += array[i];
        }
        vid =vid/array.length;
        return vid;
    }
    /**
     * 
     * @param array - matrica kurai velas iegut mazako vertibu
     * @return - mazako matricas vertibu
     */
    static double getMin(double[] array){
        double mazakais;
        mazakais = array[0];
        for (int i = 0; i<array.length; i++){
            if (mazakais > array[i]){
                mazakais = array[i];
            }
        }
        return mazakais;
    }
    /**
     * 
     * @param array - matrica kurai velas iegut lielako vertibu
     * @return - lielako matricas vertibu
     */
    static double getMax(double[] array){
        double lielakais;
        lielakais = array[0];
        for (int i = 0; i<array.length; i++){
            if (lielakais < array[i]){
                lielakais = array[i];
            }
        }
        return lielakais;
    }
    /**
     * 
     * @param array - matrica kuru velas sakartot
     * @return - sakartotu matricu augosa seciba
     */
    static double[] arraySort(double[] array){
        double[] sakartots;
        sakartots = new double[array.length];
        double temp = 0;
        for(int i=0; i < array.length; i++){  
            for(int j=1; j < (array.length-i); j++){  
                     if(array[j-1] > array[j]){  
                            //swap elements  
                            temp = array[j-1];  
                            array[j-1] = array[j];  
                            array[j] = temp;  
                    }  
                     
            }  
        } 
        return sakartots;
    }
    /**
     * 
     * @param N - matricas lielums 
     * @return
     */
    static double[][] generateMatrix(int N){
        double[][] mdMatrica;
        mdMatrica = new double[N][N];
        for (int i = 0; i <N; i++){
            for(int j = 0; j < N; j++){
                mdMatrica[i][j] = Math.round(Math.random() * (100-1+1)+1);
            }
        }
        return mdMatrica;
    }
    static double getProduct(double[][] matrix, int r, int k){
        // double produkts = 0.0;
        // for (int i = 0; i < r; i++){
        //     for (int j = 0; j < k; j++){
        //         produkts = matrix[r][k];
        //     }
        // }
        // return produkts;
        return matrix[r][k];
    }
    static double[] coinFlip(int N){
        double[] rezultats;
        rezultats = new double[3];
        
        for (int i = 0; i < N; i++){
            Random random = new Random();
            int metiens = random.nextInt(2);
            if (metiens == 0){
                rezultats[0]++;
            } else {
                rezultats[1]++;
            }
        }

        rezultats[2] = rezultats[0]/rezultats[1];
        return rezultats;
    }
    static int[] rollDice(int N){
        int[] metieni = new int[6];
        for (int i = 0; i < N; i++){
            Random random = new Random();
            int metiens = random.nextInt(6);
            if(metiens == 0){metieni[0]++;}
            else if (metiens == 1){metieni[1]++;}
            else if (metiens == 2){metieni[2]++;}
            else if (metiens == 3){metieni[3]++;}
            else if (metiens == 4){metieni[4]++;}
            else if (metiens == 5){metieni[5]++;}
            }
        
        return metieni;
    }
    static int roll2Dices(){
        int kaulins1;
        int kaulins2;
        boolean uzmeta = false;
        int meginajumi = 0;
        while(uzmeta == false){
            Random r = new Random();
            kaulins1 =  r.nextInt(6) + 1;
            kaulins2 = r.nextInt(6) + 1;
            meginajumi++;
            if (kaulins1 + kaulins2 == 12){
                uzmeta = true;
            }
        }
        System.out.println("Meginajumi: "+meginajumi);
        return meginajumi;
    }
    static String getTextFromBytes(byte[] array){
        String biti = new String(array);
        return biti;
    }
    static String pascalsTriangle(int level){
        String rinda = "";
        for (int i = 0; i <= level; i++) {
            int paskals = (factorialForLoop(level))/(factorialForLoop(i)*factorialForLoop(level - i));
            if (i == level){
                rinda += paskals;
            } else {
                rinda += paskals + ",";
            }
        }
        return rinda;
    }
    /**
     * Aprekina funkciju kas ievadita ka String
     * @param inputEquation
     * @return
     */
    static double executeStringEquation(String inputEquation){
        return 0.0;
    }

        

}

        