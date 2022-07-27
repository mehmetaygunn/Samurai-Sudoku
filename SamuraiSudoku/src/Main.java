import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;





public class Main {

	

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
Map2 map = new Map2();
map.dosyaOku();
//SudokuSolver solver = new SudokuSolver();
/*
if (solver.solve(map.getMap4())) {
	  solver.printAnswer(map.getMap4());
 }
	*/


	Thread t1= new SudokuSolver(map.getMap1());
Thread t2= new SudokuSolver(map.getMap2());
Thread t3= new SudokuSolver(map.getMap5());
Thread t4= new SudokuSolver(map.getMap3());
Thread t5= new SudokuSolver(map.getMap4());
t1.start();
Instant start = Instant.now();
t1.join();
System.out.println("\n\n\n_______________");
t2.start();
t2.join();
System.out.println("\n\n\n_______________");
t3.start();
t3.join();
System.out.println("\n\n\n_______________");
t4.start();
t4.join();
System.out.println("\n\n\n_______________");
t5.start();
t5.join();
Instant finish = Instant.now();
long timeElapsed = Duration.between(start, finish).toMillis();
//System.out.println(timeElapsed);




Thread t6= new SudokuSolver(map.getMap1(),1);
Thread t7= new SudokuSolver(map.getMap1(),2);
Thread t8= new SudokuSolver(map.getMap2(),1);
Thread t9= new SudokuSolver(map.getMap2(),2);
Thread t10= new SudokuSolver(map.getMap5(),1);
Thread t11= new SudokuSolver(map.getMap5(),2);
Thread t12= new SudokuSolver(map.getMap3(),1);
Thread t13= new SudokuSolver(map.getMap3(),2);
Thread t14= new SudokuSolver(map.getMap4(),1);
Thread t15= new SudokuSolver(map.getMap4(),2);

Instant start2 = Instant.now();
t6.start();
t6.join();
t7.start();
t7.join();
t8.start();
t8.join();
t9.start();
t9.join();
t10.start();

t10.join();
t11.start();
t11.join();
t12.start();
t12.join();
t13.start();
t13.join();
t14.start();
t14.join();
t15.start();

Instant finish2 = Instant.now();








t15.join();

long timeElapsed2 = Duration.between(start2, finish2).toMillis();
System.out.println("\n 1.TIMER"+timeElapsed);
System.out.println("\n 2.TIMER"+timeElapsed2);


}

	
	
}
