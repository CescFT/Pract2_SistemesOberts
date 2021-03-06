package ModelEntities;

import javax.persistence.*;
import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Classe entitat que representa el llogater
 *
 * @author Cesc Ferré Tarrés
 * @author Aleix Sancho Pujals
 */
@XmlRootElement
public class Llogater implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long id;
    private InformacioLlogater info;
    private Integer numLlogades;

    /**
     * getter de habitacionsLlogades
     * @return num habitacions
     */
    public Integer getNumLlogades() {
        return numLlogades;
    }
    /**
     * setter de habitacions llogades
     * @param numLlogades 
     */
    public void setNumLlogades(Integer numLlogades) {
        this.numLlogades = numLlogades;
    }
    
    /**
     * getter del identificador
     *
     * @return identificador
     */
    public Long getId() {
        return id;
    }

    /**
     * setter del identificador
     *
     * @param id identificador
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * getter de la informacio del llogater
     *
     * @return informacio del llogater
     */
    public InformacioLlogater getInfo() {
        return info;
    }

    /**
     * setter de la informacio del llogater
     *
     * @param info informacio del llogater
     */
    public void setInfo(InformacioLlogater info) {
        this.info = info;
    }

    /**
     * override del equals
     *
     * @param object objecte a comparar
     * @return cert si igual, fals si no son iguals
     */
    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Llogater)) {
            return false;
        }
        Llogater other = (Llogater) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
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
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    /**
     * tostring
     *
     * @return string
     */
    @Override
    public String toString() {
        return "{" + "id:\"" + id + "\", info:" + info + ", numLlogades:\"" + numLlogades +"\"}";
    }

}
