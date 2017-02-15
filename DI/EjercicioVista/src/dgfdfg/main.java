/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dgfdfg;

import java.awt.List;
import java.io.File;
import java.util.ArrayList;
import java.util.jar.JarException;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;

/**
 *
 * @author AlumnoT
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws JarException, JRException {

        List<Cliente> listaClientes = new ArrayList<Cliente>();
        for (int i = 1; i <= 49; i++) {
            listaClientes.add(new Cliente(i, "cliente " + i, "persianas"));
        }
        
        for (int i = 50; i <= 79; i++) {
            listaClientes.add(new Cliente(i, "Cliente " + i, "sillas"));
        }

        JasperReport reporte = (JasperReport) JRLoader.loadObject("src/informe.jasper");
        JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, null, new JRBeanCollectionDataSource(listaClientes, false));
        JRExporter exporter = new JRPdfExporter();
        exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
        exporter.setParameter(JRExporterParameter.OUTPUT_FILE, new File("reportegrafica.pdf"));
    }
}
