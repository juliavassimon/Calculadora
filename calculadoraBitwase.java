import java.util.Scanner;
public class Calculador {
public static void main (String [] args) {
	 Scanner scanner = new Scanner(System.in);
	 System.out.print("Digite o primeiro número: ");
     int num1 = scanner.nextInt();

     System.out.print("Digite o segundo número: ");
     int num2 = scanner.nextInt();
     System.out.println("\nOperações disponíveis:");
     System.out.println("1 - Soma");
     System.out.println("2 - Subtração");
     System.out.println("3 - Multiplicação");
     System.out.println("4 - Divisão");
     System.out.print("\nDigite o número da operação desejada: ");
     int operacao = scanner.nextInt();

     int resultado = 0;

     if (operacao == 1) {
         resultado = soma(num1, num2);
     } else if (operacao == 2) {
         resultado = subtrai(num1, num2);
     } else if (operacao == 3) {
         resultado = multiplica(num1, num2);
     } else if (operacao == 4) {
         resultado = dividi(num1, num2);
     } else {
         System.out.println("Operação inválida.");
         System.exit(0);
     }

     System.out.println("Resultado: " + resultado);
 }

	 

	public static int soma(int n1, int n2) {
		while (n2 != 0) {
		 int carry = n1 & n2; //se tem a mesma quantidade de bits e vai armazenar em carry
		 n1 = n1 ^ n2; //faz a comparacao dos bits (como os valores já estão ok, sera apenas 0 ou 1 ou 10)
		 n2 = carry <<1; //aqui é o deslocamento pra esquerda 
		 }
		return n1;
	 }
	 public static int subtrai(int n1, int n2) {
	        while (n2 != 0) {
	            int borrow = (~n1) & n2;
	            n1 = n1 ^ n2;
	            n2 = borrow << 1;
	        }
	        return n1;
	    }
	  public static int multiplica(int n1, int n2) {
	        int resultado = 0;
	        while (n2 != 0) {
	            if ((n2 & 1) != 0) {
	                resultado = soma(resultado, n1);
	            }
	            n1 <<= 1;
	            n2 >>= 1;
	        }
	        return resultado;
	    }
	  
		  public static int dividi (int n1, int n2) {
	            if (n2 == 0) {
	               throw new ArithmeticException("Operação invalida");
	                
	            }
	            if (n1 == Integer.MIN_VALUE && n2 == -1) {
	                return Integer.MAX_VALUE;
	            }
	            boolean negative = (n1 < 0) ^ (n2 < 0);
	           n1 = Math.abs(n1);
	            n2 = Math.abs(n2);
	            int quotient = 0;
	            for (int i = 31; i >= 0; i--) {
	                if ((n1 >> i) >= n2) {
	                    quotient |= 1 << i;
	                    n1 = subtrai(n1, n2 << i);
	                }
	            }
	            return negative ? subtrai(0, -quotient) : quotient;
	        }
		  
	  }
