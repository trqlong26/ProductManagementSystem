package model;

/**
 * Product
 */
public class Product {
    private String productCode;
    private String description;
    private double unitPrice;
    private int onHandQuantity;
    private int categoryId;

    public Product() {
    }

    public Product(String productCode, String description, double unitPrice, int onHandQuantity, int categoryId) {
        this.productCode = productCode;
        this.description = description;
        this.unitPrice = unitPrice;
        this.onHandQuantity = onHandQuantity;
        this.categoryId = categoryId;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getOnHandQuantity() {
        return onHandQuantity;
    }

    public void setOnHandQuantity(int onHandQuantity) {
        this.onHandQuantity = onHandQuantity;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
}