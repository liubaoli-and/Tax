package main;

import com.salesapp.products.BookProduct;
import com.salesapp.products.FoodProduct;
import com.salesapp.products.MedicalProduct;
import com.salesapp.products.MiscellaneousProduct;
import com.salesapp.products.Product;
import com.salesapp.shopdomain.StoreShelf;
import com.salesapp.taxcalculations.MathHelper;

import java.util.HashMap;

import static com.salesapp.taxcalculations.MathHelper.roundoff;

public class productor {
	/** name - name of the Product. */
	public  static String name;

	/** price - original price of the product excluding tax for the number of items specified in the quantity. */
	public static double price;

	/** imported - boolean value which indicates whether product is imported or not. */
	public static Boolean imported;

	/** quantity - the quantity of the product to be purchased. */
	public static int quantity;

	/** taxedCost - the net price of the product imported tax. */
	public static double importCost;

	/** taxedCost - the net price of the product sale tax. */
	public static double saleCost;

	/** taxedCost - the net price of the product extend tax. */
	public static double extendCost;


	/** taxedCost - the net price of the product including tax. */
	public static double taxedCost;
	
	/** The product items mapped to their respective categories */
	public static HashMap<String, productor> productItems;

	/**
	 * Default constructor to instantiate Product.
	 */
	public productor()
	{
		this.name = "";
		this.price = 0.0;
		this.imported = false;
		this.quantity = 0;
		this.taxedCost = 0.0;
	}

	/**
	 * Parameterized constructor to initialize the values of the product attributes.
	 *
	 * @param name - the name of the product
	 * @param price - the price of the product
	 * @param imported - boolean value of whether product imported or not
	 * @param quantity - quantity of product item
	 */	
	public productor(String name, double price, boolean imported, int quantity)
	{
		this.name = name;
		this.price = price * quantity;
		this.imported = imported;
		this.quantity = quantity;
		this.taxedCost = 0.0;
	}



	/**
	 * Gets the name of the product
	 *
	 * @return String
	 */
	public static String getName()
	{
		return name;
	}

	/**
	 * Sets the name of the product
	 *
	 * @param name - the product's name as a String
	 */
	public void setName(String name)
	{
		this.name = name;
	}

	/**
	 * Gets the price of the product.
	 *
	 * @return double
	 */
	public static double getPrice()
	{
		return price;
	}

	/**
	 * Calculates the price for the number of items mentioned in the quantity.
	 *
	 * @param price - the product's price as a double
	 */
	public void setPrice(double price)
	{
		this.price = price * quantity;
	}

	/**
	 * Checks if product is imported.
	 *
	 * @return <code>true</code> if the product is imported, otherwise <code>false</code>
	 */
	public static boolean isImported()
	{
		return imported;
	}

	/**
	 * Sets a boolean value for <code>imported</code> attribute
	 *
	 * @param imported - a boolean value which is <code>true</code> if the product is imported, otherwise <code>false</code>
	 */
	public void setImported(boolean imported)
	{
		this.imported = imported;
	}

	/**
	 * Gets the quantity of the product.
	 *
	 * @return int
	 */
	public static int getQuantity()
	{
		return quantity;
	}

	/**
	 * Sets the quantity of product.
	 *
	 * @param quantity - the product's quantity as an int
	 */
	public void setQuantity(int quantity)
	{
		this.quantity = quantity;
	}

	/**
	 * Gets the net cost of the product including tax.
	 *
	 * @return double
	 */
	public  static double getTaxedCost()
	{
		return taxedCost;
	}

	/**
	 * Sets the total taxed cost of the product.
	 *
	 * @param taxedCost - the product's total taxed value as a double
	 */
	public void setTaxedCost(double taxedCost)
	{
		this.taxedCost = taxedCost;
	}

	public static void setProductItems( HashMap<String, productor> productItems)
	{
		productItems.put("book", new productor());
		productItems.put("music CD" , new productor());
		productItems.put("chocolate bar", new productor());
		productItems.put("box of chocolates" , new productor());
		productItems.put("bottle of perfume", new productor());
		productItems.put("packet of headache pills", new productor());
		productItems.put("clothes", new productor());
		productItems.put("furniture", new productor());
		productItems.put("freezing", new productor());

	}

	public static double gettax(String name, double price, boolean imported, int quantity, String area){

		StoreShelf storeShelf = new StoreShelf();
		productItems = new HashMap<String, productor>();
		setProductItems(productItems);

		/**
		 * bookProduct is an item belonging to the category 'Book' in the shopping store.
		 * music CDProduct is an item belonging to the category 'music CD' in the shopping store.
		 * chocolate bar is an item belonging to the category 'chocolate bar' in the shopping store.
		 * box of chocolates is an item belonging to the category 'box of chocolates' in the shopping store.
		 * bottle of perfume is an item belonging to the category 'bottle of perfume' in the shopping store.
		 * packet of headache pills is an item belonging to the category 'packet of headache pills' in the shopping store.
		 * clothes is an item belonging to the category 'cloths' in the shopping store.
		 * furniture is an item belonging to the category 'furniture' in the shopping store.
		 * freezing is an item belonging to the category 'freezing' in the shopping store.
		 *
		 */

		storeShelf.addProductItemsToShelf("book", new BookProduct());
		storeShelf.addProductItemsToShelf("music CD" , new MiscellaneousProduct());
		storeShelf.addProductItemsToShelf("chocolate bar", new FoodProduct());
		storeShelf.addProductItemsToShelf("box of chocolates" , new FoodProduct());
		storeShelf.addProductItemsToShelf("bottle of perfume", new MiscellaneousProduct());
		storeShelf.addProductItemsToShelf("packet of headache pills", new MedicalProduct());
		storeShelf.addProductItemsToShelf("clothes", new MiscellaneousProduct());
		storeShelf.addProductItemsToShelf("furniture", new MiscellaneousProduct());
		storeShelf.addProductItemsToShelf("freezing", new FoodProduct());



		if(name.equals("book")){

			productor buy = productItems.get("book");
			buy.setName(name);
			buy.setImported(imported);
			buy.setQuantity(quantity);
			buy.setPrice(price);

			if(imported==true){
				importCost = price*0.05*quantity;
			}
			else  importCost = 0;

			saleCost = 0;

			if(buy.getQuantity()>200)
				extendCost = (buy.getQuantity()-200)*0.05*price;
			else extendCost = 0;

			taxedCost = importCost + saleCost +extendCost ;
			taxedCost = (int)(taxedCost / 0.05 + 0.5) * 0.05;
		}

		if(name.equals("music CD")){

			productor buy = productItems.get("music CD");
			buy.setName(name);
			buy.setImported(imported);
			buy.setQuantity(quantity);
			buy.setPrice(price);

			if(imported==true){

				importCost = price*0.05*quantity;

				if(area.equals("local")){
					saleCost = price*0.1*quantity;
				}
				if(area.equals("other")){
					saleCost = price*0.15*quantity;
				}
				if(buy.getQuantity()>200)
					extendCost = (buy.getQuantity()-200)*0.05*price;
				else extendCost = 0;

			}
			else{
				importCost = 0;

				if(area.equals("local")){
					saleCost = price*0.1*quantity;
				}
				if(area.equals("other")){
					saleCost = price*0.15*quantity;
				}
				if(buy.getQuantity()>200)
					extendCost = (buy.getQuantity()-200)*0.05*price;
				else extendCost = 0;
			}
			taxedCost = importCost + saleCost +extendCost ;
			taxedCost = (int)(taxedCost / 0.05 + 0.5) * 0.05;
		}

		if(name.equals("chocolate bar")){
			productor buy = productItems.get("chocolate bar");
			buy.setName(name);
			buy.setImported(imported);
			buy.setQuantity(quantity);
			buy.setPrice(price);

			if(imported==true){
				importCost = price*0.05*quantity;
			}
			else  importCost = 0;

			saleCost = 0;

			if(buy.getQuantity()>200)
				extendCost = (buy.getQuantity()-200)*0.05*price;
			else extendCost = 0;

			taxedCost = importCost + saleCost +extendCost ;
			taxedCost = (int)(taxedCost / 0.05 + 0.5) * 0.05;

		}

		if(name.equals("box of chocolates")){
			productor buy = productItems.get("box of chocolates");
			buy.setName(name);
			buy.setImported(imported);
			buy.setQuantity(quantity);
			buy.setPrice(price);

			if(imported==true){
				importCost = price*0.05*quantity;
			}
			else  importCost = 0;

			saleCost = 0;

			if(buy.getQuantity()>200)
				extendCost = (buy.getQuantity()-200)*0.05*price;
			else extendCost = 0;

			taxedCost = importCost + saleCost +extendCost ;
			taxedCost = (int)(taxedCost / 0.05 + 0.5) * 0.05;

		}

		if(name.equals("bottle of perfume")){

			productor buy = productItems.get("bottle of perfume");
			buy.setName(name);
			buy.setImported(imported);
			buy.setQuantity(quantity);
			buy.setPrice(price);

			if(imported==true){

				importCost = price*0.05*quantity;

				if(area.equals("local")){
					saleCost = price*0.1*quantity;
				}
				if(area.equals("other")){
					saleCost = price*0.15*quantity;
				}
				if(buy.getQuantity()>200)
					extendCost = (buy.getQuantity()-200)*0.05*price;
				else extendCost = 0;

			}
			else{
				importCost = 0;

				if(area.equals("local")){
					saleCost = price*0.1*quantity;
				}
				if(area.equals("other")){
					saleCost = price*0.15*quantity;
				}
				if(buy.getQuantity()>200)
					extendCost = (buy.getQuantity()-200)*0.05*price;
				else extendCost = 0;
			}
			taxedCost = importCost + saleCost +extendCost ;
			taxedCost = (int)(taxedCost / 0.05 + 0.5) * 0.05;
		}

		if(name.equals("packet of headache pills")){
			productor buy = productItems.get("packet of headache pills");
			buy.setName(name);
			buy.setImported(imported);
			buy.setQuantity(quantity);
			buy.setPrice(price);

			if(imported==true){
				importCost = price*0.05*quantity;
			}
			else  importCost = 0;

			saleCost = 0;

			if(buy.getQuantity()>200)
				extendCost = (buy.getQuantity()-200)*0.05*price;
			else extendCost = 0;

			taxedCost = importCost + saleCost +extendCost ;
			taxedCost = (int)(taxedCost / 0.05 + 0.5) * 0.05;
		}

		if(name.equals("clothes")){

			productor buy = productItems.get("clothes");
			buy.setName(name);
			buy.setImported(imported);
			buy.setQuantity(quantity);
			buy.setPrice(price);

			if(imported==true){

				importCost = price*0.05*quantity;

				if(area.equals("local")){
					saleCost = price*0.1*quantity;
				}
				if(area.equals("other")){
					saleCost = price*0.15*quantity;
				}
				if(buy.getQuantity()>200)
					extendCost = (buy.getQuantity()-200)*0.05*price;
				else extendCost = 0;

			}
			else{
				importCost = 0;

				if(area.equals("local")){
					saleCost = price*0.1*quantity;
				}
				if(area.equals("other")){
					saleCost = price*0.15*quantity;
				}
				if(buy.getQuantity()>200)
					extendCost = (buy.getQuantity()-200)*0.05*price;
				else extendCost = 0;
			}
			taxedCost = importCost + saleCost +extendCost ;
			taxedCost = (int)(taxedCost / 0.05 + 0.5) * 0.05;
		}

		if(name.equals("furniture")){

			productor buy = productItems.get("furniture");
			buy.setName(name);
			buy.setImported(imported);
			buy.setQuantity(quantity);
			buy.setPrice(price);

			if(imported==true){

				importCost = price*0.05*quantity;

				if(area.equals("local")){
					saleCost = price*0.1*quantity;
				}
				if(area.equals("other")){
					saleCost = price*0.15*quantity;
				}
				if(buy.getQuantity()>200)
					extendCost = (buy.getQuantity()-200)*0.05*price;
				else extendCost = 0;

			}
			else{
				importCost = 0;

				if(area.equals("local")){
					saleCost = price*0.1*quantity;
				}
				if(area.equals("other")){
					saleCost = price*0.15*quantity;
				}
				if(buy.getQuantity()>200)
					extendCost = (buy.getQuantity()-200)*0.05*price;
				else extendCost = 0;
			}
			taxedCost = importCost + saleCost +extendCost ;
			taxedCost = (int)(taxedCost / 0.05 + 0.5) * 0.05;
		}

		if(name.equals("freezing")){

			productor buy = productItems.get("freezing");
			buy.setName(name);
			buy.setImported(imported);
			buy.setQuantity(quantity);
			buy.setPrice(price);

			if(imported==true){
				importCost = price*0.05*quantity;
			}
			else  importCost = 0;

			saleCost = 0;

			if(buy.getQuantity()>200)
				extendCost = (buy.getQuantity()-200)*0.05*price;
			else extendCost = 0;

			taxedCost = importCost + saleCost +extendCost ;
			taxedCost = (int)(taxedCost / 0.05 + 0.5) * 0.05;
		}




		return taxedCost;

	}
	public static void main(String[] args){
////		double t = gettax("book",25,false,200,"local");
////		System.out.println(t);
//		double t = 5.07009;
//		t = (int)(t / 0.05 + 0.5) * 0.05;
//		System.out.println(t);
//
//		System.out.println(roundoff(t));
	}


}
