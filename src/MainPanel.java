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
import javax.swing.JTextArea;



public class MainPanel {
    
    private JFrame frame;
    private JTextField UserID;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MainPanel window = new MainPanel();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    
    /**
     * Create the application.
     */
    public MainPanel() {
        initialize();
    }
    
    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 754, 392);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        frame.getContentPane().add(tabbedPane, BorderLayout.CENTER);
        
        JPanel panel = new JPanel();
        tabbedPane.addTab("Doctor/Author", null, panel, null);
        panel.setLayout(null);
        
        JLabel lblNewLabel_2 = new JLabel("Doctor/Author ID");
        lblNewLabel_2.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
        lblNewLabel_2.setBounds(24, 6, 175, 35);
        panel.add(lblNewLabel_2);
        
        JButton btnNewButton = new JButton("Login");
        btnNewButton.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnNewButton.setBounds(426, 7, 153, 35);
        panel.add(btnNewButton);
        
        textField_1 = new JTextField();
        textField_1.setBounds(218, 12, 175, 28);
        panel.add(textField_1);
        textField_1.setColumns(10);
        
        JLabel lblNewLabel_3 = new JLabel("Find Patient ID");
        lblNewLabel_3.setFont(new Font("Lucida Grande", Font.PLAIN, 19));
        lblNewLabel_3.setBounds(24, 60, 153, 35);
        panel.add(lblNewLabel_3);
        
        textField_2 = new JTextField();
        textField_2.setBounds(189, 66, 162, 28);
        panel.add(textField_2);
        textField_2.setColumns(10);
        
        JButton btnNewButton_1 = new JButton("Find");
        btnNewButton_1.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
        btnNewButton_1.setBounds(360, 60, 153, 42);
        panel.add(btnNewButton_1);
        
        JComboBox comboBox_2 = new JComboBox();
        comboBox_2.setBounds(24, 123, 103, 27);
        panel.add(comboBox_2);
        
        JComboBox comboBox_3 = new JComboBox();
        comboBox_3.setBounds(163, 123, 112, 27);
        panel.add(comboBox_3);
        
        textField_3 = new JTextField();
        textField_3.setBounds(301, 121, 134, 28);
        panel.add(textField_3);
        textField_3.setColumns(10);
        
        JButton btnNewButton_2 = new JButton("Change");
        btnNewButton_2.setBounds(462, 114, 134, 42);
        panel.add(btnNewButton_2);
        
        JTextArea txtrSadf = new JTextArea();
        txtrSadf.setText("PlanWindow");
        txtrSadf.setBounds(24, 168, 585, 56);
        panel.add(txtrSadf);
        
        JTextArea txtrAllergywindow = new JTextArea();
        txtrAllergywindow.setText("AllergyWindow");
        txtrAllergywindow.setBounds(24, 236, 585, 56);
        panel.add(txtrAllergywindow);
        
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
        
        JButton btnLogin = new JButton("Login");
        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnLogin.setBounds(332, 19, 196, 40);
        panel_1.add(btnLogin);
        
        JComboBox comboBox = new JComboBox();
        comboBox.setBounds(39, 88, 146, 27);
        panel_1.add(comboBox);
        
        JComboBox comboBox_1 = new JComboBox();
        comboBox_1.setBounds(220, 88, 129, 27);
        panel_1.add(comboBox_1);
        
        textField = new JTextField();
        textField.setBounds(385, 87, 134, 28);
        panel_1.add(textField);
        textField.setColumns(10);
        
        JButton btnChange = new JButton("Change");
        btnChange.setBounds(531, 87, 117, 29);
        panel_1.add(btnChange);
        
        JTextArea txtrPatientwindow = new JTextArea();
        txtrPatientwindow.setText("PatientWindow");
        txtrPatientwindow.setBounds(39, 186, 583, 51);
        panel_1.add(txtrPatientwindow);
        
        JTextArea txtrGuardianwindow = new JTextArea();
        txtrGuardianwindow.setText("GuardianWindow");
        txtrGuardianwindow.setBounds(39, 249, 583, 51);
        panel_1.add(txtrGuardianwindow);
        
        JPanel panel_2 = new JPanel();
        tabbedPane.addTab("Administrator", null, panel_2, null);
        panel_2.setLayout(null);
        
        JTextArea textArea = new JTextArea();
        textArea.setBounds(45, 217, 597, 85);
        panel_2.add(textArea);
        
        JComboBox comboBox_4 = new JComboBox();
        comboBox_4.setBounds(45, 21, 123, 36);
        panel_2.add(comboBox_4);
        
        JLabel lblNewLabel_1 = new JLabel("View number of patients for each type of allergy (substance).");
        lblNewLabel_1.setBounds(192, 30, 488, 16);
        panel_2.add(lblNewLabel_1);
        
        JButton btnNewButton_3 = new JButton("Function1");
        btnNewButton_3.setBounds(45, 59, 123, 36);
        panel_2.add(btnNewButton_3);
        
        JButton btnNewButton_4 = new JButton("Function2");
        btnNewButton_4.setBounds(45, 107, 130, 36);
        panel_2.add(btnNewButton_4);
        
        JButton btnFunction = new JButton("Function3");
        btnFunction.setBounds(45, 155, 130, 36);
        panel_2.add(btnFunction);
        
        JLabel lblListThePatients = new JLabel("List the patients who have more than one allergy.");
        lblListThePatients.setBounds(192, 68, 488, 16);
        panel_2.add(lblListThePatients);
        
        JLabel lblListThe = new JLabel("List the patients who have a plan for surgery today.");
        lblListThe.setBounds(192, 116, 488, 16);
        panel_2.add(lblListThe);
        
        JLabel lblIdentifyAuthorsWith = new JLabel("Identify authors with more than one patient.");
        lblIdentifyAuthorsWith.setBounds(192, 164, 488, 16);
        panel_2.add(lblIdentifyAuthorsWith);
    }
}