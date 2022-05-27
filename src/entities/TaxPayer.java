package entities;

public class TaxPayer {

	private double salaryIncome;
	private double servicesIncome;
	private double capitalIncome;
	private double healthSpending;
	private double educationSpending;
	
	public TaxPayer(double salaryIncome, double servicesIncome, double capitalIncome, double healthSpending,
			double educationSpending) {
		this.salaryIncome = salaryIncome;
		this.servicesIncome = servicesIncome;
		this.capitalIncome = capitalIncome;
		this.healthSpending = healthSpending;
		this.educationSpending = educationSpending;
	}
	
	public double getSalaryIncome() {
		return salaryIncome;
	}
	public void setSalaryIncome(double salaryIncome) {
		this.salaryIncome = salaryIncome;
	}
	public double getServicesIncome() {
		return servicesIncome;
	}
	public void setServicesIncome(double servicesIncome) {
		this.servicesIncome = servicesIncome;
	}
	public double getCapitalIncome() {
		return capitalIncome;
	}
	public void setCapitalIncome(double capitalIncome) {
		this.capitalIncome = capitalIncome;
	}
	public double getHealthSpending() {
		return healthSpending;
	}
	public void setHealthSpending(double healthSpending) {
		this.healthSpending = healthSpending;
	}
	public double getEducationSpending() {
		return educationSpending;
	}
	public void setEducationSpending(double educationSpending) {
		this.educationSpending = educationSpending;
	}
	
	public double salaryTax() {
		double monthlySalary = salaryIncome / 12;
		
		if(monthlySalary < 3000) {
			return 0;
		}
		else if(monthlySalary < 5000) {
			return monthlySalary * 0.1 * 12;
		}
		else {
			return monthlySalary * 0.2 * 12;
		}
	}
	
	public double servicesTax() {
		return servicesIncome * 0.15;
	}
	
	public double capitalTax() {
		return capitalIncome * 0.2;
	}
	
	public double grossTax() {
		return salaryTax() + servicesTax() + capitalTax();
	}
	
	public double taxRebate() {
		double deductibleExpenses = healthSpending + educationSpending;
		double maximumDeductible = grossTax() * 0.3;
		
		if(deductibleExpenses < maximumDeductible) {
			return deductibleExpenses;
		}
		else {
			return maximumDeductible;
		}
	}
	
	public double netTax() {
		return grossTax() - taxRebate();
	}
	
}
