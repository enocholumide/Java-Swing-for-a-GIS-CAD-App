package core_components;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import application_frames.Settings;
import toolset.Tools;

/**
 * Blue print for the tool buttons<br>
 * Uses background image and can change background dynamically<br>
 * Responds to mouse over and mouse exited by changing the background of the button
 * 
 * @author OlumideEnoch
 *
 */
public class ToolIconButton extends JButton {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1387944835690709531L;
	
	private boolean buttonReleased = false;

	public ToolIconButton(String text, String iconPath, int x, int y) {
		
		super();
		setBackground(Settings.DEFAULT_STATE_COLOR);
		setBorderPainted(false);
		setFocusPainted(false);
		setActionCommand(text);
		setIcon(Tools.getIconImage(iconPath, x,y));
		setText(null);
		
		
		addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				if (getActionCommand().equals("Editing")|| 
					getActionCommand().equals("Query")  || 
					getActionCommand().equals("Select") ||
					getActionCommand().equals("Snap") ||
					getActionCommand().equals("Grid") ||
					getActionCommand().equals("Ortho")){
					
					if (buttonReleased) {
						buttonReleased = false;
					} else {
						buttonReleased = true;
					} 
				}
			}
		});
		
		addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseEntered(e);
				setBackground(Settings.HIGHLIGHTED_STATE_COLOR);
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseExited(e);
				if(!buttonReleased) {
					setBackground(Settings.DEFAULT_STATE_COLOR);
				}
			}
		});
		
	}

	/**
	 * @return the buttonReleased
	 */
	public boolean isButtonReleased() {
		return buttonReleased;
	}

	/**
	 * @param buttonReleased the buttonReleased to set
	 */
	public void setButtonReleased(boolean buttonReleased) {
		this.buttonReleased = buttonReleased;
	}
}