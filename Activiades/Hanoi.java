package Activiades;

public class Hanoi {
	public static void main(String[] args) {
		int n = 3; 
        int movimientos = (int) (Math.pow(2, n) - 1);
        
        System.out.println("Resolver Torres de Hanoi con " + n + " discos");
        System.out.println("Número minimo de movimientos: " + movimientos);
        System.out.println("Pasos para resolver:");

        torresHanoi(n, 1, 2, 3);
    }

    public static void torresHanoi(int discos, int torre1, int torre2, int torre3) {
        if (discos == 1) {
            System.out.println("Mover disco de torre " + torre1 + " a torre " + torre3);
        } else {
            torresHanoi(discos - 1, torre1, torre3, torre2);
            System.out.println("Mover disco de torre " + torre1 + " a torre " + torre3);
            torresHanoi(discos - 1, torre2, torre1, torre3);
        }
    }

}
