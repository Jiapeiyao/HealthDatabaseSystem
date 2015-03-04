import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

/**
 * 
 */

/**
 * @author Jiapei Yao, Xinglun Xu
 *
 */

public class View extends JPanel{
	public static final int IMAGE_SIZE = 600;
	private Image image;
	
	View(){
	}
	
	void setImage(Image image){
		this.image = image;
	}
	
	//@Override
	public void paintComponent( Graphics graphics ){
		super.paintComponent( graphics ); 
		graphics.drawImage( image, 0, 0, IMAGE_SIZE, IMAGE_SIZE, this );
	}
	
}
