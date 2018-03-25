package pl.edu.wat.wcy.csv;

import java.util.ArrayList;
import java.io.*; //File,FileReader,FileNotFoundException,BufferedReader,IOException

public class CountryList {
	private ArrayList<Country> books;

	public CountryList() {
      books = new ArrayList<Country>();
   }

	public void add(Country sb) {
		books.add(sb);
	}

	public void readFromCSV(String filename) {
		File file = new File(filename);
		FileReader reader = null;
		try {
			reader = new FileReader(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.exit(1);
		}
		BufferedReader infile = new BufferedReader(reader);
		String line = "";
		try {
			boolean done = false;
			while (!done) {
				line = infile.readLine();
				if (line == null) {
					done = true;
				} else {
					String[] tokens = line.trim().split(";");
					String country = tokens[0].trim();
					String capital = tokens[1].trim();
					int population = Integer.parseInt(tokens[2].trim());
					Country sb = new Country(country, capital, population);
					books.add(sb);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	public Object[][] convert2Data() {
		Object[][] data = new Object[books.size()][3];
		for (int i = 0; i < books.size(); i++) {
			data[i][0] = books.get(i).getCountry();
			data[i][1] = books.get(i).getCapital();
			data[i][2] = new Double(books.get(i).getPopulation());
		}
		return data;
	}
}