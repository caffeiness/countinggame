package kazutorigame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;


public class numpick {
	static int inputnumber=0;
	static int playerTotal = 0;
	static int cpuTotal = 0;
	public static void main(String[] args) {
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

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(num.size() != 0) {
			System.out.println(num);
			System.out.println("どれを取りますか？");
			try {
				inputnumber = Integer.parseInt(br.readLine());
			}
			catch(NumberFormatException e) {
				System.err.println("数値を入力してください");
			}catch(IOException e) {
				System.out.println("もう一度入力してください");
			}
			
			if(num.contains(inputnumber)) {
				player(num,num_p);
				if(playerTotal == 15 || num.size() == 0) {
					break;
				}
				cpu(num,num_c);
				if(cpuTotal == 15 || num.size() == 0) {
					break;
				}
				}else {
					System.out.println("その数字はありません");
				}
			}
			if(playerTotal == 0 && cpuTotal == 0) {
				System.out.println("引き分け");
				System.out.println("あなたの取得した数は" + num_p);
				System.out.println("CPUの取得した数は" + num_c);
			}
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

	public static void player(ArrayList<Integer>num,ArrayList<Integer>num_p) {
		num_p.add(inputnumber);
		num.remove(num.indexOf(inputnumber));
		if(match(num_p) == true) {
			System.out.println("あなたの勝ちです");
			System.out.println("");
			playerTotal = 15;
		}else {
			System.out.println("あなたの取得した数は" + num_p);
			System.out.println();
		}
	}
	public static void cpu(ArrayList<Integer>num,ArrayList<Integer>num_c) {
		int index = new Random().nextInt(num.size());
		int cpuPicknum = num.get(index);
			num_c.add(cpuPicknum);
			num.remove(num.indexOf(cpuPicknum));
			if(match(num_c) == true) {
				System.out.println("CPUの勝ちです");
				System.out.println("");
				cpuTotal = 15;
			}else {
				System.out.println("CPUの取得した数は" + num_c);
				System.out.println();
			}
	}

	public static void reset() {

	}
}



