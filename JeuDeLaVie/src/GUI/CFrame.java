/**
 * 
 */
package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;




/**
 * @author xtream
 *
 */
public class CFrame extends JFrame /*implements ActionListener*/ {
	
	private final static int WIDTH = 800;
	private final static int HEIGHT = 600;
	
	private final Dimension dimension = new Dimension(WIDTH, HEIGHT);
	
	private JButton button;
	
	private int  mgenCount;
	private JLabel labelCount;
			
	CPanel panel;
	
	
		
	public CFrame(String s) {
		super(s);
		initComponent();
		
	}
	
	
	private void initComponent() {
		this.panel = new CPanel();
		panel.setBackground(new java.awt.Color(192,192,192));
		//panel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
		panel.setPreferredSize(new Dimension(400, 300));
		
		JPanel panel2 = new JPanel();
		
		button = new JButton("Toggle");   
		button.addActionListener(e -> { 
		//System.out.println("toggle clic" + e.getActionCommand());
			this.panel.toggle();
		});		
		panel2.add(button);
		
		button = new JButton("+");
		button.addActionListener(e -> { 			
			this.panel.increaseRate();
		});
		panel2.add(button);
		
		button = new JButton("-");
		button.addActionListener(e -> { 			
			this.panel.decreaseRate();
		});
		panel2.add(button);
		
		labelCount = new JLabel("Génération : ");
		panel2.add(labelCount);
		
		
		
		this.add(panel, BorderLayout.CENTER);
		this.add(panel2, BorderLayout.NORTH);
		pack();
		
		
	}
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public void paint(Graphics g) {
	    super.paint(g);
	           
	}
	
	@Override
    public Dimension getPreferredSize() {
        return this.dimension;
    }	
//
//	@Override
//	public void actionPerformed(ActionEvent arg0) {		
//		
//		
//	}

}






