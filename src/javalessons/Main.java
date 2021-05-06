package javalessons;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import javalessons.models.FirstGeoPlugin;
import javalessons.models.SecondGeoPlugin;

import java.io.IOException;
import java.net.URL;

public class Main {

    public static void main(String[] args) throws IOException {
        XmlMapper xmlMapper = new XmlMapper();
        URL firstURL = new URL("http://www.geoplugin.net/xml.gp?base_currency=USD");

        FirstGeoPlugin firstObject = xmlMapper.readValue(firstURL, FirstGeoPlugin.class);
        URL secondURL = new URL("http://www.geoplugin.net/xml.gp?ip=xx.xx.xx.xx");
        secondURL = new URL(secondURL.toString().replaceAll
                ("xx.xx.xx.xx", firstObject.getRequest()));

        SecondGeoPlugin secondObject = xmlMapper.readValue(secondURL, SecondGeoPlugin.class);
        System.out.println("___________________________________________________________\n\n" + firstObject);

        System.out.println("\n__________________________________________________________\n" + secondObject);
    }
}
