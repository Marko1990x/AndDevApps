package primer7;

import primer1.klase.Automobil;

public class Nizovi {
    public static void main(String[] args) {
        {
            // sve vrednosti u nizu su 0
            int a[] = new int[5];
        }
        {
            int a[] = {1, 2, 3, 4, 5};
        }
        {
            Automobil[] parking = new Automobil[20];
            // sve vrednosti u nizu su null
            // dodaj objekte u niz
            parking[0] = new Automobil();
            parking[1] = new Automobil();
            // ili
            for (int i = 0; i < parking.length; i++)
                parking[i] = new Automobil();

        }
        {
            Automobil[] parking = {
                    new Automobil(),
                    new Automobil(),
                    new Automobil()};

            parking = new Automobil[]{
                    new Automobil(),
                    new Automobil(),
                    new Automobil()
            };
        }
    }
}
