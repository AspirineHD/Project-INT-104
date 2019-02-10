package test;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class sqliteAppDEMO {

	private JFrame frame;
	private JTextField textField_input;
	private JTextField textField_INPUT_char;
	private JTextField textField_INPUT_meaning;
	private JTextField textField_INPUT_reading;
	private JLabel display_CHAR_main;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					sqliteAppDEMO window = new sqliteAppDEMO();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	sqliteProgram app = new sqliteProgram();
	private JTextField textField_INPUT_edit;
	private JTextField textField_INPUT_MEANING_edit;
	private JTextField textField_INPUT_READING_edit;
	
	/**
	 * Create the application.
	 */
	public sqliteAppDEMO() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 710, 434);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		JPanel main = new JPanel();
		frame.getContentPane().add(main, "name_420923129244618");
		main.setLayout(null);
		
		JButton btnDisplay = new JButton("Display");
		btnDisplay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				display_CHAR_main.setText(app.select(Integer.parseInt(textField_input.getText())));
			}
		});
		btnDisplay.setBounds(176, 254, 89, 23);
		main.add(btnDisplay);
		
		display_CHAR_main = new JLabel("漢字");
		display_CHAR_main.setHorizontalAlignment(SwingConstants.CENTER);
		display_CHAR_main.setFont(new Font("Yu Gothic", Font.BOLD, 99));
		display_CHAR_main.setBounds(176, 11, 346, 187);
		main.add(display_CHAR_main);
		
		textField_input = new JTextField();
		textField_input.setBounds(301, 255, 184, 20);
		main.add(textField_input);
		textField_input.setColumns(10);
		
		JButton btnNewButton = new JButton("EDIT");
		btnNewButton.setBounds(10, 11, 89, 23);
		main.add(btnNewButton);
		
		JPanel insert = new JPanel();
		frame.getContentPane().add(insert, "name_421175089160741");
		insert.setLayout(null);
		
		textField_INPUT_char = new JTextField();
		textField_INPUT_char.setBounds(293, 107, 192, 37);
		insert.add(textField_INPUT_char);
		textField_INPUT_char.setColumns(10);
		
		textField_INPUT_meaning = new JTextField();
		textField_INPUT_meaning.setColumns(10);
		textField_INPUT_meaning.setBounds(293, 175, 192, 37);
		insert.add(textField_INPUT_meaning);
		
		textField_INPUT_reading = new JTextField();
		textField_INPUT_reading.setColumns(10);
		textField_INPUT_reading.setBounds(293, 246, 192, 37);
		insert.add(textField_INPUT_reading);
		
		JLabel lblKanji = new JLabel("Kanji");
		lblKanji.setBounds(168, 118, 46, 14);
		insert.add(lblKanji);
		
		JLabel lblReading = new JLabel("Reading");
		lblReading.setBounds(168, 257, 46, 14);
		insert.add(lblReading);
		
		JLabel lblMeaning = new JLabel("Meaning");
		lblMeaning.setBounds(168, 186, 46, 14);
		insert.add(lblMeaning);
		
		JButton btn_Add = new JButton("ADD");
		btn_Add.setBounds(286, 308, 89, 23);
		insert.add(btn_Add);
		
		JButton btn_Back = new JButton("Back");
		btn_Back.setBounds(595, 361, 89, 23);
		insert.add(btn_Back);
		
		JPanel edit = new JPanel();
		frame.getContentPane().add(edit, "name_424123191911658");
		edit.setLayout(null);
		
		textField_INPUT_edit = new JTextField();
		textField_INPUT_edit.setBounds(86, 74, 105, 28);
		edit.add(textField_INPUT_edit);
		textField_INPUT_edit.setColumns(10);
		
		JLabel layout_suggestion = new JLabel("which character do you want to edit");
		layout_suggestion.setBounds(53, 49, 177, 14);
		edit.add(layout_suggestion);
		
		JButton btn_OK = new JButton("OK");
		btn_OK.setBounds(96, 113, 89, 23);
		edit.add(btn_OK);
		
		JLabel layout_kanji = new JLabel("漢字");
		layout_kanji.setFont(new Font("Yu Gothic", Font.BOLD, 60));
		layout_kanji.setHorizontalAlignment(SwingConstants.CENTER);
		layout_kanji.setBounds(293, 27, 147, 123);
		edit.add(layout_kanji);
		
		JLabel label_meaning = new JLabel("Meaning");
		label_meaning.setHorizontalAlignment(SwingConstants.CENTER);
		label_meaning.setBounds(266, 216, 50, 23);
		edit.add(label_meaning);
		
		JLabel label_reading = new JLabel("Reading");
		label_reading.setHorizontalAlignment(SwingConstants.CENTER);
		label_reading.setBounds(266, 264, 50, 23);
		edit.add(label_reading);
		
		textField_INPUT_MEANING_edit = new JTextField();
		textField_INPUT_MEANING_edit.setColumns(10);
		textField_INPUT_MEANING_edit.setBounds(358, 217, 169, 28);
		edit.add(textField_INPUT_MEANING_edit);
		
		textField_INPUT_READING_edit = new JTextField();
		textField_INPUT_READING_edit.setFont(new Font("Yu Gothic", Font.PLAIN, 11));
		textField_INPUT_READING_edit.setColumns(10);
		textField_INPUT_READING_edit.setBounds(358, 265, 169, 28);
		edit.add(textField_INPUT_READING_edit);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.setBounds(399, 317, 89, 23);
		edit.add(btnEdit);
		
		JLabel layout_meaning = new JLabel("meaning");
		layout_meaning.setFont(new Font("Yu Gothic", Font.PLAIN, 14));
		layout_meaning.setHorizontalAlignment(SwingConstants.CENTER);
		layout_meaning.setBounds(475, 59, 136, 28);
		edit.add(layout_meaning);
		
		JLabel layout_reading = new JLabel("reading");
		layout_reading.setFont(new Font("Yu Gothic", Font.PLAIN, 14));
		layout_reading.setHorizontalAlignment(SwingConstants.CENTER);
		layout_reading.setBounds(475, 93, 136, 23);
		edit.add(layout_reading);
	}
}
