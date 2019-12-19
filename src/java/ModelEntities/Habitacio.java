package ModelEntities;

import javax.persistence.*;
import java.io.Serializable;
import javax.validation.constraints.*;
import javax.xml.bind.annotation.XmlRootElement;
import ModelEntities.Llogater;
import ModelEntities.Requeriment;
import ModelEntities.TipusHabitacio;

/**
 * Classe entitat que representa una habitacio i emmagatzema les dades que es
 * demanen a l'enunciat
 *
 * @author Cesc Ferré Tarrés
 * @author Aleix Sancho Pujals
 */

@XmlRootElement

public class Habitacio implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long idHabitacio;
    private String descripcio;
    private String adresa;
    private String ciutat;
    private TipusHabitacio tipusHabitacio;
    private float preuMes;
    private Requeriment requeriment;
    private Llogater llogater;
    private String urlImatge;
    private Boolean ocupada;

    /**
     * getter habitacio ocupada
     * @return ocupada
     */
    public Boolean getOcupada() {
        return ocupada;
    }

    /**
     * setter habitacio ocupada
     * @param ocupada ocupada
     */
    public void setOcupada(Boolean ocupada) {
        this.ocupada = ocupada;
    }
    
    /**
     * getter del tipus habitacio
     *
     * @return tipus habitacio
     */
    public TipusHabitacio getTipusHabitacio() {
        return tipusHabitacio;
    }

    /**
     * setter del tipus habitacio
     *
     * @param tipusHabitacio tipus habitacio
     */
    public void setTipusHabitacio(TipusHabitacio tipusHabitacio) {
        this.tipusHabitacio = tipusHabitacio;
    }

    /**
     * getter de la url de la imatge
     * @return urlimatge
     */
    public String getUrlImatge() {
        return urlImatge;
    }

    /**
     * setter de la url de la imatge
     * @param urlImatge urlimatge
     */
    public void setUrlImatge(String urlImatge) {
        this.urlImatge = urlImatge;
    }
    
    /**
     * getter del llogater
     *
     * @return llogater
     */
    public Llogater getLlogater() {
        return llogater;
    }

    /**
     * setter del llogater
     *
     * @param llogater llogater
     */
    public void setLlogater(Llogater llogater) {
        this.llogater = llogater;
    }

    /**
     * contructor buit
     */
    public Habitacio() {

    }

    /**
     * getter del id
     *
     * @return identificador de l'habitacio
     */
    public Long getIdHabitacio() {
        return idHabitacio;
    }

    /**
     * setter del id de l'habitacio
     *
     * @param idHabitacio id habitacio
     */
    public void setIdHabitacio(Long idHabitacio) {
        this.idHabitacio = idHabitacio;
    }

    /**
     * getter de la descripcio
     *
     * @return descripcio
     */
    public String getDescripcio() {
        return descripcio;
    }

    /**
     * setter de la descripcio
     *
     * @param descripcio descripcio habitacio
     */
    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }

    /**
     * getter de la adresa
     *
     * @return adresa
     */
    public String getAdresa() {
        return adresa;
    }

    /**
     * setter de la adresa
     *
     * @param adresa adresa
     */
    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    /**
     * getter de la ciutat
     *
     * @return ciutat
     */
    public String getCiutat() {
        return ciutat;
    }

    /**
     * setter de la ciutat
     *
     * @param ciutat ciutat
     */
    public void setCiutat(String ciutat) {
        this.ciutat = ciutat;
    }

    /**
     * getter del preu per mes
     *
     * @return preu per mes
     */
    public float getPreuMes() {
        return preuMes;
    }

    /**
     * setter del preu per mes
     *
     * @param preuMes preu per mes
     */
    public void setPreuMes(float preuMes) {
        this.preuMes = preuMes;
    }

    /**
     * getter del requeriment
     *
     * @return requeriment
     */
    public Requeriment getRequeriment() {
        return requeriment;
    }

    /**
     * setter del requeriment
     *
     * @param requeriment requeriment
     */
    public void setRequeriment(Requeriment requeriment) {
        this.requeriment = requeriment;
    }

    /**
     * override de equals
     *
     * @param object objecte a comparar
     * @return cert si iguals, fals si no son iguals
     */
    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Habitacio)) {
            return false;
        }
        Habitacio other = (Habitacio) object;
        if ((this.idHabitacio == null && other.idHabitacio != null) || (this.idHabitacio != null && !this.idHabitacio.equals(other.idHabitacio))) {
            return false;
        }
        return true;
    }

    /**
     * calcul del hashcode
     *
     * @return hash
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idHabitacio != null ? idHabitacio.hashCode() : 0);
        return hash;
    }

    /**
     * tostring
     *
     * @return string
     */
    @Override
    public String toString() {
        return "Habitacio{" + "idHabitacio=" + idHabitacio + ", descripcio=" + descripcio + ", adresa=" + adresa + ", ciutat=" + ciutat + ", tipusHabitacio=" + tipusHabitacio + ", preuMes=" + preuMes + ", requeriment=" + requeriment + ", urlImatge=" + urlImatge + ", ocupada=" + ocupada + ", llogater=" + llogater + '}';
    }

}
