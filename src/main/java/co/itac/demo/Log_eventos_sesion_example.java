package co.itac.demo;

import co.itac.baas.componentes.logs.ProveedorContextoLog;
import co.itac.baas.componentes.logs.dto.AtributosContextoLog;
import co.itac.demo.dto.DatosParaPruebas;
import co.itac.demo.util.CargarValoresContexto;
import co.itac.demo.util.GenerarDatosDePrueba;
import lombok.extern.slf4j.Slf4j;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Random;

import static net.logstash.logback.argument.StructuredArguments.kv;

@Slf4j
public class Log_eventos_sesion_example {

    /**
     * Se declara una instancia del objeto que transporta los datos del contexto.
     */
    private static AtributosContextoLog parametrosContexto = new AtributosContextoLog();

    /**
     * Este metodo permite generar la prueba de registrar en el log los datos del contexto de sesión más los datos
     * particulares generado aleatoriamente para efectos de las pruebas.
     */
    public static void main(String args[]) {
        CargarValoresContexto cargarValoresContexto = new CargarValoresContexto();
        GenerarDatosDePrueba generarDatosDePrueba = new GenerarDatosDePrueba();
        try {
            //Se obtienen los atributos del contexto de aplicación desde el properties.
            parametrosContexto = cargarValoresContexto.cargarAtributos();

            //Se registran en el log atributos especificos y particulares a este metodo.
            imprimirLog(generarDatosDePrueba.generarDatos());

        } catch (Exception e) {
            log.error("Se generó error '" + e.getMessage() + "' Prueba alcance: Sesión", e);
        }
    }


    /**
     * Este metodo registra en el log datos de prueba.
     * @param datos Nombres de cliente de prueba, productos, tipo de transacciones, y estados.
     */
    public static void imprimirLog(DatosParaPruebas datos) {
        ProveedorContextoLog proveedorContextoLog = new ProveedorContextoLog();
        SecureRandom random = new SecureRandom();
        for (int i = 0; i < datos.getNombresGenerados().length; i++) {
            String trama = new BigInteger(130, random).toString(32);
            Long cuenta = new Long(String.valueOf(new Random().nextLong()).substring(6));
            int idTransaccion = new Random().nextInt(900)+100;

            log.info("Demostración envío de tramas en una transacción bancaria: {}, {}, {}, {}, {}, {}, {}, {}, {}, {}.",
                    kv("Aplicacion", parametrosContexto.getAplicacion()),
                    kv("Funcionalidad", parametrosContexto.getFuncionalidad()),
                    kv("Modulo", parametrosContexto.getModulo()),
                    kv("Componente", parametrosContexto.getComponente()),
                    kv("Version", parametrosContexto.getVersion()),
                    kv("Cliente", datos.getNombresGenerados()[i]),
                    kv("Producto", datos.getProductosGenerados()[i]),
                    kv("Cuenta", cuenta),
                    kv("Trama", trama),
                    kv("Transacción", "SE".concat(String.valueOf(idTransaccion).concat(datos.getTiposTransaccionesGenerados()[i]))),
                    kv("Estado", datos.getEstadosGenerados()[i]),
                    kv("Usuario", datos.getUsuariosGenerados()[i]),
                    kv("Sesion","S".concat((idTransaccion-i)+cuenta.toString().substring(2,5)).concat(
                            datos.getUsuariosGenerados()[i].substring(0,datos.getUsuariosGenerados()[i].length()-(datos.getUsuariosGenerados()[i].length()-1)))
                            .concat(String.valueOf(idTransaccion).substring(0,2))
                            .concat(trama.substring(4,7)))
            );

            parametrosContexto.setTransaccion(String.valueOf(idTransaccion).concat(datos.getTiposTransaccionesGenerados()[i]));
            parametrosContexto.setUsuario(datos.getUsuariosGenerados()[i]);
            parametrosContexto.setSesion("S".concat((idTransaccion-i)+cuenta.toString().substring(3,5)));

            //Se registran datos según el alcance del contexto de la prueba.
            proveedorContextoLog.registrarDatosAplicacion(parametrosContexto);
            proveedorContextoLog.registrarDatosSesion(parametrosContexto);
        }
    }

}