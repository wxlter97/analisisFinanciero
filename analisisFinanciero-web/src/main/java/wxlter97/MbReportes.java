package wxlter97;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.Serializable;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import org.omnifaces.cdi.ViewScoped;

@Named(value = "mbReportes")
@ViewScoped 
public class MbReportes implements Serializable {

    private Conexion con = new Conexion();
            
   
    public void verPDF(Map<String, Object> parametros, String filePath) throws Exception {
        JasperPrint jp = JasperFillManager.fillReport(filePath,
                parametros,
                con.conexion());
        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        try (ServletOutputStream outStream = response.getOutputStream()) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            JasperExportManager.exportReportToPdfStream(jp, byteArrayOutputStream);
            response.setContentType("application/pdf");
            outStream.write(byteArrayOutputStream.toByteArray());
            response.setHeader("Cache-Control", "max-age=0");
            response.setContentLength(byteArrayOutputStream.toByteArray().length);
            outStream.flush();
        }
        FacesContext.getCurrentInstance().responseComplete();
    }

    public void rptBalance() {
        try {
            System.out.println("CACA");
            Map<String, Object> parametros = new HashMap<>();
            File jasper = new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("/resources/reports/balance2.jasper"));
            String fileName = jasper.getPath();
            verPDF(parametros, fileName);
        } catch (Exception ex) {
            Logger.getLogger(MbReportes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
