package kazutorigame;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class numpick {
	public static void main(String[] args) {
		int total_p = 0;
		int total_c = 0;
		int inputnumber=0;
		ArrayList<Integer> num_p = new ArrayList<Integer>();
		ArrayList<Integer> num_c = new ArrayList<Integer>();
		ArrayList<Integer> num = new ArrayList<Integer>();
		num.add(1);
		num.add(2);
		num.add(3);
		num.add(4);
		num.add(5);
		num.add(6);
		num.add(7);
		num.add(8);
		num.add(9);

		Scanner scanner = new Scanner(System.in);

		while(total_p != 15 || total_c != 15) {
			System.out.println(num);
			System.out.println("どれを取りますか？");
			inputnumber = scanner.nextInt();

			if(num.size()==1){
				num_p.add(inputnumber);
				num.remove(num.indexOf(inputnumber));
				match(num_p);
				System.out.println("The end");
				break;
			}else if(num.contains(inputnumber)) {
				//Player
				num_p.add(inputnumber);
				num.remove(num.indexOf(inputnumber));
				if(match(num_p) == true) {
					System.out.println("あなたの勝ちです");
					System.out.println("");
					break;
				}else {
					System.out.println("あなたの取得した数は" + num_p);
					System.out.println();
				}


				//CPU
				int index = new Random().nextInt(num.size());
				int cpuPicknum = num.get(index);
				num_c.add(cpuPicknum);
				num.remove(num.indexOf(cpuPicknum));
				match(num_c);
				if(match(num_c) == true) {
					System.out.println("CPUの勝ちです");
					System.out.println("");
					break;
				}else {
					System.out.println("CPUの取得した数は" + num_c);
					System.out.println();
				}
			}else {
				System.out.println("その数字はありません");
			}


		}
		scanner.close();
	}

	public static boolean match(ArrayList<Integer>array) {
		if(array.size() >= 3) {
			boolean flag = true;
			ArrayList<Integer> result = new ArrayList<Integer>();
			for(int i=0;i<array.size()-2;i++) {
				for(int j=i+1;j<array.size()-1;j++) {
					for(int k=j+1;k<array.size();k++) {
						int total = array.get(i) + array.get(j) + array.get(k);
						if(total == 15) {
							result.add(array.get(i));
							result.add(array.get(j));
							result.add(array.get(k));
							System.out.println(result);
							return flag;
						}
					}
				}
			}
		}
		return false;
	}
}



