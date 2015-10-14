import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JMenuBar;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JTextArea;
import javax.swing.JScrollBar;



public class MainPanel {
    
    private JFrame frame;
    private JTextField UserID;
    private JTextField PatientChangeValue;
    private JTextField FindPatientTextfield;
    private JTextField DoctorTextfield;
    private JTextArea txtrPatientwindow;
    private JTextArea txtrGuardianwindow;
    private JTextArea planWindow;
    private JTextArea AllergyWindow;
    private JTextArea AdministratorConsole;
    private JTextArea FamilyHistoryWindow;
    private JTextArea AuthorWindow;
    private JTextArea InsuranceWindow;
    private JTextArea LabTestWindow;
    private JComboBox Patient_1;
    private JComboBox Patient_2;
    private JComboBox Doctor_1;
    private JComboBox Doctor_2;
    private JComboBox Doctor_3;
    private Controller c;
    private Database db;
    private JTextField SubstanceIDTextfield;
    
    /**
     * Launch the application.
     */
    
    /**
     * Create the application.
     */
    public MainPanel(Database db) {
    	this.db = db;
        initialize();
        c = new Controller(db);
    }
    
    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 814, 544);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        frame.getContentPane().add(tabbedPane, BorderLayout.CENTER);
        
        JPanel panel = new JPanel();
        tabbedPane.addTab("Doctor/Author", null, panel, null);
        panel.setLayout(null);
        
        JLabel lblNewLabel_3 = new JLabel("Find Patient ID");
        lblNewLabel_3.setFont(new Font("Lucida Grande", Font.PLAIN, 19));
        lblNewLabel_3.setBounds(24, 22, 153, 35);
        panel.add(lblNewLabel_3);
        
        FindPatientTextfield = new JTextField();
        FindPatientTextfield.setBounds(189, 28, 162, 28);
        panel.add(FindPatientTextfield);
        FindPatientTextfield.setColumns(10);
        
        JButton DoctorLogin = new JButton("Find");
        DoctorLogin.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
        DoctorLogin.setBounds(397, 22, 153, 42);
        DoctorLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	DoctorLoginActionPerformed(e);
            }
        });
        panel.add(DoctorLogin);
        
        Doctor_1 = new JComboBox();
        Doctor_1.setBounds(24, 77, 135, 27);
        panel.add(Doctor_1);
        setDoctor_1ComboItems();
        Doctor_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	setDoctor_2ComboItems();
            }
        });
        
        Doctor_2 = new JComboBox();
        Doctor_2.setBounds(171, 77, 121, 27);
        setDoctor_2ComboItems();
        panel.add(Doctor_2);
        
        
        DoctorTextfield = new JTextField();
        DoctorTextfield.setBounds(447, 76, 134, 28);
        panel.add(DoctorTextfield);
        DoctorTextfield.setColumns(10);
        
        JButton DoctorChange = new JButton("Change");
        DoctorChange.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		doctorChangeActionPerformed(e);
        	}
        });
        DoctorChange.setBounds(593, 69, 134, 42);
        panel.add(DoctorChange);
        
        planWindow = new JTextArea();
        planWindow.setWrapStyleWord(true);
        planWindow.setLineWrap(true);
        planWindow.setText("PlanWindow");
        planWindow.setBounds(24, 116, 763, 56);
        
        panel.add(planWindow);
        
        AllergyWindow = new JTextArea();
        AllergyWindow.setWrapStyleWord(true);
        AllergyWindow.setLineWrap(true);
        AllergyWindow.setText("AllergyWindow");
        AllergyWindow.setBounds(24, 184, 763, 53);
        panel.add(AllergyWindow);
        
        Doctor_3 = new JComboBox();
        Doctor_3.setBounds(304, 77, 131, 27);
        panel.add(Doctor_3);
        
        FamilyHistoryWindow = new JTextArea();
        FamilyHistoryWindow.setWrapStyleWord(true);
        FamilyHistoryWindow.setLineWrap(true);
        FamilyHistoryWindow.setBounds(24, 249, 761, 35);
        panel.add(FamilyHistoryWindow);
        
        AuthorWindow = new JTextArea();
        AuthorWindow.setLineWrap(true);
        AuthorWindow.setWrapStyleWord(true);
        AuthorWindow.setBounds(24, 295, 763, 28);
        panel.add(AuthorWindow);
        
        InsuranceWindow = new JTextArea();
        InsuranceWindow.setWrapStyleWord(true);
        InsuranceWindow.setLineWrap(true);
        InsuranceWindow.setBounds(24, 335, 763, 50);
        panel.add(InsuranceWindow);
        
        LabTestWindow = new JTextArea();
        LabTestWindow.setWrapStyleWord(true);
        LabTestWindow.setLineWrap(true);
        LabTestWindow.setBounds(24, 397, 763, 73);
        panel.add(LabTestWindow);
        
        JPanel panel_1 = new JPanel();
        tabbedPane.addTab("Patient", null, panel_1, null);
        panel_1.setLayout(null);
        
        UserID = new JTextField();
        UserID.setBounds(144, 24, 160, 28);
        panel_1.add(UserID);
        UserID.setColumns(10);
        
        JLabel lblNewLabel = new JLabel("Patient ID");
        lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
        lblNewLabel.setBounds(39, 14, 117, 43);
        panel_1.add(lblNewLabel);
        
        JButton PatientLogin = new JButton("Login");
        PatientLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	patientLoginActionPerformed(e);
            }
        });
        PatientLogin.setBounds(332, 19, 196, 40);
        panel_1.add(PatientLogin);
        
        Patient_1 = new JComboBox();
        Patient_1.setBounds(39, 88, 146, 27);
        Patient_1.addItem("PATIENTS");
        Patient_1.addItem("GUARDIANS");
        Patient_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	setPatientComboItems();
            }
        });
        panel_1.add(Patient_1);
        
        Patient_2 = new JComboBox();
        Patient_2.setBounds(220, 88, 129, 27);
        setPatientComboItems();
        panel_1.add(Patient_2);
        
        PatientChangeValue = new JTextField();
        PatientChangeValue.setBounds(385, 87, 134, 28);
        panel_1.add(PatientChangeValue);
        PatientChangeValue.setColumns(10);
        
        JButton PatientChange = new JButton("Change");
        PatientChange.setBounds(531, 87, 117, 29);
        PatientChange.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	patientChangeActionPerformed(e);
            }
        });
        panel_1.add(PatientChange);
        
        txtrPatientwindow = new JTextArea();
        txtrPatientwindow.setWrapStyleWord(true);
        txtrPatientwindow.setLineWrap(true);
        txtrPatientwindow.setText("PatientWindow");
        txtrPatientwindow.setBounds(39, 183, 583, 51);
        panel_1.add(txtrPatientwindow);
        
        txtrGuardianwindow = new JTextArea();
        txtrGuardianwindow.setWrapStyleWord(true);
        txtrGuardianwindow.setLineWrap(true);
        txtrGuardianwindow.setText("GuardianWindow");
        txtrGuardianwindow.setBounds(39, 249, 583, 51);
        panel_1.add(txtrGuardianwindow);
        
        JPanel panel_2 = new JPanel();
        tabbedPane.addTab("Administrator", null, panel_2, null);
        panel_2.setLayout(null);
        
        AdministratorConsole = new JTextArea();
        AdministratorConsole.setLineWrap(true);
        AdministratorConsole.setWrapStyleWord(true);
        AdministratorConsole.setBounds(45, 217, 597, 85);
        panel_2.add(AdministratorConsole);
        
        JLabel lblNewLabel_1 = new JLabel("View number of patients for each type of allergy (substance).");
        lblNewLabel_1.setBounds(293, 30, 387, 16);
        panel_2.add(lblNewLabel_1);
        
        JButton Function1Button = new JButton("Function1");
        Function1Button.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Function1ActionPerformed(e);
        	}
        });
        Function1Button.setBounds(45, 59, 123, 36);
        panel_2.add(Function1Button);
        
        JButton Function2Button = new JButton("Function2");
        Function2Button.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Function2ActionPerformed(e);
        	}
        });
        Function2Button.setBounds(45, 107, 130, 36);
        panel_2.add(Function2Button);
        
        JButton Function3Button = new JButton("Function3");
        Function3Button.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Function3ActionPerformed(e);
        	}
        });
        Function3Button.setBounds(45, 155, 130, 36);
        panel_2.add(Function3Button);
        
        JLabel lblListThePatients = new JLabel("List the patients who have more than one allergy.");
        lblListThePatients.setBounds(192, 68, 488, 16);
        panel_2.add(lblListThePatients);
        
        JLabel lblListThe = new JLabel("List the patients who have a plan for surgery today.");
        lblListThe.setBounds(192, 116, 488, 16);
        panel_2.add(lblListThe);
        
        JLabel lblIdentifyAuthorsWith = new JLabel("Identify authors with more than one patient.");
        lblIdentifyAuthorsWith.setBounds(192, 164, 488, 16);
        panel_2.add(lblIdentifyAuthorsWith);
        
        JButton ButtonGo = new JButton("GO");
        ButtonGo.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		administratorComboBoxSelectActionPerformed(e);
        	}
        });
        ButtonGo.setBounds(164, 25, 117, 29);
        panel_2.add(ButtonGo);
        
        SubstanceIDTextfield = new JTextField();
        SubstanceIDTextfield.setBounds(34, 24, 134, 28);
        panel_2.add(SubstanceIDTextfield);
        SubstanceIDTextfield.setColumns(10);
        
        frame.setVisible( true );
    }
    
    
    
    private void patientLoginActionPerformed(ActionEvent e)
    {
    	System.out.print("see me?");
    	try{
    	txtrPatientwindow.setText(c.getPatientInfo(UserID.getText()));
    	txtrGuardianwindow.setText(c.getGuardianInfo(UserID.getText()));
    	}
    	catch(SQLException e1)
    	{
    		e1.printStackTrace();
    	}
    }
    private void setPatientComboItems()
    {
    	Patient_2.removeAllItems();
    	if(Patient_1.getSelectedItem() == "PATIENTS")
    	{
    		Patient_2.addItem("PatientID");
    		Patient_2.addItem("GivenName");
    		Patient_2.addItem("FamilyName");
    		Patient_2.addItem("Suffix");
    		Patient_2.addItem("Gender");
    		Patient_2.addItem("Birthtime");
    		Patient_2.addItem("ProviderID");
    		Patient_2.addItem("InsuranceID");
    		Patient_2.addItem("Relationship");
    	}
    	
    	else
    	{
    		Patient_2.addItem("GuardianNo");
    		Patient_2.addItem("GivenName");
    		Patient_2.addItem("FamilyName");
    		Patient_2.addItem("Phone");
    		Patient_2.addItem("Address");
    		Patient_2.addItem("City");
    		Patient_2.addItem("State");
    		Patient_2.addItem("Zip");
    	}
    }
    
    private void setDoctor_1ComboItems()
    {
    	Doctor_1.removeAllItems();
    	Doctor_1.addItem("PLANS");
    	Doctor_1.addItem("ALLERGIES");
    }
    
    private void setDoctor_2ComboItems()
    {
    	Doctor_2.removeAllItems();
    	if(Doctor_1.getSelectedItem() == "PLANS")
    	{
    		Doctor_2.addItem("PlanID");
    		Doctor_2.addItem("PlanDate");
    		Doctor_2.addItem("Activity");
    		Doctor_2.addItem("PatientID");	
    	}
    	
    	else
    	{
    		Doctor_2.addItem("AllergyStatus");
    		Doctor_2.addItem("Reaction");
    		setDoctor_3ComboItems();
    	}
    }
    
    private void setDoctor_3ComboItems()
    {
    	Doctor_3.removeAllItems();
    	try{
    	ArrayList<String> al = c.getAllergyRelationIndex(FindPatientTextfield.getText());
    	for(int i = 0; i<al.size();i++)
    	{
    		Doctor_3.addItem(al.get(i));
    	}
    	}
    	catch(SQLException s)
    	{
    		
    	}
    	
    }
    
    private void patientChangeActionPerformed(ActionEvent e) 
    {
    	String IDName;
    	if(Patient_1.getSelectedItem() == "PATIENTS")
    	{
    		IDName = "PatientID";
    	}
    	else
    	{
    		IDName = "GuardianNo";
    	}
    	
    	try{
    	c.updateAttribute(Patient_1.getSelectedItem().toString(), Patient_2.getSelectedItem().toString(), PatientChangeValue.getText(), UserID.getText(), IDName);
    	}
    	catch(SQLException s)
    	{
    		
    	}
    }
    
    private void doctorChangeActionPerformed(ActionEvent e)
    {
    	if(Doctor_1.getSelectedItem() == "PLANS")
    	{	
    		try{
    		c.updateAttribute(Doctor_1.getSelectedItem().toString(), Doctor_2.getSelectedItem().toString(), DoctorTextfield.getText(), FindPatientTextfield.getText(), "PatientID");
    		}
    		catch(SQLException s)
    		{
    			
    		}
    	}
    	
    	else
    	{
    		try{
    			c.updateAllergy(Doctor_2.getSelectedItem().toString(), DoctorTextfield.getText(), FindPatientTextfield.getText(), Doctor_3.getSelectedIndex());
    		}
    		catch(SQLException s)
    		{
    			
    		}
    	}
    }
    
    private void DoctorLoginActionPerformed(ActionEvent e)
    {
    	try{
    	planWindow.setText(c.getPlanInfo(FindPatientTextfield.getText()));
    	AllergyWindow.setText(c.getAllergyInfo(FindPatientTextfield.getText()));
    	FamilyHistoryWindow.setText(c.getFamilyHistory(FindPatientTextfield.getText()));
    	AuthorWindow.setText(c.getAuthorsWithPID(FindPatientTextfield.getText()));
    	InsuranceWindow.setText(c.getInsuranceWithPatientID(FindPatientTextfield.getText()));
    	LabTestWindow.setText(c.getVisitResult(FindPatientTextfield.getText()));
    	}
    	catch(SQLException s)
    	{
    		
    	}
    }
    
    private void administratorComboBoxSelectActionPerformed(ActionEvent e)
    {
    	try
    	{
    		String s = c.countPatientFromAllergy(SubstanceIDTextfield.getText())+"";
    		AdministratorConsole.setText(s);
    	}
    	catch(SQLException s)
    	{
    		
    	}
    }
    
    private void Function1ActionPerformed(ActionEvent e)
    {
    	try
    	{
    		AdministratorConsole.setText(c.getPatientsWithManyA());
    		System.out.print(c.getPatientsWithManyA());
    	}
    	catch(SQLException s)
    	{
    		
    	}
    }
    
    private void Function2ActionPerformed(ActionEvent e)
    {
    	try{
    	AdministratorConsole.setText(c.getPatientsWithS());
    	}
    	catch(SQLException s)
    	{
    		
    	}
    }
    
    private void Function3ActionPerformed(ActionEvent e)
    {
    	try
    	{
    		AdministratorConsole.setText(c.getAuthorsWithManyP());
    	}
    	catch(SQLException s)
    	{
    		
    	}
    }
    
}

