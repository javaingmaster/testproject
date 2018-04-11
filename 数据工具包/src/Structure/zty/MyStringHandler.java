package Structure.zty;

public class MyStringHandler {
	/*
	 *  java�����ַ��������÷�����
	 * 
	 *  substring()   �ַ����ü�
	 *  concat()      �ַ�������
	 *  replace()     �ַ����滻
	 *  trim()        ȥ����ʼ�ͽ�β�Ŀո�
	 *  valueOf()     ת��Ϊ�ַ���
	 *  toLowerCase() ת��ΪСд
     *  toUpperCase() ת��Ϊ��д
     *  length()      ȡ���ַ����ĳ���
     *  charAt()      ��ȡһ���ַ�
     *  getChars()    ��ȡ����ַ�
     *  indexOf()     �����ַ������Ӵ���һ�γ��ֵĵط�
     *  lastIndexOf() �����ַ������Ӵ��Ǻ�һ�γ��ֵĵط�
     *  startsWith()  ���������Ƿ����ض��ַ�����ʼ
     *  endWith()     ���������Ƿ����ض��ַ�������
	 */
	
	/*
	 * ͳ��s�ַ�����from������ʼ�м���������c�����ظ���
	 */
	public int countchar(String s,char c,int from){
		int number=0;
		if(from<s.length()&&from>=0){
			for(int i=from;i<s.length();i++){
				if(s.charAt(i)==c){
					number++;
				}else{
					break;
				}
			}
			return number;
		}else{
			System.out.println("error in countchar()");
			return -1;
		}	
	}
	/*
	 * ͳ���ַ���s��from��to�м����ַ�c�����Բ����������ظ���
	 */
	public int countchar(String s,char c,int from, int to){
		return -1;
	}
	/*
	 * ͳ������item������arc���ǲ��ǵ���
	 */
	public boolean issingle(int item,String[] out){

		if(out[item+1]!=null){
			if(!out[item].endsWith(".")&&out[item+1].equals("\n")){

				return true;
			}
		}else{
			if(!out[item].endsWith(".")){

				return true;
			}else{
				if(item>0){
					if(out[item-1].startsWith("<")||out[item-1].equals("\n")){
						return true;
					}else{
						return false;
					}
				}else{
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean isli(int item,String[] out){
		if(out[item].charAt(1)=='l'&&out[item].charAt(2)=='i'){
			return true;
		}
		return false;
	}
	public int numberofli(int item,String[] out){
		int number=1;
		
		while(out[item+1]!=null&&out[item+1].length()>3&&isli(item+1,out)){
			number++;
			item++;
		}
		return number;
	}
	
	public int numberofparagraph(int item,String[] out){
		int number=1;
		
		while(out[item+1]!=null&&!out[item+1].endsWith(".")){
			number++;
			item++;
		}
		return number;
	}
	
	/*public static void main(String[] args){
		MyStringHandler msh=new MyStringHandler();
		String s="a aaa    a";
		System.out.println(msh.countchar(s, ' ', 5));
	}*/

}
