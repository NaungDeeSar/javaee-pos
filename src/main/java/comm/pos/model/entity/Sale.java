package comm.pos.model.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import static javax.persistence.CascadeType.PERSIST;
import static javax.persistence.CascadeType.MERGE;
import static javax.persistence.CascadeType.REMOVE;

/**
 * Entity implementation class for Entity: Orders
 *
 */
@Entity

public class Sale implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private LocalDate saleDate;	
	@OneToMany(mappedBy = "sale", cascade = { PERSIST, MERGE, REMOVE })
	private List<SaleDetail> detaiList=new ArrayList<>();
	private static final long serialVersionUID = 1L;

	
	 public void addSaleItem(SaleDetail s) {
		 s.setSale(this);
		 detaiList.add(s);
	 }
	public Sale() {
		super();
	}   
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	public LocalDate getSaleDate() {
		return saleDate;
	}
	public void setSaleDate(LocalDate saleDate) {
		this.saleDate = saleDate;
	}
	public List<SaleDetail> getDetaiList() {
		return detaiList;
	}
	public void setDetaiList(List<SaleDetail> detaiList) {
		this.detaiList = detaiList;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
   
}
