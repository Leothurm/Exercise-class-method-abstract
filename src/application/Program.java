package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entitites.Company;
import entitites.Individual;
import entitites.TaxPayer;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<TaxPayer> list = new ArrayList<>();

		
		System.out.print("Enter the number of tax payers: ");
		int N = sc.nextInt();
		
		for(int i = 1; i<=N;i++) {
			System.out.printf("Tax payer #%d data: %n",i);
			System.out.print("Individual or company (i/c)? ");
			char ch = sc.next().charAt(0);
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Anual income: ");
			double anualIncome = sc.nextDouble();
			
			if (ch == 'i') {
				System.out.print("Health expenditures: ");
				double healthExpenditures = sc.nextDouble();
				TaxPayer tp = new Individual(name, anualIncome, healthExpenditures);
				list.add(tp);	
			} else {
				System.out.print("Number of employees: ");
				int numberOfEmployees = sc.nextInt();
				TaxPayer tp = new Company(name, anualIncome, numberOfEmployees);
				list.add(tp);
			}
			
		
		}
		
		double totalTaxes = 0;
		System.out.println();
		System.out.println("TAXES PAID: ");
		for(TaxPayer tp : list) {
			/*Print with "toString"*/
			System.out.println(tp);
			
			/* Another way to print without the method "toString"
			System.out.println(tp.getName() + ": $ " + String.format("%.2f", tp.tax()));
			*/
			
			totalTaxes += tp.tax();
		}
		
		System.out.println();
		System.out.println("TOTAL TAXES: $ " + String.format("%.2f", totalTaxes));
		
		
		
		
		sc.close();
		
	}

}
