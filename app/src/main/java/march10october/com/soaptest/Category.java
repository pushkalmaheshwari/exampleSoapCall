package march10october.com.soaptest;

import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

/**
 * Created by maheshwarip on 10-09-2015.
 */



public class Category implements KvmSerializable
{
    public int CategoryId;
    public String Name;
    public String Description;
    public List<Stock> Stocks;

    public Category(int categoryId, String name, String description,  List<Stock> stocks) {
        Stocks = new ArrayList<Stock>();

        CategoryId = categoryId;
        Name = name;
        Description = description;
        for ( Stock stock : stocks)
        {
            Stocks.add(stock);
        }
    }

    public void setStocks(List<Stock> stocks) {
        this.stocks = stocks;
    }

    protected List <Stock> stocks;
    public Category(){}


    public int getCategoryId() {
        return CategoryId;
    }

    public List<Stock> getStocks() {
        return stocks;
    }
    public void setStock(int loc, Stock stock) {
        this.stocks.set(loc,stock);
    }

    public void setCategoryId(int categoryId) {
        CategoryId = categoryId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public Category(int categoryId, String name, String description) {

        CategoryId = categoryId;
        Name = name;
        Description = description;

    }


    public Object getProperty(int arg0) {

        switch(arg0)
        {
            case 0:
                return CategoryId;
            case 1:
                return Name;
            case 2:
                return Description;
        }

        return null;
    }

    public int getPropertyCount() {
        return 3;
    }

    public void getPropertyInfo(int index, Hashtable arg1, PropertyInfo info) {
        switch(index)
        {
            case 0:
                info.type = PropertyInfo.INTEGER_CLASS;
                info.name = "CategoryId";
                break;
            case 1:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "Name";
                break;
            case 2:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "Description";
                break;
            default:break;
        }
    }

    public void setProperty(int index, Object value) {
        switch(index)
        {
            case 0:
                CategoryId = Integer.parseInt(value.toString());
                break;
            case 1:
                Name = value.toString();
                break;
            case 2:
                Description = value.toString();
                break;
            default:
                break;
        }
    }

    public void setInnerText(String s){

    }

    public String getInnerText(){
        return "hello";
    }


    public static class Stock{

        protected BigInteger sku;
        protected BigInteger stockAnt;
        protected BigInteger ventas;
        protected BigInteger notaCredito;
        protected BigInteger stockAct;
        protected BigInteger mesAntiguedad;
        protected String talla;
        protected String color;

        /**
         * Gets the value of the sku property.
         *
         * @return
         *     possible object is
         *     {@link BigInteger }
         *
         */
        public BigInteger getSku() {
            return sku;
        }

        /**
         * Sets the value of the sku property.
         *
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *
         */
        public void setSku(BigInteger value) {
            this.sku = value;
        }

        /**
         * Gets the value of the stockAnt property.
         *
         * @return
         *     possible object is
         *     {@link BigInteger }
         *
         */
        public BigInteger getStockAnt() {
            return stockAnt;
        }

        /**
         * Sets the value of the stockAnt property.
         *
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *
         */
        public void setStockAnt(BigInteger value) {
            this.stockAnt = value;
        }

        /**
         * Gets the value of the ventas property.
         *
         * @return
         *     possible object is
         *     {@link BigInteger }
         *
         */
        public BigInteger getVentas() {
            return ventas;
        }

        /**
         * Sets the value of the ventas property.
         *
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *
         */
        public void setVentas(BigInteger value) {
            this.ventas = value;
        }

        /**
         * Gets the value of the notaCredito property.
         *
         * @return
         *     possible object is
         *     {@link BigInteger }
         *
         */
        public BigInteger getNotaCredito() {
            return notaCredito;
        }

        /**
         * Sets the value of the notaCredito property.
         *
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *
         */
        public void setNotaCredito(BigInteger value) {
            this.notaCredito = value;
        }

        /**
         * Gets the value of the stockAct property.
         *
         * @return
         *     possible object is
         *     {@link BigInteger }
         *
         */
        public BigInteger getStockAct() {
            return stockAct;
        }

        /**
         * Sets the value of the stockAct property.
         *
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *
         */
        public void setStockAct(BigInteger value) {
            this.stockAct = value;
        }

        /**
         * Gets the value of the mesAntiguedad property.
         *
         * @return
         *     possible object is
         *     {@link BigInteger }
         *
         */
        public BigInteger getMesAntiguedad() {
            return mesAntiguedad;
        }

        /**
         * Sets the value of the mesAntiguedad property.
         *
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *
         */
        public void setMesAntiguedad(BigInteger value) {
            this.mesAntiguedad = value;
        }

        /**
         * Gets the value of the talla property.
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getTalla() {
            return talla;
        }

        /**
         * Sets the value of the talla property.
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setTalla(String value) {
            this.talla = value;
        }

        /**
         * Gets the value of the color property.
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getColor() {
            return color;
        }

        /**
         * Sets the value of the color property.
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setColor(String value) {
            this.color = value;
        }

    }

}