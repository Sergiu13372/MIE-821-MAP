package first;

public class firstClass {
	public static void main(String args[]){
	      double a, b, max, step, scm = 0;
	      a = Double.parseDouble(args[0]);
	      b = Double.parseDouble(args[1]);

	      if(a > b){
	         max = step = a;
	      }
	      else{
	         max = step = b;
	      }

	      while(a!= 0) {
	         if(max % a == 0 && max % b == 0) {
	            scm = max;
	            break;
	         }
	         max += step;
	      }
	      System.out.println("SCM of given numbers is :: " + scm);
	   }
}