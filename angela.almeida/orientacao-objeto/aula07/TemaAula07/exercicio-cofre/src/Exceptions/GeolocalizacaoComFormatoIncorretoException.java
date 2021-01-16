package Exceptions;

public class GeolocalizacaoComFormatoIncorretoException extends Exception {
    public GeolocalizacaoComFormatoIncorretoException() {
        super("A Geolocalizacao está com formato incorreto");
    }
}