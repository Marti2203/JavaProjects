package xml;

import java.util.Scanner;

import javax.xml.transform.*;
import javax.xml.transform.stream.*;

public class XSLTransform
{
	public static void main(String[] args) throws Exception
	{
		Scanner scanner=new Scanner(System.in);
		String xslFile = scanner.nextLine(), xmlFile = scanner.nextLine();
		TransformerFactory factory = TransformerFactory.newInstance();
		Transformer transformer = factory.newTransformer(new StreamSource(xslFile));
		StreamSource xmlsource = new StreamSource(xmlFile);
		StreamResult output = new StreamResult(System.out);
		transformer.transform(xmlsource, output);
	}
}