public class OracleDataAdapter implements IDataAdapter {
    public int connect(String dbfile) {
        //...
        return CONNECTION_OPEN_OK;
    }

    public int disconnect() {
        // ...
        return CONNECTION_CLOSE_OK;

    }
    public CustomerModel loadCustomer(int id) {
        return null;
    }
    public int saveCustomer(CustomerModel cust) {return 0;}

    public ProductModel loadProduct(int id) {
        return null;
    }
    public int saveProduct(ProductModel model) {
        return PRODUCT_SAVED_OK;
    }


    public int savePurchase(PurchaseModel model) {
        return 0;
    }
    public PurchaseModel loadPurchase(int id) {return null;}

}