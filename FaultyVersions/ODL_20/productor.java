// This is a mutant program.
// Author : ysma

package ustb.edu.cn.tax.ODL_20;


import com.salesapp.products.BookProduct;
import com.salesapp.products.FoodProduct;
import com.salesapp.products.MedicalProduct;
import com.salesapp.products.MiscellaneousProduct;
import com.salesapp.products.Product;
import com.salesapp.shopdomain.StoreShelf;
import java.util.HashMap;


public class productor
{

    public static java.lang.String name;

    public static double price;

    public static java.lang.Boolean imported;

    public static int quantity;

    public static double importCost;

    public static double saleCost;

    public static double extendCost;

    public static double taxedCost;

    public static java.util.HashMap<String,productor> productItems;

    public productor()
    {
        this.name = "";
        this.price = 0.0;
        this.imported = false;
        this.quantity = 0;
        this.taxedCost = 0.0;
    }

    public productor( java.lang.String name, double price, boolean imported, int quantity )
    {
        this.name = name;
        this.price = price * quantity;
        this.imported = imported;
        this.quantity = quantity;
        this.taxedCost = 0.0;
    }

    public static  java.lang.String getName()
    {
        return name;
    }

    public  void setName( java.lang.String name )
    {
        this.name = name;
    }

    public static  double getPrice()
    {
        return price;
    }

    public  void setPrice( double price )
    {
        this.price = price * quantity;
    }

    public static  boolean isImported()
    {
        return imported;
    }

    public  void setImported( boolean imported )
    {
        this.imported = imported;
    }

    public static  int getQuantity()
    {
        return quantity;
    }

    public  void setQuantity( int quantity )
    {
        this.quantity = quantity;
    }

    public static  double getTaxedCost()
    {
        return taxedCost;
    }

    public  void setTaxedCost( double taxedCost )
    {
        this.taxedCost = taxedCost;
    }

    public static  void setProductItems( java.util.HashMap<String,productor> productItems )
    {
productItems.put( "book", new productor() );
            productItems.put( "music CD", new productor() );
            productItems.put( "chocolate bar", new productor() );
            productItems.put( "box of chocolates", new productor() );
            productItems.put( "bottle of perfume", new productor() );
             productItems.put( "packet of headache pills", new productor() );
           productItems.put( "clothes", new productor() );
           productItems.put( "furniture", new productor() );
           productItems.put( "freezing", new productor() );
    }

    public static  double gettax( java.lang.String name, double price, boolean imported, int quantity, java.lang.String area )
    {
        com.salesapp.shopdomain.StoreShelf storeShelf = new com.salesapp.shopdomain.StoreShelf();
        productItems = new java.util.HashMap<String,productor>();
        setProductItems( productItems );
        storeShelf.addProductItemsToShelf( "book", new com.salesapp.products.BookProduct() );
        storeShelf.addProductItemsToShelf( "music CD", new com.salesapp.products.MiscellaneousProduct() );
        storeShelf.addProductItemsToShelf( "chocolate bar", new com.salesapp.products.FoodProduct() );
        storeShelf.addProductItemsToShelf( "box of chocolates", new com.salesapp.products.FoodProduct() );
        storeShelf.addProductItemsToShelf( "bottle of perfume", new com.salesapp.products.MiscellaneousProduct() );
        storeShelf.addProductItemsToShelf( "packet of headache pills", new com.salesapp.products.MedicalProduct() );
        storeShelf.addProductItemsToShelf( "clothes", new com.salesapp.products.MiscellaneousProduct() );
        storeShelf.addProductItemsToShelf( "furniture", new com.salesapp.products.MiscellaneousProduct() );
        storeShelf.addProductItemsToShelf( "freezing", new com.salesapp.products.FoodProduct() );
        if (name.equals( "book" )) {
           productor buy = productItems.get( "book" );
            buy.setName( name );
            buy.setImported( imported );
            buy.setQuantity( quantity );
            buy.setPrice( price );
            if (imported == true) {
                importCost = price * 0.05 * quantity;
            } else {
                importCost = 0;
            }
            saleCost = 0;
            if (buy.getQuantity() > 200) {
                extendCost = (buy.getQuantity() - 200) * 0.05 * price;
            } else {
                extendCost = 0;
            }
            taxedCost = saleCost + extendCost;
            taxedCost = (int) (taxedCost / 0.05 + 0.5) * 0.05;
        }
        if (name.equals( "music CD" )) {
            productor buy = productItems.get( "music CD" );
            buy.setName( name );
            buy.setImported( imported );
            buy.setQuantity( quantity );
            buy.setPrice( price );
            if (imported == true) {
                importCost = price * 0.05 * quantity;
                if (area.equals( "local" )) {
                    saleCost = price * 0.1 * quantity;
                }
                if (area.equals( "other" )) {
                    saleCost = price * 0.15 * quantity;
                }
                if (buy.getQuantity() > 200) {
                    extendCost = (buy.getQuantity() - 200) * 0.05 * price;
                } else {
                    extendCost = 0;
                }
            } else {
                importCost = 0;
                if (area.equals( "local" )) {
                    saleCost = price * 0.1 * quantity;
                }
                if (area.equals( "other" )) {
                    saleCost = price * 0.15 * quantity;
                }
                if (buy.getQuantity() > 200) {
                    extendCost = (buy.getQuantity() - 200) * 0.05 * price;
                } else {
                    extendCost = 0;
                }
            }
            taxedCost = importCost + saleCost + extendCost;
            taxedCost = (int) (taxedCost / 0.05 + 0.5) * 0.05;
        }
        if (name.equals( "chocolate bar" )) {
            productor buy = productItems.get( "chocolate bar" );
            buy.setName( name );
            buy.setImported( imported );
            buy.setQuantity( quantity );
            buy.setPrice( price );
            if (imported == true) {
                importCost = price * 0.05 * quantity;
            } else {
                importCost = 0;
            }
            saleCost = 0;
            if (buy.getQuantity() > 200) {
                extendCost = (buy.getQuantity() - 200) * 0.05 * price;
            } else {
                extendCost = 0;
            }
            taxedCost = importCost + saleCost + extendCost;
            taxedCost = (int) (taxedCost / 0.05 + 0.5) * 0.05;
        }
        if (name.equals( "box of chocolates" )) {
            productor buy = productItems.get( "box of chocolates" );
            buy.setName( name );
            buy.setImported( imported );
            buy.setQuantity( quantity );
            buy.setPrice( price );
            if (imported == true) {
                importCost = price * 0.05 * quantity;
            } else {
                importCost = 0;
            }
            saleCost = 0;
            if (buy.getQuantity() > 200) {
                extendCost = (buy.getQuantity() - 200) * 0.05 * price;
            } else {
                extendCost = 0;
            }
            taxedCost = importCost + saleCost + extendCost;
            taxedCost = (int) (taxedCost / 0.05 + 0.5) * 0.05;
        }
        if (name.equals( "bottle of perfume" )) {
            productor buy = productItems.get( "bottle of perfume" );
            buy.setName( name );
            buy.setImported( imported );
            buy.setQuantity( quantity );
            buy.setPrice( price );
            if (imported == true) {
                importCost = price * 0.05 * quantity;
                if (area.equals( "local" )) {
                    saleCost = price * 0.1 * quantity;
                }
                if (area.equals( "other" )) {
                    saleCost = price * 0.15 * quantity;
                }
                if (buy.getQuantity() > 200) {
                    extendCost = (buy.getQuantity() - 200) * 0.05 * price;
                } else {
                    extendCost = 0;
                }
            } else {
                importCost = 0;
                if (area.equals( "local" )) {
                    saleCost = price * 0.1 * quantity;
                }
                if (area.equals( "other" )) {
                    saleCost = price * 0.15 * quantity;
                }
                if (buy.getQuantity() > 200) {
                    extendCost = (buy.getQuantity() - 200) * 0.05 * price;
                } else {
                    extendCost = 0;
                }
            }
            taxedCost = importCost + saleCost + extendCost;
            taxedCost = (int) (taxedCost / 0.05 + 0.5) * 0.05;
        }
        if (name.equals( "packet of headache pills" )) {
             productor buy = productItems.get( "packet of headache pills" );
            buy.setName( name );
            buy.setImported( imported );
            buy.setQuantity( quantity );
            buy.setPrice( price );
            if (imported == true) {
                importCost = price * 0.05 * quantity;
            } else {
                importCost = 0;
            }
            saleCost = 0;
            if (buy.getQuantity() > 200) {
                extendCost = (buy.getQuantity() - 200) * 0.05 * price;
            } else {
                extendCost = 0;
            }
            taxedCost = importCost + saleCost + extendCost;
            taxedCost = (int) (taxedCost / 0.05 + 0.5) * 0.05;
        }
        if (name.equals( "clothes" )) {
            productor buy = productItems.get( "clothes" );
            buy.setName( name );
            buy.setImported( imported );
            buy.setQuantity( quantity );
            buy.setPrice( price );
            if (imported == true) {
                importCost = price * 0.05 * quantity;
                if (area.equals( "local" )) {
                    saleCost = price * 0.1 * quantity;
                }
                if (area.equals( "other" )) {
                    saleCost = price * 0.15 * quantity;
                }
                if (buy.getQuantity() > 200) {
                    extendCost = (buy.getQuantity() - 200) * 0.05 * price;
                } else {
                    extendCost = 0;
                }
            } else {
                importCost = 0;
                if (area.equals( "local" )) {
                    saleCost = price * 0.1 * quantity;
                }
                if (area.equals( "other" )) {
                    saleCost = price * 0.15 * quantity;
                }
                if (buy.getQuantity() > 200) {
                    extendCost = (buy.getQuantity() - 200) * 0.05 * price;
                } else {
                    extendCost = 0;
                }
            }
            taxedCost = importCost + saleCost + extendCost;
            taxedCost = (int) (taxedCost / 0.05 + 0.5) * 0.05;
        }
        if (name.equals( "furniture" )) {
            productor buy = productItems.get( "furniture" );
            buy.setName( name );
            buy.setImported( imported );
            buy.setQuantity( quantity );
            buy.setPrice( price );
            if (imported == true) {
                importCost = price * 0.05 * quantity;
                if (area.equals( "local" )) {
                    saleCost = price * 0.1 * quantity;
                }
                if (area.equals( "other" )) {
                    saleCost = price * 0.15 * quantity;
                }
                if (buy.getQuantity() > 200) {
                    extendCost = (buy.getQuantity() - 200) * 0.05 * price;
                } else {
                    extendCost = 0;
                }
            } else {
                importCost = 0;
                if (area.equals( "local" )) {
                    saleCost = price * 0.1 * quantity;
                }
                if (area.equals( "other" )) {
                    saleCost = price * 0.15 * quantity;
                }
                if (buy.getQuantity() > 200) {
                    extendCost = (buy.getQuantity() - 200) * 0.05 * price;
                } else {
                    extendCost = 0;
                }
            }
            taxedCost = importCost + saleCost + extendCost;
            taxedCost = (int) (taxedCost / 0.05 + 0.5) * 0.05;
        }
        if (name.equals( "freezing" )) {
            productor buy = productItems.get( "freezing" );
            buy.setName( name );
            buy.setImported( imported );
            buy.setQuantity( quantity );
            buy.setPrice( price );
            if (imported == true) {
                importCost = price * 0.05 * quantity;
            } else {
                importCost = 0;
            }
            saleCost = 0;
            if (buy.getQuantity() > 200) {
                extendCost = (buy.getQuantity() - 200) * 0.05 * price;
            } else {
                extendCost = 0;
            }
            taxedCost = importCost + saleCost + extendCost;
            taxedCost = (int) (taxedCost / 0.05 + 0.5) * 0.05;
        }
        return taxedCost;
    }

    public static  void main( java.lang.String[] args )
    {
        double t = gettax( "book", 25, false, 200, "local" );
        System.out.println( t );
    }

}
