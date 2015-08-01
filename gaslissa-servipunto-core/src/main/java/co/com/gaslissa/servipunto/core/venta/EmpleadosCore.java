/**
 * 
 */
package co.com.gaslissa.servipunto.core.venta;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.com.gaslissa.common.dto.Islero;
import co.com.gaslissa.servipunto.core.exception.CoreException;
import co.com.gaslissa.servipunto.entity.Empleado;
import co.com.gaslissa.servipunto.repository.EmpleadoRepository;

/**
 * @author jsarmien
 *
 */
public class EmpleadosCore {
	
	final static Logger logger = LoggerFactory.getLogger(EmpleadosCore.class);
	
	private final EmpleadoRepository empleadoRepository;
	
	
	public EmpleadosCore(EmpleadoRepository empleadoRepository) {
		super();
		this.empleadoRepository = empleadoRepository;
	}

	/**
	 * Trae la lista de todos los empleados en el BD de servipunto
	 * @return
	 * @throws CoreException
	 */
	public List<Islero> getEmpleados() throws CoreException{
		try{
			List<Islero> isleros = null;
			List<Empleado> empleados = (List<Empleado>) this.empleadoRepository.findAll();
			
			if(empleados != null){
				isleros = new ArrayList<Islero>();
				
				for(Empleado empleado : empleados){
					Islero islero = new Islero();
					islero.setCodigo(empleado.getCodEmp().trim());
					islero.setNombre(empleado.getNombre().trim());
					isleros.add(islero);
				}
			}
			
			return isleros;
		}catch(Exception e){
			logger.error("No se puede realizar la consulta de empelados en la bd servipunto: " + e.getMessage(), e);
			throw new CoreException("No se puede realizar la consulta de empelados en la bd servipunto: " + e.getMessage());
		}
	}

}
