package screen;

public class User {
	private int edat;
	private String lloguer;
	private String matricula;
	private double llargadaCotxe;
	private String tePadro;
	
	public User(int edat,String lloguer,String matricula,double llargadaCotxe,String tePadro) {
		this.edat=edat;
		this.lloguer=lloguer;
		this.matricula=matricula;
		this.llargadaCotxe=llargadaCotxe;
		this.tePadro=tePadro;
		
	}
	public User() {
		this (0,"","",0.0,"");
	}
	
	public int getEdat() {
		return edat;
	}
	
	public void setEdat(int edat) {
		this.edat=edat;
	}
	public String getLloguer() {
		return lloguer;
	}
	public void setLloguer(String lloguer) {
		this.lloguer=lloguer;
	}
	
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula=matricula;
	}
	public double getLlargadaCotxe() {
		return llargadaCotxe;
	}
	public void setLlargadaCotxe(double llargadaCotxe) {
		this.llargadaCotxe=llargadaCotxe;
	}
	public String getPadro() {
		return tePadro;
	}
	public void setPadro(String tePadro) {
		this.tePadro=tePadro;
	}
}
