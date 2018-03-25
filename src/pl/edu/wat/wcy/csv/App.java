package pl.edu.wat.wcy.csv;

import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.Dimension;

public class App extends JFrame {
	private Object[][] data;
	private String[] columnNames = { "Country", "Capital", "Population" };
	private DefaultTableModel tableModel;
	private JTable table;
	private CountryList myList;

	public App(String title) {
		super(title);
		setBounds(10, 10, 400, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myList = new CountryList();
		myList.readFromCSV("data/country.csv");
		data = myList.convert2Data();
		tableModel = new DefaultTableModel(data, columnNames);
		table = new JTable(tableModel);
		table.setAutoCreateRowSorter(true);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setPreferredSize(new Dimension(380, 280));
		JPanel panel = new JPanel();
		panel.add(scrollPane);
		add(panel, BorderLayout.CENTER);
	}

	public static void main(String[] args) {
		App myApp = new App("Basic JTable");
		myApp.setVisible(true);
	}
}
