package co.itac.demo.util;

import co.itac.demo.dto.DatosParaPruebas;

public class GenerarDatosDePrueba {

    public static void main(String[] args) {

    }

    public DatosParaPruebas generarDatos(){
        DatosParaPruebas datos = new DatosParaPruebas();

        datos.setNombresGenerados(mockNombreClientesAleatorios(5));
        datos.setTiposTransaccionesGenerados(mockTransaccionesAleatorios(5));
        datos.setEstadosGenerados(mockEstadosAleatorios(5));
        datos.setProductosGenerados(mockTipoProductos(5));
        datos.setUsuariosGenerados(mockUsuarioAplicaciónAleatorios(5));

        return datos;
    }


    /**
     * Este metodo genera datos de prueba aleatorios, en cada prueba el programa mostrará datos diferentes.
     * @param cantidad Cantidad de datos que se quieren generar.
     * @return un arreglo de String con los datos generados. El formato de salida es: Nombre Apellido
     */
    public static String[] mockNombreClientesAleatorios(int cantidad) {
        String[] nombresAleatorios = new String[cantidad];

        String[] nombres = { "Olga","Alejandra","Armando","Sebastian", "Santiago", "Carlos","Andrea", "David", "Baldomero", "Balduino", "Baldwin", "Baltasar", "Barry", "Bartolo",
                "Bartolomé", "Baruc", "Baruj", "Candelaria", "Cándida", "Canela", "Caridad", "Carina", "Carisa",
                "Caritina", "Carlota", "Baltazar"};
        String[] apellidos = { "Castro","Niño","León", "Martinez", "Perez", "Rodriguez","Gomez", "Guerrero", "Cardenas", "Cardiel", "Cardona", "Cardoso", "Cariaga", "Carillo",
                "Carion", "Castiyo", "Castorena", "Castro", "Grande", "Grangenal", "Grano", "Grasia", "Griego",
                "Grigalva" };

        for (int i = 0; i < cantidad; i++) {
            nombresAleatorios[i] = nombres[(int) (Math.floor(Math.random() * ((nombres.length - 1) - 0 + 1) + 0))] + " "
                    + apellidos[(int) (Math.floor(Math.random() * ((apellidos.length - 1) - 0 + 1) + 0))];
        }
        return nombresAleatorios;
    }

    /**
     * Este metodo genera tipo de transacciones de prueba aleatorios, en cada prueba el programa mostrará datos diferentes.
     * @param cantidad Cantidad de transacciones que se quieren generar.
     * @return un arreglo de String con los datos generados. El formato de salida es: Transaccion
     */
    public static String[] mockTransaccionesAleatorios(int cantidad) {
        String[] transaccionesAleatorios = new String[cantidad];
        String[] transacciones = {"pago", "consignacion", "transferencia", "abono", "cierre", "compra", "apertura", "consulta"};
        for (int i = 0; i < cantidad; i++) {
            transaccionesAleatorios[i] = transacciones[(int) (Math.floor(Math.random() * ((transacciones.length - 1) - 0 + 1) + 0))];
        }
        return transaccionesAleatorios;
    }

    /**
     * Este metodo genera tipo de transacciones de prueba aleatorios, en cada prueba el programa mostrará datos diferentes.
     * @param cantidad Cantidad de transacciones que se quieren generar.
     * @return un arreglo de String con los datos generados. El formato de salida es: Transaccion
     */
    public static String[] mockEstadosAleatorios(int cantidad) {
        String[] estadosAleatorios = new String[cantidad];
        String[] estadosTransaccion = {"aprobado", "negado", "en_espera", "cancelado", "revisado", "enviado", "en_revisión"};
        for (int i = 0; i < cantidad; i++) {
            estadosAleatorios[i] = estadosTransaccion[(int) (Math.floor(Math.random() * ((estadosTransaccion.length - 1) - 0 + 1) + 0))];
        }
        return estadosAleatorios;
    }

    /**
     * Este metodo genera tipo de transacciones de prueba aleatorios, en cada prueba el programa mostrará datos diferentes.
     * @param cantidad Cantidad de transacciones que se quieren generar.
     * @return un arreglo de String con los datos generados. El formato de salida es: Transaccion
     */
    public static String[] mockTipoProductos(int cantidad) {
        String[] productosAleatorios = new String[cantidad];
        String[] productos = {"Cuenta de ahorros", "Cuenta corriente", "Broker", "Fondo de inversión", "Plan de pension", "Hipoteca", "Crédito", "Tarjeta de crédito"};
        for (int i = 0; i < cantidad; i++) {
            productosAleatorios[i] = productos[(int) (Math.floor(Math.random() * ((productos.length - 1) - 0 + 1) + 0))];
        }
        return productosAleatorios;
    }

    /**
     * Este metodo genera datos de prueba aleatorios, en cada prueba el programa mostrará datos diferentes.
     * @param cantidad Cantidad de datos que se quieren generar.
     * @return un arreglo de String con los datos generados. El formato de salida es: Nombre Apellido
     */
    public static String[] mockUsuarioAplicaciónAleatorios(int cantidad) {
        String[] usauriosAleatorios = new String[cantidad];

        String[] nombres = { "maria", "damian", "aleja", "pedro", "luis", "ana","tomas", "elverth", "julian", "daniel",
                "ruben", "marlon", "carlos", "andres", "javier", "lourdes", "daniela", "marcela", "lina", "jina",
                "katerin", "natalia", "astrid", "carlina", "carmen", "baltazar"};
        String[] apellidos = { "castro","nuñez","gracia", "madariaga", "perez", "rodriguez","gomez", "guerrero", "cardenas",
                "mejia", "cardona", "ruiz", "saenz", "carillo", "garzon", "castiyo", "castorena", "castro",
                "muriel", "jaramillo", "gutierrez", "paez", "dominguez", "valdez" };

        for (int i = 0; i < cantidad; i++) {
            usauriosAleatorios[i] = nombres[(int) (Math.floor(Math.random() * ((nombres.length - 1) - 0 + 1) + 0))]
                    +"."+ apellidos[(int) (Math.floor(Math.random() * ((apellidos.length - 1) - 0 + 1) + 0))]
                    +"@bsnc.com.co";
        }
        return usauriosAleatorios;
    }

}
