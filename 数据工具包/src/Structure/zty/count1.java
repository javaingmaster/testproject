package Structure.zty;

import java.io 

.BufferedReader;
import java.io 

.FileInputStream;
import java.io 

.FileNotFoundException;
import java.io 

.IOException;
import java.io 

.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

import jxl.read.biff.BiffException;

public class count1 {
	ArrayList<String> status;
	ArrayList<String> time;
	int tem = 0, zaifull = 0;

	public count1() throws BiffException, IOException {
		this.status = new ArrayList<String>();
		this.time = new ArrayList<String>();

		BufferedReader in = null;
		String temp;
		// int control=0;
		try {
			in = new BufferedReader(new InputStreamReader(new FileInputStream("D://3//daa.txt")));
			if (in != null) {
				temp = in.readLine();
				while (((temp = in.readLine()) != null)) { // &&control<50000
					String[] sp = temp.split(",");
					this.status.add(sp[5]);
					String[] pro = sp[2].split(" ");
					this.time.add(pro[1]);
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			in.close();
		}
	}

	public void docount(String inputtime) {

		for (int i = 1; i < status.size()-1; i++) {
			if (status.get(i).equals("0.0")) {
				tem = i + 1;
				String begin = time.get(i);
				while (!(status.get(tem)).equals("0.0")) {
					tem++;
				}
				String endtime = time.get(tem);
				if (begin.compareTo(inputtime) < 0 && endtime.compareTo(inputtime) > 0) {
					zaifull++;
				}
				i = tem + 1;
			}
		}
		System.out.println("这一时刻满载车数量是：" + zaifull);

	}

	public static void main(String[] args) throws BiffException, IOException {
		count1 c = new count1();
		System.out.println("时刻：");
		Scanner in = new Scanner(System.in 

);
		String inputtime = in.nextLine();
		c.docount(inputtime);
	}
}

