package TestClient;

import java.io.File;
import java.io.FileInputStream;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import beans.Avatar;

public class AvatarClient {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("resources/Avatar.cfg.xml");
		SessionFactory sf =cfg.buildSessionFactory();
		Session s =sf.openSession();
		Transaction t =s.beginTransaction();
		
		
		
		File file = new File("C:\\BPER\\BPER related\\IMG.jpg");
        byte[] bFile = new byte[(int) file.length()];
        
        try {
	     FileInputStream fileInputStream = new FileInputStream(file);
	     //convert file into array of bytes
	     fileInputStream.read(bFile);
	     fileInputStream.close();
        } catch (Exception e) {
	     e.printStackTrace();
        }
        
        Avatar avatar = new Avatar();
        avatar.setImage(bFile);
        
        s.save(avatar);
        
        //Get image from database
        /*Avatar avatar2 = (Avatar)session.get(Avatar.class, avatar.getAvatarId());
        byte[] bAvatar = avatar2.getImage();
        
        try{
            FileOutputStream fos = new FileOutputStream("C:\\test.gif"); 
            fos.write(bAvatar);
            fos.close();
        }catch(Exception e){
            e.printStackTrace();
        }*/

        t.commit();
        s.close();
        sf.close();

	}

}
