import com.cloudgarden.layout.AnchorConstraint;
import com.cloudgarden.layout.AnchorLayout;
import org.apache.commons.lang3.time.StopWatch;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;


/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class StoppUhr extends javax.swing.JFrame {
	private JPanel jPanel2;
	private JPanel jPanel1;
	private JButton startButton;
	private JButton resetButton;
	private JLabel stoppuhrAusgabe;
	private JLabel uhrzeitAusgabe;
    private JTextArea jTextArea;
    private JLabel jLabelFontSize;
    private JTextField jTextFieldStNr;
    private JPanel jPanel3;
    private JScrollPane jScrollPane1;
    private JPanel jPanel4;
    private JButton minusButton;
    private JButton plusButton;
    private int uhrFontSize = 80;
    private int counter = 0;
	String action = "";
	String displayString = "";
	public FileWriter csvFile;
	
	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				StoppUhr inst = new StoppUhr();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public StoppUhr() {
		super();
		initGUI();
	    UhrzeitThread uz = new UhrzeitThread();
	    uz.start();
	    
    	StoppUhrThread su = new StoppUhrThread();
    	su.start();
	}
	
	private void initGUI() {
		try {
			AnchorLayout thisLayout = new AnchorLayout();
			getContentPane().setLayout(thisLayout);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setPreferredSize(new java.awt.Dimension(609, 394));
			{
				jPanel3 = new JPanel();
				GridBagLayout jPanel3Layout = new GridBagLayout();
				jPanel3.setLayout(jPanel3Layout);
				getContentPane().add(jPanel3, new AnchorConstraint(668, 811, 978, 19, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				jPanel3.setPreferredSize(new java.awt.Dimension(384, 94));
				{
					jScrollPane1 = new JScrollPane();
					jPanel3.add(jScrollPane1, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
					jScrollPane1.setPreferredSize(new java.awt.Dimension(300, 90));
					{
						jTextArea = new JTextArea();
						jScrollPane1.setViewportView(jTextArea);
						jTextArea.setText("");
					}
				}
				{
					jTextFieldStNr = new JTextField();
					jPanel3.add(jTextFieldStNr, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
					jTextFieldStNr.setText("");
					jTextFieldStNr.setPreferredSize(new java.awt.Dimension(150, 90));
					jTextFieldStNr.setHorizontalAlignment(JTextField.CENTER);
					jTextFieldStNr.setFont(new Font(Font.DIALOG, Font.BOLD, 40));

				}
				jPanel3Layout.rowWeights = new double[] {0.1};
				jPanel3Layout.rowHeights = new int[] {7};
				jPanel3Layout.columnWeights = new double[] {0.1, 0.1};
				jPanel3Layout.columnWidths = new int[] {7, 7};
			}
			{
				jPanel2 = new JPanel();
				GridBagLayout jPanel2Layout = new GridBagLayout();
				jPanel2Layout.rowWeights = new double[] {0.1, 0.1};
				jPanel2Layout.rowHeights = new int[] {7, 7};
				jPanel2Layout.columnWeights = new double[] {0.1};
				jPanel2Layout.columnWidths = new int[] {7};
				jPanel2.setLayout(jPanel2Layout);
				getContentPane().add(jPanel2, new AnchorConstraint(47, 821, 721, 27, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				jPanel2.setPreferredSize(new java.awt.Dimension(363, 178));
				{
					uhrzeitAusgabe = new JLabel();
					jPanel2.add(uhrzeitAusgabe, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
					uhrzeitAusgabe.setText("00:00:00");
					uhrzeitAusgabe.setFont(new Font(Font.DIALOG, Font.BOLD, uhrFontSize));
					
				}
				{
					stoppuhrAusgabe = new JLabel();
					jPanel2.add(stoppuhrAusgabe, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
					stoppuhrAusgabe.setText("00:00:00");
					stoppuhrAusgabe.setFont(new Font(Font.DIALOG, Font.BOLD, uhrFontSize));
				}
			}
			{
				jPanel1 = new JPanel();
				GridBagLayout jPanel1Layout = new GridBagLayout();
				getContentPane().add(jPanel1, new AnchorConstraint(48, 987, 954, 820, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				jPanel1Layout.rowWeights = new double[] {0.1, 0.1, 0.1, 1.0, 0.1};
				jPanel1Layout.rowHeights = new int[] {1, 1, 1, 1, 1};
				jPanel1Layout.columnWeights = new double[] {0.1};
				jPanel1Layout.columnWidths = new int[] {7};
				jPanel1.setLayout(jPanel1Layout);
				jPanel1.setPreferredSize(new java.awt.Dimension(100, 330));
				{
					startButton = new JButton();
					jPanel1.add(startButton, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
					startButton.setPreferredSize(new java.awt.Dimension(90, 30));
					startButton.setText("Start");
				}
				{
					resetButton = new JButton();
					jPanel1.add(resetButton, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
					resetButton.setText("Reset");
					resetButton.setPreferredSize(new java.awt.Dimension(90, 30));
				}
				{
					jPanel4 = new JPanel();
					GridBagLayout jPanel4Layout = new GridBagLayout();
					jPanel1.add(jPanel4, new GridBagConstraints(0, 4, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
					jPanel4.setPreferredSize(new java.awt.Dimension(51, 81));
					jPanel4Layout.rowWeights = new double[] {0.1, 0.1, 0.1};
					jPanel4Layout.rowHeights = new int[] {7, 7, 7};
					jPanel4Layout.columnWeights = new double[] {0.1};
					jPanel4Layout.columnWidths = new int[] {7};
					jPanel4.setLayout(jPanel4Layout);
					{
						plusButton = new JButton();
						jPanel4.add(plusButton, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						plusButton.setText("+");
						plusButton.setPreferredSize(new java.awt.Dimension(50, 30));
					}
					{
						minusButton = new JButton();
						jPanel4.add(minusButton, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						minusButton.setText("-");
						minusButton.setPreferredSize(new java.awt.Dimension(50, 30));
					}
					{
						jLabelFontSize = new JLabel();
						jPanel4.add(jLabelFontSize, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						jLabelFontSize.setFont(new Font(Font.DIALOG, Font.PLAIN, 10));
						jLabelFontSize.setText("Font Size");
					}
				}

			}
			
			this.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent evt) {
					thisWindowClosing(evt);
				}
			});
			
			startButton.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	            	startButtonListener(evt);
	            }
	        });

			resetButton.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	            	resetButtonListener(evt);
	            }
	        });

			jTextFieldStNr.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	            	try { stNrFieldListener(evt);} catch (IOException e) { e.printStackTrace(); }
	            }
	        });
			
			plusButton.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	            	plusButtonListener(evt);
	            }
	        });
			
			minusButton.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	            	minusButtonListener(evt);
	            }
	        });
			
			pack();
			this.setSize(609, 394);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}

	private void startButtonListener(ActionEvent evt) {
		if (evt.getActionCommand().equals("Start")) {
			startButton.setText("Pause");
	        action = "start";
		} else if (evt.getActionCommand().equals("Pause")) {
			action = "suspend";
			startButton.setText("Resume");
		} else {
			action = "resume";
			startButton.setText("Pause");
		}

		try { Thread.sleep(100); } catch (InterruptedException e) { e.printStackTrace(); }
		jTextFieldStNr.requestFocus();
	}

	private void resetButtonListener(ActionEvent evt) {
		action = "reset";
		startButton.setText("Start");
		jTextFieldStNr.requestFocus();
	}

	private void stNrFieldListener(ActionEvent evt) throws IOException {
		
		counter++;
		
        openCsv();
		csvFile.append(counter + ";");
        csvFile.append(jTextFieldStNr.getText() + ";");
        csvFile.append(uhrzeitAusgabe.getText() + ";");
		csvFile.append(stoppuhrAusgabe.getText() + "\n");
		closeCsv();
		
		jTextArea.append(counter + " - ");
		jTextArea.append(uhrzeitAusgabe.getText() + " - ");
		jTextArea.append(stoppuhrAusgabe.getText() + " - ");
		jTextArea.append(jTextFieldStNr.getText() + "\n");

		jTextFieldStNr.setText("");
		jTextFieldStNr.requestFocus();
	}
	
	private void plusButtonListener(ActionEvent evt) {
		uhrFontSize = uhrFontSize + 10;
		stoppuhrAusgabe.setFont(new Font(Font.DIALOG, Font.BOLD, uhrFontSize));
		uhrzeitAusgabe.setFont(new Font(Font.DIALOG, Font.BOLD, uhrFontSize));
		jTextFieldStNr.requestFocus();
	}
	
	private void minusButtonListener(ActionEvent evt) {
		uhrFontSize = uhrFontSize - 10;
		stoppuhrAusgabe.setFont(new Font(Font.DIALOG, Font.BOLD, uhrFontSize));
		uhrzeitAusgabe.setFont(new Font(Font.DIALOG, Font.BOLD, uhrFontSize));
		jTextFieldStNr.requestFocus();
	}
	
	private void thisWindowClosing(WindowEvent evt) {   
    	System.exit(0);
	}

	
	public void openCsv() {
	  	try {
	  		csvFile = new FileWriter("times.csv", true);
			//csvFile.append("time;antenna;serial;\n");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
        }
	}
	
	public void closeCsv() {
        try {
			csvFile.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
    
	class StoppUhrThread extends Thread{	    
	
	    public void run(){
	    	StopWatch stopWatch = new StopWatch();

	    	while(true){
		    	if(action.equals("start"))    {stopWatch.start();   action = ""; }
		    	if(action.equals("suspend"))  {stopWatch.suspend(); action = ""; }
		    	if(action.equals("reset"))    {stopWatch.reset();   action = ""; }
		    	if(action.equals("resume"))   {stopWatch.resume();  action = ""; }
		    	
		    	try{Thread.sleep(200);}catch(Exception e){}
		    	if(stopWatch.toString().length() == 11) {
		    		displayString = "0" + stopWatch.toString().substring(0,7);
		    	} else {
		    		displayString = stopWatch.toString().substring(0,7);		    		
		    	}
		    	
		    	stoppuhrAusgabe.setText(displayString);
		    	
		    	//System.out.println(stopWatch.toString());
		    	//System.out.println(stopWatch.toString().length());
	       }
	    }
	    
	}


	class UhrzeitThread extends Thread{
	
		public void run(){
			
			while(true){
				Calendar calendar = Calendar.getInstance();
				calendar.setTimeZone(TimeZone.getTimeZone("CET"));
				DateFormat fmt = new SimpleDateFormat("HH:mm:ss");
				//System.out.println(fmt.format(calendar.getTime()));
				
				try{Thread.sleep(200);}catch(Exception e){}
				uhrzeitAusgabe.setText(fmt.format(calendar.getTime()));
		  }
		}
	}
}
