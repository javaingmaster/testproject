package zty.acm.demo;
/*
 * ö�ٷ���ϰ
 * ������26����ͬ��Ӣ��Сд��ĸ���е�3��5�����,��������Ϊaaa;asd;dfsg;gfdrh
 */
public class GetSimplePassword {
	String test="abc";
	String password;
	char la,lb,lc,ld,le;
	
	public void computePassword(){
		for(int i=3;i<6;i++){
			for(int a=0;a<26;a++){
				for(int b=0;b<26;b++){
					if(b!=a){
						for(int c=0;c<26;c++){
	                        la=(char)(a+97);
	                        lb=(char)(b+97);
	                        lc=(char)(c+97);
	                        password=String.valueOf(la)+String.valueOf(lb)+String.valueOf(lc);
	                        if(password.equals(test)){
	                        	System.out.println("������: "+password);
	                        }
							if(i>3){
								for(int d=0;d<26;d++){
									    la=(char)(a+97);
				                        lb=(char)(b+97);
				                        lc=(char)(c+97);
				                        ld=(char)(d+97);
				                        password=String.valueOf(la)+String.valueOf(lb)+String.valueOf(lc)+String.valueOf(ld);
				                        if(password.equals(test)){
				                        	System.out.println("������: "+password);
				                        }
									if(i>4){
										for(int e=0;e<26;e++){
											    la=(char)(a+97);
						                        lb=(char)(b+97);
						                        lc=(char)(c+97);
						                        ld=(char)(d+97);
						                        le=(char)(e+97);
						                        password=String.valueOf(la)+String.valueOf(lb)+String.valueOf(lc)+String.valueOf(ld)+String.valueOf(le);
						                        if(password.equals(test)){
						                        	System.out.println("������: "+password);
						                        }
										}
									}			
								}
							}				
						}
					}		
				}
			}
		}
	}
	public static void main(String[] aaa){
		
	}
}
