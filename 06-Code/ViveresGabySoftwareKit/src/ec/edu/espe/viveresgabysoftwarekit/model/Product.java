/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.viveresgabysoftwarekit.model;

/**
 *
 * @author mateo
 */
class Product {
        private int id;
    private String Description;
    private String name;
    private float price;
    private float unitaryPrice;
    private Category category;
    private String provider;
    private Tax[] taxes;

    public void addToInventory(){};
    public void deleteToinventory(){};
    public void addToStock(){};
    public void deletetoStock(){};
    public void Updateprice(){};
    public void UpdateDescription(){};
    public void getProductInfo(){};
}
