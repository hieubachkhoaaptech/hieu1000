/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "ProductDetail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductDetail.findAll", query = "SELECT p FROM ProductDetail p")
    , @NamedQuery(name = "ProductDetail.findByProductDetailId", query = "SELECT p FROM ProductDetail p WHERE p.productDetailId = :productDetailId")
    , @NamedQuery(name = "ProductDetail.findByPrice", query = "SELECT p FROM ProductDetail p WHERE p.price = :price")
    , @NamedQuery(name = "ProductDetail.findBySaleOff", query = "SELECT p FROM ProductDetail p WHERE p.saleOff = :saleOff")
    , @NamedQuery(name = "ProductDetail.findByDescriptions", query = "SELECT p FROM ProductDetail p WHERE p.descriptions = :descriptions")
    , @NamedQuery(name = "ProductDetail.findByStatus", query = "SELECT p FROM ProductDetail p WHERE p.status = :status")})
public class ProductDetail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ProductDetailId")
    private Integer productDetailId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Price")
    private Double price;
    @Column(name = "SaleOff")
    private Double saleOff;
    @Size(max = 100)
    @Column(name = "Descriptions")
    private String descriptions;
    @Column(name = "Status")
    private Boolean status;
    @JoinColumn(name = "ColorId", referencedColumnName = "ColorId")
    @ManyToOne
    private Color colorId;
    @JoinColumn(name = "ProductId", referencedColumnName = "ProductId")
    @ManyToOne
    private Product productId;
    @JoinColumn(name = "SizeId", referencedColumnName = "SizeId")
    @ManyToOne
    private Size1 sizeId;

    public ProductDetail() {
    }

    public ProductDetail(Integer productDetailId) {
        this.productDetailId = productDetailId;
    }

    public Integer getProductDetailId() {
        return productDetailId;
    }

    public void setProductDetailId(Integer productDetailId) {
        this.productDetailId = productDetailId;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getSaleOff() {
        return saleOff;
    }

    public void setSaleOff(Double saleOff) {
        this.saleOff = saleOff;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Color getColorId() {
        return colorId;
    }

    public void setColorId(Color colorId) {
        this.colorId = colorId;
    }

    public Product getProductId() {
        return productId;
    }

    public void setProductId(Product productId) {
        this.productId = productId;
    }

    public Size1 getSizeId() {
        return sizeId;
    }

    public void setSizeId(Size1 sizeId) {
        this.sizeId = sizeId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productDetailId != null ? productDetailId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductDetail)) {
            return false;
        }
        ProductDetail other = (ProductDetail) object;
        if ((this.productDetailId == null && other.productDetailId != null) || (this.productDetailId != null && !this.productDetailId.equals(other.productDetailId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.ProductDetail[ productDetailId=" + productDetailId + " ]";
    }
    
}
