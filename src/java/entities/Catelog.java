/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "Catelog")
public class Catelog implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CatelogId")
    private Integer catelogId;
    @Size(max = 128)
    @Column(name = "CatelogName")
    private String catelogName;
    @Size(max = 100)
    @Column(name = "Images")
    private String images;
    @Size(max = 100)
    @Column(name = "Descriptions")
    private String descriptions;
    @OneToMany(mappedBy = "catelogId")
    private Collection<Product> productCollection;

    public Catelog() {
    }

    public Catelog(Integer catelogId) {
        this.catelogId = catelogId;
    }

    public Integer getCatelogId() {
        return catelogId;
    }

    public void setCatelogId(Integer catelogId) {
        this.catelogId = catelogId;
    }

    public String getCatelogName() {
        return catelogName;
    }

    public void setCatelogName(String catelogName) {
        this.catelogName = catelogName;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    @XmlTransient
    public Collection<Product> getProductCollection() {
        return productCollection;
    }

    public void setProductCollection(Collection<Product> productCollection) {
        this.productCollection = productCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (catelogId != null ? catelogId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Catelog)) {
            return false;
        }
        Catelog other = (Catelog) object;
        if ((this.catelogId == null && other.catelogId != null) || (this.catelogId != null && !this.catelogId.equals(other.catelogId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Catelog[ catelogId=" + catelogId + " ]";
    }
    
}
