package bean;

public class Personne {	
	
	private int id=0;
	private int previd = 0;
	private String classe=null;
	private String niveau=null;
	private String nom=null;
	private String prenom=null;;
	private String sexe=null;;
	private String dateNaissance=null;;
	private String statut=null;;
	private String adresse=null;;
	private String tel=null;
	private String prevNom=null;
	private String prevPrenom=null;
	private String prevTel=null;

	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getClasse() {
		return classe;
	}
	public void setClasse(String classe) {
		this.classe = classe;
	}
	public String getNiveau() {
		return niveau;
	}
	public void setNiveau(String niveau) {
		this.niveau = niveau;
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
	public String getSexe() {
		return sexe;
	}
	public void setSexe(String sexe) {
		this.sexe = sexe;
	}
	public String getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(String dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	public String getStatut() {
		return statut;
	}
	public void setStatut(String statut) {
		this.statut = statut;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getPrevNom() {
		return prevNom;
	}
	public void setPrevNom(String prevNom) {
		this.prevNom = prevNom;
	}
	public String getPrevPrenom() {
		return prevPrenom;
	}
	public void setPrevPrenom(String prevPrenom) {
		this.prevPrenom = prevPrenom;
	}
	public String getPrevTel() {
		return prevTel;
	}
	public void setPrevTel(String prevTel) {
		this.prevTel = prevTel;
	}
	public int getPrevid() {
		return previd;
	}
	public void setPrevid(int previd) {
		this.previd = previd;
	}

}