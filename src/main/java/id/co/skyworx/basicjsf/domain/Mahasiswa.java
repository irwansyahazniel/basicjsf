package id.co.skyworx.basicjsf.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

// menyatakan class merupakan entity
@Entity
// menyatakan class akan di-map ke table yang dispesifikan
@Table(name = "mahasiswa")
public class Mahasiswa {
	// merupakan primary key, berdasarkan terminologi objek
	@Id
	// untuk menyatakan field merupakan column
	// dan dispesifikan field dipetakan ke kolom mana
	@Column(name = "nim", length = 5)
	private String nim;
	@Column(name = "nama_depan", length = 50)
	private String namaDepan;
	@Column(name = "nama_belakang", length = 50)
	private String namaBelakang;
	@Column(name = "alamat", length = 255)
	private String alamat;
	@Column(name = "tanggal_lahir")
	private Date tanggalLahir;
	@Column(name = "tempat_lahir", length = 50)
	private String tempatLahir;

	public String getNim() {
		return nim;
	}

	public void setNim(String nim) {
		this.nim = nim;
	}

	public String getNamaDepan() {
		return namaDepan;
	}

	public void setNamaDepan(String namaDepan) {
		this.namaDepan = namaDepan;
	}

	public String getNamaBelakang() {
		return namaBelakang;
	}

	public void setNamaBelakang(String namaBelakang) {
		this.namaBelakang = namaBelakang;
	}

	public String getAlamat() {
		return alamat;
	}

	public void setAlamat(String alamat) {
		this.alamat = alamat;
	}

	public Date getTanggalLahir() {
		return tanggalLahir;
	}

	public void setTanggalLahir(Date tanggalLahir) {
		this.tanggalLahir = tanggalLahir;
	}

	public String getTempatLahir() {
		return tempatLahir;
	}

	public void setTempatLahir(String tempatLahir) {
		this.tempatLahir = tempatLahir;
	}

}