package product;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class ShoppingCart implements IShoppingCart  {
    private final List<Item> products = new ArrayList<>();
    private final Scanner board = new Scanner(System.in);

    public void addItem(IWallet wallet) {
        String productName;
        double productPrice;
        int productQuantity;

        while(true) {
            System.out.println("Ingrese el nombre del producto:");

            if (!this.board.hasNextLine()) {
                System.out.println("Ingrese un nombre válido");
                this.board.next();
                continue;
            }

            productName = this.board.next();



            if (productName.isBlank()) {
                System.out.println("El nombre no puede estar vacio o solo espacios en blanco");
                continue;
            }

            break;
        }

        while(true) {
            System.out.println("Ingrese el precio del producto:");

            if (!this.board.hasNextDouble()) {
                System.out.println("Ingrese un precio válido");
                this.board.next();
                continue;
            }

            productPrice = this.board.nextDouble();

            if (productPrice < 0) {
                System.out.println("El precio no puede ser negativo");
                continue;
            }

            break;
        }

        while(true) {
            System.out.println("Ingrese la cantidad del producto:");

            if (!this.board.hasNextInt()) {
                System.out.println("Ingrese una cantidad válida");
                this.board.next();
                continue;
            }

            productQuantity = this.board.nextInt();


            if (productQuantity < 0) {
                System.out.println("La cantidad no puede ser negativa");
                continue;
            }

            break;
        }

        try {
            wallet.removeAmount(productPrice * productQuantity);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return;
        }

        Item newProduct = new Product(productName, productPrice, productQuantity);

        this.products.add(newProduct);
    }

    public void removeItem(IWallet wallet) {
        String productToSearch;

        showProducts();

        if (this.products.isEmpty()) return;

        while(true) {
            System.out.println("Ingrese el nombre del producto a eliminar:");

            if (!this.board.hasNextLine()) {
                System.out.println("Ingrese un nombre válido");
                this.board.next();
                continue;
            }

            productToSearch = this.board.next();

            break;
        }

        Iterator<Item> iteratorProducts = this.products.iterator();

        while(iteratorProducts.hasNext()) {
            Item currentProduct = iteratorProducts.next();
            if (currentProduct.getName().equalsIgnoreCase(productToSearch)) {
                System.out.println("Producto eliminado:" + currentProduct.getName());
                wallet.amountToBeRefunded(currentProduct.getPrice() * currentProduct.getQuantity());
                iteratorProducts.remove();
                return;
            }

            System.out.println("Prodcuto a eliminar no encontrado");
            break;
        }
    }

    public void showProducts() {
        int index = 1;

        if (this.products.isEmpty()) {
            System.out.println("No hay productos agregados aún.");
            return;
        }

        System.out.println("////////////////////////////////////");
        System.out.println("////////////////////////////////////\n");
        System.out.println("Productos agregados:");

        for(Item product: this.products) {
            System.out.println(index + "-" + product.getName() +  "(" + product.getQuantity() + ")");
            index++;
        }

        System.out.println("\n////////////////////////////////////");
        System.out.println("////////////////////////////////////");
    }

    public double getTotal() {
        double total = 0;

        if (this.products.isEmpty()) return total;

        try {
            for (Item product: this.products) {
                total += product.getPrice() * product.getQuantity();
            }

            return total;
        } catch (Exception e) {
            throw new RuntimeException("Error al intentar optener el monto total, intente denuevo");
        }
    }
}
