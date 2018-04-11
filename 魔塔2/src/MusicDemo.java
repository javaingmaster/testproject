import java.applet.*; 
import java.io.File;
import java.net.URL; 

public class MusicDemo{ 
public void a()
{ 
URL musicURL = null; 
try{ 

musicURL = new URL("mu.mp3");//得到要播放音乐的url 
}catch(Exception e){ 
e.printStackTrace(); 
} 
AudioClip ac = Applet.newAudioClip(musicURL); //得到一个播放音频的实例 
ac.play();//播放一编 
//ac.loop();//循环播放 
//ac.stop();//停止 
} 
} 
