package patikastore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeSet;

public class PatikaStore {

    private static TreeSet<Brand> brands = new TreeSet<>();
    static {
        brands.add(new Brand(1, "Samsung"));
        brands.add(new Brand(2, "Lenovo"));
        brands.add(new Brand(3, "Apple"));
        brands.add(new Brand(4, "Huawei"));
        brands.add(new Brand(5, "Casper"));
        brands.add(new Brand(6, "Asus"));
        brands.add(new Brand(7, "HP"));
        brands.add(new Brand(8, "Xiaomi"));
        brands.add(new Brand(9, "Monster"));
    }

    private static HashMap<String, ArrayList<Product>> products = new HashMap<>();
    static {
        products.put("Notebook", new ArrayList<>());
        products.put("MobilePhone", new ArrayList<>());
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println();
            System.out.println("PatikaStore Product Management Panel");

            System.out.println("1 - Notebook Operations");
            System.out.println("2 - Mobile Phone Operations");
            System.out.println("3 - List Brands");
            System.out.println("0 - Exit");

            System.out.print("Your choice: ");
            int productChoice = input.nextInt();
            boolean isExit = false;

            switch (productChoice) {
                case 0:
                    isExit = true;
                case 1:
                    System.out.println("Notebook");
                    printOperations();
                    chooseOperations(productChoice, input.nextInt());
                case 2:
                    System.out.println("Mobile Phone");
                    printOperations();
                    chooseOperations(productChoice, input.nextInt());
                case 3:
                    System.out.println("Our Brands");
                    System.out.println("-----------------");
                    for (Brand brand : getBrands()) {
                        System.out.println("-" + brand.getName());
                    }
            }
            if (isExit) {
                System.out.println();
                System.out.println("You've left the store. See you soon.");
                return;
            }
        }
    }

    private static void chooseOperations(int productChoice, int operationChoice) {
        switch (operationChoice) {
            case 1:
                if (productChoice == 1) {
                    listProduct("Notebook");
                } else if (productChoice == 2) {
                    listProduct("Mobile Phone");
                }
        }
    }

    private static void listProduct(String key) {
        for (Product product : getProducts().get(key)) {
            System.out.println("Product Id: " + product.getId());
            System.out.println("Product Name: " + product.getName());
            System.out.println("Price: " + product.getPrice());
            System.out.println("Brand: " + product.getBrand());
            System.out.println("Storage: " + product.getStorage());
            System.out.println("Screen Size: " + product.getScreenSize());
            if(key.equals("Notebook")){
                System.out.println("RAM: " + product.getRam());
            }else if(key.endsWith("Mobile Phone")){
                System.out.println("Camera: " + product.getCamera());
                System.out.println("Batery: " + product.getBatery());
                System.out.println("Ram: " + product.getRam());
                System.out.println("Color: " + product.getColor());
            }
        }
    }

    private static void printOperations() {
       System.out.println("-----------------");
        System.out.println("1 - List Products");
        System.out.println("2 - Add Products");
        System.out.println("3 - Delete Products");
        System.out.println("4 - Filter Products");
        System.out.print("Your choice: ");
    }

    public static TreeSet<Brand> getBrands() {
        return PatikaStore.brands;
    }

    public static HashMap<String, ArrayList<Product>> getProducts() {
        return PatikaStore.products;
    }
}
