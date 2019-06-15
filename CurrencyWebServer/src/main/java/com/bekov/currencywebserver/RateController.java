package com.bekov.currencywebserver;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@RestController
public class RateController {

    @Value("${rate.uri_rate}")
    private String uri_rate;
    @Value("${rate.uri_rates}")
    private String uri_rates;

    static List<Rate> rateList = new ArrayList<>();


    @GetMapping("/rate")
    public List<Rate> downloadRateInfo() throws IOException, ParserConfigurationException, SAXException {
        getRate(uri_rate);
        getRate(uri_rates);

        return rateList;
    }




    public List<Rate> getRate(String strURL) throws ParserConfigurationException, IOException, SAXException {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");


        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(strURL);
        doc.getDocumentElement().normalize();

        NodeList nList = doc.getElementsByTagName("Currency");
        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList.item(temp);
            Element eElement = (Element) nNode;
            String code = String.valueOf(eElement.getAttribute("ISOCode"));
            Double value = Double.valueOf(eElement.getElementsByTagName("Value").item(0).getTextContent().replaceAll(",", "."));

            String date =String.valueOf(doc.getFirstChild().getAttributes().getNamedItem("Date").getNodeValue());

            Rate rates = new Rate(date, code, value);
            rateList.add(rates);


        }
        return rateList;

    }
}
