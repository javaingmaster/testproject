package Structure.zty;

public class MyStringHandler {
	/*
	 *  java包中字符串处理常用方法：
	 * 
	 *  substring()   字符串裁剪
	 *  concat()      字符串链接
	 *  replace()     字符串替换
	 *  trim()        去掉起始和结尾的空格
	 *  valueOf()     转换为字符串
	 *  toLowerCase() 转换为小写
     *  toUpperCase() 转换为大写
     *  length()      取得字符串的长度
     *  charAt()      截取一个字符
     *  getChars()    截取多个字符
     *  indexOf()     查找字符或者子串第一次出现的地方
     *  lastIndexOf() 查找字符或者子串是后一次出现的地方
     *  startsWith()  方法决定是否以特定字符串开始
     *  endWith()     方法决定是否以特定字符串结束
	 */
	
	/*
	 * 统计s字符串从from索引开始有几个连续的c，返回个数
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
	 * 统计字符串s从from到to有几个字符c，可以不连续，返回个数
	 */
	public int countchar(String s,char c,int from, int to){
		return -1;
	}
	/*
	 * 统计索引item在文章arc中是不是单句
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
