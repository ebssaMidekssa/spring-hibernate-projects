//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-793 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2009.07.07 at 09:00:08 PM CDT 
//

package generated.shoppingList;

import java.util.ArrayList;
import java.util.Collection;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for anonymous complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base=&quot;{http://www.w3.org/2001/XMLSchema}anyType&quot;&gt;
 *       &lt;sequence&gt;
 *         &lt;element name=&quot;item&quot; maxOccurs=&quot;unbounded&quot; minOccurs=&quot;0&quot;&gt;
 *           &lt;complexType&gt;
 *             &lt;simpleContent&gt;
 *               &lt;extension base=&quot;&lt;http://www.w3.org/2001/XMLSchema&gt;string&quot;&gt;
 *                 &lt;attribute name=&quot;qty&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}byte&quot; /&gt;
 *                 &lt;attribute name=&quot;notes&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; /&gt;
 *               &lt;/extension&gt;
 *             &lt;/simpleContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "item" })
@XmlRootElement(name = "shopping-list")
public class ShoppingList {

	protected Collection<Item> item;

	public ShoppingList() {
	}

	public ShoppingList(Collection<Item> item) {
		this.item = item;
	}

	/**
	 * Gets the value of the item property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the item property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getItem().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link ShoppingList.Item }
	 * 
	 * 
	 */
	public Collection<Item> getItem() {
		if (item == null) {
			item = new ArrayList<Item>();
		}
		return this.item;
	}

	public String toString() {
		String result = "";
		for (Item itm : item) {
			result += String.format("%2d %-20s %-20s\n", itm.getQty(), itm
					.getProduct(), itm.getNotes());
		}
		return result;
	}

}
