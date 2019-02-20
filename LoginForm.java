import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


class LoginForm extends JFrame{

	private JCheckBox boldBox;
	private JCheckBox italicBox;
	private JButton login;
	private JTextField email;
	private JPasswordField password;

	public LoginForm(){
		super("Login Fool");

		setLayout(new FlowLayout());

		email =  new JTextField(20);
		email.setFont(new Font("Serif" , Font.PLAIN , 15));
		add(email);

		password = new JPasswordField(20);
		add(password);

		italicBox = new JCheckBox("Italic");
		add(italicBox);

		boldBox = new JCheckBox("Bold");
		add(boldBox);

		login = new JButton("Login");
		add(login);

		HandleFieldChange  onSubmit = new HandleFieldChange();
		HandleCheckChange onCheck = new HandleCheckChange();


		email.addActionListener(onSubmit);
		password.addActionListener(onSubmit);
		login.addActionListener(onSubmit);


		italicBox.addItemListener(onCheck);
		boldBox.addItemListener(onCheck);

	}


	public class HandleFieldChange implements ActionListener{

		public void actionPerformed(ActionEvent e){

			String email = "";
			String password = "";

			if(e.getSource() == email){
				email = String.format("Email is: %s" , e.getActionCommand());
			}else if( e.getSource() == password ){
				password = String.format("Password is: %s" , e.getActionCommand());
			}
		}

	}

	public class HandleCheckChange implements ItemListener{
		public void itemStateChanged( ItemEvent e ){

			Font font = null;

			if(boldBox.isSelected() && italicBox.isSelected() ){
				font = new Font("Serif" , Font.BOLD + Font.ITALIC , 15);
			}else if(italicBox.isSelected()){
				font = new Font("Serif" , Font.ITALIC , 15);
			}else if(boldBox.isSelected()){
				font = new Font("Serif" , Font.BOLD , 15);				
			}else{
				font = new Font("Serif" , Font.PLAIN , 15);
			}

			email.setFont(font);

		}
	}

}