package medecine.mvc.java.model;



public class Medecine {
	private Integer  id;
	private String nom;
	private String prenom;
	private String adress;
	private String tel;
	private String spe;
	private Integer departement;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getSpe() {
		return spe;
	}
	public void setSpe(String spe) {
		this.spe = spe;
	}
	public Integer getDepartement() {
		return departement;
	}
	public void setDepartement(Integer departement) {
		this.departement = departement;
	}
	@Override
	public String toString() {
		return "Medecine [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", adress=" + adress + ", tel=" + tel
				+ ", spe=" + spe + ", departement=" + departement + ", getId()=" + getId() + ", getNom()=" + getNom()
				+ ", getPrenom()=" + getPrenom() + ", getAdress()=" + getAdress() + ", getTel()=" + getTel()
				+ ", getSpe()=" + getSpe() + ", getDepartement()=" + getDepartement() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
	
	

	

}
