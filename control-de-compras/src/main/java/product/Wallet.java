package product;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Wallet implements IWallet {
    private final Scanner board = new Scanner(System.in);
    private double balance = 0;
    private final DecimalFormat df = new DecimalFormat("#");

    public Wallet() {
        initializeBalance();
    }

    public double getBalance() {
        return this.balance;
    }

    private void initializeBalance() {
        while (true) {
            System.out.println("Ingrese el monto a de su tarjeta:");

            if (!this.board.hasNextDouble()) {
                System.out.println("Ingrese un valor valido");
                this.board.next();
                continue;
            }

            double amount = this.board.nextDouble();

            if (amount < 0) {
                System.out.println("El monto no puede ser negativo");
                continue;
            }

            this.balance = amount;
            System.out.println("Monto inicial: " + this.df.format(this.balance));
            break;
        }


    }

    public void removeAmount(double amount) {
        if(this.balance < amount) {
            throw new RuntimeException("Saldo insuficiente");
        }
        System.out.println("Saldo retirado: " + this.df.format(amount));
        this.balance -= amount;
        showbalance();
    }

    public void amountToBeRefunded(double amount) {
        System.out.println("Monto a devolver: " + this.df.format(amount));
        this.balance += amount;
        showbalance();
    }

    public void showbalance() {
        System.out.println("Saldo actual: " + this.df.format(this.balance));
    }
}
