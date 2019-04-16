package co.itac.demo.util;

import co.itac.baas.componentes.logs.dto.AtributosContextoLog;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

/**
 * Esta clase permite obtener los valores fijos del contexto que son de alcance de aplicación leyendo el archivo
 * de propiedades.
 */
@Slf4j
public class CargarValoresContexto {

  /**
   * Instancia de la clase Properties que permite leer el fichero de propiedades
   */
  private static Properties appProps = new Properties();

  /**
   * Se le pasa la ruta donde tenemos ubicado nuestro archivo de propiedades, para el componente de logs
   * se tiene un archivo application.properties que es donde se definen los atributos de contexto de alcance Aplicacion.
   */
  private static Path propertyFile = Paths.get("src/main/resources/application.properties");

  /**
   * Este metodo permite obtener los atributos de alcance aplicación desde el archivo de propiedades y se le asignan a
   * los atributos del objeto de transferencia de datos AtributosContextoLog que es retornado para su registro en el log.
   * @return AtributosContextoLog
   */
  @PostConstruct
  public AtributosContextoLog cargarAtributos() {
    AtributosContextoLog atributosDto = new AtributosContextoLog();
    try {
      Reader propReader = Files.newBufferedReader(propertyFile);
      appProps.load(propReader);

      atributosDto.setAplicacion(appProps.getProperty("contexto.aplicacion.name"));
      atributosDto.setFuncionalidad(appProps.getProperty("contexto.funcionalidad.name"));
      atributosDto.setModulo(appProps.getProperty("contexto.modulo.name"));
      atributosDto.setComponente(appProps.getProperty("contexto.componente.name"));
      atributosDto.setVersion(appProps.getProperty("contexto.version.name"));
      log.info("Obteniendo atributos fijos de aplicación desde archivo de properties: aplicacion: "+
              atributosDto.getAplicacion()+
              " funcionalidad: "+atributosDto.getFuncionalidad()+
              " modulo; "+atributosDto.getModulo()+
              " componente; "+atributosDto.getComponente()+
              " version; "+atributosDto.getVersion()
      );

    } catch (IOException e) {
      e.printStackTrace();
    } catch (Exception e) {
      log.warn("Excepción inesperada en cargue de atributos de aplicación desde el archivo de propiedades.", e.getMessage());
    }

    return atributosDto;
  }
}
