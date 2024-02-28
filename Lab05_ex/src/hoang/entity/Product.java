package hoang.entity;
// Generated Feb 28, 2024, 8:43:58 AM by Hibernate Tools 5.6.15.Final

import java.io.Serializable;

/**
 * Product generated by hbm2java
 */
public class Product implements java.io.Serializable {

	private Serializable maSp;
	private Serializable tenSanPham;
	private Serializable anhSanPham;
	private Integer soLuong;
	private Double donGia;
	private Boolean trangThai;

	public Product() {
	}

	public Product(Serializable maSp) {
		this.maSp = maSp;
	}

	public Product(Serializable maSp, Serializable tenSanPham, Serializable anhSanPham, Integer soLuong, Double donGia,
			Boolean trangThai) {
		this.maSp = maSp;
		this.tenSanPham = tenSanPham;
		this.anhSanPham = anhSanPham;
		this.soLuong = soLuong;
		this.donGia = donGia;
		this.trangThai = trangThai;
	}

	public Serializable getMaSp() {
		return this.maSp;
	}

	public void setMaSp(Serializable maSp) {
		this.maSp = maSp;
	}

	public Serializable getTenSanPham() {
		return this.tenSanPham;
	}

	public void setTenSanPham(Serializable tenSanPham) {
		this.tenSanPham = tenSanPham;
	}

	public Serializable getAnhSanPham() {
		return this.anhSanPham;
	}

	public void setAnhSanPham(Serializable anhSanPham) {
		this.anhSanPham = anhSanPham;
	}

	public Integer getSoLuong() {
		return this.soLuong;
	}

	public void setSoLuong(Integer soLuong) {
		this.soLuong = soLuong;
	}

	public Double getDonGia() {
		return this.donGia;
	}

	public void setDonGia(Double donGia) {
		this.donGia = donGia;
	}

	public Boolean getTrangThai() {
		return this.trangThai;
	}

	public void setTrangThai(Boolean trangThai) {
		this.trangThai = trangThai;
	}

}
