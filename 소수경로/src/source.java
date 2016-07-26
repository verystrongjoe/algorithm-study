import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class source {
 
	static int[] primeArray = new int[10000];
	static int[] visited = new int[10000];
	static Queue<Integer> queue;
	
	public static void main(String[] args) {
		
		makePrimeArray();
		
		int visitCnt = 0;
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t = 0 ; t < T; t++) {
			int p = sc.nextInt();
			int q = sc.nextInt();	
			
			queue = new LinkedList<Integer>();
			visited = new int[10000];
			
			queue.add(p);
			visited[p] = 0;
			
			while(!queue.isEmpty()) {
				
				int n = queue.poll();
				visitCnt = visited[n] + 1;
				
				if(n == q) {
					System.out.println(visitCnt-1); break; 
				}
				
				for(int i = 1000 ; i <= 9999; i++) { 
					if(primeArray[i]==1 && count4NumDiff(n, i) == 1 && visited[i] == 0) {
						queue.add(i);
						visited[i] = visitCnt;
					}
				}
				
			}
			
			
		}
		sc.close();
		
	}
	
	
	public static int count4NumDiff(int p, int q) {
		
		int diff = 0;
		
		int p1 = p / 1000;
		int p2 = (p % 1000) / 100;
		int p3 = (p % 100) / 10;
		int p4 = (p % 10);
		
		int q1 = q / 1000;
		int q2 = (q % 1000) / 100;
		int q3 = (q % 100) / 10;
		int q4 = (q % 10);
		
		if(p1 != q1) diff++;
		if(p2 != q2) diff++;
		if(p3 != q3) diff++;
		if(p4 != q4) diff++;
		
		return diff;
	}
	
	
	public static void makePrimeArray() {
		
		for(int i = 1000 ; i <= 9999; i++) {
			boolean flag = true;
//			for(int j = 2; j < Math.sqrt(i); j++) {
			for(int j = 2; j < i; j++) {
				if( i % j == 0 ) {
					flag = false;
					break;
				}
			}
			if (flag) {
				primeArray[i] = 1;
			}
		}
	}
	
}
