package ec.edu.espe.viveresgabysoftwarekit.utils;


import ec.edu.espe.viveresgabysoftwarekit.model.Constans;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

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
            System.out.println("Scrapped from: " + url + "Successfully");
        } catch (
                IOException e) {
            e.printStackTrace();
        }
        return IVA;
    }
}
