/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tenda;
import java.io.IOException;
import java.net.URL;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

/**
 *
 * @author koke
 */


public class tituloxml extends DefaultHandler {

    //Aqui imos gardar os datos de todalas persoas do XML
    public ArrayList<String> titulo=new ArrayList<>();



    //E un atributo auxiliar po texto que hai entre as etiquetas
    public String cadeaTexto;



    public tituloxml(){
        super();
    }

    /*
    Este e o metodo que se executa ao comezo, antes de parsear nada
    Non o imos utilizar neste caso, poderiase utilizar se fose necesario
     */
    @Override
    public void startDocument() throws SAXException {}

    /*
    Este e o método que se executa ao finalizar o  parseo
    Non o imos utilizar neste caso, poderiase utilizar se fose necesario
     */
    @Override
    public void endDocument() throws SAXException {}

    /*
    Este metodo executase ao comezar a ler unha etiqueta
     */
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

    }

    /*
    Este método executase cando se finaliza de ler unha etiqueta
     */
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        //Finalizamos de ler a etiqueta Nome, polo que podemos gardar o texto que hai entre as etiquetas
        if("title".equals(localName)){
            this.titulo.add(this.cadeaTexto);
        }
    }

    /*
    Este metodo executase cando se le unha cadea de texto
     */
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        //Gardamos todo o texto entre caracteres na cadea de texto auxiliar
        this.cadeaTexto = new String(ch,start,length);

    }

    public ArrayList<String> getTitulo() {
        return titulo;
    }
    
    public void leerxml(){
        XMLReader procesadorXML = null;
        try {

            //Creamos un parseador de texto e engadimoslle a nosa clase que vai parsear o texto
            procesadorXML = XMLReaderFactory.createXMLReader();
            tituloxml titulo = new tituloxml();
            procesadorXML.setContentHandler(titulo);

            //Indicamos o texto donde estan gardadas as persoas
            InputSource arquivo = new InputSource(new URL("http://ep00.epimg.net/rss/elpais/portada.xml").openStream());
            procesadorXML.parse(arquivo);

            //Imprimimos os datos lidos no XML
            ArrayList<String> tituloA = titulo.getTitulo();
            System.out.println("");
            for(int i=2;i<tituloA.size();i++){
                String tituloB = tituloA.get(i);
                System.out.println("Titulo: " + tituloB);
            }
            System.out.println("");

        } catch (SAXException e) {
            System.out.println("Ocurriu un erro ao ler o arquivo XML");
        } catch (IOException e) {
            System.out.println("Ocurriu un erro ao ler o arquivo XML");
        }

    }

}