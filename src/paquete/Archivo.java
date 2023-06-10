/*
 * Universidad Politécnica de San Luis Potosí
 * Programación III Java 
 * Programación Orientada a Objetos
 */

package paquete;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.HeadlessException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * Clase que da los métodos para el uso de archivos con hilos
 * @author Ana Sofía Rodríguez Castillo, 178815@upslp.edu.mx
 * @author Ana Sofía Rodriguez Castillo
 * @author 178815@upslp.edu.mx
 * @version 1.0
 */
public class Archivo extends Thread{
    
    /**
     * fuente del pdf
     */
    private Font fontSubrayado = new Font(Font.FontFamily.HELVETICA, 12, Font.UNDERLINE);
    /**
     * fuente del pdf
     */
    Font fontAzul = new Font(Font.FontFamily.HELVETICA, 12, Font.NORMAL, BaseColor.BLUE);
    /**
     * fuente del pdf
     */
    Font fontNaranja = new Font(Font.FontFamily.HELVETICA, 12, Font.NORMAL, BaseColor.RED);
    /**
     * Representa la conexión 
     */
    private final Connection con;
    /**
     * id empleado para la consulta
     */
    private int idEmpleado;
    /**
     * estado para la consulta
     */
    private String estado;
    /**
     * tipo de consulta 1 general / 2 empleado / 3 estado
     */
    private int opcion;

    /**
     * Crea una instancia de tipo archivo
     * @param con conexión
     * @param opcion 1 general / 2 empleado / 3 estado
     */
    public Archivo(Connection con, int opcion) {
        this.con = con;
        this.opcion = opcion;
    }
    
    /**
     * Crea una instancia de tipo archivo
     * @param con conexión
     * @param idEmpleado id del empleado
     * @param opcion 1 general / 2 empleado / 3 estado
     */
    public Archivo(Connection con, int idEmpleado, int opcion) {
        this.con = con;
        this.idEmpleado = idEmpleado;
        this.opcion = opcion;
    }
    
    /**
     * Crea una instancia de tipo archivo
     * @param con conexión
     * @param estado Activo / en proceso / entregado
     * @param opcion 1 general / 2 empleado / 3 estado
     */
    public Archivo(Connection con, String estado, int opcion) {
        this.con = con;
        this.estado = estado;
        this.opcion = opcion;
    }
    
    @Override
    public void run(){
        try{
            switch (opcion) {
                case 1:
                    xlsGeneral();
                    pdfGeneralPkt();
                    break;
                case 2:
                    xlsXEmpleadoPkt();
                    pdfXEmpleadoPkt();
                    break;
                case 3:
                    xlsEstadoPkt();
                    pdfXEstadoPkt();
                    break;
                default:
                    break;
            }
            
        }catch(FileNotFoundException err){
            System.out.println(err);
        }
    }
    
    /**
     * metodo que genera el archivo excel de la consulta general de paquetes
     * @throws FileNotFoundException excepcion por si no encuentra el archivo
     */
    public synchronized void xlsGeneral()throws FileNotFoundException{
        try{
            PrintStream reporte = new PrintStream("src/Reportes/ReporteGeneralPaquetesXLS.xls");
            Statement sts = con.createStatement();
            sts.execute("SELECT idPaquete, idCliente, nombreCliente, direccion, pClave, estado FROM paquete");
            ResultSet rs = sts.getResultSet();
            reporte.println("ID PAQUETE \t ID CLIENTE \t NOMBRE CLIENTE \t DIRECCIÓN \t PALABRA CLAVE \t ESTADO");
            while(rs.next()){
                reporte.println(rs.getInt("idPaquete") 
                        + "\t" + rs.getInt("idCliente") 
                        + "\t" + rs.getString("nombreCliente") 
                        + "\t" + rs.getString("direccion")
                        + "\t" + rs.getString("pClave")
                        + "\t" + rs.getString("estado")
                );
            }
        }catch(SQLException e){
            System.out.println("Error"+e);
        }
    }
    
    /**
     * A partir de una consutla sql se genera un pdf con los registros de 
     * todos los paquetes que han sido registrados
     */
    public synchronized void pdfGeneralPkt(){
        Document documento = new Document();
        
        try{
            
            Image imagen = null;
            try {
                imagen = Image.getInstance("img/FedExLogo.png");
                imagen.scaleAbsolute(150, 100);
                imagen.setAbsolutePosition(75, documento.getPageSize().getHeight() - 120);
            } catch (BadElementException | IOException ex) {
                Logger.getLogger(Paquete.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            Paragraph titulo1 = new Paragraph("PAQUETERIA FEDEX", fontSubrayado);
            titulo1.setAlignment(Element.ALIGN_CENTER); 
            titulo1.setSpacingAfter(20); 
            titulo1.setSpacingBefore(40);

            Paragraph titulo2 = new Paragraph("Reporte General de Paquetes",fontAzul);
            titulo2.setIndentationLeft(150);
            titulo2.setSpacingAfter(10);
            
            Paragraph titulo3 = new Paragraph("Todos los paquetes",fontNaranja);
            titulo3.setIndentationLeft(380);
            titulo3.setSpacingAfter(10);
            
            PdfWriter.getInstance(documento, new FileOutputStream("src/Reportes/ReporteGeneralPaquetes.pdf"));
            documento.setMargins(10, 10, 20, 20); 
            documento.open();
            documento.add(imagen);
            documento.add(titulo1);
            documento.add(titulo2);
            documento.add(titulo3);
            
            PdfPTable tabla = new PdfPTable(6);
            tabla.getDefaultCell().setBorderColor(BaseColor.WHITE);
            Font font = new Font(Font.FontFamily.HELVETICA, 3);

            tabla.setSpacingBefore(10);
            agregarTitulo(tabla, "Id paquete");
            agregarTitulo(tabla, "Id cliente");
            agregarTitulo(tabla, "Nom Cliente");
            agregarTitulo(tabla, "Dirección");
            agregarTitulo(tabla, "Palabra Clave");
            agregarTitulo(tabla, "Estado");
            
            Statement sts = con.createStatement();
            sts.execute("SELECT idPaquete, idCliente, nombreCliente, direccion, pClave, estado FROM paquete");
            ResultSet rs = sts.getResultSet();
            
            while(rs.next()){
                tabla.setSpacingBefore(10);
                font.setSize(5);
                
                tabla.addCell(rs.getString(1));
                tabla.addCell(rs.getString(2));
                tabla.addCell(rs.getString(3));
                tabla.addCell(rs.getString(4));
                tabla.addCell(rs.getString(5));
                tabla.addCell(rs.getString(6));
            }
            
            documento.add(tabla);
            documento.close();
            JOptionPane.showMessageDialog(null, "Reporte generado");
            
        }catch(DocumentException | HeadlessException | FileNotFoundException | SQLException e){
            
        }
    }
    
    /**
     * método que genera el archivo pdf de la consulta por empleado de los paquetes
     * @throws FileNotFoundException archivo no encontrado
     */
    public synchronized void xlsXEmpleadoPkt()throws FileNotFoundException{
        try{
            PrintStream reporte = new PrintStream("src/Reportes/ReporteIdEmpleadoXLS_"+idEmpleado+".xls");
            Statement sts = con.createStatement();
            sts.execute("SELECT idPaquete, estado FROM paquete WHERE idEmpleado = " + idEmpleado +"");
            ResultSet rs = sts.getResultSet();
            reporte.println("ID PAQUETE \t ESTADO");
            while(rs.next()){
                reporte.println(rs.getInt("idPaquete")
                        + "\t" + rs.getString("estado")
                );
            }
        }catch(SQLException e){
            System.out.println("Error"+e);
        }
    }
    /**
     * A partir de un id de empleado se genera un pdf con la consulta de 
     * los paquetes que han sido asignados a ese empleado
     */
    public synchronized void pdfXEmpleadoPkt(){
        Document documento = new Document();
        
        try{
            Image imagen = null;
            try {
                imagen = Image.getInstance("img/FedExLogo.png");
                imagen.scaleAbsolute(150, 100);
                imagen.setAbsolutePosition(75, documento.getPageSize().getHeight() - 120);
            } catch (BadElementException | IOException ex) {
                Logger.getLogger(Paquete.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            Paragraph titulo1 = new Paragraph("PAQUETERIA FEDEX", fontSubrayado);
            titulo1.setAlignment(Element.ALIGN_CENTER); 
            titulo1.setSpacingAfter(20); 
            titulo1.setSpacingBefore(40);

            Paragraph titulo2 = new Paragraph("Paquetes asignados a un empleado",fontAzul);
            titulo2.setIndentationLeft(150);
            titulo2.setSpacingAfter(10);
            
            Paragraph titulo4 = new Paragraph("Id Empleado: " + idEmpleado,fontNaranja);
            titulo4.setIndentationLeft(380);
            titulo4.setSpacingAfter(10);
            
            PdfWriter.getInstance(documento, new FileOutputStream("src/Reportes/ReporteIdEmpleado_"+idEmpleado+".pdf"));
            documento.setMargins(10, 10, 20, 20); 

            documento.open();
            documento.add(imagen);
            documento.add(titulo1);
            documento.add(titulo2);
            documento.add(titulo4);
            
            PdfPTable tabla = new PdfPTable(2);
            tabla.getDefaultCell().setBorderColor(BaseColor.WHITE);
            Font font = new Font(Font.FontFamily.HELVETICA, 3);
            
            tabla.setSpacingBefore(10);
            agregarTitulo(tabla, "Id paquete");
            agregarTitulo(tabla, "Estado");
            
            Statement sts = con.createStatement();
            sts.execute("SELECT idPaquete, estado FROM paquete WHERE idEmpleado = " + idEmpleado + "");
            ResultSet rs = sts.getResultSet();
            
            while(rs.next()){
                tabla.setSpacingBefore(10);
                font.setSize(5);
                tabla.addCell(rs.getString(1));
                tabla.addCell(rs.getString(2));
            }

            documento.add(tabla);
            documento.close();
            JOptionPane.showMessageDialog(null, "Reporte generado");
            
        }catch(DocumentException | HeadlessException | FileNotFoundException | SQLException e){
            
        }
        
    }
    
    /**
     * Método que genera el archivo excel para la consulta de paqutes por el estado en el que se encuentran
     * @throws FileNotFoundException archivo no encontrado
     */
    public synchronized void xlsEstadoPkt()throws FileNotFoundException{
        try{
            PrintStream reporte = new PrintStream("src/Reportes/ReporteEstado_"+estado+".xls");
            Statement sts = con.createStatement();
            sts.execute("SELECT p.idPaquete, p.idEmpleado, e.nombre FROM paquete AS p JOIN empleado AS e ON p.idEmpleado = e.idEmpleado WHERE p.estado = '"+ estado + "'");
            ResultSet rs = sts.getResultSet();
            reporte.println("ID PAQUETE \t ID EMPLEADO \t NOMBRE EMPLEADO");
            while(rs.next()){
                reporte.println(rs.getInt(1)
                        + "\t" + rs.getInt(2)
                        + "\t" + rs.getString(3)
                );
            }
        }catch(SQLException e){
            System.out.println("Error"+e);
        }
    }
    /**
     * A partir del estado de los paquetes se genera un pdf con la consulta de 
     * los paquetes que tienen este estado
     */
    public void pdfXEstadoPkt(){
        Document documento = new Document();
        
        try{
            Image imagen = null;
            try {
                imagen = Image.getInstance("img/FedExLogo.png");
                imagen.scaleAbsolute(150, 100);
                imagen.setAbsolutePosition(75, documento.getPageSize().getHeight() - 120);
            } catch (BadElementException | IOException ex) {
                Logger.getLogger(Paquete.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            Paragraph titulo1 = new Paragraph("PAQUETERIA FEDEX", fontSubrayado);
            titulo1.setAlignment(Element.ALIGN_CENTER); 
            titulo1.setSpacingAfter(20); 
            titulo1.setSpacingBefore(40);

            Paragraph titulo2 = new Paragraph("Paquetes por estado",fontAzul);
            titulo2.setIndentationLeft(150);
            titulo2.setSpacingAfter(10);
            
            Paragraph titulo4 = new Paragraph("Estado: " + estado,fontNaranja);
            titulo4.setIndentationLeft(380);
            titulo4.setSpacingAfter(10);

            PdfWriter.getInstance(documento, new FileOutputStream("src/Reportes/ReporteEstado_"+estado+".pdf"));
            documento.setMargins(10, 10, 20, 20); 

            documento.open();
            documento.add(imagen);
            documento.add(titulo1);
            documento.add(titulo2);
            documento.add(titulo4);
            
            PdfPTable tabla = new PdfPTable(3);
            tabla.getDefaultCell().setBorderColor(BaseColor.WHITE);
            Font font = new Font(Font.FontFamily.HELVETICA, 3);
            
            tabla.setSpacingBefore(3);
            agregarTitulo(tabla, "Id paquete");
            agregarTitulo(tabla, "Id empleado");
            agregarTitulo(tabla, "Nombre empleado");
            
            Statement sts = con.createStatement();
            sts.execute("SELECT p.idPaquete, p.idEmpleado, e.nombre FROM paquete AS p JOIN empleado AS e ON p.idEmpleado = e.idEmpleado WHERE p.estado = '"+ estado + "'");
            ResultSet rs = sts.getResultSet();
            
            while(rs.next()){
                tabla.setSpacingBefore(10);
                font.setSize(5);
                tabla.addCell(rs.getString(1));
                tabla.addCell(rs.getString(2));
                tabla.addCell(rs.getString(3));
            }

            documento.add(tabla);
            documento.close();
            JOptionPane.showMessageDialog(null, "Reporte generado");
            
        }catch(DocumentException | HeadlessException | FileNotFoundException | SQLException e){
            
        }
        
    }
    
    /**
     * Método que da formato a los títulos de la tabla
     * @param tabla tabla
     * @param texto texto del pdf
     */
    private void agregarTitulo(PdfPTable tabla, String texto) {
        PdfPCell celdaTitulo = new PdfPCell(new Phrase(texto, new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD)));
        celdaTitulo.setBackgroundColor(BaseColor.LIGHT_GRAY);
        celdaTitulo.setHorizontalAlignment(Element.ALIGN_CENTER);
        tabla.addCell(celdaTitulo);
    }

}
