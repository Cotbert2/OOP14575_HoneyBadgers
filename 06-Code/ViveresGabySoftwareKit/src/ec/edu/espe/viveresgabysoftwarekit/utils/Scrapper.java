package ec.edu.espe.viveresgabysoftwarekit.utils;

import ec.edu.espe.viveresgabysoftwarekit.helpers.Constans;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

/**
 * @autor Alex Cuzco, Stefany Díaz, Eduardo García, Matego García-HONEYBUDGERS-DCCO-14575
 */

public class Scrapper {
    float IVA = 12f;

    public float updateIva() {
        String url = Constans.IVA_URL;

        try {
            Document doc = Jsoup.connect(url).get();
            Element container = doc.selectFirst("div#page-information").getElementById("¿cuál-es").selectFirst("div.contenido-seccion div");
            String ivaComponent = container.text().substring(34, 36);
            IVA = Float.parseFloat(ivaComponent);
            System.out.println("Iva: " + IVA);
            System.out.println("Scrapped from: " + url + " Successfully");
        } catch (
                IOException e) {
            System.out.println("[-] Something went wrong while scrapping the IVA from: " + url );
        }
        return IVA;
    }
}
