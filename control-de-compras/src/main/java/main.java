import product.*;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        System.out.println("Control de compras");

        Scanner board = new Scanner(System.in);
        IShoppingCart shoppingCart = new ShoppingCart();
        IWallet wallet = new Wallet();

        while(true) {
            int selectedOption = showMenu(board);

            if (selectedOption == 5) {
                exit(board, shoppingCart, wallet);
                break;
            }

            switch (selectedOption) {
                case 1 -> shoppingCart.addItem(wallet);
                case 2 -> shoppingCart.removeItem(wallet);
                case 3 -> shoppingCart.showProducts();
                case 4 -> wallet.showbalance();
                default -> System.out.println("Opción inválida");
            }
        }
    }

    public static int showMenu(Scanner board) {
        int option;

        System.out.println("1. Agregar producto");
        System.out.println("2. Eliminar producto");
        System.out.println("3. Mostrar productos");
        System.out.println("4. Ver saldo");
        System.out.println("5. Terminar / Salir");

        while(true) {
            if (!board.hasNextInt()) {
                board.next();
                System.out.println("Ingrese una opción válida");
                continue;
            }

            option = board.nextInt();
            break;
        }

        return option;
    }

    private static void exit(Scanner board, IShoppingCart shoppingCart, IWallet wallet) {
        board.close();
        System.out.println("Resumen de la compra");
        shoppingCart.showProducts();
        wallet.showbalance();
        System.out.println("---------------------------------------");
        System.out.println("Cerrando aplicación");

    }
}