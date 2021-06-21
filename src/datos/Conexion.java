package datos;
import java.sql.*;
import java.util.Map;
import java.util.HashMap;

import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
public class Conexion {
	public Connection conn;
	public String driver = "com.mysql.cj.jdbc.Driver";
	public String cadena = "jdbc:mysql://localhost/MILKY_WAY";
	public String usuario ="root";
	public String clave ="";
	public Connection obtener_conexion() {
		try {
			Class.forName(driver);
			conn= DriverManager.getConnection(cadena,usuario,clave);
		}catch(ClassNotFoundException e1) {
			JOptionPane.showMessageDialog(null, "Error en el Driver");
		}catch(SQLException e2) {
			JOptionPane.showMessageDialog(null, "Error en la Conexión");
		}
		return conn;
	}
	
	public void reporte_cliente(String reporte,String consulta, String distrito) {
		try {
			conn=obtener_conexion();
			String sql = consulta;
			String ruta = "src/reporte/"+reporte+".jrxml";
			JasperDesign jd=JRXmlLoader.load(ruta);
			Map<String,Object> map=new HashMap<String,Object>();
			map.clear();
			map.put("distrito", distrito);
			JRDesignQuery jrdq = new JRDesignQuery();
			jrdq.setText(sql);
			jd.setQuery(jrdq);
			JasperReport jr = JasperCompileManager.compileReport(jd);
			JasperPrint jp = JasperFillManager.fillReport(jr, map, conn);
			JasperViewer.viewReport(jp,false);
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Error al ejecutar su reporte");
		}
	}
	public void reporte_producto(String reporte, String consulta, String categoria) {
		try {
			conn=obtener_conexion();
			String sql = consulta;
			String ruta = "src/reporte/"+reporte+".jrxml";
			JasperDesign jd=JRXmlLoader.load(ruta);
			Map<String,Object> map=new HashMap<String,Object>();
			map.clear();
			map.put("categoria", categoria);
			JRDesignQuery jrdq = new JRDesignQuery();
			jrdq.setText(sql);
			jd.setQuery(jrdq);
			JasperReport jr = JasperCompileManager.compileReport(jd);
			JasperPrint jp = JasperFillManager.fillReport(jr, map, conn);
			JasperViewer.viewReport(jp,false);
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al ejecutar su reporte");
		}
	}
}