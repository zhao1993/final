package zhao.blog.managementsystem.test;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;



public class Spider {
	public static void main(String[] args) throws Exception {
		URL url = new URL("http://www.baidu.com");
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		InputStream stream = connection.getInputStream();
		byte[] bytes = new byte[stream.available()];
		stream.read(bytes);
		String string = new String(bytes);
		Document document =  Jsoup.parse(string);
		System.out.println(document);
		Elements element = document.getElementsByClass("box vertical news");
		Iterator<Element> iterator = element.iterator();
		while (iterator.hasNext()) {
			Element e = (Element) iterator.next();
			System.out.println(e);
		}
	}
	
	
	public static void callGetMethodOfClass(Object object) {
		Method[] methods = object.getClass().getMethods();
		for (Method method : methods) {
			if(method.getName().startsWith("get") && method.getParameterCount()==0){
				try{
				System.out.println("调用方法[ "+method.getName()+" ]--->得到的结果:["+method.invoke(object)+"]");
				}catch (Exception e) {
					System.out.println("调用方法[ "+method.getName()+" ]失败"+e.getMessage());
					continue;
				}
			}
		}
	}
}
