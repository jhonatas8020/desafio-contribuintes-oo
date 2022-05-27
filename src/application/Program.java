package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.TaxPayer;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		List<TaxPayer> list = new ArrayList<>();
		
		System.out.print("Quantos contribuintes você vai digitar? ");
		int n = sc.nextInt();
		
		for(int i = 0; i < n; i++) {
			System.out.println();
			System.out.println("Digite os dados do " + (i + 1) + "o contribuinte:");
			System.out.print("Renda anual com salário: ");
			double salaryIncome = sc.nextDouble();
			System.out.print("Renda anual com prestação de serviço: ");
			double servicesIncome = sc.nextDouble();
			System.out.print("Renda anual com ganho de capital: ");
			double capitalIncome = sc.nextDouble();
			System.out.print("Gastos médicos: ");
			double healthSpending = sc.nextDouble();
			System.out.println("Gastos educacionais: ");
			double educationSpending =sc.nextDouble();
			
			TaxPayer taxPayer = new TaxPayer(salaryIncome, servicesIncome, capitalIncome, healthSpending, educationSpending);
			
			list.add(taxPayer);
		}
		
		for(int i = 0; i < list.size(); i++) {
			System.out.println();
			System.out.println("Resumo do " + (i + 1) + "o contribuinte:");
			System.out.printf("Imposto bruto total: %.2f%n", list.get(i).grossTax());
			System.out.printf("Abatimento: %.2f%n", list.get(i).taxRebate());
			System.out.printf("Imposto devido: %.2f%n", list.get(i).netTax());
		}
		
		sc.close();
	}

}
