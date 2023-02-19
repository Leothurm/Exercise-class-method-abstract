package entitites;

public class Company extends TaxPayer{
	
	private int numberOfEmployees;

	public Company() {
		
	}
	
	public Company(String name, Double anualIncome, int numberOfEmployees) {
		super(name, anualIncome);
		this.numberOfEmployees = numberOfEmployees;
	}

	public int getNumberOfEmployees() {
		return numberOfEmployees;
	}

	public void setNumberOfEmployees(int numberOfEmployees) {
		this.numberOfEmployees = numberOfEmployees;
	}
	
	
	public double tax() {
		if(numberOfEmployees>10) {
			return super.getAnualIncome() * 0.14;
		} else {
			return super.getAnualIncome()*0.16;
		}
	}
	
	@Override
	public String toString(){
		return getName() + ": $ " + String.format("%.2f", tax());
	}
	
}
