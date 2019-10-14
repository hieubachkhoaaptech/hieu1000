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
@Table(name = "Size")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Size1.findAll", query = "SELECT s FROM Size1 s")
    , @NamedQuery(name = "Size1.findBySizeId", query = "SELECT s FROM Size1 s WHERE s.sizeId = :sizeId")
    , @NamedQuery(name = "Size1.findBySizeName", query = "SELECT s FROM Size1 s WHERE s.sizeName = :sizeName")
    , @NamedQuery(name = "Size1.findByDescriptions", query = "SELECT s FROM Size1 s WHERE s.descriptions = :descriptions")})
public class Size1 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SizeId")
    private Integer sizeId;
    @Size(max = 100)
    @Column(name = "SizeName")
    private String sizeName;
    @Size(max = 100)
    @Column(name = "Descriptions")
    private String descriptions;
    @OneToMany(mappedBy = "sizeId")
    private Collection<Product> productCollection;

    public Size1() {
    }

    public Size1(Integer sizeId) {
        this.sizeId = sizeId;
    }

    public Integer getSizeId() {
        return sizeId;
    }

    public void setSizeId(Integer sizeId) {
        this.sizeId = sizeId;
    }

    public String getSizeName() {
        return sizeName;
    }

    public void setSizeName(String sizeName) {
        this.sizeName = sizeName;
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
        hash += (sizeId != null ? sizeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Size1)) {
            return false;
        }
        Size1 other = (Size1) object;
        if ((this.sizeId == null && other.sizeId != null) || (this.sizeId != null && !this.sizeId.equals(other.sizeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Size1[ sizeId=" + sizeId + " ]";
    }

}
