package operaciones;

interface operacion {
    int operar(int x, int y);
}

class SumaSimple implements operacion {
    public int operar(int x, int y) {
        return x + y;
    }
}

public class Init {
    public static void main(String[] args) {
        
        operacion __sumasimple = (x, y) -> (x + y);
        operacion __sumapordos = (x, y) -> (2*x + 2 * y);
        operacion __multiplicar = (x, y) -> x * y;
        
        System.out.println(__multiplicar.operar(5,2));
    }
}
