import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Fenetre extends JFrame implements ActionListener{

	JButton[] bouton = new JButton[9];

	public Fenetre() {
		this.setSize(600, 400);
		this.setVisible(true);
		initComponents();
		jTextArea1.setFont(new java.awt.Font("Tahoma", 1, 14)); 
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
	
		 
		 if(e.getSource()== nouveau){
			 
			 for(int i =0 ; i != 9 ; i++ ){
				 if(i==8){
					bouton[i].setBackground(new Color(102, 255, 204));
					bouton[i].setText(" "); 
				 }else{
				 bouton[i].setBackground(Color.white);
				 bouton[i].setText(String.valueOf(i+1));
				 }
					 
				 }
				 
			 jTextArea1.setText("");
		 }else if(e.getSource() == executer1){
			 Main.depart.s[0][0]=bouton[0].getText().charAt(0);
			 Main.depart.s[0][1]=bouton[1].getText().charAt(0);
			 Main.depart.s[0][2]=bouton[2].getText().charAt(0);
			 Main.depart.s[1][0]=bouton[3].getText().charAt(0);
			 Main.depart.s[1][1]=bouton[4].getText().charAt(0);
			 Main.depart.s[1][2]=bouton[5].getText().charAt(0);
			 Main.depart.s[2][0]=bouton[6].getText().charAt(0);
			 Main.depart.s[2][1]=bouton[7].getText().charAt(0);
			 Main.depart.s[2][2]=bouton[8].getText().charAt(0);
			 
			// on ajout s ï¿½ nv et ï¿½ fr
				// important de donner une clï¿½ ï¿½ 1, de cette maniï¿½re on pourra
				// identifier ses noeuds fils qui auront les clï¿½s 11,12 et 13,
				// et eux mï¿½me auront des fils 111, 112,113 ..
				
				Main.depart.nv.put("1", Main.depart.copier(Main.depart.s));
				
				Main.depart.fr.put("1", Main.depart.copier(Main.depart.s));
			 
			 Main.depart.recherche();
			 
			 jTextArea1.setText(Main.depart.str);
			 
			 Main.depart.str="";
			  Enumeration del = Main.depart.nv.keys();
			  Enumeration f = Main.depart.fr.keys();
			  while(del.hasMoreElements()){
				  Main.depart.nv.remove(del.nextElement());
			  }
			  while(f.hasMoreElements()){
				  Main.depart.fr.remove(f.nextElement());
			  }
			  
			 
		 }else{
		 
			 for(int i =0 ; i != 9 ; i++ ){
				 if(bouton[i].getText().equals(" ")){
					 bouton[i].setText(((JButton)e.getSource()).getText());
					 bouton[i].setBackground(new Color(255,255,255));
					 
					 ((JButton)e.getSource()).setText(" ");
					 ((JButton)e.getSource()).setBackground(new Color(102, 255, 204));
					 
				 }
				 
			 }
		 }
		 
	
		 
		 
		
	}

	private void initComponents() {

		jPanel1 = new JPanel();
		jScrollPane1 = new JScrollPane();
		jTextArea1 = new JTextArea();
		jPanel2 = new javax.swing.JPanel();
		jButton1 = new javax.swing.JButton();
		jButton6 = new javax.swing.JButton();
		jButton4 = new javax.swing.JButton();
		jButton5 = new javax.swing.JButton();
		jButton2 = new javax.swing.JButton();
		jButton7 = new javax.swing.JButton();
		jButton3 = new javax.swing.JButton();
		jButton9 = new javax.swing.JButton();
		jButton8 = new javax.swing.JButton();

		bouton[0] = jButton1;
		bouton[1] = jButton2;
		bouton[2] = jButton3;
		bouton[3] = jButton4;
		bouton[4] = jButton5;
		bouton[5] = jButton6;
		bouton[6] = jButton7;
		bouton[7] = jButton8;
		bouton[8] = jButton9;
		
		for(int i =0 ; i !=9 ; i++){
			bouton[i].addActionListener(this);
			if(i != 9)bouton[i].setBackground(new Color(255,255,255));
		}
		

		nouveau = new javax.swing.JButton();
		executer1 = new javax.swing.JButton();
		
		nouveau.addActionListener(this);
		executer1.addActionListener(this);

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("Taquin");
		setResizable(false);
		setSize(new java.awt.Dimension(400, 400));

		jTextArea1.setColumns(20);
		jTextArea1.setRows(5);
		jScrollPane1.setViewportView(jTextArea1);

		jPanel2.setBackground(new java.awt.Color(153, 153, 153));

		jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
		jButton1.setText("1");
		jButton1.setPreferredSize(new java.awt.Dimension(60, 60));
	
		jButton6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
		jButton6.setText("6");
		jButton6.setPreferredSize(new java.awt.Dimension(60, 60));
	

		jButton4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
		jButton4.setText("4");
		jButton4.setPreferredSize(new java.awt.Dimension(60, 60));
		

		jButton5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
		jButton5.setText("5");
		jButton5.setPreferredSize(new java.awt.Dimension(60, 60));
	
		jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
		jButton2.setText("2");
		jButton2.setPreferredSize(new java.awt.Dimension(60, 60));
	

		jButton7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
		jButton7.setText("7");
		jButton7.setPreferredSize(new java.awt.Dimension(60, 60));
	

		jButton3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
		jButton3.setText("3");
		jButton3.setPreferredSize(new java.awt.Dimension(60, 60));
	

		jButton9.setBackground(new java.awt.Color(102, 255, 204));
		jButton9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
		jButton9.setText(" ");
		jButton9.setPreferredSize(new java.awt.Dimension(60, 60));
		

		jButton8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
		jButton8.setText("8");
		jButton8.setPreferredSize(new java.awt.Dimension(60, 60));
	

		javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(
				jPanel2);
		jPanel2.setLayout(jPanel2Layout);
		jPanel2Layout
				.setHorizontalGroup(jPanel2Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel2Layout
										.createSequentialGroup()
										.addComponent(
												jButton7,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(
												jButton8,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(
												jButton9,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGroup(
								jPanel2Layout
										.createSequentialGroup()
										.addComponent(
												jButton1,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(
												jButton2,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(
												jButton3,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGroup(
								jPanel2Layout
										.createSequentialGroup()
										.addComponent(
												jButton4,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(
												jButton5,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(
												jButton6,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)));
		jPanel2Layout
				.setVerticalGroup(jPanel2Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel2Layout
										.createSequentialGroup()
										.addGroup(
												jPanel2Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																jButton1,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																52,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																jButton2,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																52,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																jButton3,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																52,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												jPanel2Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																jButton4,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																52,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																jButton5,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																52,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																jButton6,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																52,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												jPanel2Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																jButton7,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																52,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																jButton8,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																52,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																jButton9,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																52,
																javax.swing.GroupLayout.PREFERRED_SIZE))));

		nouveau.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
		nouveau.setText("Nouveau");
	
		executer1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
		executer1.setText("Exécuter");
		

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(
				jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout
				.setHorizontalGroup(jPanel1Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel1Layout
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(
												jScrollPane1,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												381,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																jPanel1Layout
																		.createSequentialGroup()
																		.addGap(
																				72,
																				72,
																				72)
																		.addComponent(
																				jPanel2,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addContainerGap(
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				Short.MAX_VALUE))
														.addGroup(
																javax.swing.GroupLayout.Alignment.TRAILING,
																jPanel1Layout
																		.createSequentialGroup()
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																				12,
																				Short.MAX_VALUE)
																		.addComponent(
																				executer1,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				127,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addGap(
																				18,
																				18,
																				18)
																		.addComponent(
																				nouveau,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				127,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addContainerGap()))));
		jPanel1Layout
				.setVerticalGroup(jPanel1Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel1Layout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																jPanel1Layout
																		.createSequentialGroup()
																		.addComponent(
																				jScrollPane1)
																		.addContainerGap())
														.addGroup(
																jPanel1Layout
																		.createSequentialGroup()
																		.addComponent(
																				jPanel2,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																				134,
																				Short.MAX_VALUE)
																		.addGroup(
																				jPanel1Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.BASELINE)
																						.addComponent(
																								nouveau,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								39,
																								javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								executer1,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								39,
																								javax.swing.GroupLayout.PREFERRED_SIZE))
																		.addGap(
																				76,
																				76,
																				76)))));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jPanel1, javax.swing.GroupLayout.Alignment.TRAILING,
				javax.swing.GroupLayout.DEFAULT_SIZE,
				javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jPanel1, javax.swing.GroupLayout.Alignment.TRAILING,
				javax.swing.GroupLayout.DEFAULT_SIZE,
				javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

		pack();
	}// </editor-fold>

	

	// Variables declaration - do not modify
	private javax.swing.JButton executer1;
	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	private javax.swing.JButton jButton3;
	private javax.swing.JButton jButton4;
	private javax.swing.JButton jButton5;
	private javax.swing.JButton jButton6;
	private javax.swing.JButton jButton7;
	private javax.swing.JButton jButton8;
	private javax.swing.JButton jButton9;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTextArea jTextArea1;
	private javax.swing.JButton nouveau;
	// End of variables declaration


}
