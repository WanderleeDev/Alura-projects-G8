package product;

public interface IShoppingCart {
    public void addItem(IWallet wallet);
    public void removeItem(IWallet wallet);
    public void showProducts();
    public double getTotal();
}
