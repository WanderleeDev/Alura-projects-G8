package product;

public interface IWallet {
    double getBalance();
    void removeAmount(double amount);
    void showbalance();
    void amountToBeRefunded(double amount);
}
