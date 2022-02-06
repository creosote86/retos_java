package ChipBici;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

// ------------------------------------------------------------
//                   Clase ChipBici
// ------------------------------------------------------------
/**
 * Clase que representa un <strong>microdispositivo de bicicleta</strong> que se acopla
 * a las bicis de alquiler de un establecmiento deportes de ocio y aventura.
 * <p>
 * Los objetos de esta clase permiten almacenar y gestionar información sobre la
 * versión de firmware en el chip de la bici, así como fecha y hora del alquiler actual
 * de la bici, si es que está alquilada, datos sobre distancia recorrida, fecha
 * del último alquiler, etc. </p>
 * <p>
 * La clase también dispone de información general independiente de los objetos
 * concretos que se hayan creado. Es el caso de:</p>
 * <ul>
 * <li><strong>número total de chips</strong> insertados hasta el momento o lo
 * que es lo mismo, <strong>número total de bicis</strong>;</li>
 * <li><strong>número de bicis alquiladas</strong> en el momento actual, o</li>
 * <li><strong>distancia global</strong> recorrida por todas las bicis.</li>
 * </ul>
 *
 * @author profe
 */
public class ChipBici {

    // ------------------------------------------------------------
    //                 ATRIBUTOS ESTÁTICOS (de clase)
    // ------------------------------------------------------------
    // Atributos estáticos constantes públicos
    // (rangos y requisitos de los atributos de objeto)
    // Son públicos, disponibles para que cualquier código cliente pueda acceder a ellos
    // ---------------------------------------------------------------------------------
    /**
     * Máximo trayecto permitido para realizar a una bici:
     * {@value MAX_DISTANCIA_TRAYECTO} km.
     */
    public final static double MAX_DISTANCIA_TRAYECTO = 140.0;

    /**
     * Máxima versión del firmware permitida: {@value MAX_VERSION}.
     */
    public static final int MAX_VERSION = 10;
    /**
     * Mínima versión del firmware permitida: {@value MIN_VERSION}.
     */
    public static final int MIN_VERSION = 1;
    /**
     * Valor por omisión para la versión del firmware: {@value DEFAULT_VERSION}.
     */
    public static final int DEFAULT_VERSION = MIN_VERSION;

    /**
     * Máxima revisión del firmware permitida: {@value MAX_REVISION}.
     */
    public static final int MAX_REVISION = 9;
    /**
     * Mínima revisión del firmware permitida: {@value MIN_REVISION}.
     */
    public static final int MIN_REVISION = 0;
    /**
     * Valor por omisión para la revisión del firmware:
     * {@value DEFAULT_REVISION}.
     */
    public static final int DEFAULT_REVISION = MIN_REVISION;

    /**
     * Mínima fecha de adquisición permitida: 15/06/2020.
     */
    public static final LocalDate MIN_FECHA_ADQUISICION = LocalDate.of(2020, 6, 15);

    // Atributos estáticos constantes privados para uso interno
    private static final DateTimeFormatter FORMATO_FECHA = DateTimeFormatter.ofPattern("dd/MM/YYYY");
    private static final  DateTimeFormatter FORMATO_FECHA_HORA = DateTimeFormatter.ofPattern("dd/MM/YYYY HH:mm:ss");

    // ------------------------------------------------------------------------
    // Atributos estáticos variables (privados).
    // Representan "estado" de la clase en general. No de objetos en particular
    // ------------------------------------------------------------------------

    private static int numBicis = 0;                    // Total de chips/bicis creados hasta el momento
    private static double kilometrosTodasLasBicis = 0;  // Total de kilómetros recorridos entre todas las bicis
    private static int bicisAlquiladas = 0;             // Número de bicis alquiladas en un momento dado

    // ------------------------------------------------------------
    //               ATRIBUTOS DE OBJETO (todos privados)
    // ------------------------------------------------------------
    // Atributos de objeto constantes durante la vida del objeto (desde que se crea objeto)
    // No hace falta declararlas como variables pues no van a cambiar una vez creado el objeto.
    // Representan "características inmutables" o "de naturaleza" del objeto.
    // (usamos notación "camelCase" aunque sean final, pues son "internos" y no los "ve" nadie más)
    // ------------------------------------------------------------------------
    private final long numSerie;                // Número de serie de la bici (desde 1 hasta el máximo número positivo long)
    private final LocalDate fechaAdquisicion;   // Fecha en que fue adquirida la bici por la organización

    // Atributos de objeto variables
    // Representan el "estado" del objeto en un instante dado.
    // ------------------------------------------------------------------------
    private boolean alquilada;    // Si ya está o no alquilada la bici
    private int version;          // Versión(v) del firmware: v.r
    private int revision;         // Revisión(r) del firmware: v.r 
    private LocalDateTime registroInicioAlquilerActual;  // Inicio del alquiler actual (null si no está alquilada)
    private double kilometrosTotales;                    // Total de kilómetros recorridos por la bici
    private double kilometrosRecorridosAlquilerActual;   // Kilómetros recorridos durante el alquiler actual (0 si no está alquilada)
    // Información relativa al último alquiler de la bici:
    private LocalDateTime registroUltimoAlquiler;        // Fecha y hora del inicio del último alquiler (no actual). Si no ha se ha alquilado nunca antes será null
    private LocalDateTime registroFinUltimoAlquiler;     // Fecha y hora del fin del último alquiler. Si no ha se ha alquilado nunca antes será null
    private double kilometrosRecorridosUltimoAlquiler;   // Kilómetros recorridos durante el último alquiler (no actual). Si no ha se ha alquilado nunca antes será 0.0

    // ------------------------------------------------------------
    //                        CONSTRUCTORES
    // ------------------------------------------------------------
    /**
     * Constructor basado en la fecha de adquisición de la bici, así como en la
     * versión y la revisión del firmware (v.r). Crea un nuevo objeto
     * <code>ChipBici</code> con la versión y revisión de firmware y la fecha de
     * adquisición indicadas. La <strong>versión</strong>
     * debe estar entre <code>ChipBici.MIN_VERSION</code> y
     * <code>ChipBici.MAX_VERSION</code>. La <strong>revisión</strong> debe
     * estar entre <code>ChipBici.MIN_REVISION</code> y
     * <code>ChipBici.MAX_REVISION</code>. La <strong>fecha de
     * adquisición</strong> no puede ser anterior a
     * <code>ChipBici.MIN_FECHA_ADQUISICION</code> ni posterior a la fecha
     * actual.
     * @param fechaAdquisicion fecha de adquisición de la bici
     * @param version versión del firmware
     * @param revision revision del firmware
     * @throws IllegalArgumentException Si alguno de los parámetros no es válido
     */
    public ChipBici(LocalDate fechaAdquisicion, int version, int revision) throws IllegalArgumentException {

        if (fechaAdquisicion == null || fechaAdquisicion.isBefore(ChipBici.MIN_FECHA_ADQUISICION)
                || fechaAdquisicion.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Fecha incorrecta: "
                    + (fechaAdquisicion != null ? fechaAdquisicion.format(FORMATO_FECHA) : null));
        } else if (!versionCorrecta(version)) {
            throw new IllegalArgumentException("Versión incorrecta: " + version);
        } else if (!revisionCorrecta(revision)) {
            throw new IllegalArgumentException("Revisión incorrecta: " + revision);
        } else {
            // No hay errores, se procede a crear e inicializar atributos de objeto

            // Inicialización de atributos "inmutables"
            this.numSerie = ChipBici.numBicis+1;

            // Inicialización de atributos de estado
            this.version = version;
            this.revision = revision;
            this.fechaAdquisicion = fechaAdquisicion;

            // Estas inicializaciones no son obligatorias: (en Java un atributo no inicializado pasa a ser el valor "nulo" de su tipo)
            this.alquilada = false;
            this.kilometrosRecorridosAlquilerActual = 0;
            this.kilometrosRecorridosUltimoAlquiler = 0;
            this.kilometrosTotales = 0;

            // Actualizamos atributos de clase
            ChipBici.numBicis++;
        }
    }
    
    /**
     * Constructor basado en la versión y la revisión del firmware (v.r). 
     * Crea un nuevo objeto <code>ChipBici</code> con la versión y revisión 
     * de firmwareindicadas. La <strong>versión</strong>
     * debe estar entre <code>ChipBici.MIN_VERSION</code> y
     * <code>ChipBici.MAX_VERSION</code>. La <strong>revisión</strong> debe
     * estar entre <code>ChipBici.MIN_REVISION</code> y
     * <code>ChipBici.MAX_REVISION</code>.
     * @param version versión del firmware
     * @param revision revision del firmware
     * @throws IllegalArgumentException Si alguno de los parámetros no es válido
     */
    public ChipBici(int version, int revision) throws IllegalArgumentException {
        this(LocalDate.now(), version, revision);
    }

    /**
     * Constructor sin parámetros. Crea un nuevo objeto <code>ChipBici</code>
     * con la fecha actual como fecha de adquisición y con los valores por
     * omisión para la versión y la revisión.
     */
    public ChipBici() {
        this(ChipBici.DEFAULT_VERSION, ChipBici.DEFAULT_REVISION);
    }

    // ------------------------------------------------------------
    //          MÉTODOS "FÁBRICA" O PSEUDOCONSTRUCTORES
    // ------------------------------------------------------------
    /**
     * Método "fábrica" creador de un array de objetos ChipBici. Crea un array
     * de referencias a objetos <code>ChipBici</code> con los parámetros por
     * omisión. El tamaño del array será indicado por el parámetro
     * <code>cantidad</code>.
     * @param cantidad tamaño del array a devolver
     * @return array de referencias a objetos <code>ChipBici</code>
     * @throws IllegalArgumentException si la cantidad es inferior a 1
     */
    public static ChipBici[] crearArrayChipBici(int cantidad) throws IllegalArgumentException {
        if (cantidad < 1) {
            throw new IllegalArgumentException("Cantidad no válida: " + cantidad);
        }
        ChipBici[] arrayChipBici = new ChipBici[cantidad];
        for (int i = 0; i < arrayChipBici.length; i++) {
            arrayChipBici[i] = new ChipBici();
        }
        return arrayChipBici;
    }

    // ------------------------------------------------------------
    //                 Getters:  Métodos GET
    // ------------------------------------------------------------
    // Métodos de consulta del estado (atributos) del objeto
    // -----------------------------------------------------
    // Algunos puede que devuelvan directamente el valor de un atributo.
    // Otros puede que devuelvan el resultado de operar con uno o varios atributos.
    /**
     * Obtiene el número de serie de la bici.
     * @return número de serie de la bici
     */
    public String getNumSerie() {
        return String.valueOf(this.numSerie);
    }

    /**
     * Obtiene la fecha de adquisición de la bici.
     * @return fecha de adquisición de la bici
     */
    public LocalDate getFechaAdquisicion() {
        return this.fechaAdquisicion;
    }

    /**
     * Obtiene la versión del firmware instalado en el chip de la bici.
     * @return versión del firmware del chip de la bici
     */
    public int getVersion() {
        return this.version;
    }

    /**
     * Obtiene la revisión del firmware instalado en el chip de la bici.
     * @return revisión del firmware del chip de la bici
     */
    public int getRevision() {
        return this.revision;
    }

    /**
     * Obtiene la versión y revisión del firmware simultáneamente.
     * @return cadena de caracteres con la versión y revisión del firmware
     * instalado en el chip. Formato "versión.revisión"
     */
    public String getVersionRevision() {
        return String.format("%d.%d", this.version, this.revision);
    }

    /**
     * Indica si la bici está alquilada.
     * @return si la bici está alquilada o no
     */
    public boolean isAlquilada() {
        return this.alquilada;
    }

    /**
     * Obtiene el total de kilómetros recorridos hasta el momento por la bici.
     * @return kilómetros recorridos hasta el momento.
     */
    public double getKilometrosTotales() {
        return this.kilometrosTotales;
    }

    /**
     * Obtiene la fecha y hora del alquiler actual de la bici, si es que está
     * alquilada. Si la bici no está alquilada, devolverá <code>null</code>.
     * @return fecha y hora del alquiler actual. Si no está alquilada devuelve
     * <code>null</code>.
     */
    public LocalDateTime getRegistroInicioAlquilerActual() {
        return this.registroInicioAlquilerActual;
    }

    /**
     * Obtiene los kilómetros recorridos hasta el momento por la bici durante el
     * alquiler actual, si es que está alquilada. Si la bici no está alquilada,
     * devolverá 0.
     * @return kilómetros recorridos durante el alquiler actual. Si no está
     * alquilada devuelve 0.
     */
    public double getKilometrosRecorridosAlquilerActual() {
        return this.kilometrosRecorridosAlquilerActual;
    }

    /**
     * Obtiene la fecha y hora de inicio del último alquiler de la bici
     * (anterior al actual, si es que estuviera alquilada). Si todavía no ha
     * llegado finalizar ningún alquiler (aún no ha sido alquilada y devuelta),
     * será <code>null</code>.
     * @return fecha y hora de inicio del último alquiler.
     */
    public LocalDateTime getRegistroInicioUltimoAlquiler() {
        return this.registroUltimoAlquiler;
    }

    /**
     * Obtiene la fecha y hora de fin del último alquiler de la bici (anterior
     * al actual, si es que estuviera alquilada). Si todavía no ha llegado
     * finalizar ningún alquiler (aún no ha sido alquilada y devuelta), será
     * <code>null</code>.
     * @return fecha y hora de fin del último alquiler.
     */
    public LocalDateTime getRegistroFinUltimoAlquiler() {
        return this.registroFinUltimoAlquiler;
    }

    /**
     * Obtiene el total de kilómetros recorridos por la bici durante el último
     * alquiler. Si todavía no ha llegado finalizar ningún alquiler (aún no ha
     * sido alquilada y devuelta), será 0.
     * @return kilómetros recorridos durante el último alquiler.
     */
    public double getKilometrosRecorridosUltimoAlquiler() {
        return this.kilometrosRecorridosUltimoAlquiler;
    }

    // Métodos estáticos de acceso a atributos estáticos
    // -------------------------------------------------
    /**
     * Obtiene la cantidad de chips (y por tanto de bicis) creados hasta el
     * momento.
     * @return cantidad de bicis registradas
     */
    public static int getNumBicis() {
        return ChipBici.numBicis;
    }

    /**
     * Obtiene la cantidad de bicis alquiladas en ese momento.
     * @return cantidad de bicis alquiladas
     */
    public static int getNumBicisAlquiladas() {
        return ChipBici.bicisAlquiladas;
    }

    /**
     * Obtiene el total de kilómetros recorridos entre todas las bicis hasta el momento.
     * @return total de kilómetros recorridos entre todas las bicis hasta el momento
     */
    public static double getKilometrosTodasLasBicis() {
        return ChipBici.kilometrosTodasLasBicis;
    }

    // ------------------------------------------------------------
    //                 Métodos de "ACCIÓN"
    // ------------------------------------------------------------
    // Se trata de métodos que modifican el estado del objeto en uno
    // o varios atributos en función del estado en el que se encuentre
    // y/o los parámetros que reciba.
    // ------------------------------------------------------------
    //                 Método alquilar
    // ------------------------------------------------------------
    /**
     * Pasa el estado de la bici a "alquilada". Si ya está alquilada no se puede
     * volver a alquilar.
     * @throws IllegalStateException si ya está alquilada
     */
    public void alquilar() throws IllegalStateException {
        if (this.alquilada) {
            throw new IllegalStateException("Bici ya alquilada");
        } else {
            this.alquilada = true;
            this.registroInicioAlquilerActual = LocalDateTime.now();  // El alquiler empieza ahora
            // Actualizamos atributos de clase (una bici más alquilada)
            ChipBici.bicisAlquiladas++;
        }
    }

    // ------------------------------------------------------------
    //                 Método devolver
    // ------------------------------------------------------------
    /**
     * Pasa el estado de la bici a "no alquilada". Si no está alquilada no puede
     * llevarse a cabo esta operación.
     * @throws IllegalStateException si no está alquilada
     */
    public void devolver() throws IllegalStateException {
        if (!this.alquilada) {
            throw new IllegalStateException("Bici no alquilada");
        } else {
            this.alquilada = false; // Deja de estar alquilada
            // Actualizamos los registros del último alquiler con el aquiler que acaba de finalizar
            this.registroUltimoAlquiler = this.registroInicioAlquilerActual;
            this.registroFinUltimoAlquiler = LocalDateTime.now(); // Deja de estar alquilada ahora
            this.kilometrosRecorridosUltimoAlquiler = this.kilometrosRecorridosAlquilerActual;
            // Reseteamos el alquiler actual, que deja de existir
            this.registroInicioAlquilerActual = null; // Deja de estar alquilada y no tiene registro de alquiler
            this.kilometrosRecorridosAlquilerActual = 0; // Deja de estar alquilada y no tiene kilómetros recorridos
            // Actualizamos atributos de clase (una bici menos alquilada)
            ChipBici.bicisAlquiladas--;
        }
    }

    // ------------------------------------------------------------
    //                 Método recorrerTrayecto
    // ------------------------------------------------------------
    /**
     * Recorre un trayecto de una determinada distancia con la bici. No se puede
     * superar la máxima ditancia permitida por trayecto. No se permiten
     * distancias negativas. Sí se permite la distancia 0.
     * @return la cantidad de kilómetros que se llevan recorridos con el alquiler actual
     * @param distancia longitud del trayecto (en kilómetros)
     * @throws IllegalStateException si la bici no está alquilada
     * @throws IllegalArgumentException si la distancia no es válida
     */
    public double recorrerTrayecto(double distancia) throws IllegalStateException, IllegalArgumentException {
        if (!this.alquilada) {
            throw new IllegalStateException("Bici no alquilada");
        } else if (distancia < 0 || distancia > ChipBici.MAX_DISTANCIA_TRAYECTO) {
            throw new IllegalArgumentException(String.format("Distancia incorrecta: %.2f km", distancia));
        } else {
            // Actualizamos recorridos
            this.kilometrosRecorridosAlquilerActual += distancia;
            this.kilometrosTotales += distancia;
            ChipBici.kilometrosTodasLasBicis += distancia;
            return this.kilometrosRecorridosAlquilerActual;
        }
    }

    /**
     * Recorre la máxima distancia que se puede recorrer en un trayecto con la bici.
     * @return la cantidad de kilómetros que se llevan recorridos con el alquiler actual
     * @throws IllegalStateException si la bici no está alquilada
     */
    public double recorrerTrayecto () throws IllegalStateException {
        return recorrerTrayecto (ChipBici.MAX_DISTANCIA_TRAYECTO);
    }
    
        
    // ------------------------------------------------------------
    //                 Método actualizarFirmware
    // ------------------------------------------------------------
    /**
     * Lleva a cabo una actualización del firmware del chip. Siempre debe de ser
     * un upgrade, es decir, debe ser a una revisión superior válida de la
     * versión actual o bien a cualquier revisión válida de una versión
     * superior. Si la bici está alquilada no se permite la actualización.
     * @param version versión de actualización
     * @param revision revisión de actualización
     * @throws IllegalStateException si la bici está alquilada
     * @throws IllegalArgumentException si la versión o revisión es incorrecta o
     * bien no es un upgrade
     */
    public void actualizarFirmware(int version, int revision) throws IllegalStateException, IllegalArgumentException {
        if (this.alquilada) {
            throw new IllegalStateException("No se puede actualizar el firmware a una bici alquilada");
        } else if (!versionCorrecta(version)) {
            throw new IllegalArgumentException("Versión incorrecta: " + version);
        } else if (!revisionCorrecta(revision)) {
            throw new IllegalArgumentException("Revisión incorrecta: " + revision);
        } else if (version < this.version || (version == this.version && revision <= this.revision)) {
            throw new IllegalStateException(String.format("Es necesario actualizar a una versión superior a la actual: %d.%d <= %d.%d",
                    version, revision, this.version, this.revision));
        } else { // Si no hay ningún error, procedemos a actualizar el firmware
            this.version = version;
            this.revision = revision;
        }
    }

    /**
     * Lleva a cabo una actualización del firmware del chip. Solo se indica la versión.
     * La revisón será la 0. Siempre debe de ser un upgrade, es decir, debe ser a 
     * versión superior válida a la versión actual.
     * Si la bici está alquilada no se permite la actualización.
     * @param version versión de actualización
     * @throws IllegalStateException si la bici está alquilada
     * @throws IllegalArgumentException si la versión o revisión es incorrecta o
     * bien no es un upgrade
     */
    public void actualizarFirmware (int version) throws IllegalStateException, IllegalArgumentException {
        actualizarFirmware (version, ChipBici.DEFAULT_REVISION);
    }
        
    // ------------------------------------------------------------
    //                      Método reset
    // ------------------------------------------------------------
    /**
     * Resetea el chip a los valores de fábrica. Solo puede ser reseteado si la
     * bici no está alquilada. El firmware volverá a la versión por omisión. Se
     * perderán todos los registros de alquileres, incluyedo cualquier fecha y
     * dato kilométrico. Tan solo se mantendrán el número de serie y la fecha de
     * adquisición.
     * @throws IllegalStateException si la bici está alquilada
     */
    public void reset() throws IllegalStateException {
        if (this.alquilada) {
            throw new IllegalStateException("No se puede resetear un chip de una bici que esté alquilada");
        } else {
            // Iniciamos los valores de versión y revisión del firwmare
            this.version  = ChipBici.DEFAULT_VERSION;
            this.revision = ChipBici.DEFAULT_REVISION;
            // Reseteamos la información de registro 
            this.registroUltimoAlquiler = null;
            this.registroFinUltimoAlquiler = null;
            this.kilometrosRecorridosUltimoAlquiler= 0;
            this.kilometrosTotales = 0;
        }
    }

    // ------------------------------------------------------------
    //                 Método toString
    // ------------------------------------------------------------
    /**
     * Devuelve una cadena que representa el estado de un objeto <code>ChipBici</code>.
     * El resultado devuelto representará el estado del chip y tendrá la
     * siguiente estructura:
     * <ol>
     * <li>un inicio de bloque o llave (carácter '{');</li>
     * <li>la etiqueta "NS: " junto con el número de serie;</li>
     * <li>la fecha de adquisción de la bici;</li>
     * <li>la etiqueta "fw: " y a continuación la versión y revisión del firmware;</li>
     * <li>si la bici está o no alquilada;</li>
     * <li>cantidad de kilómetros totales recorridos por la bici hasta el momento;</li>
     * <li>información sobre el alquiler actual: fecha y hora de inicio del alquiler actual 
     * y kilómetros recorridos durante ese alquiler;</li>
     * <li>información sobre el último alquiler realizado: fecha y hora de inicio y de fin 
     * de ese alquiler junto con los kilómetros realizados durante el mismo;</li>
     * <li>un fin de bloque o llave (carácter '}').</li>
     * </ol>
     * <p>Un ejemplo de cadena devuelta podría ser:</p>
     * <p><code>{ NS: 33; 15/09/2021; fw: 2.1; no alquilada; 150,00 km totales; Alquiler actual: ---, 0,00 km; Último alquiler: 09/12/2021 12:33:36, 09/12/2021 22:02:57, 57,28 km }</code></p>
     * <p>donde podríamos observar la siguiente información:</p>
     * <ul>
     * <li>el número de serie de la bici es 33;</li>
     * <li>la fecha de adquisición es el 15 de septiembre de 2021;</li>
     * <li>la versión y revisión del firmware es 2.1;</li>
     * <li>la bici no está alquilada en este momento;</li>
     * <li>la cantidad de kilómetros recorridos por la bici hasta el momento es de 150,00 kilómetros;</li>
     * <li>la información sobre el alquiler actual será nula: fecha/hora con "---" y kilómetros a cero, pues no está alquilada;</li>
     * <li>la información sobre el último alquiler completado será: los registros "09/12/2021 12:33:36" para el inicio y "09/12/2021 22:02:57" para el fin del alquiler junto con los 57,28 km realizados durante ese alquiler.</li>
     * </ul>
     * 
     * @return una cadena que representa el estado de un objeto microdispositivo <code>ChipBici</code>
     */
    @Override
    public String toString() {
        String cadenaResultado=
            String.format (
                    "{ NS: %s; %s; fw: %s; %salquilada; %.2f km totales; Alquiler actual: %s, %.2f km; Último alquiler: %s, %s, %.2f km }",
                    // Información inmutable
                    this.getNumSerie(),
                    this.fechaAdquisicion.format(ChipBici.FORMATO_FECHA),
                    // Información de estado
                    this.getVersionRevision(),
                    this.alquilada ? "" : "no ",
                    this.kilometrosTotales,
                    // Información sobre el alquiler actual
                    this.registroInicioAlquilerActual != null ? 
                            this.registroInicioAlquilerActual.format(ChipBici.FORMATO_FECHA_HORA) :
                            "---",
                    this.kilometrosRecorridosAlquilerActual,
                    // Información sobre el último alquiler                    
                    this.registroUltimoAlquiler != null ? 
                            this.registroUltimoAlquiler.format(ChipBici.FORMATO_FECHA_HORA) :
                            "---",
                    this.registroFinUltimoAlquiler != null ? 
                            this.registroFinUltimoAlquiler.format(ChipBici.FORMATO_FECHA_HORA) :
                            "---",
                    this.kilometrosRecorridosUltimoAlquiler
                );
        return cadenaResultado;
    }

    // ------------------------------------------------------------
    //               MÉTODOS PRIVADOS "HERRAMIENTA"
    // ------------------------------------------------------------
    // Métodos "internos" que sirven como "herramientas" para ayudar 
    // en la implementación de otros métodos
    // ------------------------------------------------------------
    //                 Método versionCorrecta
    // ------------------------------------------------------------
    // Indica si un número de versión está dentro del rango válido
    private static boolean versionCorrecta(int version) {
        return version >= ChipBici.MIN_VERSION && version <= ChipBici.MAX_VERSION;
    }

    // ------------------------------------------------------------
    //                 Método revisionCorrecta
    // ------------------------------------------------------------
    // Indica si un número de revisión está dentro del rango válido
    private static boolean revisionCorrecta(int revision) {
        return revision >= ChipBici.MIN_REVISION && revision <= ChipBici.MAX_REVISION;
    }

}
