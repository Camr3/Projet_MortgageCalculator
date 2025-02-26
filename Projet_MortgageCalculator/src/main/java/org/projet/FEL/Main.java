package org.projet.FEL;

import static org.projet.BLL.Service.InsuranceRateService.*;

public class Main {
    public static void main(String[] args) {


        String separateur = "-------------------------------------------------------------------------------------------";
        System.out.println("Resultats en utilsant InMemory data:");
        String bankname ="RBC";
        String servicename = "Savings account";
        System.out.println("Le taux d'intérêt de la banque: "+bankname+" est "+ fetchInterestRateByBankNameUsingInMemoryDB(bankname));
        System.out.println("La banque qui offre le taux le plus bas du marché est: "+fetchLowestInterestRateUsingInMemoryDB());
        System.out.println("Les banques offrant le service de "+servicename+" sont: "+ fetchBanksByServiceUsingInMemoryDB(servicename));
        System.out.println(separateur);

        System.out.println("Resultats en utilisant JDBC");
        System.out.println("Le taux d'intérêt de la banque: "+bankname+" est "+fetchInterestRateByBankNameUsingJDBC(bankname));
        System.out.println("La banque qui offre le taux le plus bas du marché est: "+fetchLowestInterestRateUsingJDBC());
        System.out.println("Les banques offrant le service de "+servicename+" sont: "+fetchBanksByServiceUsingJDBC(servicename));
         System.out.println(separateur);

        System.out.println("Resultat en utilisant JPA");
        System.out.println("Le taux d'intérêt de la banque: "+bankname+" est "+fetchInterestRateByBankNameUsingJPA(bankname));
        System.out.println("La banque qui offre le taux le plus bas du marché est: "+fetchLowestInterestRateUsingJPA());
        System.out.println("Les banques offrant le service de "+servicename+" sont: "+fetchBanksByServiceUsingJPA(servicename));





    }
}