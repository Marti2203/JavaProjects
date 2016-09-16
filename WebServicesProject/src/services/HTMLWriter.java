package services;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.text.MessageFormat;
import java.util.*;

import javax.servlet.http.HttpServletResponse;

import org.w3c.dom.Attr;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.TypeInfo;
import org.w3c.dom.UserDataHandler;


public class HTMLWriter
	{
		PrintWriter out;
		final String START = "<html>";
		boolean startWritten = false;
		boolean endWritten = false;
		final String END = "</body></html>";

		public HTMLWriter(HttpServletResponse response) throws IOException
			{
				response.setContentType("text/html");
				this.out = response.getWriter();
			}

		public HTMLWriter(Writer writer)
			{
				this(new PrintWriter(writer));
			}

		public HTMLWriter(PrintWriter writer)
			{
				this.out = writer;
			}

		public void writeText(String text)
			{

			}

	}

class HTMLElement implements org.w3c.dom.html.HTMLElement
	{
		String tagName;
		boolean isEnding=false;
		HashMap<String, String> attributes=new HashMap<>();
		
		public String toString()
		{
			// TODO Auto-generated method stub
			return MessageFormat.format("<{1}{0}>", tagName, isEnding? "/" : "" );
		}
		@Override
		public String getTagName()
			{
				return tagName;
			}
		@Override
		public String getAttribute(String name)
			{
				return attributes.get(name);
			}
		@Override
		public void setAttribute(String name, String value) throws DOMException
			{
				attributes.put(name,value);
			}
		@Override
		public void removeAttribute(String name) throws DOMException
			{
				attributes.remove(name);
			}
		@Override
		public Attr getAttributeNode(String name)
			{
				// TODO Auto-generated method stub
				return null;
			}
		@Override
		public Attr setAttributeNode(Attr newAttr) throws DOMException
			{
				// TODO Auto-generated method stub
				return null;
			}
		@Override
		public Attr removeAttributeNode(Attr oldAttr) throws DOMException
			{
				// TODO Auto-generated method stub
				return null;
			}
		@Override
		public NodeList getElementsByTagName(String name)
			{
				// TODO Auto-generated method stub
				return null;
			}
		@Override
		public String getAttributeNS(String namespaceURI, String localName) throws DOMException
			{
				// TODO Auto-generated method stub
				return null;
			}
		@Override
		public void setAttributeNS(String namespaceURI, String qualifiedName, String value) throws DOMException
			{
				// TODO Auto-generated method stub
				
			}
		@Override
		public void removeAttributeNS(String namespaceURI, String localName) throws DOMException
			{
				// TODO Auto-generated method stub
				
			}
		@Override
		public Attr getAttributeNodeNS(String namespaceURI, String localName) throws DOMException
			{
				// TODO Auto-generated method stub
				return null;
			}
		@Override
		public Attr setAttributeNodeNS(Attr newAttr) throws DOMException
			{
				// TODO Auto-generated method stub
				return null;
			}
		@Override
		public NodeList getElementsByTagNameNS(String namespaceURI, String localName) throws DOMException
			{
				// TODO Auto-generated method stub
				return null;
			}
		@Override
		public boolean hasAttribute(String name)
			{
				// TODO Auto-generated method stub
				return false;
			}
		@Override
		public boolean hasAttributeNS(String namespaceURI, String localName) throws DOMException
			{
				// TODO Auto-generated method stub
				return false;
			}
		@Override
		public TypeInfo getSchemaTypeInfo()
			{
				// TODO Auto-generated method stub
				return null;
			}
		@Override
		public void setIdAttribute(String name, boolean isId) throws DOMException
			{
				// TODO Auto-generated method stub
				
			}
		@Override
		public void setIdAttributeNS(String namespaceURI, String localName, boolean isId) throws DOMException
			{
				// TODO Auto-generated method stub
				
			}
		@Override
		public void setIdAttributeNode(Attr idAttr, boolean isId) throws DOMException
			{
				// TODO Auto-generated method stub
				
			}
		@Override
		public String getNodeName()
			{
				// TODO Auto-generated method stub
				return null;
			}
		@Override
		public String getNodeValue() throws DOMException
			{
				// TODO Auto-generated method stub
				return null;
			}
		@Override
		public void setNodeValue(String nodeValue) throws DOMException
			{
				// TODO Auto-generated method stub
				
			}
		@Override
		public short getNodeType()
			{
				// TODO Auto-generated method stub
				return 0;
			}
		@Override
		public Node getParentNode()
			{
				// TODO Auto-generated method stub
				return null;
			}
		@Override
		public NodeList getChildNodes()
			{
				// TODO Auto-generated method stub
				return null;
			}
		@Override
		public Node getFirstChild()
			{
				// TODO Auto-generated method stub
				return null;
			}
		@Override
		public Node getLastChild()
			{
				// TODO Auto-generated method stub
				return null;
			}
		@Override
		public Node getPreviousSibling()
			{
				// TODO Auto-generated method stub
				return null;
			}
		@Override
		public Node getNextSibling()
			{
				// TODO Auto-generated method stub
				return null;
			}
		@Override
		public NamedNodeMap getAttributes()
			{
				// TODO Auto-generated method stub
				return null;
			}
		@Override
		public Document getOwnerDocument()
			{
				// TODO Auto-generated method stub
				return null;
			}
		@Override
		public Node insertBefore(Node newChild, Node refChild) throws DOMException
			{
				// TODO Auto-generated method stub
				return null;
			}
		@Override
		public Node replaceChild(Node newChild, Node oldChild) throws DOMException
			{
				// TODO Auto-generated method stub
				return null;
			}
		@Override
		public Node removeChild(Node oldChild) throws DOMException
			{
				// TODO Auto-generated method stub
				return null;
			}
		@Override
		public Node appendChild(Node newChild) throws DOMException
			{
				// TODO Auto-generated method stub
				return null;
			}
		@Override
		public boolean hasChildNodes()
			{
				// TODO Auto-generated method stub
				return false;
			}
		@Override
		public Node cloneNode(boolean deep)
			{
				// TODO Auto-generated method stub
				return null;
			}
		@Override
		public void normalize()
			{
				// TODO Auto-generated method stub
				
			}
		@Override
		public boolean isSupported(String feature, String version)
			{
				// TODO Auto-generated method stub
				return false;
			}
		@Override
		public String getNamespaceURI()
			{
				// TODO Auto-generated method stub
				return null;
			}
		@Override
		public String getPrefix()
			{
				// TODO Auto-generated method stub
				return null;
			}
		@Override
		public void setPrefix(String prefix) throws DOMException
			{
				// TODO Auto-generated method stub
				
			}
		@Override
		public String getLocalName()
			{
				// TODO Auto-generated method stub
				return null;
			}
		@Override
		public boolean hasAttributes()
			{
				// TODO Auto-generated method stub
				return false;
			}
		@Override
		public String getBaseURI()
			{
				// TODO Auto-generated method stub
				return null;
			}
		@Override
		public short compareDocumentPosition(Node other) throws DOMException
			{
				// TODO Auto-generated method stub
				return 0;
			}
		@Override
		public String getTextContent() throws DOMException
			{
				// TODO Auto-generated method stub
				return null;
			}
		@Override
		public void setTextContent(String textContent) throws DOMException
			{
				// TODO Auto-generated method stub
				
			}
		@Override
		public boolean isSameNode(Node other)
			{
				// TODO Auto-generated method stub
				return false;
			}
		@Override
		public String lookupPrefix(String namespaceURI)
			{
				// TODO Auto-generated method stub
				return null;
			}
		@Override
		public boolean isDefaultNamespace(String namespaceURI)
			{
				// TODO Auto-generated method stub
				return false;
			}
		@Override
		public String lookupNamespaceURI(String prefix)
			{
				// TODO Auto-generated method stub
				return null;
			}
		@Override
		public boolean isEqualNode(Node arg)
			{
				// TODO Auto-generated method stub
				return false;
			}
		@Override
		public Object getFeature(String feature, String version)
			{
				// TODO Auto-generated method stub
				return null;
			}
		@Override
		public Object setUserData(String key, Object data, UserDataHandler handler)
			{
				// TODO Auto-generated method stub
				return null;
			}
		@Override
		public Object getUserData(String key)
			{
				// TODO Auto-generated method stub
				return null;
			}
		@Override
		public String getId()
			{
				// TODO Auto-generated method stub
				return null;
			}
		@Override
		public void setId(String id)
			{
				// TODO Auto-generated method stub
				
			}
		@Override
		public String getTitle()
			{
				// TODO Auto-generated method stub
				return null;
			}
		@Override
		public void setTitle(String title)
			{
				// TODO Auto-generated method stub
				
			}
		@Override
		public String getLang()
			{
				// TODO Auto-generated method stub
				return null;
			}
		@Override
		public void setLang(String lang)
			{
				// TODO Auto-generated method stub
				
			}
		@Override
		public String getDir()
			{
				// TODO Auto-generated method stub
				return null;
			}
		@Override
		public void setDir(String dir)
			{
				// TODO Auto-generated method stub
				
			}
		@Override
		public String getClassName()
			{
				// TODO Auto-generated method stub
				return null;
			}
		@Override
		public void setClassName(String className)
			{
				// TODO Auto-generated method stub
				
			}
	}
