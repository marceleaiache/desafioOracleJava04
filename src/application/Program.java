package application;

import entities.Address;
import entities.FileGenerator;
import entities.ZipCodeSearch;

import java.io.IOException;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ZipCodeSearch zipCodeSearch = new ZipCodeSearch();

        System.out.println("Digite um número de CEP para consulta: ");
        String cep = sc.nextLine();

        try {
            Address newAddress = zipCodeSearch.searchAddress(cep);
            System.out.println(newAddress);
            FileGenerator generator = new FileGenerator();
            generator.saveJson(newAddress);
        }
        catch (RuntimeException | IOException e) {
            System.out.println(e.getMessage());
            System.out.println("Finalizando a aplicação");
        }


        sc.close();
    }
}
