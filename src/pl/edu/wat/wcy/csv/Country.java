package pl.edu.wat.wcy.csv;

public class Country {
	private String country;
	private String capital;
	private int population;

	public Country(String coun, String cap, int pop) {
		country = coun.trim();
		capital = cap.trim();
		population = pop;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCapital() {
		return capital;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}
}
