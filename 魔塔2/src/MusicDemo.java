import java.applet.*; 
import java.io.File;
import java.net.URL; 

public class MusicDemo{ 
public void a()
{ 
URL musicURL = null; 
try{ 

musicURL = new URL("mu.mp3");//�õ�Ҫ�������ֵ�url 
}catch(Exception e){ 
e.printStackTrace(); 
} 
AudioClip ac = Applet.newAudioClip(musicURL); //�õ�һ��������Ƶ��ʵ�� 
ac.play();//����һ�� 
//ac.loop();//ѭ������ 
//ac.stop();//ֹͣ 
} 
} 
