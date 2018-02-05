package qingniaoyingyuan;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class Schedule {
	private List<Scheduleltem> items = new ArrayList<Scheduleltem>();
	// 电影信息结婚

	/**
	 * 使用DOM4J解析XML
	 */
	Document doc = null;

	public void loadltems() {
		SAXReader saxReader = new SAXReader();
		try {
			doc = saxReader.read("电影信息.xml");

		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * 显示XML所有信息
	 * 
	 * @return
	 */
	public void showInfo() {
		// 获取跟节点
		Element root = doc.getRootElement();
		// 遍历根节点
		System.out.println(
				"序号：" + "\t" + " 电影名称" + " 英文名称 " + "    导演" + "\t" + "演员" + "\t" + "电影类型" + "    价格" + "\t" + "时间");
		for (Iterator it = root.elementIterator(); it.hasNext();) {
			Element brand = (Element) it.next();
			// 获取根节点的属性值
			String id = brand.attributeValue("id");
			System.out.print(id + "\t");
			// 获取根节点中的子节点Name
			Element element = brand.element("Name");
			String name = element.getText();
			System.out.print(" " + name);
			// 获取根节点中的子节点Poster
			Element element2 = brand.element("Poster");
			String poster = element2.getText();
			System.out.print(" " + poster);
			// 获取根节点中的子节点Director
			Element element3 = brand.element("Director");
			String director = element3.getText();
			System.out.print(" " + director);
			// 获取根节点中的子节点Actor
			Element element4 = brand.element("Actor");
			String actor = element4.getText();
			System.out.print("\t" + actor);
			// 获取根节点中的子节点Type
			Element element5 = brand.element("Type");
			String type = element5.getText();
			System.out.print("\t" + type);
			// 获取根节点中的子节点Price
			Element element6 = brand.element("Price");
			String price = element6.getText();
			System.out.print(" " + price);
			// 获取根节点的子节点Schedule中的子节点Item
			Element element7 = brand.element("Schedule");
			for (Iterator is = element7.elementIterator(); is.hasNext();) {
				Element itemm = (Element) is.next();
				String item = itemm.getText();
				System.out.print("\t" + item + "\n");

			}
	
		}

	}

	public List<Scheduleltem> getItems() {
		return items;
	}

	public void setItems(List<Scheduleltem> items) {
		this.items = items;
	}


}
