package XML;

import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class Parser {

   public static void main(String[] args) {

      try {
         File inputFile = new File("input.xml");
         DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
         DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
         Document doc = dBuilder.parse(inputFile);
         doc.getDocumentElement().normalize();
         System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
         NodeList nList = doc.getElementsByTagName("student");
         System.out.println("----------------------------");
         
         for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList.item(temp);
                  
            System.out.println("\n- Current Element :" + nNode.getNodeName());
            
               Element eElement = (Element) nNode;
               
               NodeList nList2 = eElement.getElementsByTagName("course");
               for (int temp2 = 0; temp2 < nList2.getLength() ; temp2++) {
            	   Node nNode2 = nList2.item(temp2);
            	   Element eElement2 = (Element) nNode2;
            	   System.out.print("-- Course : " 
                           + eElement2.getAttribute("id")+" ");
            	   System.out.print (eElement2
                           .getElementsByTagName("name")
                           .item(0)
                           .getTextContent()+" ");
            	   System.out.print (eElement2
                           .getElementsByTagName("time")
                           .item(0)
                           .getTextContent()+" ");
            	   System.out.println();
            	   
                   NodeList nList4 = eElement2.getElementsByTagName("details");
                   for (int temp3 = 0; temp3 < nList4.getLength() ; temp3++) {
                	   Node nNode3 = nList4.item(temp3);
                	   Element eElement4 = (Element) nNode3;
                	   System.out.print ("--- " + eElement4
                               .getElementsByTagName("place")
                               .item(0)
                               .getTextContent()+" ");
                	   System.out.print (eElement4
                               .getElementsByTagName("description")
                               .item(0)
                               .getTextContent()+" ");
                	   System.out.println();
                   }

               }

               NodeList nList3 = eElement.getElementsByTagName("history");
               for (int temp2 = 0; temp2 < nList3.getLength() ; temp2++) {
            	   Node nNode2 = nList3.item(temp2);
            	   Element eElement3 = (Element) nNode2;
            	   System.out.print ("-- "+eElement3
                           .getElementsByTagName("idCourse")
                           .item(0)
                           .getTextContent()+" ");
            	   System.out.print (eElement3
                           .getElementsByTagName("grade")
                           .item(0)
                           .getTextContent()+" ");
            	   System.out.println();
               }
               
               System.out.println("- Student roll no : " 
                  + eElement.getAttribute("rollno"));
               System.out.println("- First Name : " 
                  + eElement
                  .getElementsByTagName("firstname")
                  .item(0)
                  .getTextContent());
               System.out.println("- Last Name : " 
                  + eElement
                  .getElementsByTagName("lastname")
                  .item(0)
                  .getTextContent());
               System.out.println("- Nick Name : " 
                  + eElement
                  .getElementsByTagName("nickname")
                  .item(0)
                  .getTextContent());
               System.out.println("- Marks : " 
                  + eElement
                  .getElementsByTagName("marks")
                  .item(0)
                  .getTextContent());
            }
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
}
