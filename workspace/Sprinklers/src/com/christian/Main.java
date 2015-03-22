package com.christian;








import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JFrame;
//import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

//main sprinkler class, includes GUI.


public class Main {

	Main parent;
	
	
	JLabel connStatus,output,enabled;
	JPanel window;
	JPanel connectInfo,outputPan;
	JPanel sprinklerList;
	
		JLabel	l1,l2,l3,l4,l5,l6,
			  	l7,l8,l9,l10,l11,l12;
		
		JTextField 	t1,t2,t3,t4,t5,t6,
					t7,t8,t9,t10,t11,t12;
		
		JLabel 	e1,e2,e3,e4,e5,e6,
				e7,e8,e9,e10,e11,e12;
		
		JRadioButton r1,r2,r3,r4,r5,r6,
					 r7,r8,r9,r10,r11,r12;
		
	
	JTextField custInput,address,port;
	JButton send,connect,disconnect;
	JPanel customMessage,connInfo,programbox;
	JComboBox<String[]> programs;
	JRadioButton enabledProgram;
	
	ArrayList<JLabel> asprinklers;
	
	String[] programsList = {"Summer","Winter","number2"};
	String[] sprinkLabels = { 	"One",
								"Two",
								"three",
								"Fower",
								"cinco",
								"seis",
								"seven",
								"octo",
								"nova",
								"decka",
								"once",
								"dozen"};
	
	
	
	Main(){
		SprinklerEngine engine = new SprinklerEngine(this);
		
		window = new JPanel();
		connInfo = new JPanel();
		customMessage = new JPanel();	
		programbox = new JPanel();
		sprinklerList = new JPanel();
		outputPan = new JPanel();
		
		connStatus = new JLabel(" Not Connected");
		output = new JLabel("System Output: ",SwingConstants.LEFT);
		enabled = new JLabel(" Enabled");
		
		programs = new JComboBox(programsList);
		
		enabledProgram = new JRadioButton();
		
		custInput = new JTextField(30);
		address = new JTextField(10);
		port = new JTextField(5);
		custInput.setText("Command:");
		address.setText("192.168.2.8");
		port.setText("42001");
		
		send = new JButton("Send");
		connect = new JButton("Connect");
		disconnect = new JButton("Disconnect");
		
		send.addActionListener(engine);
		connect.addActionListener(engine);
		disconnect.addActionListener(engine);
		
		asprinklers = new ArrayList<JLabel>();
		
			for (int i = 0;i < 12;i++){
				//JLabel j = new JLabel("Sprinkler "+i);
				asprinklers.add(new JLabel((i+1)+": "+sprinkLabels[i]));
				
				sprinklerList.add(asprinklers.get(i));
			}
		
		BoxLayout box = new BoxLayout(window, 1);
		/*GridLayout gl2 = new GridLayout();
		customMessage.setLayout(gl);
		connInfo.setLayout(gl);*/
		window.setLayout(box);
		sprinklerList.setLayout(new BoxLayout(sprinklerList,1));
		
		
		connInfo.add(address);
		connInfo.add(port);
		connInfo.add(connect);
		connInfo.add(disconnect);
		connInfo.add(connStatus);
		
		programbox.add(programs);
		programbox.add(enabled);
		programbox.add(enabledProgram);
		
		outputPan.add(output);
		
		customMessage.add(custInput);
		customMessage.add(send);
		
		window.add(connInfo);
		window.add(programbox);
		window.add(sprinklerList);
		window.add(outputPan);
		window.add(customMessage);
		
		JFrame frame = new JFrame("Christian's Sprinkler Pi Program!");
		frame.setContentPane(window);
		
		frame.pack();
		
		frame.setVisible(true);
	}
	
		
	
	public static void main(String[] args) {
		
		
		@SuppressWarnings("unused")
		Main main = new Main();
	
	}
	
	
	public String getText(){
		System.out.println(custInput.getText());
		return custInput.getText();
		
	}
	
	public void setConnStatus(String status){
		connStatus.setText(status);
	}
	
	public String getAddress(){
		return address.getText();
	}
	
	public String getPort(){
		return port.getText();
	}

	public void write(String out){
		output.setText(out);
	}
	
	public void setLabel(int l,String text){
		asprinklers.get(l).setText(text);
	}

}
